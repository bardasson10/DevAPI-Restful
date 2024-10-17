package br.com.cinemafilme.security.entities;

import br.com.cinemafilme.security.enums.PurchaseStatusEnum;
import jakarta.mail.Session;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "purchase")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private SessionFilm sessionFilm;

    @Column(name = "ticket_quantity")
    private Integer ticketQuantity;

    @Column(name = "total_price")
    private double totalPrice;

    @Column(name = "purchase_date")
    private LocalDateTime purchaseDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private PurchaseStatusEnum status; // Ex: "PENDING", "CONFIRMED", "CANCELLED"

    public Purchase(Integer id, User user, SessionFilm sessionFilm, Integer ticketQuantity, double totalPrice, LocalDateTime purchaseDate, PurchaseStatusEnum status) {
        this.id = id;
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
