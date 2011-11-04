/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.carshare.service;

import javax.servlet.*;
import javax.servlet.http.*;
import com.carshare.service.util.*;
import com.carshare.service.annotation.*;
import com.carshare.service.storage.EntityManagerFactory;
import com.neptuo.service.*;
import com.neptuo.service.annotation.*;
import com.neptuo.service.io.*;
import com.neptuo.service.util.*;
import javax.persistence.EntityManager;

/**
 *
 * @author Mara
 */
public class DefaultParamsProvider {
    public static final String AUTH_HEADER_NAME = "AuthToken";

    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected ServletContext context;
    protected MethodInfo method;

    @ProviderMethod(ProviderMethodType.INIT)
    public void init() {
        
    }

    @ProviderMethod(ProviderMethodType.BEFORE)
    public void beforeRequest(ServletContext context, HttpServletRequest request, HttpServletResponse response, Serializer serializer, Deserializer deserializer) {
        this.request = request;
        this.response = response;
        this.context = context;
    }

    @ProviderMethod(ProviderMethodType.AFTER)
    public void afterRequest(ServletContext context, HttpServletRequest request, HttpServletResponse response) {
        //If there is AuthToken in request, than copy that one to response
        if (request.getHeader(DefaultParamsProvider.AUTH_HEADER_NAME) != null) {
            response.setHeader(DefaultParamsProvider.AUTH_HEADER_NAME, request.getHeader(DefaultParamsProvider.AUTH_HEADER_NAME));
        }

        //Clear for next request
        this.request = null;
        this.response = null;
        this.context = null;
    }

    @ProviderMethod(ProviderMethodType.PROVIDE)
    public ParamsProviderResult provide(Class clazz, MethodInfo method, int index) throws HttpUnauthorizedException {
        this.method = method;

        Object result = null;
        boolean handled = false;

        if (clazz == EntityManager.class) {
            result = EntityManagerFactory.create();
            handled = true;
        } else {
            if(ReflectionHelper.getParamAnnotation(method.getMethod(), index, AuthToken.class) != null) {
                result = getAuthToken();
                handled = true;
            }
        }

        if (handled) {
            return new ParamsProviderResult(result);
        } else {
            return new ParamsProviderResult();
        }
    }

    public String getAuthToken() {
        return RequestHelper.getAuthToken(request);
    }
}
