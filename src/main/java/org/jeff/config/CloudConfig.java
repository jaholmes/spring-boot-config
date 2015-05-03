package org.jeff.config;

import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.cloud.config.java.CloudScan;
import org.springframework.cloud.config.java.ServiceScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Bean;

@Configuration
@CloudScan
@ServiceScan
@Profile({"cloud"})
public class CloudConfig extends AbstractCloudConfig {

	final static String UPS_NAME = "my-uri-ups";
	
	@Bean
	public UpsService upsConfig() {
		return new UpsService(UPS_NAME);
	}
	
}
