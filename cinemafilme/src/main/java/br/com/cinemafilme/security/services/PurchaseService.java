package br.com.cinemafilme.security.services;

import br.com.cinemafilme.security.dtos.PurchaseRequestDTO;
import br.com.cinemafilme.security.dtos.PurchaseResponseDTO;
import br.com.cinemafilme.security.dtos.SessionFilmResponseDTO;
import br.com.cinemafilme.security.entities.Purchase;
import br.com.cinemafilme.security.entities.SessionFilm;
import br.com.cinemafilme.security.entities.User;
import br.com.cinemafilme.security.repositories.PurchaseRepository;
import br.com.cinemafilme.security.repositories.SessionFilmeRepository;
import br.com.cinemafilme.security.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SessionFilmeRepository sessionFilmeRepository;

    public PurchaseResponseDTO savePurchase(Integer idUser, Integer idSession, PurchaseRequestDTO purchaseRequestDTO) {
        User user = userRepository.findById(idUser).orElseThrow(() -> new NoSuchElementException("User not found"));
        SessionFilm sessionFilm = sessionFilmeRepository.findById(idSession).orElseThrow(() -> new NoSuchElementException("SessionFilm not found"));

        Purchase purchase = new Purchase(
                user,
                sessionFilm,
                purchaseRequestDTO.getTicketQuantity(),
                purchaseRequestDTO.getPurchaseDate(),
                purchaseRequestDTO.getStatus()
        );
        double priceTotal = sessionFilm.getPrice() * purchase.getTicketQuantity();
        purchase.setTotalPrice(priceTotal);
        purchaseRepository.save(purchase);
        return new PurchaseResponseDTO(
                purchase.getId(),
                purchase.getPurchaseDate(),
                purchase.getTicketQuantity(),
                purchase.getTotalPrice(),
                purchase.getStatus(),
                purchase.getUser().getId(),
                purchase.getUser().getEmail(),
                new SessionFilmResponseDTO(
                        sessionFilm.getId(),
                        sessionFilm.getSessionTime(),
                        sessionFilm.getPrice(),
                        sessionFilm.getMovie().getTitle(),
                        sessionFilm.getMovie().getDirector(),
                        sessionFilm.getMovie().getGenre(),
                        sessionFilm.getMovie().getYear(),
                        sessionFilm.getMovie().getDuration(),
                        sessionFilm.getMovieTheatre().getId(),
                        sessionFilm.getMovieTheatre().getNametheatre()));
    }
}
