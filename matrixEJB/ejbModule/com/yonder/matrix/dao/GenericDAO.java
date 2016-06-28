package com.yonder.matrix.dao;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 * Generic DAO class for basic CRUD operations and others DAOs
 * 
 * @author IoanaV
 *
 * @param <T>
 */
public abstract class GenericDAO<T> implements CRUDDAO<T> {

	private final static String UNIT_NAME = "MatrixPU";

	@PersistenceContext(unitName = UNIT_NAME)
	private EntityManager em;

	private Class<T> entityClass;

	public GenericDAO(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	@Override
	public void save(T entity) {
		em.persist(entity);
	}

	@Override
	public void delete(int entityID) throws EntityNotFoundException {

		if (entityClass == null) {
			throw new EntityNotFoundException();
		}

		T entityToBeRemoved = em.find(entityClass, entityID);
		em.remove(entityToBeRemoved);

	}

	@Override
	public T update(T entity) {
		return em.merge(entity);
	}

	@Override
	public T find(int entityID) {
		return em.find(entityClass, entityID);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<T> findAll() {
		CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
		cq.select(cq.from(entityClass));
		return em.createQuery(cq).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findOneResult(String namedQuery, Map<String, Object> parameters) {
		T result = null;

		try {
			Query query = em.createNamedQuery(namedQuery);

			// Method that will populate parameters if they are passed not null
			// and empty
			if (parameters != null && !parameters.isEmpty()) {
				populateQueryParameters(query, parameters);
			}

			result = (T) query.getSingleResult();

		} catch (Exception e) {
			System.out.println("Error while running query: " + e.getMessage());
			e.printStackTrace();
		}

		return result;
	}

	@SuppressWarnings("unchecked")
	public List<T> findByEntity(String namedQuery,
			Map<String, Object> parameters) {
		List<T> resultList = null;

		try {
			Query query = em.createNamedQuery(namedQuery);

			// Method that will populate parameters if they are passed not null
			// and empty
			if (parameters != null && !parameters.isEmpty()) {
				populateQueryParameters(query, parameters);
			}

			resultList = (List<T>) query.getResultList();

		} catch (Exception e) {
			System.out.println("Error while running query: " + e.getMessage());
			e.printStackTrace();
		}

		return resultList;
	}

	@Override
	public void populateQueryParameters(Query query,
			Map<String, Object> parameters) {

		for (Entry<String, Object> entry : parameters.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
	}

}
