package com.devsuperior.movieflix.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;
import com.sun.istack.NotNull;

@Component
public class ReviewDTO {
	
	private Long id;
	
	@Size(min = 10, max = 150, message = "Campo deve ter entre 10 e 150 caracteres")
	@NotEmpty(message = "Campo requerido text")
	private String text;
	
	@NotNull//porque se trata de campo numérico notblank e not empty dão erro, so devem ser usados para campos de string
	private Long movieId;
	
	//@NotBlank(message = "Campo requerido user")
	private User user;
	
	@NotNull
	private Movie movie;
	
	public ReviewDTO() {
		
	}

	public ReviewDTO(Long id, String text, Long movieId, User user) {
		this.id = id;
		this.text = text;
		this.movieId = movieId;
		//this.movie = movie;
		this.user = user;
		}

	public ReviewDTO(Review entity) {
		id = entity.getId();
		text = entity.getText();
		//movie = entity.getMovie();
		movieId = entity.getMovie().getId();
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


	public User getUser() {
		return user;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}
	
	public Long getMovieId() {
		return movieId;
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
	
	/*public Long getUserId() {
		return user.getId();
	}*/
	
	
	
}
