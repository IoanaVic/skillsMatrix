package com.yonder.matrix.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.yonder.matrix.dao.UserDAO;
import com.yonder.matrix.model.User;

@Stateless
public class UserFacadeImpl implements UserFacade {

	@EJB
	private UserDAO userDAO;

	@Override
	public void save(User user) {
		isUserWithAllData(user);

		userDAO.save(user);

	}

	@Override
	public User update(User user) {
		isUserWithAllData(user);
		
		return userDAO.update(user);
	}
	
	@Override
	public void delete(User user) {
		userDAO.delete(user.getId());
		
	}

	@Override
	public User find(int entityID) {
		
		return userDAO.find(entityID);
	}

	@Override
	public List<User> findAll() {
		
		return userDAO.findAll();
	}
	
	 public User findUserByEmail(String email) {
	        return userDAO.findUserByEmail(email);
	    }

	private void isUserWithAllData(User user) {
		boolean hasError = false;

		if (user == null) {
			hasError = true;
		}

		if (user.getUsername() == null || "".equals(user.getUsername().trim())) {
			hasError = true;
		}

		if (user.getEmail() == null || "".equals(user.getEmail().trim())) {
			hasError = true;
		}

		if (hasError) {
			throw new IllegalArgumentException(
					"The user is missing data. Check the email and username, they should have value.");
		}
	}

}
