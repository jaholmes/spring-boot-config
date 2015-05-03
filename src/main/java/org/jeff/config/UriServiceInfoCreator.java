package org.jeff.config;

import org.springframework.cloud.cloudfoundry.CloudFoundryServiceInfoCreator;
import org.springframework.cloud.cloudfoundry.Tags;

import java.util.Map;

public class UriServiceInfoCreator extends CloudFoundryServiceInfoCreator<UriServiceInfo> {

    public static final String URI_TAG = "uri";

    public UriServiceInfoCreator() {
        super(new Tags(URI_TAG));
    }

    @Override
    public boolean accept(Map<String, Object> serviceData) {
        Map<String, Object> credentials = getCredentials(serviceData);
        String tag = (String) credentials.get("tag");
    	System.out.println("tag: " + tag);
        return super.accept(serviceData) || URI_TAG.equals(tag);
    }

    @Override
    public UriServiceInfo createServiceInfo(Map<String, Object> serviceData) {
        String id = (String) serviceData.get("name");

        Map<String, Object> credentials = getCredentials(serviceData);
        String uri = getStringFromCredentials( credentials, "uri", "uri");

    	System.out.println("uri: " + uri);
        return new UriServiceInfo(id, uri);
    }

    @SuppressWarnings("unchecked")
    public Map<String, Object> getCredentials(Map<String, Object> serviceData) {
        return (Map<String, Object>) serviceData.get("credentials");
    }
}
