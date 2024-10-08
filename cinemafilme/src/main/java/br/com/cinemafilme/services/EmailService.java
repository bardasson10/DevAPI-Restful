package br.com.cinemafilme.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class EmailService {

    @Autowired
    public JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String emailFrom;

    @Value("${spring.mail.host}")
    private String emailServerHost;

    @Value("${spring.mail.port}")
    private Integer emailServerPort;

    @Value("${spring.mail.password}")
    private String emailPassword;

    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setUsername(emailFrom);
        mailSender.setHost(emailServerHost);
        mailSender.setPort(emailServerPort);
        mailSender.setPassword(emailPassword);

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        return mailSender;

    };


}
