package com.Meta_Keiber.SpringBoot.infraestructure.helpers;

import java.time.LocalDateTime;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;


@Component
@AllArgsConstructor
public class EmailHelper {
    //Iyectar el servicio de email la libreria
    private final JavaMailSender mailSender;


    public void sendMail(String destinity, String nameClient, String nameEmployee, LocalDateTime date){
        MimeMessage message = mailSender.createMimeMessage();
        try {
            message.setFrom(new InternetAddress("leandro1991.9@gmail.com"));
            message.setSubject("Verification");

            message.setRecipients(MimeMessage.RecipientType.TO,destinity);

            mailSender.send(message);
            System.out.println("Send Email");

        } catch (Exception e) {
            System.out.println("ERROR email could not be sent " + e.getMessage());

        }
    }

}
