package com.yonder.matrix.facade;

import java.util.List;

import javax.ejb.Local;

import com.yonder.matrix.model.Matrix;

@Local
public interface MatrixFacade {

	public abstract void save(Matrix matrix);

	public abstract Matrix update(Matrix matrix);

	public abstract void delete(Matrix matrix);

	public abstract Matrix find(int entityID);

	public abstract List<Matrix> findAll();

}
