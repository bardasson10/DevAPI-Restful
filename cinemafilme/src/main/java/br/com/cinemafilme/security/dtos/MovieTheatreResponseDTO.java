package br.com.cinemafilme.security.dtos;


import br.com.cinemafilme.security.entities.MovieTheatres;

public class MovieTheatreResponseDTO {
    private String name;
    private String phone;
    private String email;
    private AddressResponseDTO address; // Usando AddressResponseDTO para encapsular a resposta de endereço

    // Construtor com parâmetros
    public MovieTheatreResponseDTO(String name, String phone, String email, AddressResponseDTO address) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    // Construtor sem parâmetros
    public MovieTheatreResponseDTO() {
    }

    // Construtor que aceita a entidade MovieTheatres
    public MovieTheatreResponseDTO(MovieTheatres movieTheatre) {
        this.name = movieTheatre.getName_theatre();
        this.phone = movieTheatre.getPhone();
        this.email = movieTheatre.getEmail();

        // Convertendo Address para AddressResponseDTO
        if (movieTheatre.getMovieTheatresAddress() != null) {
            this.address = new AddressResponseDTO(movieTheatre.getMovieTheatresAddress());
        }
    }

    public MovieTheatreResponseDTO(Integer id, String nameTheatre, String phone, String email, AddressResponseDTO addressResponseDTO) {
    }


    // Getters e Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public AddressResponseDTO getAddress() {
        return address;
    }

    public void setAddress(AddressResponseDTO address) {
        this.address = address;
    }
}
