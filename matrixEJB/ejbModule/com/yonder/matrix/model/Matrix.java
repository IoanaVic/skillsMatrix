package com.yonder.matrix.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Max;

@Entity
@NamedQueries({ @NamedQuery(name = "Matrix.findMatrixByUserAndTopic", query = "SELECT m FROM Matrix m WHERE m.user = :user and m.topic = :topic"),
	@NamedQuery(name = "Matrix.findMatrixByTopic", query = "SELECT m FROM Matrix m WHERE m.topic = :topic")	})
public class Matrix {

	public static final String FIND_BY_USER_AND_TOPIC = "Matrix.findMatrixByUserAndTopic";
	public static final String FIND_BY_TOPIC = "Matrix.findMatrixByTopic";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Max(4)
	private Integer grade;
	private String phase;
	private String details;
	@ManyToOne
	private User user;
	@ManyToOne
	private Topic topic;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the grade
	 */
	public Integer getGrade() {
		return grade;
	}

	/**
	 * @param grade the grade to set
	 */
	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	/**
	 * @return the phase
	 */
	public String getPhase() {
		return phase;
	}

	/**
	 * @param phase the phase to set
	 */
	public void setPhase(String phase) {
		this.phase = phase;
	}

	/**
	 * @return the details
	 */
	public String getDetails() {
		return details;
	}

	/**
	 * @param details the details to set
	 */
	public void setDetails(String details) {
		this.details = details;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the topic
	 */
	public Topic getTopic() {
		return topic;
	}

	/**
	 * @param topic the topic to set
	 */
	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	@Override
	public int hashCode() {
		return (Integer) getId();
	}

	@Override
	public boolean equals(Object obj) {

		if (obj instanceof Matrix) {
			Matrix matrix = (Matrix) obj;
			return matrix.getId() == getId();
		}

		return false;
	}
}
