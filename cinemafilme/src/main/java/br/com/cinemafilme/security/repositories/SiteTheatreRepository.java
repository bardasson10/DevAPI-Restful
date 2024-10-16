package br.com.cinemafilme.security.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("site_theatres")
public interface SiteTheatreRepository<SiteTheatre> extends JpaRepository<SiteTheatre, Integer> {
}
