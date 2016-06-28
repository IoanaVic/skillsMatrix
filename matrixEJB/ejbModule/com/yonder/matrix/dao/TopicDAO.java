package com.yonder.matrix.dao;

import com.yonder.matrix.model.Topic;

/**
 * Topic DAO interface for CRUD operations
 * 
 * @author IoanaV
 *
 */
public interface TopicDAO extends CRUDDAO<Topic> {

	/**
	 * Get a topic by id
	 * 
	 * @param id
	 * @return Topic entity
	 */
	Topic getById(int id);
}
