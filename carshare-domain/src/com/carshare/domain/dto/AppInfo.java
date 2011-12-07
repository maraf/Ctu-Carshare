package com.carshare.domain.dto;

import com.neptuo.service.io.annotation.*;

@Serializable(name="app-info")
@Deserializable(name="app-info")
public class AppInfo implements java.io.Serializable {
    private String version;
    private String appName;
    private String hello;

    public AppInfo() {
    }

    public AppInfo(String version, String appName, String hello) {
        this.version = version;
        this.appName = appName;
        this.hello = hello;
    }

    @Serializable(name="app-name")
    public String getAppName() {
        return appName;
    }

    @Serializable(name="hello")
    public String getHello() {
        return hello;
    }

    @Serializable(name="version")
    public String getVersion() {
        return version;
    }

    @Deserializable(name="app-name")
    public void setAppName(String appName) {
        this.appName = appName;
    }

    @Deserializable(name="hello")
    public void setHello(String hello) {
        this.hello = hello;
    }

    @Deserializable(name="version")
    public void setVersion(String version) {
        this.version = version;
    }
}
