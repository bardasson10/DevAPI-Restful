package br.com.cinemafilme.security.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "movie_theatres")
public class MovieTheatres {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_theatres_cd_cinema")
    private Integer id;
    @Column(name = "movie_theatres_tx_nome")
    private String name_theatre;
    @Column(name = "movie_theatres_tx_telefone")
    private String phone;
    @Column(name = "movie_theatres_tx_email")
    private String email;
    @ManyToMany
    @JoinTable(
            name = "movie_theatres_movies",
            joinColumns = @JoinColumn(name = "movie_theatres_cd_cinema"),
            inverseJoinColumns = @JoinColumn(name = "movies_cd_filme")
    )
    private Set<Movies> movies = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "address_cd_endereco")
    private Address movieTheatreaddres;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName_theatre() {
        return name_theatre;
    }

    public void setName_theatre(String name_theatre) {
        this.name_theatre = name_theatre;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Movies> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movies> movies) {
        this.movies = movies;
    }

    public Address getMovieTheatreaddres() {
        return movieTheatreaddres;
    }

    public void setMovieTheatreaddres(Address movieTheatreaddres) {
        this.movieTheatreaddres = movieTheatreaddres;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
