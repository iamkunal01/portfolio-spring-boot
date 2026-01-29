package com.porfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.porfolio.dao.ContactDao;
import com.porfolio.model.Contact;

@Service
@Transactional
public class ContactServiceImpl implements ContactService {

	@Autowired
	ContactDao cd;

	@Autowired
	private JavaMailSender mailSender;

	@Override
	public void saveQueryAndSendEmail(String name, String email, String message) {
		Contact c = new Contact();
		c.setContactUserName(name);
		c.setContactUserEmail(email);
		c.setContactuserMsg(message);
		cd.save(c);

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setFrom(email);
		mail.setTo("kunalwahurwagh358@gmail.com");
		mail.setSubject("New Contact Form Query");
		mail.setText("Name: " + name + "\nEmail: " + email + "\nMessage: " + message);

		mailSender.send(mail);
	}

}
