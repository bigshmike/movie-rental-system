package edu.wccnet.mbrown99.finProj.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "movie")
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "title")
	private String title;
	
	@JsonIgnore
	@Column(name = "movie_info")
	private String movieInfo;
	
	@JsonIgnore
	@Column(name = "length_in_min")
	private int lengthInMin;
	
	@JsonIgnore
	@Column(name = "year_made")
	private int yearMade;
	
	@JsonIgnore
	@Column(name = "release_date")
	private String releaseDate;
	
	@JsonIgnore
	@Column(name = "num_of_copies")
	private int numOfCopies;
	
	@JsonIgnore
	@Column(name = "num_of_available_copies")
	private int numOfAvailableCopies;
	
	@JsonIgnore
	@Column(name = "rating")
	private String rating;
	
	@JsonIgnore
	@Column(name = "genre")
	private String genre;
	
	@JsonIgnore
	@OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<CustomerMovie> checkoutHistory = new ArrayList<CustomerMovie>();
	
	public Movie() {
		
	}

	public Movie(String title, String movieInfo, int lengthInMin, int yearMade, String releaseDate, int numOfCopies,
			String rating, String genre) {
		setTitle(title);
		setMovieInfo(movieInfo);
		setLengthInMin(lengthInMin);
		setYearMade(yearMade);
		setReleaseDate(releaseDate);
		setNumOfCopies(numOfCopies);
		setRating(rating);
		setGenre(genre);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMovieInfo() {
		return movieInfo;
	}

	public void setMovieInfo(String movieInfo) {
		this.movieInfo = movieInfo;
	}

	public int getLengthInMin() {
		return lengthInMin;
	}

	public void setLengthInMin(int lengthInMin) {
		this.lengthInMin = lengthInMin;
	}

	public int getYearMade() {
		return yearMade;
	}

	public void setYearMade(int yearMade) {
		this.yearMade = yearMade;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public int getNumOfCopies() {
		return numOfCopies;
	}

	public void setNumOfCopies(int numOfCopies) {
		this.numOfCopies = numOfCopies;
	}

	public int getNumOfAvailableCopies() {
		return numOfAvailableCopies;
	}

	public void setNumOfAvailableCopies(int numOfAvailableCopies) {
		this.numOfAvailableCopies = numOfAvailableCopies;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public List<CustomerMovie> getCheckoutHistory() {
		return checkoutHistory;
	}

	public void setCheckoutHistory(List<CustomerMovie> checkoutHistory) {
		this.checkoutHistory = checkoutHistory;
	}

	@Override
	public String toString() {
		return title;
	}
	
	
}
