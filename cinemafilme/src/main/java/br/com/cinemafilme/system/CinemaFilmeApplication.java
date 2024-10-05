package br.com.cinemafilme.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "br.com.cinemafilme")
public class CinemaFilmeApplication {
    public static void main(String[] args) {
        SpringApplication.run(CinemaFilmeApplication.class, args);}
}