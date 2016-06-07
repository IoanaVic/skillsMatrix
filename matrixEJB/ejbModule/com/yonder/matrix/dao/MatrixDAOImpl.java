package com.yonder.matrix.dao;

import javax.ejb.Stateless;

import com.yonder.matrix.model.Matrix;

/**
 * Matrix DAO implementation class for custom CRUD operations
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
		// TODO Auto-generated method stub
		return null;
	}

}
