package com.med.market.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.med.market.util.ConfigurationManager;

public class MailServiceImpl implements MailService {

	public void sendMail(String address, String subject, String body) throws Exception {
		Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", ConfigurationManager.getAsString("smtp.host"));
        props.put("mail.smtp.port", ConfigurationManager.getAsString("smtp.port"));
        final String username = ConfigurationManager.getAsString("username");
        final String password = ConfigurationManager.getAsString("password");
        
        Session session = Session.getInstance(props,
      		  new javax.mail.Authenticator() {
      			protected PasswordAuthentication getPasswordAuthentication() {
      				return new PasswordAuthentication(username, password);
      			}
      		  });
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(username));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(address));
        message.setSubject(subject, "UTF-8");
        message.setContent(body, "text/plain; charset=UTF-8");
        Transport.send(message);
	}

}
