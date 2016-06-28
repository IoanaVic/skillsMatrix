package com.yonder.matrix.dao;

import com.yonder.matrix.model.User;

/**
 * User DAO interface for CRUD operations
 * 
 * @author IoanaV
 *
 */
public interface UserDAO extends CRUDDAO<User> {

	/**
	 * Get a User by id
	 * 
	 * @param id
	 * @return User entity
	 */
	User getById(int id);

	/**
	 * Get a User by email
	 * 
	 * @param email
	 * @return User entity
	 */
	User findUserByEmail(String email);

}
