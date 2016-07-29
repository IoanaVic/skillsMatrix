package com.yonder.matrix.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.yonder.matrix.dao.MatrixDAO;
import com.yonder.matrix.model.Matrix;
import com.yonder.matrix.model.Topic;
import com.yonder.matrix.model.User;

/**
 * Matrix Facade implementation class for custom CRUD operations
 * 
 * @author IoanaV
 *
 */
@Stateless
public class MatrixFacadeImpl implements MatrixFacade {

	@EJB
	private MatrixDAO matrixDAO;

	@Override
	public void save(Matrix matrix) {
		isMatrixWithAllData(matrix);

		matrixDAO.save(matrix);

	}

	@Override
	public Matrix update(Matrix matrix) {
		isMatrixWithAllData(matrix);

		return matrixDAO.update(matrix);
	}

	@Override
	public void delete(Matrix matrix) {
		matrixDAO.delete(matrix.getId());

	}

	@Override
	public Matrix find(int entityID) {

		return matrixDAO.find(entityID);
	}

	@Override
	public List<Matrix> findAll() {

		return matrixDAO.findAll();
	}

	public List<Matrix> findMatricesByUserAndTopic(User user, Topic topic) {
		return matrixDAO.findMatricesByUserAndTopic(user, topic);
	}

	public List<Matrix> findMatricesByTopic(Topic topic) {
		return matrixDAO.findMatricesByTopic(topic);
	}

	private void isMatrixWithAllData(Matrix matrix) {
		boolean hasError = false;

		if (matrix == null) {
			hasError = true;
		}

		if (matrix.getTopic() == null) {
			hasError = true;
		}
		
		if (matrix.getUser() == null) {
			hasError = true;
		}

		if (hasError) {
			throw new IllegalArgumentException(
					"The matrix is missing data. Check the area and topic, they should have value.");
		}
	}
}
