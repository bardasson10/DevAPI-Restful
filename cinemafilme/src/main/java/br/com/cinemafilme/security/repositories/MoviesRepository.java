package br.com.cinemafilme.security.repositories;


import br.com.cinemafilme.security.entities.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("movies")
public interface MoviesRepository extends JpaRepository<Movies, Integer> {
    /*
    @Query("SELECT title FROM public.movies WHERE title = :title_film")
    public void String (String title_film);*/

}
