package com.devsuperior.movieflix.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class GenreDTO {
	
	private Long id;
	private String name;
	//private Movie movie;
	@JsonIgnore
	public List<Movie> movie = new ArrayList<>();
	//private Set<Movie> movie = new HashSet<>();
	
	public GenreDTO() {
		
	}

	public GenreDTO(Long id, String name, List<Movie> movie) {
		this.id = id;
		this.name = name;
		this.movie = movie;
	}
	
	public GenreDTO(Genre entity) {
		id = entity.getId();
		name = entity.getName();
		movie = entity.getMovies();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Movie> getMovie() {
		return movie;
	}

	public void setMovie(List<Movie> movie) {
		this.movie = movie;
	}
	
	

}
