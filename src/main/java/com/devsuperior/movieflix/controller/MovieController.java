package com.devsuperior.movieflix.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.dto.GenreDTO;
import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.service.MovieService;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {
	
	@Autowired
	private MovieService service;
	
	@GetMapping(value ="/{id}")
	public ResponseEntity<MovieDTO> findById(@PathVariable Long id){
		MovieDTO movie = service.findById(id);
		if(movie == null) {
			return ResponseEntity.notFound().build();
		}
		else {
			return ResponseEntity.ok().body(movie);
		}
		
	}
	
	@GetMapping//(value = "/movies?genreId=")
	public ResponseEntity<Page<MovieDTO>> findByGenre(@RequestParam(value = "genreId", defaultValue = "0") Long genreId,Pageable pageable){
		//PageRequest pageRequest = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("title"));
		//Optional<MovieDTO> page =  service.findByGenre(pageable, id);
		Page<MovieDTO> list = service.findByGenre(genreId, pageable);
		return ResponseEntity.ok(list);
	}
	
	/*@GetMapping//(value ="/genres/{id}")
	public ResponseEntity<MovieDTO> findByGenre(@PathVariable Long id){
		MovieDTO movie = service.findByGenre(id);
		return ResponseEntity.ok().body(movie);
	}*/
}
