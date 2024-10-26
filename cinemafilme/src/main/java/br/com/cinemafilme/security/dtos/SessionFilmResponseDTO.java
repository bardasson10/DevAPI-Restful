package br.com.cinemafilme.security.dtos;
import java.time.LocalDateTime;

public class SessionFilmResponseDTO {
    Integer id;
    MovieReponseDTO movie;
    LocalDateTime sessionTime;

    public SessionFilmResponseDTO(Integer id, MovieReponseDTO movie, LocalDateTime sessionTime) {
        this.id = id;
        this.movie = movie;
        this.sessionTime = sessionTime;
    }

    public SessionFilmResponseDTO() {
    }

    public SessionFilmResponseDTO(Integer id, String title, String director, String genre, Integer year, Integer duration, String nameTheatre, String phone, String email, String cep, String logradouro, Integer numero, String bairro, String localidade, String uf, String estado, Integer id1, LocalDateTime sessionTime) {
    this.id = id;
    this.movie = new MovieReponseDTO(id,
            title,
            director,
            genre,
            year,
            duration,
            new MovieTheatreResponseDTO(
                    id1,
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
}
