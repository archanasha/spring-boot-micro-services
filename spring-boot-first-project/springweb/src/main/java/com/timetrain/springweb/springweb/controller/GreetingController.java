package com.timetrain.springweb.springweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.timetrain.springweb.springweb.dto.Greet;

@RestController
public class GreetingController {
	
	@Autowired
	public MessageSource messageSource;
	
//	@RequestMapping(method=RequestMethod.GET, path="/greetings")
	@GetMapping(path="/greetings")
	public String getGreetings() {
		return "Hello Good Morning!";
	}
	
	@GetMapping(path="/greetings-word")
	public Greet getGreetingsObject() {
		 return new Greet("Hello from the other side Vamp!");
	}
	
	@GetMapping(path="/greetings-word/{userName}")
	public Greet getGreetingsObjectPathVariable(@PathVariable String userName) {
		 return new Greet(String.format("Hello from the other side %s", userName));
	}
	
	@GetMapping(path="/greetings-internaltional")
	public String getGreetingInterNaltionlized() {
		return messageSource.getMessage("message.morning.greeting", null, LocaleContextHolder.getLocale());
	}

}
