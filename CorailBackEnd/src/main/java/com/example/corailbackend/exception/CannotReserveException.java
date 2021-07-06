package com.example.corailbackend.exception;

public class CannotReserveException extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private static final String MESSAGE = "Ce matériel ne peut être réservé";

	public CannotReserveException() {
		super(CannotReserveException.MESSAGE);
	}

}
