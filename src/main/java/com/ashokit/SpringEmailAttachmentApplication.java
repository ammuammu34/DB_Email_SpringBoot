package com.ashokit;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.ashokit.attachment.EmailSenderService;

@SpringBootApplication
public class SpringEmailAttachmentApplication {
	@Autowired
	private EmailSenderService emailSenderService;

	public static void main(String[] args) {
		SpringApplication.run(SpringEmailAttachmentApplication.class, args);
	}
	@EventListener(ApplicationReadyEvent.class)
	public void triggerEmail()  throws MessagingException{
		emailSenderService.sendEmailWithAttachment("k.ravali034@gmail.com", "Java Developer Resume - Ravali", 
				"Hi , Please find my resume as attachment","C:\\pdf\\Ravali.pdf");
	}

}