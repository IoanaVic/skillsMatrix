package com.yonder.matrix.facade;

import java.util.List;

import javax.ejb.Local;

import com.yonder.matrix.model.User;

/**
 * User Facade interface for custom CRUD operations
 * 
 * @author IoanaV
 *
 */
@Local
public interface UserFacade {

	/**
	 * Save a User entity into Database
	 * 
	 * @param user
	 */
	void save(User user);

	/**
	 * Update a User entity from Database
	 * 
	 * @param user
	 * @return updated User entity
	 */
	User update(User user);

	/**
	 * Delete a User entity from Database
	 * 
	 * @param user
	 */
	void delete(User user);

	/**
	 * Get a User entity by id
	 * 
	 * @param entityID
	 * @return User entity
	 */
	User find(int entityID);

	/**
	 * Get all User entities
	 * 
	 * @return List<User>
	 */
	List<User> findAll();

	/**
	 * Get User entity by email
	 * 
	 * @param email
	 * @return User entity
	 */
	User findUserByEmail(String email);

}
