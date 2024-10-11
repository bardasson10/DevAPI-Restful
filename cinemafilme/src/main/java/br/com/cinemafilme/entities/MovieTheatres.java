package br.com.cinemafilme.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "movie_theatres")
public class MovieTheatres {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_theatres_cd_cinema")
    private Integer id;
    @Column(name = "movie_theatres_tx_nome")
    private String name_theatre;
    @Column(name = "movie_theatres_tx_endereco")
    private String address;
    @Column(name = "movie_theatres_tx_cidade")
    private String city;
    @Column(name = "movie_theatres_tx_estado")
    private String state;
    @Column(name = "movie_theatres_tx_telefone")
    private String phone;
    @Column(name = "movie_theatres_tx_email")
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name_theatre;
    }

    public void setName(String name_theatre) {
        this.name_theatre = name_theatre;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
