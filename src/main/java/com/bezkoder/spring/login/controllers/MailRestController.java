package com.bezkoder.spring.login.controllers;

import com.bezkoder.spring.login.models.Mail;
import com.bezkoder.spring.login.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class MailRestController {
  @Autowired
  private MailService emailService;
  @RequestMapping(value="/sendMail",method= RequestMethod.POST)
  public String sendMail(){
    System.out.println("Spring Mail - Sending Simple Email with JavaMailSender Example");

    Mail mail = new Mail();
    mail.setFrom("rimesbenabdallh@gmail.com");
    mail.setTo("rimesbenabdallh@gmail.com");
    mail.setSubject("Sending Simple Email with JavaMailSender Example");
    mail.setContent("This tutorial covoituragebackendnstrates how to send a simple email using Spring Framework.");

    emailService.sendSimpleMessage(mail);
    return "ok";
  }
}
