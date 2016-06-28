package com.yonder.matrix.dao;

import javax.ejb.Stateless;

import com.yonder.matrix.model.Topic;

/**
 * Topic DAO implementation class for CRUD operations
 * 
 * @author IoanaV
 *
 */
@Stateless
public class TopicDAOImpl extends GenericDAO<Topic> implements TopicDAO {

	public TopicDAOImpl() {
		super(Topic.class);
	}

	@Override
	public Topic getById(int id) {
		return super.find(id);
	}

}
