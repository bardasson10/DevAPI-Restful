package br.com.cinemafilme.security.controllers;


import br.com.cinemafilme.security.dtos.MovieTheatreResponseDTO;
import br.com.cinemafilme.security.dtos.MovieTheatreResquestDTO;
import br.com.cinemafilme.security.services.MovieTheatreService;
import br.com.cinemafilme.security.services.AddressService; // Assegure-se de que isso esteja importado
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cinemas")
public class MovieTheatreController {

    @Autowired
    private MovieTheatreService movieTheatreService;



    @GetMapping("/lista")
    public String listMoviesTheatres() {
        return "Lista de cinemas"; // Considere retornar uma lista real
    }

    @PutMapping("/atualizar")
    public String adjustMoviesTheatres() {
        return "Cinemas atualizados"; // Implementar a lógica para atualizar cinemas
    }

    @DeleteMapping("/deletar")
    public String deleteMoviesTheatres() {
        return "Cinemas deletados"; // Implementar a lógica para deletar cinemas
    }

    @PostMapping("/cinemas/cadastrar")
    public ResponseEntity<MovieTheatreResponseDTO> registerMovieTheatre(@RequestBody MovieTheatreResquestDTO movieTheatreResquestDTO) {
        MovieTheatreResponseDTO response = movieTheatreService.saveMovieTheatre(movieTheatreResquestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}

