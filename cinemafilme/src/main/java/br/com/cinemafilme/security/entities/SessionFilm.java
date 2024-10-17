package br.com.cinemafilme.security.entities;

import jakarta.persistence.*;

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
    @JoinColumn(name = "movie_id")
    private Movies movie;

    @ManyToOne
    @JoinColumn(name = "movie_theatre_id")
    private MovieTheatres movieTheatre;

    @Column(name = "session_time")
    private LocalDateTime sessionTime;

    @OneToMany(mappedBy = "sessionFilm")
    private List<Purchase> purchases;


    public SessionFilm(Integer id, Movies movie, MovieTheatres movieTheatre, LocalDateTime sessionTime) {
        this.id = id;
        this.movie = movie;
        this.movieTheatre = movieTheatre;
        this.sessionTime = sessionTime;
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

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }
}
