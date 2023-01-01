package edu.wccnet.mbrown99.finProj.dao;

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
		customerMovie.setReturnedDate(LocalDate.now());
		Movie movie = customerMovie.getMovie();
		movie.setNumOfAvailableCopies(movie.getNumOfAvailableCopies() + 1);
		return customerMovie;
	}
	
	@Override
	public void rentMovie(CustomerMovie rental) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(rental);
	}

}
