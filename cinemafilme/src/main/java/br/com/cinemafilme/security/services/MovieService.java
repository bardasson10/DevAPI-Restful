package br.com.cinemafilme.security.services;

import br.com.cinemafilme.security.dtos.AddressResponseDTO;
import br.com.cinemafilme.security.dtos.MovieReponseDTO;
import br.com.cinemafilme.security.dtos.MovieRequestDTO;
import br.com.cinemafilme.security.dtos.MovieTheatreResponseDTO;
import br.com.cinemafilme.security.entities.MovieTheatres;
import br.com.cinemafilme.security.entities.Movies;
import br.com.cinemafilme.security.repositories.MoviesRepository;
import br.com.cinemafilme.security.repositories.MoviesTheatresRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MovieService {

    @Autowired
    private MoviesRepository moviesRepository;

    @Autowired
    private MoviesTheatresRepository moviesTheatreRepository;

    @Autowired
    MovieTheatreService movieTheatreService;

    public MovieReponseDTO save(MovieRequestDTO movieRequestDTO) {
        Movies movies = new Movies(
                movieRequestDTO.getTitle(),
                movieRequestDTO.getDirector(),
                movieRequestDTO.getGenre(),
                movieRequestDTO.getYear(),
                movieRequestDTO.getDuration()
        );

        moviesRepository.save(movies);

        return new MovieReponseDTO(
                movies.getId(),
                movies.getTitle(),
                movies.getDirector(),
                movies.getGenre(),
                movies.getYear(),
                movies.getDuration()
        );
    }

    public MovieReponseDTO saveNew(Integer idCinema, MovieRequestDTO movieRequestDTO) {
        Movies movies = new Movies(
                movieRequestDTO.getTitle(),
                movieRequestDTO.getDirector(),
                movieRequestDTO.getGenre(),
                movieRequestDTO.getYear(),
                movieRequestDTO.getDuration()
        );

        //Busca a pk de cinemas
        MovieTheatres movieTheatres = movieTheatreService.findById(idCinema);
        //Adiciona a chave pk do filme ao cinema
        movieTheatres.getMovies().add(movies);
        //Adiciona a chave pk do cinema ao filme
        movies.getMovieTheatres().add(movieTheatres);

        //Salva as chaves estrangeiras na tabela auxiliar para relacionamento many to many
        moviesRepository.save(movies);
        moviesTheatreRepository.save(movieTheatres);

        return new MovieReponseDTO(
                movies.getId(),
                movieTheatres.getId(),
                movies.getTitle(),
                movies.getDirector(),
                movies.getGenre(),
                movies.getYear(),
                movies.getDuration()
        );
    }

    public MovieReponseDTO selectSave(Integer idCinema, Integer idMovie) {

        //Busca a pk de filmes
        Movies movies = moviesRepository.findById(idCinema).orElseThrow(() -> new EntityNotFoundException("Filme não encontrado."));

        //Busca a pk de cinemas
        MovieTheatres movieTheatres = movieTheatreService.findById(idMovie);
        //Adiciona a chave pk do filme ao cinema
        movieTheatres.getMovies().add(movies);
        //Adiciona a chave pk do cinema ao filme
        movies.getMovieTheatres().add(movieTheatres);

        //Salva as chaves estrangeiras na tabela auxiliar para relacionamento many to many
        moviesRepository.save(movies);
        moviesTheatreRepository.save(movieTheatres);

        return new MovieReponseDTO(
                movies.getId(),
                movieTheatres.getId(),
                movies.getTitle(),
                movies.getDirector(),
                movies.getGenre(),
                movies.getYear(),
                movies.getDuration()
        );
    }


    public List<MovieReponseDTO> findAll() {
        List<Movies> movies = moviesRepository.findAll();

        return movies.stream().map(movie -> new MovieReponseDTO(
                movie.getId(),
                movie.getTitle(),
                movie.getDirector(),
                movie.getGenre(),
                movie.getYear(),
                movie.getDuration()
        )).toList();
    }
    //Funcao que deleta um filme todos os cinemas
    public MovieReponseDTO deleteAll(Integer id) {
        // Busca o filme pelo ID
        Optional<Movies> optionalMovies = moviesRepository.findById(id);

        if (optionalMovies.isPresent()) {
            Movies movies = optionalMovies.get();

            // Busca todos os cinemas que possuem esse filme
            List<MovieTheatres> movieTheatresList = moviesTheatreRepository.findAllByMovies(movies.getId());

            // Remove o filme de cada cinema
            for (MovieTheatres movieTheatres : movieTheatresList) {
                movieTheatres.getMovies().remove(movies);
                movies.getMovieTheatres().remove(movieTheatres);
                moviesTheatreRepository.save(movieTheatres);
            }

            // Retorna o DTO de resposta
            return new MovieReponseDTO(
                    movies.getId(),
                    movies.getTitle(),
                    movies.getDirector(),
                    movies.getGenre(),
                    movies.getYear(),
                    movies.getDuration()
            );
        } else {
            // Tratar o caso onde o filme não foi encontrado
            throw new EntityNotFoundException("Filme não encontrado.");
        }
    }
    //Funcao que dessocia um filme de um cinema
    public MovieReponseDTO selectDelete(Integer idMovie, Integer idMovieTheatre) {
        // Busca o filme pelo ID
        Optional<Movies> optionalMovies = moviesRepository.findById(idMovie);

        if (optionalMovies.isPresent()) {
            Movies movies = optionalMovies.get();

            // Busca o cinema pelo ID
            MovieTheatres movieTheatres = movieTheatreService.findById(idMovieTheatre);

            // Remove o filme do cinema
            movieTheatres.getMovies().remove(movies);
            movies.getMovieTheatres().remove(movieTheatres);

            // Salva as alterações
            moviesTheatreRepository.save(movieTheatres);

            // Retorna o DTO de resposta
            return new MovieReponseDTO(
                    idMovie,
                    idMovieTheatre,
                    movies.getTitle(),
                    movies.getDirector(),
                    movies.getGenre(),
                    movies.getYear(),
                    movies.getDuration(),
                    new MovieTheatreResponseDTO(
                            movieTheatres.getId(),
                            movieTheatres.getNametheatre(),
                            movieTheatres.getPhone(),
                            movieTheatres.getEmail(),
                            new AddressResponseDTO(
                                    movieTheatres.getMovieTheatresAddress().getCep(),
                                    movieTheatres.getMovieTheatresAddress().getLogradouro(),
                                    movieTheatres.getMovieTheatresAddress().getNumero(),
                                    movieTheatres.getMovieTheatresAddress().getBairro(),
                                    movieTheatres.getMovieTheatresAddress().getLocalidade(),
                                    movieTheatres.getMovieTheatresAddress().getUf(),
                                    movieTheatres.getMovieTheatresAddress().getEstado()
                            )
                    )
            );
        } else {
            // Tratar o caso onde o filme não foi encontrado
            throw new EntityNotFoundException("Filme não encontrado.");
        }
    }

    public MovieReponseDTO updateMovie(Integer id, MovieRequestDTO movieRequestDTO) {
        Optional<Movies> optionalMovies = moviesRepository.findById(id);

        if (optionalMovies.isPresent()) {
            Movies movies = optionalMovies.get();
            movies.setTitle(movieRequestDTO.getTitle());
            movies.setDirector(movieRequestDTO.getDirector());
            movies.setGenre(movieRequestDTO.getGenre());
            movies.setYear(movieRequestDTO.getYear());
            movies.setDuration(movieRequestDTO.getDuration());

            moviesRepository.save(movies);

            return new MovieReponseDTO(
                    movies.getId(),
                    movies.getTitle(),
                    movies.getDirector(),
                    movies.getGenre(),
                    movies.getYear(),
                    movies.getDuration()
            );
        } else {
            throw new EntityNotFoundException("Filme não encontrado.");
        }
    }

    public Movies findById(Integer idMovie) {
        return moviesRepository.findById(idMovie).orElseThrow(() -> new EntityNotFoundException("Filme não encontrado."));
    }
}


