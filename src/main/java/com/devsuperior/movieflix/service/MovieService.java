package com.devsuperior.movieflix.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.GenreDTO;
import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository repository;
	
	@Autowired
	private AuthService authService;
	
	@Autowired
	private GenreService genreService;

	@Transactional(readOnly = true)
	public MovieDTO findById(Long id) {
		User user = authService.authenticated();
		authService.validateSelfOrMember(user.getId());//antes de relacionar o id autenticado com user.getId estava recebendo forbidden.
		Optional<Movie> obj = repository.findById(id);
		Movie entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found."));
		return new MovieDTO(entity);
	}	//VALIDADO
	
	/*@Transactional(readOnly = true)
	public MovieDTO findById(Long id) {
		Movie movie = repository.getOne(id);
		return new MovieDTO(movie);
	}

	
	/*@Transactional(readOnly = true)
	public Optional<MovieDTO> findById(Long id){
		User user = authService.authenticated();
		authService.validateSelfOrMember(user.getId());
		Optional<Movie> movie = repository.findById(id);
		//if(movie == null) {
		//	throw new ResourceNotFoundException("Resource not found!");
		//}
		return movie.map(x -> new MovieDTO(x));
	}    este era válido e passava 6 testes*/
	 
	
	@Transactional(readOnly = true)
	public Page<MovieDTO> findAll(Pageable pageable){
		User user = authService.authenticated();
		authService.validateSelfOrMember(user.getId());
		Page<Movie> page = repository.findAll(pageable);
		return page.map(x -> new MovieDTO(x));
	}
	

	
	@Transactional(readOnly = true)
	public Optional<MovieDTO> findByGenre(Pageable pageable, Long id) {
		User user = authService.authenticated();
		authService.validateSelfOrMember(user.getId());
		Optional<Movie> page = repository.findByGenre(id);
		return page.map(x -> new MovieDTO(x));
	}
	

}
