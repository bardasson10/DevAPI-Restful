package br.com.cinemafilme.security.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "session_film")
public class SessionFilm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "session_cd_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "movies_cd_id")
    @NotNull(message = "Movie cannot be null")
    private Movies movie;

    @ManyToOne
    @JoinColumn(name = "movie_theatre_id")
    @NotNull(message = "Movie theatre cannot be null")
    private MovieTheatres movieTheatre;

    @Column(name = "session_time")
    @NotNull(message = "Session time cannot be null")
    @Future(message = "Session time must be in the future")
    private LocalDateTime sessionTime;



    public SessionFilm(Movies movie, MovieTheatres movieTheatre, LocalDateTime sessionTime) {
        this.movie = movie;
        this.movieTheatre = movieTheatre;
        this.sessionTime = sessionTime;
    }

    public SessionFilm(LocalDateTime sessionTime) {
        this.sessionTime = sessionTime;
    }

    public SessionFilm() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Movies getMovie() {
        return movie;
    }

    public void setMovie(Movies movie) {
        this.movie = movie;
    }

    public MovieTheatres getMovieTheatre() {
        return movieTheatre;
    }

    public void setMovieTheatre(MovieTheatres movieTheatre) {
        this.movieTheatre = movieTheatre;
    }

    public LocalDateTime getSessionTime() {
        return sessionTime;
    }

    public void setSessionTime(LocalDateTime sessionTime) {
        this.sessionTime = sessionTime;
    }

}
