package edu.wccnet.mbrown99.finProj.controller;

import java.time.LocalDate;
import java.util.List;

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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.wccnet.mbrown99.finProj.entity.Customer;
import edu.wccnet.mbrown99.finProj.entity.CustomerMovie;
import edu.wccnet.mbrown99.finProj.entity.Movie;
import edu.wccnet.mbrown99.finProj.entity.SearchRequest;
import edu.wccnet.mbrown99.finProj.service.CustomerMovieService;
import edu.wccnet.mbrown99.finProj.service.CustomerService;
import edu.wccnet.mbrown99.finProj.service.MovieService;

@Controller
public class MainController {
	private CustomerMovie customerMovie;
	
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
	
	@RequestMapping("/searchMoviesGuest")
	public String searchMoviesGuest(Model model) {
		model.addAttribute("movies", movieService.getMovies());
		return "search-movies-guest";
	}
	
	@RequestMapping("/searchDatabase")
	public ModelAndView searchDatabase(Model model, @RequestParam("customerId") int id, RedirectAttributes redirectAttributes) {
		Customer customer = customerService.getCustomer(id);
		SearchRequest searchRequest = new SearchRequest();
		model.addAttribute("searchRequest", searchRequest);
		model.addAttribute("searchType", searchRequest.getSearchType());
		model.addAttribute("inputText", searchRequest.getInputText());
		model.addAttribute("customerId", customer.getId());
		if (customerMovie == null) {
			customerMovie = new CustomerMovie(customer);
		}
		model.addAttribute("customerMovie", customerMovie);
		redirectAttributes.addAttribute("customerId", customer.getId());
		return new ModelAndView("search-database", "searchRequest", new SearchRequest());
	}
	
	@PostMapping("/processSearchRequest")
	public String processSearchRequest(Model model, @ModelAttribute("searchRequest") SearchRequest searchRequest) {
		List<Movie> movies = movieService.getMovies(searchRequest);
		model.addAttribute("queriedMovies", movies);
		model.addAttribute("searchRequest", searchRequest);
		return "search-results";
	}

	@RequestMapping("/rentalHistory")
	public String listRentals(Model model, @RequestParam("customerId") int id, RedirectAttributes redirectAttributes) {
		model.addAttribute("rentals", customerMovieService.getRentalHistory(id));
		Customer customer = customerService.getCustomer(id);
		model.addAttribute("customerName", customer.getFirstName());
		model.addAttribute("customerId", customer.getId());
		redirectAttributes.addAttribute("customerId", id);
		return "order-history";
	}
	
	@GetMapping("/addMovie")
	public String addMovie(Model model) {
		Movie movie = new Movie();
		model.addAttribute("movie", movie);
		return "add-movie";
	}
	
	@RequestMapping("/rentMovie")
	public String rentMovie(Model model, @RequestParam("movieId") int movieId, @RequestParam("customerId") int customerId, RedirectAttributes redirectAttributes) {
		Movie movie = movieService.getMovie(movieId);
		int numOfAvailableCopies = movie.getNumOfAvailableCopies();
		movie.setNumOfAvailableCopies(numOfAvailableCopies - 1);
		movieService.addMovie(movie);
		Customer customer = customerService.getCustomer(customerId);
		CustomerMovie rental = new CustomerMovie(customer, movie);
		rental.setCheckoutDate(LocalDate.now());
		model.addAttribute("rental", rental);
		model.addAttribute("customerId", customer.getId());
		movieId = customerMovie.getMovie().getId();
		customerId = customerMovie.getCustomer().getId();
		customerMovieService.rentMovie(rental);
		redirectAttributes.addAttribute("movieId", movie.getId());
		redirectAttributes.addAttribute("customerId", customer.getId());
		return "redirect:/order-history";
	}
	
	@PostMapping("/returnMovie") 
	public String returnMovie(Model model, @RequestParam("rentalId") int id, RedirectAttributes redirectAttributes) {
		CustomerMovie customerMovie = customerMovieService.returnMovie(id);
		int rentalId = customerMovie.getId();
		int customerId = customerMovie.getCustomer().getId();
		model.addAttribute("rentalId", id);
		model.addAttribute("customerId", rentalId);
		redirectAttributes.addAttribute("customerId", customerId);
		return "redirect:/rentalHistory";
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
