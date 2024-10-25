package br.com.cinemafilme.security.repositories;

import br.com.cinemafilme.security.entities.MovieTheatres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("movie_theatres")
public interface MoviesTheatresRepository extends JpaRepository<MovieTheatres, Integer> {
    Optional<MovieTheatres> findByNameTheatre(String nameTheatre); // Matches the property name
    Optional<MovieTheatres> findById(Integer id);
    boolean existsById(Integer id);
    boolean existsByNameTheatre(String nameTheatre); // Matches the property name

    @Query("SELECT mt FROM MovieTheatres mt JOIN mt.movies m WHERE m.id = :movieId")
    List<MovieTheatres> findAllByMovies(@Param("movieId") Integer movieId);
}