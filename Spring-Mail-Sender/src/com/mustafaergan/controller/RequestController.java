package com.mustafaergan.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mustafaergan.service.MailService;


@Controller
@RequestMapping("/sendmail")
@Scope("session")
public class RequestController {
	
	@Autowired
	MailService mailService;

	@RequestMapping(value = "/{param1}/{param2}", method = RequestMethod.GET)
	public String printWelcome(ModelMap model, @PathVariable("param1") String eMailAdress,@PathVariable("param2") String fromAddress) {
		try {
			mailService.sendMail(eMailAdress, fromAddress);
			model.addAttribute("text", "Success");
		} catch (MessagingException e) {
			model.addAttribute("text", "Error");
			e.printStackTrace();
		}
		return "mail";
	}

}
