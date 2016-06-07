package com.yonder.matrix.dao;

import com.yonder.matrix.model.User;

/**
 * User DAO interface for custom CRUD operations
 * 
 * @author IoanaV
 *
 */
public interface UserDAO extends CRUDDAO<User> {

	User getById(int id);
	
	User findUserByEmail(String email);

}
