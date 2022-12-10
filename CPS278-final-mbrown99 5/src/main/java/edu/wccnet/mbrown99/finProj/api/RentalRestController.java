package edu.wccnet.mbrown99.finProj.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.wccnet.mbrown99.finProj.entity.CustomerMovie;
import edu.wccnet.mbrown99.finProj.entity.Movie;
import edu.wccnet.mbrown99.finProj.service.CustomerMovieService;
import edu.wccnet.mbrown99.finProj.service.MovieService;

@RestController
@RequestMapping("/api")
public class RentalRestController {
	@Autowired
	CustomerMovieService customerMovieService;
	
	@Autowired
	MovieService movieService;
	
	@GetMapping("/rentalHistory/{customerId}")
	public List<CustomerMovie> getRentals(@PathVariable int customerId) {
		return customerMovieService.getRentalHistory(customerId);
	}
	
	@GetMapping("/movie/{movieId}")
	public List<Movie> getMovie(@PathVariable int movieId) {
		return movieService.getMovie(movieId);
	}

}
