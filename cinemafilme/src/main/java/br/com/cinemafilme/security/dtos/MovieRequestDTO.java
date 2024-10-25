package br.com.cinemafilme.security.dtos;

public class MovieRequestDTO {
    Integer id;
    String title;
    String director;
    String genre;
    Integer year;
    Integer duration;

    public MovieRequestDTO( String title, String director, String genre, Integer year, Integer duration) {
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.year = year;
        this.duration = duration;
    }

    public MovieRequestDTO() {
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
