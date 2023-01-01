package edu.wccnet.mbrown99.finProj.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.wccnet.mbrown99.finProj.entity.Movie;
import edu.wccnet.mbrown99.finProj.service.MovieService;

@RestController
@RequestMapping("/api")
public class MovieRestController {
	@Autowired
	MovieService movieService;
	
	@GetMapping("/movie/{title}")
	public List<Movie> getMovieByTitle(@PathVariable String title) {
		return movieService.getMovieByTitle(title);
	}

}
