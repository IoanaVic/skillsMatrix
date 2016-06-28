package com.yonder.matrix.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.yonder.matrix.dao.TopicDAO;
import com.yonder.matrix.model.Topic;

/**
 * Topic Facade implementation class for custom CRUD operations
 * 
 * @author IoanaV
 *
 */
@Stateless
public class TopicFacadeImpl implements TopicFacade {

	@EJB
	private TopicDAO topicDAO;

	@Override
	public void save(Topic topic) {

		topicDAO.save(topic);

	}

	@Override
	public Topic update(Topic topic) {

		return topicDAO.update(topic);
	}

	@Override
	public void delete(Topic topic) {
		topicDAO.delete(topic.getId());

	}

	@Override
	public Topic find(int entityID) {

		return topicDAO.find(entityID);
	}

	@Override
	public List<Topic> findAll() {

		return topicDAO.findAll();
	}

}
