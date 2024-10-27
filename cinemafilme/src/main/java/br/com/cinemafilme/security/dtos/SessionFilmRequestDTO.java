package br.com.cinemafilme.security.dtos;

import java.time.LocalDateTime;

public class SessionFilmRequestDTO {
    private double price;
    private LocalDateTime sessionTime;

    public SessionFilmRequestDTO(LocalDateTime sessionTime, double price) {
        this.sessionTime = sessionTime;
        this.price = price;
    }

    public SessionFilmRequestDTO() {
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
