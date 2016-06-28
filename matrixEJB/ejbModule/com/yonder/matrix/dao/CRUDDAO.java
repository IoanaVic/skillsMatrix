package com.yonder.matrix.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;

/**
 * Generic DAO interface for basic CRUD operations
 * 
 * @author IoanaV
 *
 * @param <T>
 */
public interface CRUDDAO<T> {

	/**
	 * Save an entity into Database
	 * 
	 * @param entity
	 */
	void save(T entity);

	/**
	 * Delete an entity from Database
	 * 
	 * @param id
	 * @throws EntityNotFoundException
	 */
	void delete(int id) throws EntityNotFoundException;

	/**
	 * Update an entity from Database
	 * 
	 * @param entity
	 * @return updated entity T
	 * @throws EntityNotFoundException
	 */
	T update(T entity) throws EntityNotFoundException;

	/**
	 * Get an entity by id
	 * 
	 * @param entityID
	 * @return entity T
	 */
	T find(int entityID);

	/**
	 * Get all entities
	 * 
	 * @return List<T>
	 */
	List<T> findAll();

	/**
	 * Get an entity by a named query
	 * 
	 * @param namedQuery
	 * @param parameters
	 * @return entity T
	 */
	T findOneResult(String namedQuery, Map<String, Object> parameters);

	/**
	 * Get a list of entities by a named query
	 * 
	 * @param namedQuery
	 * @param parameters
	 * @return List<T>
	 */
	List<T> findByEntity(String namedQuery, Map<String, Object> parameters);

	/**
	 * Populate the query parameters map
	 * 
	 * @param query
	 * @param parameters
	 */
	void populateQueryParameters(Query query, Map<String, Object> parameters);

}
