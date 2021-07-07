package com.example.corailbackend.exception;

public class LibelleVideException extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = -3049119896584845954L;

	private static final String MESSAGE = "Le libellé ne peut être vide";

	public LibelleVideException() {
		super(LibelleVideException.MESSAGE);
	}
}
