package br.com.cinemafilme.security.dtos;

import br.com.cinemafilme.security.entities.MovieTheatres;
import br.com.cinemafilme.security.entities.Movies;

import java.time.LocalDateTime;

public class SessionFilmRequestDTO {
    LocalDateTime sessionTime;

    public SessionFilmRequestDTO(LocalDateTime sessionTime) {
        this.sessionTime = sessionTime;
    }

    public SessionFilmRequestDTO() {
    }

    public LocalDateTime getSessionTime() {
        return sessionTime;
    }

    public void setSessionTime(LocalDateTime sessionTime) {
        this.sessionTime = sessionTime;
    }
}
