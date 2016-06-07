package com.yonder.matrix.facade;

import java.util.List;

import javax.ejb.Local;

import com.yonder.matrix.model.User;

@Local
public interface UserFacade {

	abstract void save(User user);

	abstract User update(User user);

	abstract void delete(User user);

	abstract User find(int entityID);

	abstract List<User> findAll();

	User findUserByEmail(String email);

}
