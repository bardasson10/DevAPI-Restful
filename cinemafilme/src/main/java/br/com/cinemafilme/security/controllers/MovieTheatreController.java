package br.com.cinemafilme.security.controllers;


import br.com.cinemafilme.security.dtos.MovieTheatreResponseDTO;
import br.com.cinemafilme.security.dtos.MovieTheatreRequestDTO;
import br.com.cinemafilme.security.services.MovieTheatreService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movietheatre")
public class MovieTheatreController {

    @Autowired
    private MovieTheatreService movieTheatreService;

    @GetMapping("/list")
    public ResponseEntity<List<MovieTheatreResponseDTO>> listMoviesTheatres() {
        List<MovieTheatreResponseDTO> movieTheatres = movieTheatreService.findAll();
        if (movieTheatres.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(movieTheatres);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<String> adjustMoviesTheatres(@RequestParam  Integer id, @RequestBody MovieTheatreRequestDTO movieTheatreRequestDTO) {
        MovieTheatreResponseDTO updatedMovieTheatre = movieTheatreService.updateMovieTheatre(id, movieTheatreRequestDTO);

        if (updatedMovieTheatre != null) {
            return ResponseEntity.status(HttpStatus.OK).body("Cinema atualizado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cinema não encontrado");
        }
    }


    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteMoviesTheatres(Integer id) {
        if (movieTheatreService.existsById(id)) { // Verifica se o cinema existe
            movieTheatreService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Cinema deletado");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cinema não encontrado");
        }
    }

    @SecurityRequirement(name = "Bearer Auth")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/save")
    public ResponseEntity<MovieTheatreResponseDTO> registerMovieTheatre(@RequestBody MovieTheatreRequestDTO movieTheatreRequestDTO) {
        if(movieTheatreService.existsByINameTheatre(movieTheatreRequestDTO.getName())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }else {
            return ResponseEntity.status(HttpStatus.CREATED).body(movieTheatreService.saveMovieTheatre(movieTheatreRequestDTO));
        }
    }
}

