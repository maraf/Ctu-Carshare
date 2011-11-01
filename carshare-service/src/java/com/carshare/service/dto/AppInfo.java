/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.carshare.service.dto;

import com.neptuo.service.io.annotation.Serializable;

/**
 *
 * @author Mara
 */
@Serializable(name="app-info")
public class AppInfo {
    private String version;
    private String appName;
    private String hello;

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
}
