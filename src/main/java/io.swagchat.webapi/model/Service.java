package io.swagchat.webapi.model;

public class Service {

    private final String name;
    private final String url;
    private final boolean enabled;
    private final long id;
    private final String icon;

    public Service(long id, String serviceName, String url, boolean enabled, String icon) {
        this.id = id;
        this.name = serviceName;
        this.url = url;
        this.enabled = enabled;
        this.icon = icon;
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

    public static final String[] keys = {"name", "url", "enabled", "id", "icon"};

    public long getId() {
        return id;
    }

    public String getIcon() {
        return icon;
    }
}
