package br.com.cinemafilme.security.dtos;
import java.time.LocalDateTime;

public class SessionFilmResponseDTO {
    private Integer id;
    private MovieReponseDTO movie;
    private LocalDateTime sessionTime;
    private double price;


    public SessionFilmResponseDTO(Integer id, MovieReponseDTO movie, LocalDateTime sessionTime) {
        this.id = id;
        this.movie = movie;
        this.sessionTime = sessionTime;
    }

    public SessionFilmResponseDTO() {
    }

    public SessionFilmResponseDTO(Integer id, String title, String director, String genre, Integer year, Integer duration,Integer idMovieTheatre, String nameTheatre, String phone, String email, String cep, String logradouro, Integer numero, String bairro, String localidade, String uf, String estado, LocalDateTime sessionTime, double price) {
    this.id = id;
    this.movie = new MovieReponseDTO(id,
            title,
            director,
            genre,
            year,
            duration,
            new MovieTheatreResponseDTO(
                    idMovieTheatre,
                    nameTheatre,
                    phone,
                    email,
                    new AddressResponseDTO(
                            cep,
                            logradouro,
                            numero,
                            bairro,
                            localidade,
                            uf,
                            estado)));
    this.sessionTime = sessionTime;
    this.price = price;

    }

    public SessionFilmResponseDTO(Integer idSession, LocalDateTime sessionTime, double price, String title, String director, String genre, Integer year, Integer duration, Integer idMovieTheatre, String nameMovieTheatre) {
        this.id = idSession;
        this.sessionTime = sessionTime;
        this.price = price;
        this.movie = new MovieReponseDTO(title, director, genre, year, duration, idMovieTheatre, nameMovieTheatre);
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MovieReponseDTO getMovie() {
        return movie;
    }

    public void setMovie(MovieReponseDTO movie) {
        this.movie = movie;
    }

    public LocalDateTime getSessionTime() {
        return sessionTime;
    }

    public void setSessionTime(LocalDateTime sessionTime) {
        this.sessionTime = sessionTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
