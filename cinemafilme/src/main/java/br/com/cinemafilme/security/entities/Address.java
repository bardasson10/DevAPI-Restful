package br.com.cinemafilme.security.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_cd_endereco")
    private Integer id;
    @Column(name = "address_int_cep")
    private String cep;
    @Column(name = "address_tx_name")
    private String logradouro;
    @Column(name = "address_tx_number")
    private Integer numero;
    @Column(name = "address_tx_neighborhood")
    private String bairro;
    @Column(name = "address_tx_city")
    private String localidade;
    @Column(name = "address_tx_uf")
    private String uf;
    @Column(name = "address_tx_state")
    private String estado;

    @OneToMany(mappedBy = "movieTheatresAddress")
    private List<MovieTheatres> addressesMovieTheatres;

    public Address(Integer id, String cep, String logradouro, Integer numero, String bairro, String localidade, String uf, String estado, List<MovieTheatres> addressesMovieTheatres) {
        this.id = id;
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
        this.estado = estado;
        this.addressesMovieTheatres = addressesMovieTheatres;
    }

    public Address() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
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

    public List<MovieTheatres> getAddressesMovieTheatres() {
        return addressesMovieTheatres;
    }

    public void setAddressesMovieTheatres(List<MovieTheatres> addressesMovieTheatres) {
        this.addressesMovieTheatres = addressesMovieTheatres;
    }


}
