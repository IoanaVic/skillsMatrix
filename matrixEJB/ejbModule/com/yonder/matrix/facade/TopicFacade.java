package com.yonder.matrix.facade;

import java.util.List;

import javax.ejb.Local;

import com.yonder.matrix.model.Topic;

/**
 * Topic Facade interface for custom CRUD operations
 * 
 * @author IoanaV
 *
 */
@Local
public interface TopicFacade {

	/**
	 * Save a Topic entity into Database
	 * 
	 * @param topic
	 */
	void save(Topic topic);

	/**
	 * Update a Topic entity from Database
	 * 
	 * @param topic
	 * @return updated Topic entity
	 */
	Topic update(Topic topic);

	/**
	 * Delete a Topic entity from Database
	 * 
	 * @param topic
	 */
	void delete(Topic topic);

	/**
	 * Get a Topic entity by id
	 * 
	 * @param entityID
	 * @return Topic entity
	 */
	Topic find(int entityID);

	/**
	 * Get all Topic entities
	 * 
	 * @return List<Topic>
	 */
	List<Topic> findAll();

	

}
