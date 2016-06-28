package com.yonder.matrix.views;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.yonder.matrix.facade.MatrixFacade;
import com.yonder.matrix.facade.UserFacade;
import com.yonder.matrix.model.Matrix;
import com.yonder.matrix.model.User;

@SessionScoped
@ManagedBean
public class DashboardView {

	private Matrix matrix;
	private List<Matrix> matrixs;
	private List<Matrix> usersMatrixs;
	private Date status;
	private List<User> users;
	private User user;
	
	@EJB
	private MatrixFacade matrixFacade;
	@EJB
	private UserFacade userFacade;

	public int getGrade(User user, String topic) {
		int grade = 0;
		usersMatrixs = matrixFacade.findMatrixsByUserAndTopic(user, topic);
		if (usersMatrixs != null && !usersMatrixs.isEmpty()) {
			for (Matrix userMatrix : usersMatrixs) {
				if (userMatrix.getTopic() != null && topic != null
						&& userMatrix.getTopic().equalsIgnoreCase(topic)) {
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
	
	/**
	 * 
	 * @return the matrixs
	 */
	public List<Matrix> getMatrixs() {
		matrixs = matrixFacade.findAll();
		return matrixs;

	}

	/**
	 * @return the matrix
	 */
	public Matrix getMatrix() {
		return matrix;
	}

	/**
	 * @param matrix the matrix to set
	 */
	public void setMatrix(Matrix matrix) {
		this.matrix = matrix;
	}

	/**
	 * @param matrixs the matrixs to set
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
	 * @param status the status to set
	 */
	public void setStatus(Date status) {
		this.status = status;
	}

	/**
	 * @return the users
	 */
	public List<User> getUsers() {
		users = userFacade.findAll();
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Matrix> getUsersMatrixs() {
		return usersMatrixs;
	}

	public void setUsersMatrixs(List<Matrix> usersMatrixs) {
		this.usersMatrixs = usersMatrixs;
	}

	


	

}
