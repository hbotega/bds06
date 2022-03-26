package com.devsuperior.movieflix.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;
import com.devsuperior.movieflix.repositories.UserRepository;

@Service
public class ReviewService {
	
	@Autowired
	private ReviewRepository repository;
	
	@Autowired
	private MovieRepository movieRepository;
	
	//@Autowired
	//private UserRepository userRepository;
	
	@Autowired
	private AuthService authService;
	
		
	public ReviewDTO insert(@Valid ReviewDTO dto) {
		User user = authService.authenticated();
		authService.validateSelfOrMember(user.getId());
		Review entity = new Review();
		entity.setId(dto.getId());
		entity.setText(dto.getText());
		entity.setUser(authService.authenticated());
		entity.setMovie(movieRepository.getOne(dto.getMovieId()));
		entity = repository.save(entity);
		return new ReviewDTO(entity);
		
	}
	
	/*public UserDTO getProfile(Long id) {
		User user = authService.authenticated();
		authService.validateSelfOrMember(user.getId());
		return new UserDTO(user);
	}*/
	
}
