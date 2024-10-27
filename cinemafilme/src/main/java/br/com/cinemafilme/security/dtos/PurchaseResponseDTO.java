package br.com.cinemafilme.security.dtos;

import br.com.cinemafilme.security.entities.SessionFilm;
import br.com.cinemafilme.security.entities.User;
import br.com.cinemafilme.security.enums.PurchaseStatusEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PurchaseResponseDTO {
    Integer idPurchase;
    private User user;
    private SessionFilmResponseDTO sessionFilm;
    private Integer ticketQuantity;
    private double totalPrice;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime purchaseDate;
    private PurchaseStatusEnum status;

    public PurchaseResponseDTO(Integer idPurchase, User user, SessionFilmResponseDTO sessionFilm, Integer ticketQuantity, double totalPrice, LocalDateTime purchaseDate, PurchaseStatusEnum status) {
        this.idPurchase = idPurchase;
        this.user = user;
        this.sessionFilm = sessionFilm;
        this.ticketQuantity = ticketQuantity;
        this.totalPrice = totalPrice;
        this.purchaseDate = purchaseDate;
        this.status = status;
    }

    public PurchaseResponseDTO(){
    }




    public PurchaseResponseDTO(Integer id, LocalDateTime purchaseDate, Integer ticketQuantity, double totalPrice, PurchaseStatusEnum status, Integer idUser, String email, SessionFilmResponseDTO sessionFilmResponseDTO) {
        this.idPurchase = id;
        this.purchaseDate = purchaseDate;
        this.ticketQuantity = ticketQuantity;
        this.totalPrice = totalPrice;
        this.status = status;
        this.user = new User(idUser, email);
        this.sessionFilm = sessionFilmResponseDTO;
    }

    public Integer getIdPurchase() {
        return idPurchase;
    }

    public void setIdPurchase(Integer idPurchase) {
        this.idPurchase = idPurchase;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public SessionFilmResponseDTO getSessionFilm() {
        return sessionFilm;
    }

    public void setSessionFilm(SessionFilmResponseDTO sessionFilm) {
        this.sessionFilm = sessionFilm;
    }

    public Integer getTicketQuantity() {
        return ticketQuantity;
    }

    public void setTicketQuantity(Integer ticketQuantity) {
        this.ticketQuantity = ticketQuantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public PurchaseStatusEnum getStatus() {
        return status;
    }

    public void setStatus(PurchaseStatusEnum status) {
        this.status = status;
    }
}

