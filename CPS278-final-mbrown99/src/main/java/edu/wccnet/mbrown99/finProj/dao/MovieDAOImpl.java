package edu.wccnet.mbrown99.finProj.dao;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.wccnet.mbrown99.finProj.entity.Movie;

@Repository
public class MovieDAOImpl implements MovieDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Map<String, String> populateRatings() {
		// TODO Auto-generated method stub
		Map<String, String> ratings = new LinkedHashMap<String, String>();
		ratings.put("G", "G");
		ratings.put("PG", "PG");
		ratings.put("PG-13", "PG-13");
		ratings.put("R", "R");
		ratings.put("NC-17", "NC-17");
		return ratings;
	}

	@Override
	public Map<String, String> populateGenres() {
		// TODO Auto-generated method stub
		Map<String, String> genres = new LinkedHashMap<String, String>();
		genres.put("Action", "Action");
		genres.put("Adventure", "Adventure");
		genres.put("Comedy", "Comedy");
		genres.put("Documentary", "Documentary");
		genres.put("Drama", "Drama");
		genres.put("Fantasy", "Fantasy");
		genres.put("Horror", "Horror");
		genres.put("Musical", "Musical");
		genres.put("Mystery", "Mystery");
		genres.put("Romance", "Romance");
		genres.put("Science Fiction", "Sci-fi");
		genres.put("Sports", "Sports");
		genres.put("Thriller", "Thriller");
		return genres;
	}

	@Override
	public void addMovie(Movie movie) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(movie);
		
	}
	
	@Override
	public List<Movie> getMovies() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query<Movie> query = session.createQuery("from Movie order by title ", Movie.class);
		return query.getResultList();
	}

	@Override
	public Movie getMovie(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.get(Movie.class, id);
	}

}
