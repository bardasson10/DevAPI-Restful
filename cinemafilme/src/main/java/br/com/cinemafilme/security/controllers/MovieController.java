package br.com.cinemafilme.security.controllers;

import br.com.cinemafilme.security.Util.Util;
import br.com.cinemafilme.security.dtos.MovieReponseDTO;
import br.com.cinemafilme.security.dtos.MovieRequestDTO;
import br.com.cinemafilme.security.entities.Address;
import br.com.cinemafilme.security.entities.MovieTheatres;
import br.com.cinemafilme.security.services.EmailService;
import br.com.cinemafilme.security.services.MovieService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    EmailService emailService;

    @Autowired
    MovieService moviesService;

    @PostMapping("/save/{idCinema}")
    public ResponseEntity<MovieReponseDTO> saveNew(@PathVariable Integer idCinema, @RequestBody MovieRequestDTO movieRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(moviesService.saveNew(idCinema, movieRequestDTO));
    }

    @PostMapping("/save/unique")
    public ResponseEntity<MovieReponseDTO> save(@RequestBody MovieRequestDTO movieRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(moviesService.save(movieRequestDTO));
    }

    @PostMapping("/selectSave/{idMovie}/{idMovieTheatre}")
    public ResponseEntity<MovieReponseDTO> selectSave(@PathVariable Integer idMovie, @PathVariable Integer idMovieTheatre) {
        return ResponseEntity.status(HttpStatus.CREATED).body(moviesService.selectSave(idMovie, idMovieTheatre));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<MovieReponseDTO> update(@PathVariable Integer id, @RequestBody MovieRequestDTO movieRequestDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(moviesService.updateMovie(id, movieRequestDTO));
    }

    @DeleteMapping("/deleteAll/{id}")
    public ResponseEntity<MovieReponseDTO> delete(@PathVariable Integer id) {
        MovieReponseDTO movies  = moviesService.deleteAll(id);
        return ResponseEntity.status(HttpStatus.OK).body(movies);
    }

    @DeleteMapping("/selectDelete/{idMovie}/{idMovieTheatre}")
    public ResponseEntity<String> selectDelete(@PathVariable Integer idMovie, @PathVariable Integer idMovieTheatre) {
        moviesService.selectDelete(idMovie, idMovieTheatre);
        return ResponseEntity.status(HttpStatus.OK).body("Movie deleted successfully");
    }

    @GetMapping("/list")
    public ResponseEntity<List<MovieReponseDTO>> searchAll() {
        List<MovieReponseDTO> movies = moviesService.findAll();
        return ResponseEntity.ok(movies);
    }


}




