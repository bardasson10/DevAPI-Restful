package br.com.cinemafilme.security.entities;

import br.com.cinemafilme.security.enums.PurchaseStatusEnum;
import jakarta.mail.Session;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.NumberFormat;

import java.text.DecimalFormat;
import java.time.LocalDateTime;

@Entity
@Table(name = "purchase")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_cd_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @NotNull
    private User user;

    @ManyToOne
    @JoinColumn(name = "session_id")
    @NotNull
    private SessionFilm sessionFilm;

    @Column(name = "purchase_nm_ticket_quantity")
    @NotNull
    @Min(1)
    private Integer ticketQuantity;

    @Column(name = "purchase_nm_total_price")
    @NotNull
    @Min(0)
    private double totalPrice;

    @Column(name = "purchase_dt_date")
    @NotNull
    @FutureOrPresent
    private LocalDateTime purchaseDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    @NotNull
    private PurchaseStatusEnum status;

    public Purchase( User user, SessionFilm sessionFilm, Integer ticketQuantity, double totalPrice, LocalDateTime purchaseDate, PurchaseStatusEnum status) {
        this.user = user;
        this.sessionFilm = sessionFilm;
        this.ticketQuantity = ticketQuantity;
        this.totalPrice = totalPrice;
        this.purchaseDate = purchaseDate;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public SessionFilm getSessionFilm() {
        return sessionFilm;
    }

    public void setSessionFilm(SessionFilm sessionFilm) {
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
