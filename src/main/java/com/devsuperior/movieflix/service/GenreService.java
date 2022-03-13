package com.devsuperior.movieflix.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.GenreDTO;
import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.GenreRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;

@Service
public class GenreService {
	
	@Autowired
	private AuthService authService;
	
	@Autowired
	private GenreRepository repository;

	public List<GenreDTO> findAll(){
		User user = authService.authenticated();
		authService.validateSelfOrMember(user.getId());
		List<Genre>list = repository.findAll();//(Sort.by("name"));
	return list.stream().map(x -> new GenreDTO(x)).collect(Collectors.toList());
			
			//list.stream().map(x -> new GenreDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public GenreDTO findById(Long id) {
		User user = authService.authenticated();
		authService.validateSelfOrMember(user.getId());//antes de relacionar o id autenticado com user.getId estava recebendo forbidden.
		Optional<Genre> obj = repository.findById(id);
		Genre entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found."));
		return new GenreDTO(entity);
	}
	
	/*public List<GenreDTO> findAll(){
		User user = authService.authenticated();
		authService.validateSelfOrMember(user.getId());
		List<Genre>list = repository.findAll(Sort.by("name"));
	return list.stream().map(x -> new GenreDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public Page<GenreDTO> findAll(Pageable pageable){
		User user = authService.authenticated();
		authService.validateSelfOrMember(user.getId());
		Page<Genre> page = repository.findAll(pageable);
		return page.map(x -> new GenreDTO(x));
	}*/
	
	/*public GenreDTO findAll() {
		User user = authService.authenticated();
		authService.validateSelfOrMember(user.getId());
		List<Genre> genres = repository.findAll();
		Genre entity = (Genre) genres;
		return new GenreDTO(entity);
	}*/

}
