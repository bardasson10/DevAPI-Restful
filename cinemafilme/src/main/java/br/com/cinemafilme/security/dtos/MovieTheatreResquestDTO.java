package br.com.cinemafilme.security.dtos;



public class MovieTheatreResquestDTO {
    private String name;
    private String phone;
    private String email;
    private AddressRequestDTO address;


    public MovieTheatreResquestDTO() {
    }

    public MovieTheatreResquestDTO(String name, String phone, String email, AddressRequestDTO address) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AddressRequestDTO getAddress() {
        return address;
    }

    public void setAddress(AddressRequestDTO address) {
        this.address = address;
    }



}
