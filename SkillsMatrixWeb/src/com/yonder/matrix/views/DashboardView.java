package com.yonder.matrix.views;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.CellEditEvent;

import com.yonder.matrix.facade.MatrixFacade;
import com.yonder.matrix.facade.TopicFacade;
import com.yonder.matrix.facade.UserFacade;
import com.yonder.matrix.model.Matrix;
import com.yonder.matrix.model.Topic;
import com.yonder.matrix.model.User;

@ViewScoped
@ManagedBean
public class DashboardView {

	private List<Matrix> selectedMatrixs;
	private Topic selectedTopic;
	private List<Matrix> matrixs;
	private List<Matrix> usersMatrixs;
	private Date status;
	private List<User> users;
	private User user;
	private List<Topic> topics;
	private Integer grade;

	@EJB
	private MatrixFacade matrixFacade;
	@EJB
	private UserFacade userFacade;
	@EJB
	private TopicFacade topicFacade;
	@ManagedProperty("#{msgs}")
	private ResourceBundle bundle;

	@PostConstruct
	public void init() {
		users = userFacade.findAll();
		topics = topicFacade.findAll();
	}

	public void btnUpdateAction(ActionEvent actionEvent) {
	}

	public void btnViewDetails(ActionEvent actionEvent) {

	}

	public void btnSaveAction(ActionEvent actionEvent) {

	}

	public void btnDeleteAction(ActionEvent actionEvent) {

	}

	public void btnCancelAction(ActionEvent actionEvent) {

	}

	/**
	 * Display the grades of the users for a specific topic
	 * 
	 * @param user
	 * @param topic
	 * @return the user's grade for a topic
	 */
	public int getGrade(User user, Topic topic) {
		int grade = 0;
		usersMatrixs = matrixFacade.findMatrixsByUserAndTopic(user, topic);
		if (usersMatrixs != null && !usersMatrixs.isEmpty()) {
			for (Matrix userMatrix : usersMatrixs) {
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
	 * Update the Matrix entity for each modified cell
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
	 * Get the number of users to render dynamic columns for each user
	 * 
	 * @return nr of users
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
	 * @return the matrixs
	 */
	public List<Matrix> getMatrixs() {
		return matrixs;

	}

	/**
	 * @param matrixs
	 *            the matrixs to set
	 */
	public void setMatrixs(List<Matrix> matrixs) {
		this.matrixs = matrixs;
	}

	/**
	 * @return the status
	 */
	public Date getStatus() {
		Calendar cal = Calendar.getInstance();
		status = cal.getTime();
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(Date status) {
		this.status = status;
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
	 * @return the usersMatrixs
	 */
	public List<Matrix> getUsersMatrixs() {
		return usersMatrixs;
	}

	/**
	 * @param usersMatrixs
	 *            the usersMatrixs to set
	 */
	public void setUsersMatrixs(List<Matrix> usersMatrixs) {
		this.usersMatrixs = usersMatrixs;
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
	 * @return the grade
	 */
	public Integer getGrade() {
		return grade;
	}

	/**
	 * @param grade
	 *            the grade to set
	 */
	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	/**
	 * @return the selectedMatrixs
	 */
	public List<Matrix> getSelectedMatrixs() {
		if (selectedTopic != null && selectedMatrixs == null) {
			selectedMatrixs = matrixFacade.findMatrixsByTopic(selectedTopic);
		}
		return selectedMatrixs;
	}

	/**
	 * @param selectedMatrixs
	 *            the selectedMatrixs to set
	 */
	public void setSelectedMatrixs(List<Matrix> selectedMatrixs) {
		this.selectedMatrixs = selectedMatrixs;
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
