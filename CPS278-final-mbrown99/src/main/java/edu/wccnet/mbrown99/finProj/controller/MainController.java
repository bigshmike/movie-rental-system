package edu.wccnet.mbrown99.finProj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.wccnet.mbrown99.finProj.entity.Customer;
import edu.wccnet.mbrown99.finProj.entity.Movie;
import edu.wccnet.mbrown99.finProj.service.CustomerMovieService;
import edu.wccnet.mbrown99.finProj.service.CustomerService;
import edu.wccnet.mbrown99.finProj.service.MovieService;

@Controller
public class MainController {
	@Autowired
	CustomerService customerService;
	
	@Autowired
	MovieService movieService;
	
	@Autowired
	CustomerMovieService customerMovieService;
	
	@GetMapping("/")
	public String customerLogin(Model model) {
		model.addAttribute("customers", customerService.getCustomers());
		return "index";
	}
	
	@RequestMapping("/searchMovies")
	public String searchMovies(Model model) {
		model.addAttribute("movies", movieService.getMovies());
		return "search-movies";
	}
	//working on getting customers logged in so they can browse movies with their unique cust id
	@RequestMapping("/rentalHistory")
	public String listRentals(Model model, @RequestParam("customerId") int id) {
		model.addAttribute("rentals", customerMovieService.getRentalHistory(id));
		Customer customer = customerService.getCustomer(id);
		model.addAttribute("customerName", customer.getFirstName());
		model.addAttribute("customerId", customer.getId());
		return "order-history";
	}
	
	@GetMapping("/addMovie")
	public String addMovie(Model model) {
		Movie movie = new Movie();
		model.addAttribute("movie", movie);
		return "add-movie";
	}
		
	@PostMapping("/processMovie") 
	public String processMovie(@ModelAttribute("movie") Movie movie) {
		movieService.addMovie(movie);
		return "redirect:/searchMovies";
	}
	
	@InitBinder
	public void initialBinderForTrimmingSpaces(WebDataBinder webDataBinder) {
	    StringTrimmerEditor stringTrimEditor = new StringTrimmerEditor(true);
	    webDataBinder.registerCustomEditor(String.class, stringTrimEditor);
	}
	
	@ModelAttribute
	public void populateFormWithData(Model model) {
		model.addAttribute("ratings", movieService.populateRatings());
		model.addAttribute("genres", movieService.populateGenres());
	}
	
}
