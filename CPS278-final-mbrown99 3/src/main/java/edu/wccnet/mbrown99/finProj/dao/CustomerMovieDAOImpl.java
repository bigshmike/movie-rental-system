package edu.wccnet.mbrown99.finProj.dao;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.wccnet.mbrown99.finProj.entity.Customer;
import edu.wccnet.mbrown99.finProj.entity.CustomerMovie;
import edu.wccnet.mbrown99.finProj.entity.Movie;
import edu.wccnet.mbrown99.finProj.entity.SearchRequest;

@Repository
public class CustomerMovieDAOImpl implements CustomerMovieDAO {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<CustomerMovie> getRentalHistory(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query<Customer> query = session.createQuery("from Customer where id = :customerID ", Customer.class);
		query.setParameter("customerID", id);
		Customer customer = query.getSingleResult();
		return customer.getCheckoutHistory();
	}

	@Override
	public CustomerMovie returnMovie(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		CustomerMovie customerMovie = session.get(CustomerMovie.class, id);
		customerMovie.setReturnedDate(Date.valueOf(LocalDate.now()));
		Movie movie = customerMovie.getMovie();
		movie.setNumOfAvailableCopies(movie.getNumOfAvailableCopies() + 1);
		return customerMovie;
		
		
	}
	
	@Override
	public List<Movie> searchRequest() {
		SearchRequest searchRequest = new SearchRequest();
		String searchType = searchRequest.getSearchType();
		String inputText = searchRequest.getInputText();
		String sql = "";
		if (searchType.equals("title")) {
			sql = "from Movie m where m.title like :inputText";
		}
		else {
			sql = "from Movie m where m.movie_info like :inputText";
		}
		Session session = sessionFactory.getCurrentSession();
		Query<Movie> query = session.createQuery(sql, Movie.class);
		query.setParameter("searchType", searchType);
		query.setParameter("inputText", "%"+ inputText.toUpperCase() + "%");
		return query.getResultList();
	}

}
