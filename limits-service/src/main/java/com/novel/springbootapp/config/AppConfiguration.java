package com.novel.springbootapp.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("limits")
public class AppConfiguration {
	
	private Integer minimum;
	
	private Integer maximum;

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
		return "AppConfiguration [minimum=" + minimum + ", maximum=" + maximum + "]";
	}
	
	

}
