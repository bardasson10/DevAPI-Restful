package br.com.cinemafilme.security.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "movie_theatres")
public class MovieTheatres {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_theatres_cd_id")
    private Integer id;

    @Column(name = "movie_theatres_tx_nome")
    @NotBlank
    @Size(max = 30)
    private String nameTheatre;

    @Column(name = "movie_theatres_tx_telefone")
    @Size(min = 9, max = 15)
    private String phone;
    @Column(name = "movie_theatres_tx_email")
    @Email
    private String email;
    @ManyToMany
    @JoinTable(
            name = "movie_theatres_movies",
            joinColumns = @JoinColumn(name = "movie_theatres_cd_id"),
            inverseJoinColumns = @JoinColumn(name = "movies_cd_id")
    )
    private Set<Movies> movies = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_cd_id")
    private Address movieTheatresAddress;


    public MovieTheatres(String nameTheatre, String phone, String email, Set<Movies> movies, Address movieTheatresAddress) {
        this.nameTheatre = nameTheatre;
        this.phone = phone;
        this.email = email;
        this.movies = movies;
        this.movieTheatresAddress = movieTheatresAddress;
    }

    public MovieTheatres() {

    }

    public MovieTheatres(Integer id, String nameTheatre) {
        this.id = id;
        this.nameTheatre = nameTheatre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNametheatre() {
        return nameTheatre;
    }

    public void setNametheatre(String nameTheatre) {
        this.nameTheatre = nameTheatre;
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

    public Address getMovieTheatresAddress() {
        return movieTheatresAddress;
    }

    public void setMovieTheatresAddress(Address movieTheatresAddress) {
        this.movieTheatresAddress = movieTheatresAddress;
    }

}
