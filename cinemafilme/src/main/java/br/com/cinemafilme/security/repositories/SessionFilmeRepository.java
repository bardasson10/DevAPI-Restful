package br.com.cinemafilme.security.repositories;

import br.com.cinemafilme.security.entities.SessionFilm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionFilmeRepository extends JpaRepository<SessionFilm, Integer> {

}
