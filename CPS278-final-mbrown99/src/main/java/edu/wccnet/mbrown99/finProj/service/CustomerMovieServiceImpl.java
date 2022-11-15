package edu.wccnet.mbrown99.finProj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.wccnet.mbrown99.finProj.entity.CustomerMovie;

@Service
public class CustomerMovieServiceImpl implements CustomerMovieService {
	@Autowired
	CustomerMovieService customerMovieService;

	@Override
	@Transactional
	public List<CustomerMovie> getRentalHistory(int id) {
		// TODO Auto-generated method stub
		return customerMovieService.getRentalHistory(id);
	}

}
