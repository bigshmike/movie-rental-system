package edu.wccnet.mbrown99.finProj.dao;

import java.util.List;

import edu.wccnet.mbrown99.finProj.entity.CustomerMovie;
import edu.wccnet.mbrown99.finProj.entity.Movie;

public interface CustomerMovieDAO {
	public List<CustomerMovie> getRentalHistory(int id);
	
	public CustomerMovie returnMovie(int id);

	public List<Movie> searchRequest();
}
