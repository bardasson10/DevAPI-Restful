package br.com.cinemafilme.security.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddressRequestDTO {
    private String cep;

    @JsonProperty("number")
    private Integer numero;

    public AddressRequestDTO() {
    }

    public AddressRequestDTO(String cep, Integer number) {
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

}
