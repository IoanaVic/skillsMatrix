package com.yonder.matrix.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import com.yonder.matrix.model.Matrix;
import com.yonder.matrix.model.User;

/**
 * Matrix DAO implementation class for CRUD operations
 * 
 * @author IoanaV
 *
 */
@Stateless
public class MatrixDAOImpl extends GenericDAO<Matrix> implements MatrixDAO {

	public MatrixDAOImpl() {
		super(Matrix.class);
	}

	@Override
	public Matrix getById(int id) {
		return super.find(id);
	}

	@Override
	public List<Matrix> findMatrixsByUserAndTopic(User user, String topic) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("user", user);
		parameters.put("topic", topic);
		return super.findByEntity(Matrix.FIND_BY_USER_AND_TOPIC, parameters);
	}

}
