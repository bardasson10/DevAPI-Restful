package br.com.cinemafilme.security.repositories;

import br.com.cinemafilme.security.entities.MovieTheatres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("movie_theatres")
public interface MoviesTheatresRepository extends JpaRepository<MovieTheatres, Integer> {
    /*
    @Value("SELECT name_theatre FROM public.movie_theatres WHERE name_theatre = :name_theatre_r")
    public void String (String name_theatre_r);*/
}
