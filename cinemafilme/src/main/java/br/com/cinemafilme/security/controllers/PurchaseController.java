package br.com.cinemafilme.security.controllers;

import br.com.cinemafilme.security.dtos.PurchaseRequestDTO;
import br.com.cinemafilme.security.services.PurchaseService;
import br.com.cinemafilme.security.dtos.PurchaseResponseDTO;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @SecurityRequirement(name = "Bearer Auth")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @PostMapping("/save/{idUser}/{idSession}")
    public ResponseEntity<PurchaseResponseDTO> savePurchase(@PathVariable Integer idUser,@PathVariable Integer idSession, @RequestBody PurchaseRequestDTO purchaseRequestDTO) {
        PurchaseResponseDTO purchase = purchaseService.savePurchase(idUser, idSession, purchaseRequestDTO);
        return ResponseEntity.ok(purchase);
    }
}
