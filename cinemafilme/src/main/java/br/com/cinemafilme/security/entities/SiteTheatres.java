package br.com.cinemafilme.security.entities;


import jakarta.persistence.*;



@Entity
@Table(name = "site_theatres")
public class SiteTheatres {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "site_theatres_cd_cinema")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

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
}
