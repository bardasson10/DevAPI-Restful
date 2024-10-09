package br.com.cinemafilme.controllers;

import br.com.cinemafilme.services.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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



}
