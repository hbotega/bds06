package com.devsuperior.movieflix.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.movieflix.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {


	/*@Query(nativeQuery = true, value = "Select movies.id, movies.title "
			+ "from movies "
			+ "inner join genres on movies.genre_id = genres.id "
			+ "where genres.id = :id")
	Page<Movie> findByGenre(Pageable pageable, Long id);*/
	
	
	@Query(nativeQuery = true, value = "Select tb_movie.id, tb_movie.title, tb_movie.genre_id from tb_movie where genre_id = :id order by title")
	Optional<Movie> findByGenre(Long id);
}
