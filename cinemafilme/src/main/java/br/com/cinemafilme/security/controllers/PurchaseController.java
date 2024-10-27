package br.com.cinemafilme.security.controllers;

import br.com.cinemafilme.security.dtos.PurchaseRequestDTO;
import br.com.cinemafilme.security.services.PurchaseService;
import br.com.cinemafilme.security.dtos.PurchaseResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @PostMapping("/save/{idUser}/{idSession}")
    public ResponseEntity<PurchaseResponseDTO> savePurchase(@PathVariable Integer idUser,@PathVariable Integer idSession, @RequestBody PurchaseRequestDTO purchaseRequestDTO) {
        PurchaseResponseDTO purchase = purchaseService.savePurchase(idUser, idSession, purchaseRequestDTO);
        return ResponseEntity.ok(purchase);
    }
}
