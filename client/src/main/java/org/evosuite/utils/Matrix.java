/**
 * Copyright (C) 2010-2016 Gordon Fraser, Andrea Arcuri and EvoSuite
 * contributors
 *
 * This file is part of EvoSuite.
 *
 * EvoSuite is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published
 * by the Free Software Foundation, either version 3.0 of the License, or
 * (at your option) any later version.
 *
 * EvoSuite is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with EvoSuite. If not, see <http://www.gnu.org/licenses/>.
 */
/**
 * 
 */
package org.evosuite.utils;

/**
 * @author Mingyu Jin
 * 
 */
public class Matrix {
	private int rowSize;
	private int colSize;
	
	private double values[][];
	
	public Matrix(int _rowSize, int _colSize) {
		this(_rowSize, _colSize, 0.0);
	}
	
	public Matrix(int _rowSize, int _colSize, double _init) {
		this.rowSize = _rowSize;
		this.colSize = _colSize;
		
		values = new double[rowSize][colSize];
		
		for (int i = 0; i < rowSize; i++)
			for (int j = 0; j < colSize; j++)
				values[i][j] = _init;
	}
	
	public void setValue(int row, int col, double val) {
		if (row >= rowSize || col >= colSize || row < 0 || col < 0)
			return;
		
		values[row][col] = val;
	}
	
	public double getValue(int row, int col) {
		if (row >= rowSize || col >= colSize || row < 0 || col < 0)
			return -1.0;
		
		return values[row][col];
	}
	
	public void updateMinValue(int row, int col, double val) {
		//if (row >= rowSize || col >= colSize || row < 0 || col < 0)
		//	return;
		
		if (val < values[row][col])
			values[row][col] = val;
	}
	
	public double getRowSum(int row) {
		double res = 0.0;
		
		for (int i = 0; i < rowSize; i++)
			res += values[row][i];
		
		return res;
	}
	
	public double getColSum(int col) {
		double res = 0.0;
		
		for (int i = 0; i < colSize; i++)
			res += values[i][col];
		
		return res;
	}
	
	public double getWholeSum() {
		double res = 0.0;
		
		for (int i = 0; i < rowSize; i++)
			for (int j = 0; j < colSize; j++) {
				res += values[i][j];
			}
			
		return res;
	}

	public String toString() {
		String res = "";

		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < colSize; j++) {
				res += values[i][j] + ",\t";
			}
			res += "\n";
		}

		return res;
	}
}
