package com.binson.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import com.binson.model.Contact;

@Service
//@RequestScope
//@SessionScope
@ApplicationScope
public class ContactService {

	public ContactService() {
		System.out.println("Contact Service Bean Initialized");
	}
	
	int counter = 0;
	
	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	
	public void saveMessage(Contact contact) {
		
		System.out.println("Contact: "+contact.toString());
	}
}
