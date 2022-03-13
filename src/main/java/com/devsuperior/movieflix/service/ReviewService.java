package com.devsuperior.movieflix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.dto.UserDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.ReviewRepository;

@Service
public class ReviewService {
	
	@Autowired
	private ReviewRepository repository;
	
	@Autowired
	private AuthService authService;
	
	public ReviewDTO insert(ReviewDTO dto) {
		authService.validateSelfOrMember(dto.getUser().getId());
		Review entity = new Review();
		//entity.setId(dto.getId());
		//entity.setMovie(new Movie());
		//entity.setMovie(dto.getMovie());
		entity.setText(dto.getText());
		entity.setUser(dto.getUser());
		entity.setId(dto.getMovie().getId());
		entity = repository.save(entity);
		return new ReviewDTO(entity);
		
	}
	
	public UserDTO getProfile(Long id) {
		User user = authService.authenticated();
		authService.validateSelfOrMember(user.getId());
		return new UserDTO(user);
	}
	
}
