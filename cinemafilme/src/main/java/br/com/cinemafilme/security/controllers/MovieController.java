package br.com.cinemafilme.security.controllers;

import br.com.cinemafilme.security.Util.Util;
import br.com.cinemafilme.security.entities.Address;
import br.com.cinemafilme.security.services.EmailService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    EmailService emailService;
    @GetMapping
    public String testeOla() {
        emailService.emailWriter();
        return "Email enviado com sucesso!";
    }

    @GetMapping("/email")
    public String testeEmail(){
        emailService.emailWriter2();
        return "Email enviado com sucesso para o Dg!";
    }
    @GetMapping("/email2")
    public String testeEmail3(){
        emailService.emailWriter3();
        return "Email enviado com sucesso para o Dg!";
    }


}




