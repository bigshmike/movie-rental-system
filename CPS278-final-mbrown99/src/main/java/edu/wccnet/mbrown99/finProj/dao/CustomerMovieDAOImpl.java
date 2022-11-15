package edu.wccnet.mbrown99.finProj.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.wccnet.mbrown99.finProj.entity.Customer;
import edu.wccnet.mbrown99.finProj.entity.CustomerMovie;

@Repository
public class CustomerMovieDAOImpl implements CustomerMovieDAO {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<CustomerMovie> getRentalHistory(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query<Customer> query = session.createQuery("from Customer where id = :customerId ", Customer.class);
		query.setParameter("customerId", id);
		Customer customer = query.getSingleResult();
		return customer.getCheckoutHistory();
	}

}
