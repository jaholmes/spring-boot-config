package org.jeff.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Bean;

@Configuration
@Profile({"local"})
public class LocalConfig {

	final static String LOCAL_URI = "http://localhost:9022/xyz";
	
	@Bean
	public UpsService upsService() {
		UpsService sc = new UpsService();
		sc.setUri(LOCAL_URI);
		return sc;
	}
	
}
