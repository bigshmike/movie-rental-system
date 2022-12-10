package edu.wccnet.mbrown99.finProj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.wccnet.mbrown99.finProj.dao.CustomerMovieDAO;
import edu.wccnet.mbrown99.finProj.entity.CustomerMovie;
import edu.wccnet.mbrown99.finProj.entity.Movie;

@Service
public class CustomerMovieServiceImpl implements CustomerMovieService {
	@Autowired
	private CustomerMovieDAO customerMovieDAO;

	@Override
	@Transactional
	public List<CustomerMovie> getRentalHistory(int id) {
		// TODO Auto-generated method stub
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
	public List<Movie> searchRequest() {
		// TODO Auto-generated method stub
		return customerMovieDAO.searchRequest();
	}

}
