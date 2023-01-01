package edu.wccnet.mbrown99.finProj.service;

import java.util.List;
import java.util.Map;

import edu.wccnet.mbrown99.finProj.entity.Movie;
import edu.wccnet.mbrown99.finProj.entity.SearchRequest;

public interface MovieService {
	public Map<String, String> populateRatings();
	
	public Map<String, String> populateGenres();
	
	public void addMovie(Movie movie);
	
	public List<Movie> getMovies();

	public List<Movie> getMovies(SearchRequest searchRequest);
	
	public Movie getMovie(int id);
	
	List<Movie> getMovieByTitle(String title);

}
