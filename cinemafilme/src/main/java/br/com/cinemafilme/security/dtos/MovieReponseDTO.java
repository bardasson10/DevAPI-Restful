package br.com.cinemafilme.security.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovieReponseDTO {

    Integer id;
    Integer movieTheatreId;
    String title;
    String director;
    String genre;
    Integer year;
    Integer duration;
    MovieTheatreResponseDTO movieTheatreResponseDTO;

    public MovieReponseDTO(Integer id, Integer movieTheatreId, String title, String director, String genre, Integer year, Integer duration) {
        this.id = id;
        this.movieTheatreId = movieTheatreId;
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.year = year;
        this.duration = duration;
    }

    public MovieReponseDTO(Integer id, String title, String director, String genre, Integer year, Integer duration) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.year = year;
        this.duration = duration;
    }

    public MovieReponseDTO(Integer id, String title, String director, String genre, Integer year, Integer duration, MovieTheatreResponseDTO movieTheatre) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.year = year;
        this.duration = duration;
        this.movieTheatreResponseDTO = movieTheatre;
    }


    public MovieReponseDTO() {
    }

    public MovieReponseDTO(Integer idMovie, Integer idMovieTheatre, String title, String director, String genre, Integer year, Integer duration, MovieTheatreResponseDTO movieTheatreResponseDTO) {
    }

    public MovieReponseDTO(String title, String director, String genre, Integer year, Integer duration, Integer idMovieTheatre, String nameMovieTheatre) {
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.year = year;
        this.duration = duration;
        this.movieTheatreId = idMovieTheatre;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMovieTheatreId() {
        return movieTheatreId;
    }

    public void setMovieTheatreId(Integer movieTheatreId) {
        this.movieTheatreId = movieTheatreId;
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
    
    public MovieTheatreResponseDTO getMovieTheatreResponseDTO() {
        return movieTheatreResponseDTO;
    }

    public void setMovieTheatreResponseDTO(MovieTheatreResponseDTO movieTheatreResponseDTO) {
        this.movieTheatreResponseDTO = movieTheatreResponseDTO;
    }
}
