package edu.wccnet.mbrown99.finProj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.wccnet.mbrown99.finProj.api.RentalNotFoundException;
import edu.wccnet.mbrown99.finProj.dao.CustomerMovieDAO;
import edu.wccnet.mbrown99.finProj.entity.CustomerMovie;

@Service
public class CustomerMovieServiceImpl implements CustomerMovieService {
	@Autowired
	private CustomerMovieDAO customerMovieDAO;

	@Override
	@Transactional
	public List<CustomerMovie> getRentalHistory(int id) {
		// TODO Auto-generated method stub
		List<CustomerMovie> customerMovie = customerMovieDAO.getRentalHistory(id);
		if (customerMovie == null) {
			throw new RentalNotFoundException("not found");
		}
		return customerMovieDAO.getRentalHistory(id);
	}

	@Override
	@Transactional
	public CustomerMovie returnMovie(int id) {
		// TODO Auto-generated method stub
		return customerMovieDAO.returnMovie(id);
	}

	@Override
	@Transactional
	public void rentMovie(CustomerMovie rental) {
		// TODO Auto-generated method stub
		customerMovieDAO.rentMovie(rental);
	}

}
