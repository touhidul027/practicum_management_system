package com.packt.webstore.service;

public interface EmailService {
	public abstract void sendMail(String senderMail, String senderPassword, String to, String subject, String text);

	public abstract void sendSimpleMessage(String to, String subject, String text);

	public abstract void sendMessageWithAttachment(String to, String subject, String text, String pathToAttachment);
}
