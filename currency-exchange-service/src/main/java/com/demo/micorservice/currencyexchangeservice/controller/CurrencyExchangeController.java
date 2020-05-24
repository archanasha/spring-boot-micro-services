package com.demo.micorservice.currencyexchangeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.demo.micorservice.currencyexchangeservice.dao.ExchangeValueRespository;
import com.demo.micorservice.currencyexchangeservice.dto.ExchangeValue;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private ExchangeValueRespository exchangeValueRespository;
	
	
	@GetMapping("/currency-exchange/sourceCurrency/{sourceCurrency}/"
			+ "targetCurrency/{targetCurrency}")
	public ExchangeValue getExchangeValue(@PathVariable String sourceCurrency,
			@PathVariable String targetCurrency) {
		ExchangeValue exchangeValue = exchangeValueRespository.findBySourceCurrencyAndTargetCurrency(
				sourceCurrency, targetCurrency);
		
		exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));	
		return exchangeValue;
		
	}

}
