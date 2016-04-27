package io.swagchat.webapi.model;

public class Service {

    private final String serviceName;
    private final String url;
    private final boolean enabled;

    public Service(String serviceName, String url, boolean enabled) {
        this.serviceName = serviceName;
        this.url = url;
        this.enabled = enabled;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public String getUrl() {
        return url;
    }

    public String getServiceName() {
        return serviceName;
    }
}
