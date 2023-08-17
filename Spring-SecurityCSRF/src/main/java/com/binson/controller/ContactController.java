package com.binson.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.binson.model.Contact;
import com.binson.service.ContactService;

import ch.qos.logback.classic.joran.action.LoggerAction;
import jakarta.validation.Valid;

@Controller
public class ContactController {
	
	Logger logger = Logger.getLogger("ContactController");
	
	public ContactController() {
		System.out.println("Contact COntroller Called");
	}
	
	ContactService contactService;
	
	@Autowired
	public ContactController(ContactService contactService) {
		this.contactService = contactService;
	}
	
	
	
	
	
	/*
	@RequestMapping(value = "/saveMsg", method = {RequestMethod.POST} )
	public ModelAndView saveSchoolQueryform(@RequestParam String name, @RequestParam(name="mobileNum") String phoneno,
			@RequestParam(name="email") String email, @RequestParam(name="subject") String subject, @RequestParam(name="message") String query) {
		
		logger.info("Name: "+name);
		logger.info("phoneno: "+phoneno);
		logger.info("email: "+email);
		logger.info("subject: "+subject);
		logger.info("query: "+query);
		
		contactService.saveMessage()
		
		
		return new ModelAndView("redirect:/contact");
	}
	*/
	/*
	@RequestMapping(value = "/saveMsg", method = {RequestMethod.POST} )
	public ModelAndView saveSchoolQueryform(Contact contact) {
		
		contactService.saveMessage(contact); 
		
		return new ModelAndView("redirect:/contact");
	}
	*/
	
	@RequestMapping("/contact")
	public String displayContactPage(Model model) {
		model.addAttribute("contact",new Contact());
		return "contact.html";
	}
	
	@RequestMapping(value = "/saveMsg", method = {RequestMethod.POST} )
	public String saveSchoolQueryform(@Valid @ModelAttribute("contact") Contact contact, Errors errors) {
		
		if(errors.hasErrors()) {
			logger.info("Contact form validation due to: "+errors.toString());
			return "contact.html";
		}
		contactService.saveMessage(contact); 	
		contactService.setCounter(contactService.getCounter()+1);
		System.out.println("Counter Value is: "+ contactService.getCounter());
		return "redirect:/contact";
	}
}
