package com.demo.micorservice.currencyexchangeservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.micorservice.currencyexchangeservice.dto.ExchangeValue;

@Repository
public interface ExchangeValueRespository  extends JpaRepository<ExchangeValue, Long>{
	
	ExchangeValue findBySourceCurrencyAndTargetCurrency(String sourceCurrency,
			String targetCurrency);

}
