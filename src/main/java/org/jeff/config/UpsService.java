package org.jeff.config;

import org.springframework.cloud.Cloud;
import org.springframework.cloud.CloudFactory;

/**
 * Bean that contains URI for a user provided service
 */
public class UpsService {
	String upsName;
	String uri;
	UriServiceInfo uriServiceInfo;

	public UpsService(String upsName) {
		this.upsName = upsName;
		this.uriServiceInfo = getUriServiceInfo();
	}
	
	/**
	 * Use when overriding uri with local value via setUri
	 */
	public UpsService() {}
	
	public String getUri() {
		if (uri != null) return uri;
		return uriServiceInfo.getUri();
	}

	/**
	 * Use to override uri in local case
	 */
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
