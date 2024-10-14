package br.com.cinemafilme.controllers;

import br.com.cinemafilme.services.EmailService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @SecurityRequirement(name="Bearer Auth")
    @GetMapping("/teste")
    @PreAuthorize("hasRole('USER')")
    public String teste(){
        return "Teste";
    }

    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @SecurityRequirement(name="Bearer Auth")
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/user")
    public String userAccess() {
        return "User Content.";
    }

    @SecurityRequirement(name="Bearer Auth")
    @PreAuthorize("hasRole('MOD')")
    @GetMapping("/mod")
    public String moderatorAccess() {
        return "Moderator Board.";
    }

    //@SecurityRequirement-> é usada para especificar os requisitos de segurança necessários para acessar
    //A propriedade name da anotação abaixo se refere ao name da anotação @SecurityScheme que está definida na classe SwaggerConfig
    @SecurityRequirement(name="Bearer Auth")
    //@PreAuthorize-> é utilizada para definir regras de autorização
    //hasAnyRole é uma condição de autorização utilizada na anotação "@PreAuthorize", dando acesso as Roles (USER/ADMIN/MODERATOR)
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String adminAccess() {
        return "Admin Board.";
    }


}




