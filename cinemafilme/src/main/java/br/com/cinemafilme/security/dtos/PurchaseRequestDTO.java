package br.com.cinemafilme.security.dtos;

import br.com.cinemafilme.security.enums.PurchaseStatusEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class PurchaseRequestDTO {
    private Integer ticketQuantity;
    private LocalDateTime purchaseDate;
    private PurchaseStatusEnum status;

    public PurchaseRequestDTO(Integer ticketQuantity, LocalDateTime purchaseDate, PurchaseStatusEnum status) {
        this.ticketQuantity = ticketQuantity;
        this.purchaseDate = purchaseDate;
        this.status = status;
    }

    public PurchaseRequestDTO(){
    }

    public Integer getTicketQuantity() {
        return ticketQuantity;
    }

    public void setTicketQuantity(Integer ticketQuantity) {
        this.ticketQuantity = ticketQuantity;
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
