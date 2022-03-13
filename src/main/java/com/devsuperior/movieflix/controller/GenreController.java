package com.devsuperior.movieflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.dto.GenreDTO;
import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.service.GenreService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@RestController
@RequestMapping(value="/genres")
public class GenreController {
	
	@Autowired
	private GenreService service;

	/*@GetMapping//(value = "/genres")
	public ResponseEntity<Page<GenreDTO>> findAll(Pageable pageable){
		Page<GenreDTO> page = service.findAll(pageable);
		return ResponseEntity.ok().body(page);
	}*/
	
	/*@GetMapping//(value ="/movies")
	public ResponseEntity<Page<GenreDTO>> findByGenre(Pageable pageable){
		PageRequest pageRequest = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("name"));
		Page<GenreDTO> page = service.findAll(pageRequest);
		return ResponseEntity.ok().body(page);
	}*/
	
	@GetMapping//(value ="/movies")
	public ResponseEntity<List<GenreDTO>> findByGenre(Pageable pageable){
		PageRequest pageRequest = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("name"));
		List<GenreDTO> page = service.findAll();
		return ResponseEntity.ok().body(page);
	}

}
