package org.jeff.config;

import org.springframework.cloud.Cloud;
import org.springframework.cloud.CloudFactory;

public class UpsService {
	String upsName;
	String uri;

	public UpsService(String upsName) {
		this.upsName = upsName;
		this.uri = this.getUriServiceInfo().getUri();
	}
	
	public UpsService() {}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}
	
    public String getUpsName() {
		return upsName;
	}

	UriServiceInfo getUriServiceInfo() {
    	CloudFactory cloudFactory = new CloudFactory();
        Cloud cloud = cloudFactory.getCloud();
        UriServiceInfo uriServiceInfo = 
        		(UriServiceInfo) cloud.getServiceInfo(getUpsName());
        return uriServiceInfo; 
    }
	
}
