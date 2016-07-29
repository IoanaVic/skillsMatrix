package com.yonder.matrix.facade;

import java.util.List;

import javax.ejb.Local;

import com.yonder.matrix.model.Matrix;
import com.yonder.matrix.model.Topic;
import com.yonder.matrix.model.User;

/**
 * Matrix Facade interface for custom CRUD operations
 * 
 * @author IoanaV
 *
 */
@Local
public interface MatrixFacade {

	/**
	 * Save a Matrix entity into Database
	 * 
	 * @param matrix
	 */
	void save(Matrix matrix);

	/**
	 * Update a Matrix entity from Database
	 * 
	 * @param matrix
	 * @return updated Matrix entity
	 */
	Matrix update(Matrix matrix);

	/**
	 * Delete a Matrix entity from Database
	 * 
	 * @param matrix
	 */
	void delete(Matrix matrix);

	/**
	 * Get a Matrix entity by id
	 * 
	 * @param entityID
	 * @return Matrix entity
	 */
	Matrix find(int entityID);

	/**
	 * Get all Matrix entities
	 * 
	 * @return List<Matrix>
	 */
	List<Matrix> findAll();

	/**
	 * Get a list of Matrix entities by User and by topic
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
