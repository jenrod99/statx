/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.statx.modelo;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Paula Gomez
 */
public class Mailer {

    public static void send(String destinatario, String asunto, String mensaje) {

        final String user = "gomez2014juan80341@gmail.com";//cambiará en consecuencia al servidor utilizado
        final String pass = "CAPItan123";

//1st paso) Obtener el objeto de sesión
        Properties props = new Properties();
        props.setProperty("mail.smtp.host", "smtp.gmail.com"); // envia 
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.port", "587");
        props.setProperty("mail.smtp.starttls.required", "false");
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, pass);
            }
        });

//2nd paso)compose message
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
            message.setSubject(asunto);
            message.setText(mensaje , "ISO-8859-1" , "html");

            //3rd paso)send message
            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }
}
