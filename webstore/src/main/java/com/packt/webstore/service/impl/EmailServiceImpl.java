package com.packt.webstore.service.impl;

import java.util.Properties;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.packt.webstore.service.EmailService;

public class EmailServiceImpl implements EmailService {
	@Override
	public void sendSimpleMessage(String to, String subject, String text) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendMessageWithAttachment(String to, String subject, String text, String pathToAttachment) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendMail(String senderMail, String senderPassword, String to, String subject, String text) {
		JavaMailSender javaMailSender = EMailSender.getJavaMailSender(senderMail, senderPassword);
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		javaMailSender.send(message);
		System.out.println("Mail sent successfully.");
	}

	private static final class EMailSender {
		public static JavaMailSender getJavaMailSender(String senderMail, String senderPassword) {
			JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
			mailSender.setHost("smtp.gmail.com");
			mailSender.setPort(587);

			mailSender.setUsername(senderMail);
			mailSender.setPassword(senderPassword);

			Properties props = mailSender.getJavaMailProperties();
			props.put("mail.transport.protocol", "smtp");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.debug", "true");

			return mailSender;
		}
	}

}
