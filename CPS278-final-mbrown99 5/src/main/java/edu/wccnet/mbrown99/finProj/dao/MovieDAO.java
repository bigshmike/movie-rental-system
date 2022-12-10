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
	
	public Movie getMovieByTitle(String title);
	
	public Movie getMovieByInfo(String movieInfo);

	void returnMovie(int id);

	public List<Movie> getMovies(SearchRequest searchRequest);

	List<Movie> getMovie(int id);

}
