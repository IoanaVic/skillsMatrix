package com.yonder.matrix.views;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.yonder.matrix.facade.MatrixFacade;
import com.yonder.matrix.facade.TopicFacade;
import com.yonder.matrix.facade.UserFacade;
import com.yonder.matrix.model.Matrix;
import com.yonder.matrix.model.Topic;
import com.yonder.matrix.model.User;

@ViewScoped
@ManagedBean
public class DashboardView {

	private Matrix matrix;
	private List<Matrix> matrixs;
	private List<Matrix> usersMatrixs;
	private Date status;
	private List<User> users;
	private User user;
	private List<Topic> topics;

	@EJB
	private MatrixFacade matrixFacade;
	@EJB
	private UserFacade userFacade;
	@EJB
	private TopicFacade topicFacade;

	@PostConstruct
	public void init() {
		users = userFacade.findAll();
		topics = topicFacade.findAll();
	}

	public int getGrade(User user, Topic topic) {
		int grade = 0;
		usersMatrixs = matrixFacade.findMatrixsByUserAndTopic(user, topic);
		if (usersMatrixs != null && !usersMatrixs.isEmpty()) {
			for (Matrix userMatrix : usersMatrixs) {
				if (userMatrix.getTopic() != null
						&& topic != null
						&& userMatrix.getTopic().getDescription()
								.equalsIgnoreCase(topic.getDescription())) {
					grade = userMatrix.getGrade();
					return grade;
				}
			}
		}

		return grade;
	}

	public int getUsersCount() {
		if (users != null) {
			return users.size();
		} else {
			return 0;
		}
	}

	public String getTopicForMatrix(Matrix matrix) {
		String topic = null;
		if (matrix != null) {
			topic = topicFacade.find(matrix.getTopic().getId())
					.getDescription();
		}
		return topic;
	}

	/**
	 * 
	 * @return the matrixs
	 */
	public List<Matrix> getMatrixs() {
		return matrixs;

	}

	/**
	 * @return the matrix
	 */
	public Matrix getMatrix() {
		return matrix;
	}

	/**
	 * @param matrix
	 *            the matrix to set
	 */
	public void setMatrix(Matrix matrix) {
		this.matrix = matrix;
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

}
