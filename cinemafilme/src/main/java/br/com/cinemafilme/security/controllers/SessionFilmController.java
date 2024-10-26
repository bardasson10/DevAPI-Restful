package br.com.cinemafilme.security.controllers;


import br.com.cinemafilme.security.dtos.SessionFilmRequestDTO;
import br.com.cinemafilme.security.dtos.SessionFilmResponseDTO;
import br.com.cinemafilme.security.services.SessionFilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sessionfilm")
public class SessionFilmController {

    @Autowired
    private SessionFilmService sessionFilmService;

    @PostMapping("/create/{idMovieTheatre}/{idMovie}")
    public ResponseEntity<SessionFilmResponseDTO> createSession(@PathVariable Integer idMovieTheatre, @PathVariable Integer idMovie, SessionFilmRequestDTO sessionFilmRequestDTO) {
        return ResponseEntity.ok(sessionFilmService.createSessionFilm(idMovieTheatre, idMovie, sessionFilmRequestDTO));
    }

    @GetMapping("/all")
    public ResponseEntity<List<SessionFilmResponseDTO>> findAll() {
        return ResponseEntity.ok(sessionFilmService.findAll());
    }
}
