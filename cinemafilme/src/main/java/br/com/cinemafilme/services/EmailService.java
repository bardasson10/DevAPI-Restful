package br.com.cinemafilme.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailService {

    @Autowired
    public JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String emailFrom;

}
