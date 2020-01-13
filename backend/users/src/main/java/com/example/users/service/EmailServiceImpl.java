package com.example.users.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.users.exception.EmailSendException;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class EmailServiceImpl implements EmailService {

	private final JavaMailSender javaMailSender;

	@Override
	public void sendEmail(String email, String subject, String text) {
		MimeMessage msg = javaMailSender.createMimeMessage();
		MimeMessageHelper helper;
		try {
			helper = new MimeMessageHelper(msg, true);
			helper.setTo(email);
			helper.setSubject(subject);
			helper.setText(text, true);
			javaMailSender.send(msg);
		} catch (MessagingException e) {
			log.error("Email could not be sent!");
			throw new EmailSendException();
		}
	}
}
