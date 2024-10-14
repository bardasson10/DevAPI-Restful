package br.com.cinemafilme.repositories;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository("movie_theatres")
public interface MoviesTheatresRepository {
    /*
    @Value("SELECT name_theatre FROM public.movie_theatres WHERE name_theatre = :name_theatre_r")
    public void String (String name_theatre_r);*/
}
