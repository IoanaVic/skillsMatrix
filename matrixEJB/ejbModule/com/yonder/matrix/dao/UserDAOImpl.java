package com.yonder.matrix.dao;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;

import com.yonder.matrix.model.User;

/**
 * User DAO implementation class for custom CRUD operations
 * 
 * @author IoanaV
 *
 */
@Stateless
public class UserDAOImpl extends GenericDAO<User> implements UserDAO {

	public UserDAOImpl() {
		super(User.class);
	}

	@Override
	public User getById(int id) {
		return super.find(id);

	}

	@Override
	public User findUserByEmail(String email) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("email", email);
		return super.findOneResult(User.FIND_BY_EMAIL, parameters);
	}

}
