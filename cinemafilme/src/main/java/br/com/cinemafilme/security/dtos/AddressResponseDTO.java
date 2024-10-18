package br.com.cinemafilme.security.dtos;

import br.com.cinemafilme.security.entities.Address;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class AddressResponseDTO {

        private String cep;
        private String logradouro;
        private Integer numero;
        private String bairro;
        private String localidade;
        private String uf;
        private String estado;

        public AddressResponseDTO(String cep, String logradouro, Integer numero, String bairro, String localidade, String uf, String estado) {
            this.cep = cep;
            this.logradouro = logradouro;
            this.numero = numero;
            this.bairro = bairro;
            this.localidade = localidade;
            this.uf = uf;
            this.estado = estado;
        }

    public AddressResponseDTO() {

    }


    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Address toAddress(AddressResponseDTO addressResponseDTO) {
            Address address = new Address();
            address.setCep(addressResponseDTO.getCep());
            address.setLogradouro(addressResponseDTO.getLogradouro());
            address.setNumero(addressResponseDTO.getNumero());
            address.setBairro(addressResponseDTO.getBairro());
            address.setLocalidade(addressResponseDTO.getLocalidade());
            address.setUf(addressResponseDTO.getUf());
            address.setEstado(addressResponseDTO.getEstado());
        return address;
    }
}
