package edu.wccnet.mbrown99.finProj.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "movie")
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "movie_info")
	private String movieInfo;
	
	@Column(name = "length_in_min")
	private int lengthInMin;
	
	@Column(name = "year_made")
	private int yearMade;
	
	@Column(name = "release_date")
	private int releaseDate;
	
	@Column(name = "num_of_copies")
	private int numOfCopies;
	
	@Column(name = "rating")
	private String rating;
	
	@Column(name = "genre")
	private String genre;
	
	@JsonBackReference
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id")
	private CustomerMovie checkoutHistory;
	
	public Movie() {
		
	}

	public Movie(String title, String movieInfo, int lengthInMin, int yearMade, int releaseDate, int numOfCopies,
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

	public int getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(int releaseDate) {
		this.releaseDate = releaseDate;
	}

	public int getNumOfCopies() {
		return numOfCopies;
	}

	public void setNumOfCopies(int numOfCopies) {
		this.numOfCopies = numOfCopies;
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

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", description=" + movieInfo + ", lengthInMin=" + lengthInMin
				+ ", yearMade=" + yearMade + ", releaseDate=" + releaseDate + ", numOfCopies=" + numOfCopies
				+ ", rating=" + rating + ", genre=" + genre + "]";
	}
	
	
}
