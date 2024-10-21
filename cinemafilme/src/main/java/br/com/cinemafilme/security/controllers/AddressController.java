package br.com.cinemafilme.security.controllers;

import br.com.cinemafilme.security.Util.Util;
import br.com.cinemafilme.security.dtos.AddressRequestDTO;
import br.com.cinemafilme.security.dtos.AddressResponseDTO;
import br.com.cinemafilme.security.entities.Address;
import br.com.cinemafilme.security.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    AddressService addressService;

/*
    @PostMapping("/buscar")
    public ResponseEntity<AddressResponseDTO> searchAddress(@RequestParam String cep, @RequestParam Integer numero) {
        AddressResponseDTO response = addressService.searchAddress(cep, numero);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }*/

    @PostMapping("/save-endereco")
    public AddressResponseDTO saveAddress(@RequestBody AddressRequestDTO addressRequestDTO) {
        return addressService.saveAddress(addressRequestDTO);
    }

}
