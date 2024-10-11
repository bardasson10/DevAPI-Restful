package br.com.cinemafilme.entities;


import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "movies")
public class Movies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movies_cd_filme")
    private Integer id;
    @Column(name = "movies_tx_titulo")
    private String title;
    @Column(name = "movies_tx_diretor")
    private String director;
    @Column(name = "movies_tx_genero")
    private String genre;
    @Column(name = "movies_int_ano")
    private Integer year;
    @Column(name = "movies_tx_duracao")
    private Integer duration;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}
