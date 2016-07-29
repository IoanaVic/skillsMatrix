package com.yonder.matrix.dao;

import java.util.List;

import com.yonder.matrix.model.Matrix;
import com.yonder.matrix.model.Topic;
import com.yonder.matrix.model.User;

/**
 * Matrix DAO interface for CRUD operations
 * 
 * @author IoanaV
 *
 */
public interface MatrixDAO extends CRUDDAO<Matrix> {

	/**
	 * Get a matrix by id
	 * 
	 * @param id
	 * @return Matrix entity
	 */
	Matrix getById(int id);

	/**
	 * Get a list of Matrix by user and topic
	 * 
	 * @param user
	 * @param topic
	 * @return List<Matrix>
	 */
	List<Matrix> findMatricesByUserAndTopic(User user, Topic topic);
	
	/**
	 *  Get a list of Matrix by topic
	 * @param topic
	 * @return List<Matrix>
	 */
	List<Matrix> findMatricesByTopic(Topic topic);

}
