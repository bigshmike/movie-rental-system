package edu.wccnet.mbrown99.finProj.service;

import java.util.List;

import edu.wccnet.mbrown99.finProj.entity.CustomerMovie;

public interface CustomerMovieService {
	public List<CustomerMovie> getRentalHistory(int id);
	
	public CustomerMovie returnMovie(int id);
	
	void rentMovie(CustomerMovie rental);
}
