package br.com.cinemafilme.security.entities;


import jakarta.mail.Session;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "movies")
public class Movies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movies_cd_filme")
    private Integer id;
    @Column(name = "movies_tx_titulo")
    private String title;
    @Column(name = "movies_tx_diretor")
    private String director;
    @Column(name = "movies_tx_genero")
    private String genre;
    @Column(name = "movies_int_ano")
    private Integer year;
    @Column(name = "movies_tx_duracao")
    private Integer duration;
    @ManyToMany(mappedBy = "movies")
    private List<MovieTheatres> movieTheatres;

    @OneToMany(mappedBy = "movie")
    private List<SessionFilm> sessionFilms;

    public Movies(Integer id, String title, String director, String genre, Integer year, Integer duration, List<MovieTheatres> movieTheatres, List<SessionFilm> sessionFilms) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.year = year;
        this.duration = duration;
        this.movieTheatres = movieTheatres;
        this.sessionFilms = sessionFilms;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public List<MovieTheatres> getMovieTheatres() {
        return movieTheatres;
    }

    public void setMovieTheatres(List<MovieTheatres> movieTheatres) {
        this.movieTheatres = movieTheatres;
    }

    public List<SessionFilm> getSessionFilms() {
        return sessionFilms;
    }

    public void setSessionFilms(List<SessionFilm> sessionFilms) {
        this.sessionFilms = sessionFilms;
    }
}
