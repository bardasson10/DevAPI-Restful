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
    private Integer cep;
    @Column(name = "address_tx_name")
    private String name;
    @Column(name = "address_tx_neighborhood")
    private String neighborhood;
    @Column(name = "address_tx_city")
    private String city;
    @Column(name = "address_tx_uf")
    private String uf;
    @Column(name = "address_tx_state")
    private String state;

    @OneToMany(mappedBy = "movieTheatreaddres")
    private List<MovieTheatres> movieTheatres;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<MovieTheatres> getMovieTheatres() {
        return movieTheatres;
    }

    public void setMovieTheatres(List<MovieTheatres> movieTheatres) {
        this.movieTheatres = movieTheatres;
    }
}
