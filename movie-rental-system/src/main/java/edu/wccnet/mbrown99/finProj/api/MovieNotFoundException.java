package edu.wccnet.mbrown99.finProj.api;

public class MovieNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public MovieNotFoundException(String msg) {
		super(msg);
	}

}
