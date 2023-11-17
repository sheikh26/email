package com.email.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.util.JSONPObject;

@RestController
public class AppController {

	@Autowired
	private JavaMailSender mailSender;


//	@PostMapping("/send_text_email")
//	public String sendPlainTextEmail(@RequestParam("fromEmail") String fromEmail,
//			@RequestParam("toEmail") String toEmail) {
//
//		String from = fromEmail;
//		String to = toEmail;
//		System.out.println("from-email---" + from);
//		System.out.println("to--email-" + to);
//
//		SimpleMailMessage message = new SimpleMailMessage();
//		message.setFrom(from);
//		message.setTo(to);
//		message.setSubject("This is a plain text email");
//		message.setText("Hello guys! This is a plain text email.");
//
//		mailSender.send(message);
//
//		return "result";
//	}
	
	// using Json
	//@PostMapping("/send_text_email")
	@PostMapping(value = "/send_text_email", consumes = MediaType.APPLICATION_JSON_VALUE)
	//public String sendPlainTextEmail(@RequestBody String fromEmail,@RequestBody String toEmail) {
		public String sendPlainTextEmail(@RequestBody ObjectNode json) {

		String from= json.get("fromEmail").textValue();
		String to= json.get("toEmail").textValue();

	    

//		String from = fromEmail;
//		String to = toEmail;
		System.out.println("from-email---" + from);
		System.out.println("to--email-" + to);

		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(from);
		message.setTo(to);
		message.setSubject("This is a plain text email");
		message.setText("Hello guys! This is a plain text email.");

		mailSender.send(message);

		return "result";
		
	}

}
