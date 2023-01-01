package edu.wccnet.mbrown99.finProj.dao;

import java.util.List;
import java.util.Map;

import edu.wccnet.mbrown99.finProj.entity.Movie;
import edu.wccnet.mbrown99.finProj.entity.SearchRequest;

public interface MovieDAO {
	public Map<String, String> populateRatings();
	
	public Map<String, String> populateGenres();
	
	public void addMovie(Movie movie);
	
	public List<Movie> getMovies();

	public List<Movie> getMovies(SearchRequest searchRequest);
	
	public Movie getMovie(int id);
	
	public List<Movie> getMovieByTitle(String title);

}
