package edu.wccnet.mbrown99.finProj.dao;

import java.util.List;

import edu.wccnet.mbrown99.finProj.entity.CustomerMovie;

public interface CustomerMovieDAO {
	public List<CustomerMovie> getRentalHistory(int id);
	
	public CustomerMovie returnMovie(int id);

	void rentMovie(CustomerMovie rental);
}
