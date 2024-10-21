package br.com.cinemafilme.security.services;

import br.com.cinemafilme.security.dtos.AddressRequestDTO;
import br.com.cinemafilme.security.dtos.AddressResponseDTO;
import br.com.cinemafilme.security.dtos.MovieTheatreResponseDTO;
import br.com.cinemafilme.security.dtos.MovieTheatreResquestDTO;
import br.com.cinemafilme.security.entities.Address;
import br.com.cinemafilme.security.entities.MovieTheatres;
import br.com.cinemafilme.security.repositories.MoviesTheatresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieTheatreService {

    @Autowired
    private AddressService addressService;

    @Autowired
    private MoviesTheatresRepository moviesTheatresRepository;


    public MovieTheatreResponseDTO saveMovieTheatre(MovieTheatreResquestDTO movieTheatreResquestDTO) {
        // Criar o objeto AddressRequestDTO a partir do DTO recebido
        AddressRequestDTO addressRequestDTO = new AddressRequestDTO();
        addressRequestDTO.setCep(movieTheatreResquestDTO.getAddress().getCep());
        addressRequestDTO.setNumero(movieTheatreResquestDTO.getAddress().getNumero());
        // Adicione outros campos conforme necessário...

        // Salvar o endereço e obter o objeto AddressResponseDTO
        AddressResponseDTO addressResponseDTO = addressService.saveAddress(addressRequestDTO);

        // Criar o objeto MovieTheatres
        MovieTheatres movieTheatres = new MovieTheatres();
        movieTheatres.setName_theatre(movieTheatreResquestDTO.getName());
        movieTheatres.setPhone(movieTheatreResquestDTO.getPhone());
        movieTheatres.setEmail(movieTheatreResquestDTO.getEmail());

        // Obter o endereço salvo usando o ID do AddressResponseDTO
        Address address = addressService.findById(addressResponseDTO.getId());
        movieTheatres.setMovieTheatresAddress(address);

        // Salvar o cinema
        MovieTheatres savedMovieTheatre = moviesTheatresRepository.save(movieTheatres);

        // Converter o objeto MovieTheatres salvo para MovieTheatreResponseDTO
        MovieTheatreResponseDTO movieTheatreResponse = new MovieTheatreResponseDTO();
        movieTheatreResponse.setName(savedMovieTheatre.getName_theatre());
        movieTheatreResponse.setPhone(savedMovieTheatre.getPhone());
        movieTheatreResponse.setEmail(savedMovieTheatre.getEmail());

        // Criar e definir o endereço na resposta
        AddressResponseDTO responseAddress = new AddressResponseDTO();
        responseAddress.setId(savedMovieTheatre.getMovieTheatresAddress().getId());
        responseAddress.setCep(savedMovieTheatre.getMovieTheatresAddress().getCep());
        responseAddress.setLogradouro(savedMovieTheatre.getMovieTheatresAddress().getLogradouro());
        responseAddress.setNumero(savedMovieTheatre.getMovieTheatresAddress().getNumero());
        responseAddress.setBairro(savedMovieTheatre.getMovieTheatresAddress().getBairro());
        responseAddress.setLocalidade(savedMovieTheatre.getMovieTheatresAddress().getLocalidade());
        responseAddress.setUf(savedMovieTheatre.getMovieTheatresAddress().getUf());
        responseAddress.setEstado(savedMovieTheatre.getMovieTheatresAddress().getEstado());

        // Preencher outros campos do endereço se necessário
        movieTheatreResponse.setAddress(responseAddress);

        return movieTheatreResponse;
    }
}
