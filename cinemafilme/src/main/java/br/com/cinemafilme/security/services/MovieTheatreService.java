package br.com.cinemafilme.security.services;

import br.com.cinemafilme.security.dtos.AddressRequestDTO;
import br.com.cinemafilme.security.dtos.AddressResponseDTO;
import br.com.cinemafilme.security.dtos.MovieTheatreResponseDTO;
import br.com.cinemafilme.security.dtos.MovieTheatreRequestDTO;
import br.com.cinemafilme.security.entities.Address;
import br.com.cinemafilme.security.entities.MovieTheatres;
import br.com.cinemafilme.security.repositories.MoviesTheatresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieTheatreService {

    @Autowired
    private AddressService addressService;

    @Autowired
    private MoviesTheatresRepository moviesTheatresRepository;


    public MovieTheatreResponseDTO saveMovieTheatre(MovieTheatreRequestDTO movieTheatreRequestDTO) {
        // Criar o objeto AddressRequestDTO a partir do DTO recebido
        AddressRequestDTO addressRequestDTO = new AddressRequestDTO();
        addressRequestDTO.setCep(movieTheatreRequestDTO.getAddress().getCep());
        addressRequestDTO.setNumero(movieTheatreRequestDTO.getAddress().getNumero());

        // Salvar o endereço e obter o objeto AddressResponseDTO
        AddressResponseDTO addressResponseDTO = addressService.saveAddress(addressRequestDTO);

        // Criar o objeto MovieTheatres
        MovieTheatres movieTheatres = new MovieTheatres();
        movieTheatres.setName_theatre(movieTheatreRequestDTO.getName());
        movieTheatres.setPhone(movieTheatreRequestDTO.getPhone());
        movieTheatres.setEmail(movieTheatreRequestDTO.getEmail());

        // Obter o endereço salvo usando o ID do AddressResponseDTO
        Address address = addressService.findById(addressResponseDTO.getId());
        movieTheatres.setMovieTheatresAddress(address);

        // Salvar o cinema
        MovieTheatres savedMovieTheatre = moviesTheatresRepository.save(movieTheatres);

        // Converter o objeto MovieTheatres salvo para MovieTheatreResponseDTO
        MovieTheatreResponseDTO movieTheatre = new MovieTheatreResponseDTO();
        movieTheatre.setName(savedMovieTheatre.getName_theatre());
        movieTheatre.setPhone(savedMovieTheatre.getPhone());
        movieTheatre.setEmail(savedMovieTheatre.getEmail());

        // Criar e definir o endereço na resposta do cinema
        AddressResponseDTO responseAddress = new AddressResponseDTO();
        responseAddress.setId(savedMovieTheatre.getMovieTheatresAddress().getId());
        responseAddress.setCep(savedMovieTheatre.getMovieTheatresAddress().getCep());
        responseAddress.setLogradouro(savedMovieTheatre.getMovieTheatresAddress().getLogradouro());
        responseAddress.setNumero(savedMovieTheatre.getMovieTheatresAddress().getNumero());
        responseAddress.setBairro(savedMovieTheatre.getMovieTheatresAddress().getBairro());
        responseAddress.setLocalidade(savedMovieTheatre.getMovieTheatresAddress().getLocalidade());
        responseAddress.setUf(savedMovieTheatre.getMovieTheatresAddress().getUf());
        responseAddress.setEstado(savedMovieTheatre.getMovieTheatresAddress().getEstado());

        //Retornar o DTO final de resposta
        movieTheatre.setAddress(responseAddress);

        return movieTheatre;
    }

    public List<MovieTheatreResponseDTO> findAll() {
        List<MovieTheatres> movieTheatres = moviesTheatresRepository.findAll();

        return movieTheatres.stream().map(movieTheatre -> {
            MovieTheatreResponseDTO movieTheatreResponseDTO = new MovieTheatreResponseDTO();
            movieTheatreResponseDTO.setName(movieTheatre.getName_theatre());
            movieTheatreResponseDTO.setPhone(movieTheatre.getPhone());
            movieTheatreResponseDTO.setEmail(movieTheatre.getEmail());

            AddressResponseDTO addressResponseDTO = new AddressResponseDTO();
            addressResponseDTO.setCep(movieTheatre.getMovieTheatresAddress().getCep());
            addressResponseDTO.setLogradouro(movieTheatre.getMovieTheatresAddress().getLogradouro());
            addressResponseDTO.setNumero(movieTheatre.getMovieTheatresAddress().getNumero());
            addressResponseDTO.setBairro(movieTheatre.getMovieTheatresAddress().getBairro());
            addressResponseDTO.setLocalidade(movieTheatre.getMovieTheatresAddress().getLocalidade());
            addressResponseDTO.setUf(movieTheatre.getMovieTheatresAddress().getUf());
            addressResponseDTO.setEstado(movieTheatre.getMovieTheatresAddress().getEstado());

            movieTheatreResponseDTO.setAddress(addressResponseDTO);

            return movieTheatreResponseDTO;
        }).collect(Collectors.toList());
    }

    public boolean existsByINameTheatre(String nameTheatre) {
        return moviesTheatresRepository.existsByNameTheatre(nameTheatre);
    }

    public boolean existsById(Integer id) {
        return moviesTheatresRepository.existsById(id);
    }


    public void deleteById(Integer id) {
        moviesTheatresRepository.deleteById(id);
    }


    public MovieTheatreResponseDTO updateMovieTheatre(Integer id, MovieTheatreRequestDTO movieTheatreRequestDTO) {
        // Verificar se o cinema existe
        Optional<MovieTheatres> optionalMovieTheatre = moviesTheatresRepository.findById(id);

        if (optionalMovieTheatre.isPresent()) {
            MovieTheatres movieTheatre = optionalMovieTheatre.get();

            // Atualizar os campos do cinema
            movieTheatre.setName_theatre(movieTheatreRequestDTO.getName());
            movieTheatre.setPhone(movieTheatreRequestDTO.getPhone());
            movieTheatre.setEmail(movieTheatreRequestDTO.getEmail());

            // Atualizar o endereço, se houver alteração
            if (movieTheatreRequestDTO.getAddress() != null) {
                Address address = movieTheatre.getMovieTheatresAddress();
                address.setCep(movieTheatreRequestDTO.getAddress().getCep());
                address.setNumero(movieTheatreRequestDTO.getAddress().getNumero());
            }

            // Salvar as alterações no repositório
            moviesTheatresRepository.save(movieTheatre);

            // Criar o DTO de resposta
            //Construtor ja esta definido na classe MovieTheatreResponseDTO
            return new MovieTheatreResponseDTO(movieTheatre);

        }
        return null;
    }

    public MovieTheatres findById(Integer idCinema) {
        return moviesTheatresRepository.findById(idCinema).orElse(null);
    }
}
