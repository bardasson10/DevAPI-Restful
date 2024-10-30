package br.com.cinemafilme.security.services;

import br.com.cinemafilme.security.enums.PurchaseStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

@Service
public class PurchaseEmailService {

    @Autowired
    private JavaMailSender javaMailSender;


    public String purchaseEmailSender(String email, String pedido, double produtoPreco, Integer produtoQuantidade, double totalPrice, PurchaseStatusEnum status) {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter dateForm = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email); // Endereço de e-mail do destinatário
        message.setSubject("VAI UM FILMINHO AE!?");
        message.setText("Olá!\n\n" +
                "Mais um filme na sua conta!\n" +
                "Seu ticket para a sessao '" + pedido + "' está a caminho.🎉🎉🎉\n" +
                "Status do pedido é: " + status + "\n" +
                "Preço: R$ " + produtoPreco + "\n" +
                "Quantidade: " + produtoQuantidade + "\n" +
                "Valor total: R$ " + totalPrice + "\n\n" +
                "Atenciosamente,\n" +
                "A Filminho bom agradece!.\n" +
                "Data e Hora: " + dateTime.format(dateForm) + "\n");

        try {
            javaMailSender.send(message);
            return "Email enviado com sucesso!";
        } catch (Exception e) {
            return "Erro ao enviar o Email: " + e.getMessage();
        }
    }
}
