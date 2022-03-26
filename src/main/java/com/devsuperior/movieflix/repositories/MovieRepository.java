package com.devsuperior.movieflix.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

	//@Query("Select obj from Movie obj inner join obj.genre where :genre in obj.genre")
	//@Query("SELECT obj FROM Movie obj INNER JOIN obj.genre WHERE (:genre IS NULL OR :genre = obj.genre) ORDER BY title")
	@Query("SELECT obj FROM Movie obj WHERE (:genre IS NULL OR :genre = obj.genre) ORDER BY title")
	Page<Movie> findByGenre(Genre genre, Pageable pageable);
}




/*@Query(nativeQuery = true, value = "Select movies.id, movies.title "
		+ "from movies "
		+ "inner join genres on movies.genre_id = genres.id "
		+ "where genres.id = :id")
Page<Movie> findByGenre(Pageable pageable, Long id);*/


//@Query(nativeQuery = true, value = "Select tb_movie.id, tb_movie.title, tb_movie.genre_id from tb_movie where genre_id = :genre")