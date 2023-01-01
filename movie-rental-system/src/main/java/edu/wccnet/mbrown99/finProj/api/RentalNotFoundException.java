package edu.wccnet.mbrown99.finProj.api;

public class RentalNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public RentalNotFoundException(String msg) {
		super(msg);
	}

}
