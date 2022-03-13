package com.devsuperior.movieflix.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;

public class ReviewDTO {
	
	private Long id;
	
	@Size(min = 10, max = 150, message = "Campo deve ter entre 10 e 150 caracteres")
	@NotBlank(message = "Campo requerido text")
	private String text;
	
	@NotBlank(message = "Campo requerido movieID")
	private Long movieId;
	
	@NotBlank(message = "Campo requerido user")
	private User user;
	@NotBlank(message = "Campo requerido movie")
	private Movie movie;
	
	public ReviewDTO() {
		
	}

	public ReviewDTO(Long id, String text, Long movieId, User userId) {
		this.id = id;
		this.text = text;
		this.movieId = movieId;
		this.user = userId;
		}

	public ReviewDTO(Review entity) {
		id = entity.getId();
		text = entity.getText();
		movie = entity.getMovie();
		//movieId = entity.getMovieId();
		user = entity.getUser();
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


	public Long getMovieId() {
		Movie movie = new Movie();
		this.movieId = movie.getId();
		return movieId;
	}

	public void setMovieId(Long movieId) {
		//Movie movie = new Movie();
		//movieId = movie.setId(movieId);
		this.movieId = movieId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	
	
}
