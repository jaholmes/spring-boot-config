package org.jeff.config;

import org.springframework.cloud.service.UriBasedServiceInfo;

public class UriServiceInfo extends UriBasedServiceInfo {
    public UriServiceInfo(String id, String uri) {
        super(id, uri);
    }
}
