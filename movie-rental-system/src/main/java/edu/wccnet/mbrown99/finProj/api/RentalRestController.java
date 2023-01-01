package edu.wccnet.mbrown99.finProj.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.wccnet.mbrown99.finProj.entity.CustomerMovie;
import edu.wccnet.mbrown99.finProj.service.CustomerMovieService;

@RestController
@RequestMapping("/api")
public class RentalRestController {
	@Autowired
	CustomerMovieService customerMovieService;
	
	@GetMapping("/rentalHistory/{customerId}")
	public List<CustomerMovie> getRentals(@PathVariable int customerId) {
		return customerMovieService.getRentalHistory(customerId);
	}
	
	@ExceptionHandler
	public ResponseEntity<RentalNotFoundErrorResponse> handleException(RentalNotFoundException e) {
		RentalNotFoundErrorResponse error = new RentalNotFoundErrorResponse();
		error.setMessage(e.getMessage());
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<RentalNotFoundErrorResponse> handleException(Exception e) {
		RentalNotFoundErrorResponse error = new RentalNotFoundErrorResponse();
		error.setMessage(e.getMessage());
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}
