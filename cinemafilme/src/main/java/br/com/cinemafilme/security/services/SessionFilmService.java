package br.com.cinemafilme.security.services;

import br.com.cinemafilme.security.dtos.SessionFilmRequestDTO;
import br.com.cinemafilme.security.dtos.SessionFilmResponseDTO;
import br.com.cinemafilme.security.entities.MovieTheatres;
import br.com.cinemafilme.security.entities.Movies;
import br.com.cinemafilme.security.entities.SessionFilm;
import br.com.cinemafilme.security.repositories.SessionFilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SessionFilmService {

    @Autowired
    private SessionFilmeRepository sessionFilmRepository;

    @Autowired
    private MovieTheatreService movieTheatreService;

    @Autowired
    private MovieService movieService;

    public SessionFilmResponseDTO createSessionFilm(Integer idMovieTheatre, Integer idMovie, SessionFilmRequestDTO sessionFilmRequestDTO) {
        Movies movie = movieService.findById(idMovie);
        MovieTheatres movieTheatre = movieTheatreService.findById(idMovieTheatre);

        SessionFilm sessionFilm = new SessionFilm(
                sessionFilmRequestDTO.getSessionTime());

        sessionFilm.setMovie(movie);
        sessionFilm.setMovieTheatre(movieTheatre);

        sessionFilmRepository.save(sessionFilm);

        return new SessionFilmResponseDTO(
                sessionFilm.getId(),
                sessionFilm.getMovie().getTitle(),
                sessionFilm.getMovie().getDirector(),
                sessionFilm.getMovie().getGenre(),
                sessionFilm.getMovie().getYear(),
                sessionFilm.getMovie().getDuration(),
                sessionFilm.getMovieTheatre().getName_theatre(),
                sessionFilm.getMovieTheatre().getPhone(),
                sessionFilm.getMovieTheatre().getEmail(),
                sessionFilm.getMovieTheatre().getMovieTheatresAddress().getCep(),
                sessionFilm.getMovieTheatre().getMovieTheatresAddress().getLogradouro(),
                sessionFilm.getMovieTheatre().getMovieTheatresAddress().getNumero(),
                sessionFilm.getMovieTheatre().getMovieTheatresAddress().getBairro(),
                sessionFilm.getMovieTheatre().getMovieTheatresAddress().getLocalidade(),
                sessionFilm.getMovieTheatre().getMovieTheatresAddress().getUf(),
                sessionFilm.getMovieTheatre().getMovieTheatresAddress().getEstado(),
                sessionFilm.getMovieTheatre().getMovieTheatresAddress().getId(),
                sessionFilm.getSessionTime());
    }

    public List<SessionFilmResponseDTO> findAll() {
        return sessionFilmRepository.findAll().stream()
                .map(sessionFilm -> {
                    return new SessionFilmResponseDTO(
                            sessionFilm.getId(),
                            sessionFilm.getMovie().getTitle(),
                            sessionFilm.getMovie().getDirector(),
                            sessionFilm.getMovie().getGenre(),
                            sessionFilm.getMovie().getYear(),
                            sessionFilm.getMovie().getDuration(),
                            sessionFilm.getMovieTheatre().getName_theatre(),
                            sessionFilm.getMovieTheatre().getPhone(),
                            sessionFilm.getMovieTheatre().getEmail(),
                            sessionFilm.getMovieTheatre().getMovieTheatresAddress().getCep(),
                            sessionFilm.getMovieTheatre().getMovieTheatresAddress().getLogradouro(),
                            sessionFilm.getMovieTheatre().getMovieTheatresAddress().getNumero(),
                            sessionFilm.getMovieTheatre().getMovieTheatresAddress().getBairro(),
                            sessionFilm.getMovieTheatre().getMovieTheatresAddress().getLocalidade(),
                            sessionFilm.getMovieTheatre().getMovieTheatresAddress().getUf(),
                            sessionFilm.getMovieTheatre().getMovieTheatresAddress().getEstado(),
                            sessionFilm.getMovieTheatre().getMovieTheatresAddress().getId(),
                            sessionFilm.getSessionTime());
                })
                .collect(Collectors.toList());
    }
}
