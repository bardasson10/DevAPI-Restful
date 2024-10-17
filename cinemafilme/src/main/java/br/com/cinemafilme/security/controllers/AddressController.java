package br.com.cinemafilme.security.controllers;

import br.com.cinemafilme.security.Util.Util;
import br.com.cinemafilme.security.entities.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    Util util;

    @PostMapping("/teste")
    public ResponseEntity<?> searchAddress(@RequestParam String cep) {
        Address address = util.searchAddress(cep);
        return new ResponseEntity<>(address, HttpStatus.OK);
    }

}
