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

	void save(T entity);

	void delete(int id) throws EntityNotFoundException;

	T update(T entity) throws EntityNotFoundException;

	T find(int entityID);

	List<T> findAll();

	T findOneResult(String namedQuery, Map<String, Object> parameters);

	void populateQueryParameters(Query query, Map<String, Object> parameters);

}
