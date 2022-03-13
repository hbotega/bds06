package com.devsuperior.movieflix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.UserRepository;
import com.devsuperior.movieflix.services.exceptions.ForbiddenException;
import com.devsuperior.movieflix.services.exceptions.UnauthorizedException;

@Service
public class AuthService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional(readOnly = true)
	public User authenticated() {
		try {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();//método estático - chamada pega usuário reconhecido pelo spring security
		return userRepository.findByEmail(username);
	}
		catch (Exception e) {
			throw new UnauthorizedException("Invalid user.");
		}

	}
	
	public void validateSelfOrMember(Long userId) {
		User user = authenticated();
		//if(!user.getId().equals(userId) || !user.hasRole("ROLE_MEMBER")) {
		if(!user.getId().equals(userId) && !user.hasRole("ROLE_VISITOR")|| !user.getId().equals(userId)  && !user.hasRole("ROLE_MEMBER")) {
		throw new ForbiddenException("Access denied1.");
		}

	}
}
