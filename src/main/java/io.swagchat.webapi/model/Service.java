package io.swagchat.webapi.model;

public class Service {

    private final String name;
    private final String url;
    private final boolean enabled;
    private final long id;

    public Service(long id, String serviceName, String url, boolean enabled) {
        this.id = id;
        this.name = serviceName;
        this.url = url;
        this.enabled = enabled;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public static final String[] keys = {"name", "url", "enabled", "id"};

    public long getId() {
        return id;
    }
}
