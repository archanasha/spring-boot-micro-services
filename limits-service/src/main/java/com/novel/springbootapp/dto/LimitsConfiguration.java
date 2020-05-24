package com.novel.springbootapp.dto;

public class LimitsConfiguration {
	
	private Integer minimum;
	
	private Integer maximum;

	public LimitsConfiguration(Integer min, Integer max) {
		this.maximum = max;
		this.minimum = min;
	}

	public Integer getMinimum() {
		return minimum;
	}

	public void setMinimum(Integer minimum) {
		this.minimum = minimum;
	}

	public Integer getMaximum() {
		return maximum;
	}

	public void setMaximum(Integer maximum) {
		this.maximum = maximum;
	}

	@Override
	public String toString() {
		return "LimitsConfiguration [minimum=" + minimum + ", maximum=" + maximum + "]";
	}
	
}
