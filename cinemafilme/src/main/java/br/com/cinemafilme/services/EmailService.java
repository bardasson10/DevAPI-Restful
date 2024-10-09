package br.com.cinemafilme.services;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

@Component
public class EmailService {
    LocalDateTime dtNow = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

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

    }

    public String emailWriter() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("arcarreiro@gmail.com");
        message.setSubject("Teste de envio de email");
        message.setText("Foi bom desenvolver caso de corunas meu amigo! " + dtNow.format(formatter));
        try {
            javaMailSender.send(message);
            return "Email enviado com sucesso!";
        } catch (Exception e) {
            return "Erro ao enviar email: " + e.getMessage();
        }

    }


    public String emailWriter2() {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setSubject("Teste de envio de email com anexo");
            helper.setTo("diogoportelladantas1234@gmail.com");
            String text = "<h1>Segue o Leo Pele porrra!</h1>" +
                    "<p>Na rlkia de leo pele</p>" +
                    "<p>Original pae</p>" + dtNow.format(formatter)+
                    "<img src='https://i.pinimg.com/originals/ae/a1/22/aea122898fb4e1f2d33cb733baddc870.jpg'>"+
                    "<img src='https://img.ifunny.co/images/8032e951bd9df5efca6fda6edc505ef4c964c9a0a32f5c4170fd192c99aba050_3.jpg'>"+
                    "<br>";
            helper.setText(text, true);
            javaMailSender.send(message);
            return "Email enviado com sucesso!";
        } catch (MessagingException e) {
            return "Erro ao enviar email: " + e.getMessage();
        }

    }
}
