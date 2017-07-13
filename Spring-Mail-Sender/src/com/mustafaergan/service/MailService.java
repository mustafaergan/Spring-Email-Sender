package com.mustafaergan.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	
    @Autowired
    private JavaMailSender sender;

	public void sendMail(String mailAddress, String fromMail) throws MessagingException {
		String subject = "Deneme";
        MimeMessage message = sender.createMimeMessage();
        message.setSubject(subject);
        MimeMessageHelper helper = new MimeMessageHelper(message, false, "utf-8");
        helper.addTo(mailAddress);
        helper.setFrom(fromMail);
        helper.setSubject(subject);
        helper.setText("Hello Everyone", true);
        sender.send(message);
	}
	
	
}
