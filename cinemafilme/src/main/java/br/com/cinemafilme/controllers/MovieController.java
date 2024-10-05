package br.com.cinemafilme.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/movies")
public class MovieController {
    private final Logger logger = LoggerFactory.getLogger(MovieController.class);
    @GetMapping
    public String testeOla() {
        // Log de sucesso ao chamar o endpoint
        logger.info("Sucesso ao chamar /movies");
        return "Olá, mundo!";


    }


}
