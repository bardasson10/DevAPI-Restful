package br.com.cinemafilme.security.repositories;

import br.com.cinemafilme.security.entities.MovieTheatres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("movie_theatres")
public interface MoviesTheatresRepository extends JpaRepository<MovieTheatres, Integer> {

}
