package com.yonder.matrix.views;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.CellEditEvent;

import com.yonder.matrix.facade.MatrixFacade;
import com.yonder.matrix.facade.TopicFacade;
import com.yonder.matrix.facade.UserFacade;
import com.yonder.matrix.model.Matrix;
import com.yonder.matrix.model.Topic;
import com.yonder.matrix.model.User;

/**
 * Backing bean for Dashboard page
 * 
 * @author IoanaV
 *
 */
@ViewScoped
@ManagedBean
public class DashboardView {

	private List<Matrix> selectedMatrices;
	private Topic selectedTopic;
	private List<Matrix> matrices;
	private List<Matrix> usersMatrices;
	private List<User> users;
	private User user;
	private List<Topic> topics;
	private String color;

	@EJB
	private MatrixFacade matrixFacade;
	@EJB
	private UserFacade userFacade;
	@EJB
	private TopicFacade topicFacade;
	@ManagedProperty("#{msgs}")
	private ResourceBundle bundle;

	private static final String GREEN_ROW_COLOR = "green";
	private static final String YELLOW_ROW_COLOR = "yellow";
	private static final String RED_ROW_COLOR = "red";

	@PostConstruct
	public void init() {
		users = userFacade.findAll();
		topics = topicFacade.findAll();
	}

	/**
	 * Display the grades of the users for a specific topic
	 * 
	 * @param user
	 * @param topic
	 * @return the user's grade for a topic
	 */
	public Integer getGrade(User user, Topic topic) {
		Integer grade = null;
		usersMatrices = matrixFacade.findMatricesByUserAndTopic(user, topic);
		if (usersMatrices != null && !usersMatrices.isEmpty()) {
			for (Matrix userMatrix : usersMatrices) {
				if (userMatrix.getTopic() != null && topic != null
						&& userMatrix.getTopic().getId() == topic.getId()) {
					grade = userMatrix.getGrade();
					return grade;
				}
			}
		}

		return grade;
	}

	/**
	 * Calculates the row color that will be used for every topic (table row)
	 * 
	 * @return the CSS class corresponding to the row color that will be used by
	 *         the attribute 'rowStyleClass'
	 */
	private String findTopicColor() {
		List<Integer> grades = new ArrayList<>();
		Set<User> usersSet = new HashSet<>();
		Integer occurrences = null;
		int noUsersPerTopic = 0;
		Topic topic = (Topic) ((DataTable) FacesContext.getCurrentInstance()
				.getViewRoot().findComponent("dashboardForm:dashboardTable"))
				.getRowData();
		List<Matrix> topicMatrices = matrixFacade.findMatricesByTopic(topic);
		if (topicMatrices != null && !topicMatrices.isEmpty()) {
			for (Matrix topicMatrix : topicMatrices) {
				grades.add(topicMatrix.getGrade());
				usersSet.add(topicMatrix.getUser());
			}

			// the number of users assigned to a topic
			noUsersPerTopic = usersSet.size();
			// the number of occurrences the grades 3 and 4 are found in the
			// users matrices for a topic
			occurrences = Collections.frequency(grades, 3)
					+ Collections.frequency(grades, 4);

			// if there is only one user assigned per topic there is still a
			// risk for business continuity
			if (noUsersPerTopic == 1) {
				if (occurrences == 1) {
					return YELLOW_ROW_COLOR;
				} else {
					return RED_ROW_COLOR;
				}
			}
			
			// if there are only two users assigned per topic
			if (noUsersPerTopic == 2) {
				if (occurrences == noUsersPerTopic) {
					return GREEN_ROW_COLOR;
				} else if (occurrences >= noUsersPerTopic - 1) {
					return YELLOW_ROW_COLOR;
				} else {
					return RED_ROW_COLOR;
				}
			}
			// if the number of users is equal or grater than 7
			if (noUsersPerTopic >= 7) {
				if (occurrences >= 3) {
					return GREEN_ROW_COLOR;
				} else if (occurrences >= 2) {
					return YELLOW_ROW_COLOR;
				}
			}
			// for the rest of the cases a topic has no risks if the no of
			// users that have at least the grades 3 or 4 is
			// grater or equal to the no of members
			if (occurrences >= noUsersPerTopic - 1) {
				return GREEN_ROW_COLOR;
			} else if (occurrences >= noUsersPerTopic - 2) {
				return YELLOW_ROW_COLOR;
			}
		}

		return RED_ROW_COLOR;
	}

	/**
	 * Update the Matrix entity grade field for each modified cell
	 * 
	 * @param event
	 */
	public void onCellEdit(CellEditEvent event) {
		Matrix matrix = (Matrix) ((DataTable) event.getComponent())
				.getRowData();
		if (matrix != null) {
			matrixFacade.update(matrix);
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					bundle.getString("dashboard.succesfulInsert"), null);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}

	}

	/**
	 * reset the list of matrices for the dialog to get the new values when
	 * selecting a row
	 */
	public void resetSelectedMatrices() {
		selectedMatrices = null;
	}

	/**
	 * Get the number of users to render dynamic columns for each user
	 * 
	 * @return No of users
	 */
	public int getUsersCount() {
		if (users != null) {
			return users.size();
		} else {
			return 0;
		}
	}

	/**
	 * 
	 * @return the matrices
	 */
	public List<Matrix> getMatrices() {
		return matrices;

	}

	/**
	 * @param matrices
	 *            the matrices to set
	 */
	public void setMatrices(List<Matrix> matrices) {
		this.matrices = matrices;
	}

	/**
	 * @return the users
	 */
	public List<User> getUsers() {
		return users;
	}

	/**
	 * @param users
	 *            the users to set
	 */
	public void setUsers(List<User> users) {
		this.users = users;
	}

	/**
	 * @return the usersMatrices
	 */
	public List<Matrix> getUsersMatrices() {
		return usersMatrices;
	}

	/**
	 * @param usersMatrices
	 *            the usersMatrices to set
	 */
	public void setUsersMatrices(List<Matrix> usersMatrices) {
		this.usersMatrices = usersMatrices;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the topics
	 */
	public List<Topic> getTopics() {
		return topics;
	}

	/**
	 * @param topics
	 *            the topics to set
	 */
	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

	/**
	 * @return the selectedTopic
	 */
	public Topic getSelectedTopic() {
		return selectedTopic;
	}

	/**
	 * @param selectedTopic
	 *            the selectedTopic to set
	 */
	public void setSelectedTopic(Topic selectedTopic) {
		this.selectedTopic = selectedTopic;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		color = findTopicColor();
		return color;
	}

	/**
	 * @param color
	 *            the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the selectedMatrices
	 */
	public List<Matrix> getSelectedMatrices() {
		if (selectedTopic != null && selectedMatrices == null) {
			selectedMatrices = matrixFacade.findMatricesByTopic(selectedTopic);
		}
		return selectedMatrices;
	}

	/**
	 * @param selectedMatrices
	 *            the selectedMatrices to set
	 */
	public void setSelectedMatrices(List<Matrix> selectedMatrices) {
		this.selectedMatrices = selectedMatrices;
	}

	/**
	 * @return the bundle
	 */
	public ResourceBundle getBundle() {
		return bundle;
	}

	/**
	 * @param bundle
	 *            the bundle to set
	 */
	public void setBundle(ResourceBundle bundle) {
		this.bundle = bundle;
	}

}
