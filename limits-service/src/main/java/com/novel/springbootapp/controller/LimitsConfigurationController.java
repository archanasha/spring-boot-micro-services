package com.novel.springbootapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.novel.springbootapp.config.AppConfiguration;
import com.novel.springbootapp.dto.LimitsConfiguration;

@RestController
public class LimitsConfigurationController {
	
	@Autowired
	private AppConfiguration appConfiguration;
	
	@GetMapping("/limits/getLimits")
	public LimitsConfiguration retriveLimitsConfig() {
		return new LimitsConfiguration(
				appConfiguration.getMinimum(),
				appConfiguration.getMaximum());
	}
	
	@GetMapping("/fault-tolerence-example")
	@HystrixCommand(fallbackMethod = "fallbackRetriever")		
	public LimitsConfiguration retriveConfig() {
		throw new RuntimeException("not available");
	}
	
	public LimitsConfiguration fallbackRetriever() {
		return new LimitsConfiguration(9,99);
	}


}
