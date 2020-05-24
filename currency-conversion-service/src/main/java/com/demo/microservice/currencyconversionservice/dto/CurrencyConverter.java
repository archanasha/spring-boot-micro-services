package com.demo.microservice.currencyconversionservice.dto;

import java.math.BigDecimal;

public class CurrencyConverter {
	
	private Long id;
	private String sourceCurrency;
	private String targetCurrency;
	private BigDecimal conversionFactor;
	private BigDecimal quantity;
	private BigDecimal totalCalculatedAmount;
	private int port;
	

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
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getTotalCalculatedAmount() {
		return totalCalculatedAmount;
	}
	public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
		this.totalCalculatedAmount = totalCalculatedAmount;
	}
	
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	
	@Override
	public String toString() {
		return "CurrencyConverter [id=" + id + ", sourceCurrency=" + sourceCurrency + ", targetCurrency="
				+ targetCurrency + ", conversionFactor=" + conversionFactor + ", quantity=" + quantity
				+ ", totalCalculatedAmount=" + totalCalculatedAmount + "]";
	}

	

}
