package br.com.cinemafilme.security.controllers;
import br.com.cinemafilme.security.dtos.MovieReponseDTO;
import br.com.cinemafilme.security.dtos.MovieRequestDTO;
import br.com.cinemafilme.security.services.EmailService;
import br.com.cinemafilme.security.services.MovieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<MovieReponseDTO> saveNew(@PathVariable Integer idCinema, @RequestBody @Valid MovieRequestDTO movieRequestDTO) {
        if (idCinema == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        MovieReponseDTO movieResponse = moviesService.saveNew(idCinema, movieRequestDTO);
        if (movieResponse != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(movieResponse);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/save/unique")
    public ResponseEntity<MovieReponseDTO> save(@RequestBody @Valid MovieRequestDTO movieRequestDTO) {
        if (movieRequestDTO == null || movieRequestDTO.getTitle() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        MovieReponseDTO movieResponse = moviesService.save(movieRequestDTO);
        if (movieResponse != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(movieResponse);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/selectSave/{idMovie}/{idMovieTheatre}")
    public ResponseEntity<MovieReponseDTO> selectSave(@PathVariable Integer idMovie, @PathVariable Integer idMovieTheatre) {
        if (idMovie == null || idMovieTheatre == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        MovieReponseDTO movieResponse = moviesService.selectSave(idMovie, idMovieTheatre);
        if (movieResponse != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(movieResponse);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<MovieReponseDTO> update(@PathVariable Integer id, @RequestBody @Valid MovieRequestDTO movieRequestDTO) {
        if (id == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        MovieReponseDTO movieResponse = moviesService.updateMovie(id, movieRequestDTO);
        if (movieResponse != null) {
            return ResponseEntity.status(HttpStatus.OK).body(movieResponse);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/deleteAll/{id}")
    public ResponseEntity<MovieReponseDTO> delete(@PathVariable Integer id) {
        if (id == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        MovieReponseDTO movieResponse = moviesService.deleteAll(id);
        if (movieResponse != null) {
            return ResponseEntity.status(HttpStatus.OK).body(movieResponse);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/selectDelete/{idMovie}/{idMovieTheatre}")
    public ResponseEntity<String> selectDelete(@PathVariable Integer idMovie, @PathVariable Integer idMovieTheatre) {
        if (idMovie == null || idMovieTheatre == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("IDs do filme e do cinema são obrigatórios.");
        }
        if (idMovie != null && idMovieTheatre != null) {
            moviesService.selectDelete(idMovie, idMovieTheatre);
            return ResponseEntity.status(HttpStatus.OK).body("Filme deletado com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<MovieReponseDTO>> searchAll() {
        List<MovieReponseDTO> movies = moviesService.findAll();
        if (movies == null || movies.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.ok(movies);
        }
    }


}




