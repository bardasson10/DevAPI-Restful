package br.com.cinemafilme.security.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @Column(name = "address_cd_endereco")
    private Integer id;
    @Column(name = "address_int_cep")
    private String cep;
    @Column(name = "address_tx_name")
    private String logradouro;
    @Column(name = "address_tx_neighborhood")
    private String bairro;
    @Column(name = "address_tx_city")
    private String localidade;
    @Column(name = "address_tx_uf")
    private String uf;
    @Column(name = "address_tx_state")
    private String estado;

    @ManyToOne
    @JoinColumn(name = "movie_theatres_cd_cinema")
    private MovieTheatres movieTheatresAddress;

    public Address( String cep, String logradouro, String bairro, String localidade, String uf, String estado, MovieTheatres movieTheatresAddress) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
        this.estado = estado;
        this.movieTheatresAddress = movieTheatresAddress;
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

    public MovieTheatres getMovieTheatresAddress() {
        return movieTheatresAddress;
    }

    public void setMovieTheatresAddress(MovieTheatres movieTheatresAddress) {
        this.movieTheatresAddress = movieTheatresAddress;
    }
}
