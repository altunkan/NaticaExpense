/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.natica.expense.exceptions;

/**
 *
 * @author Anil
 */
public class ExpenseExcelFormatException extends Exception {

	private String message = null;

	public ExpenseExcelFormatException() {
		super();
	}

	public ExpenseExcelFormatException(String message) {
		super(message);
		this.message = message;
	}

	public ExpenseExcelFormatException(Throwable cause) {
		super(cause);
	}

	@Override
	public String toString() {
		return message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
