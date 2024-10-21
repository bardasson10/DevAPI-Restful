package br.com.cinemafilme.security.dtos;

import br.com.cinemafilme.security.entities.Address;

public class MovieTheatreResponseDTO {
    private String name;
    private String phone;
    private String email;
    private AddressResponseDTO address; // Address response DTO

    // Constructor with all fields
    public MovieTheatreResponseDTO(String name, String phone, String email, AddressResponseDTO address) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    // Default constructor
    public MovieTheatreResponseDTO() {
    }

    // Getters and Setters
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
