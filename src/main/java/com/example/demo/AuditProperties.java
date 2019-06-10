package com.example.demo;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Component
@ConfigurationProperties()
@Validated
public class AuditProperties {

	/*
	 * @Max(5)
	 * @Min(0) 
	 * private int threadPool;
	 */

	//@NotEmpty
	@Value("${audit.enabled}")
    private boolean enabled;

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
    
}