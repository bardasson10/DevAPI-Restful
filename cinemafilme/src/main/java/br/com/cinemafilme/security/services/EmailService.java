package br.com.cinemafilme.security.services;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

@Component
public class EmailService {
    LocalDateTime dtNow = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    DecimalFormat df = new DecimalFormat("R$ #,##0.00");

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
                    "<p>Original pae</p>" + dtNow.format(formatter) +
                    "<img src='https://i.pinimg.com/originals/ae/a1/22/aea122898fb4e1f2d33cb733baddc870.jpg'>" +
                    "<img src='https://img.ifunny.co/images/8032e951bd9df5efca6fda6edc505ef4c964c9a0a32f5c4170fd192c99aba050_3.jpg'>" +
                    "<br>";
            helper.setText(text, true);
            javaMailSender.send(message);
            return "Email enviado com sucesso!";
        } catch (MessagingException e) {
            return "Erro ao enviar email: " + e.getMessage();
        }

    }

    public void emailWriter3() {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setSubject("Teste de envio de email com anexo");
            helper.setTo("diogoportelladantas1234@gmail.com");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<html>\r\n");
            stringBuilder.append("  <body>\r\n");
            stringBuilder.append("      <p>As "+dtNow.format(formatter)+"</p>\r\n");
            stringBuilder.append("      <div align=\"center\">\r\n");
            stringBuilder.append("          <h1>Vasco da Gama!</h1>\r\n");
            stringBuilder.append("          <p>Boa noite, caro Dioguin!</p>\r\n");
            stringBuilder.append("         <br>\r\n");
            stringBuilder.append("         <table border='2' cellpading='2'>\r\n");
            stringBuilder.append("          <tr><th>Nome</th><th>Preço</th>\r\n");
            stringBuilder.append("          <tr><td>Nike</td><td>"+df.format(5)+"</td></tr>\r\n");
            stringBuilder.append("         </table>\r\n");
            stringBuilder.append("      </div>\r\n");
            stringBuilder.append("  </body>\r\n");
            stringBuilder.append("</html>");
            helper.setText(stringBuilder.toString(), true);
            javaMailSender.send(message);
            System.out.println("Email enviado com sucesso!");
        } catch (MessagingException e) {
            System.out.println("Erro ao enviar e-mail" + e.getMessage());
        }

    }
}
