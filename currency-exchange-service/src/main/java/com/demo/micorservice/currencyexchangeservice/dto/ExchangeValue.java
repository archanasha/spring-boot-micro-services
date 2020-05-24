package com.demo.micorservice.currencyexchangeservice.dto;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class ExchangeValue {
	
	@Id
	private Long id;
	
	@Column(name="source_currency")
	private String sourceCurrency;
	
	@Column(name="target_currency")
	private String targetCurrency;
	
	@Column(name="conversion_factor")
	private BigDecimal conversionFactor;
	
	private int port;
	
	
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSourceCurrency() {
		return sourceCurrency;
	}
	public void setSourceCurrency(String sourceCurrency) {
		this.sourceCurrency = sourceCurrency;
	}
	public String getTargetCurrency() {
		return targetCurrency;
	}
	public void setTargetCurrency(String targetCurrency) {
		this.targetCurrency = targetCurrency;
	}
	public BigDecimal getConversionFactor() {
		return conversionFactor;
	}
	public void setConversionFactor(BigDecimal conversionFactor) {
		this.conversionFactor = conversionFactor;
	}
	@Override
	public String toString() {
		return "ExchangeValue [id=" + id + ", sourceCurrency=" + sourceCurrency + ", targetCurrency=" + targetCurrency
				+ ", conversionFactor=" + conversionFactor + "]";
	}
	
}
