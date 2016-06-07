package com.yonder.matrix.dao;

import com.yonder.matrix.model.Matrix;

/**
 * Matrix DAO interface for custom CRUD operations
 * 
 * @author IoanaV
 *
 */
public interface MatrixDAO extends CRUDDAO<Matrix> {

	Matrix getById(int id);

}
