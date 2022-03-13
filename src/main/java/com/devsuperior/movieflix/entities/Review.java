package com.devsuperior.movieflix.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_review")
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String text;
	
	@ManyToOne
	@JoinColumn(name = "movie_id")
	//private Long movieId;
	private Movie movie;
	
	
	private User userId;
	
	public Review() {
		
	}

	public Review(Long id, String text, Movie movie, User user) {
		super();
		this.id = id;
		this.text = text;
		this.movie = movie;
		//this.movieId = movieId;
		this.userId = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public User getUser() {
		return userId;
	}

	public void setUser(User user) {
		this.userId = user;
	}

	/*public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}*/
	
}
