package com.demo.microservice.currencyconversionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.demo.microservice.currencyconversionservice.config.CurrencyConverterServiceProxy;
import com.demo.microservice.currencyconversionservice.dto.CurrencyConverter;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	CurrencyConverterServiceProxy proxy;
	
//	Without fiegn
//	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
//	public CurrencyConverter getCurrencyConverter(@PathVariable String from,
//			@PathVariable String to, @PathVariable BigDecimal quantity) {
//		
//		
//		 Map<String, String> uriVariables = new HashMap<>(); 
//		 uriVariables.put("from", from);
//		 uriVariables.put("to", to);
//
//		
//		ResponseEntity<CurrencyConverter> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/sourceCurrency/{from}/targetCurrency/{to}",
//				CurrencyConverter.class, uriVariables);
//		
//		CurrencyConverter  currencyConverterResponse = responseEntity.getBody();
//		currencyConverterResponse.setQuantity(quantity);
//		currencyConverterResponse.setTotalCalculatedAmount(
//				quantity.multiply(currencyConverterResponse.getConversionFactor()));
//		return currencyConverterResponse;
//	}
	
	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConverter getCurrencyConverter(@PathVariable String from,
			@PathVariable String to, @PathVariable BigDecimal quantity) {
		
		
		 Map<String, String> uriVariables = new HashMap<>(); 
		 uriVariables.put("from", from);
		 uriVariables.put("to", to);

		
		CurrencyConverter  currencyConverterResponse = proxy.retrieveCurrencyDetails(from, to);
		
		currencyConverterResponse.setQuantity(quantity);
		currencyConverterResponse.setTotalCalculatedAmount(
				quantity.multiply(currencyConverterResponse.getConversionFactor()));
		return currencyConverterResponse;
	}

}
