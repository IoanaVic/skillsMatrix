package com.yonder.matrix.views;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.yonder.matrix.facade.MatrixFacade;
import com.yonder.matrix.model.Matrix;

@SessionScoped
@ManagedBean
public class DashboardView {

	private Matrix matrix;
	private List<Matrix> matrixs;
	
	@EJB
	private MatrixFacade matrixFacade;

	public List<Matrix> getMatrixs() {
		
		matrixs = matrixFacade.findAll();
		return matrixs;

	}

	/**
	 * @return the matrix
	 */
	public Matrix getMatrix() {
		return matrix;
	}

	/**
	 * @param matrix the matrix to set
	 */
	public void setMatrix(Matrix matrix) {
		this.matrix = matrix;
	}

	/**
	 * @param matrixs the matrixs to set
	 */
	public void setMatrixs(List<Matrix> matrixs) {
		this.matrixs = matrixs;
	}



	

}
