package br.com.cinemafilme.security.dtos;

public class AddressRequestDTO {
    private String cep;
    private Integer numero;

    public AddressRequestDTO() {
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
