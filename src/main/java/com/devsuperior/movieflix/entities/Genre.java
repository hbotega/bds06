package com.devsuperior.movieflix.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_genre")
public class Genre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER)//para que ao ser chamado o usuário do banco os perfis (roles) venham junto
	@JoinColumn(name = "genre_id")
	private List<Movie> movies = new ArrayList<>();
	//private Set<Movie> movies = new HashSet<>();
	
	public Genre() {
		
	}

	public Genre(Long id, String name, List<Movie> movies) {
		super();
		this.id = id;
		this.name = name;
		this.movies = movies;
	}
	
	public Genre(Genre entity) {
		id = entity.getId();
		name = entity.getName();
		movies = entity.getMovies();
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

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
	
	

}
