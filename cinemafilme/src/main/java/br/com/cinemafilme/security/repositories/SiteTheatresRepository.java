package br.com.cinemafilme.security.repositories;

import br.com.cinemafilme.security.entities.SiteTheatres;
import br.com.cinemafilme.security.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiteTheatresRepository extends JpaRepository<SiteTheatres, Integer> {
    
    //SiteTheatres findByUser(User user);
}
