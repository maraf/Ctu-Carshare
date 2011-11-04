/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.carshare.service;

import com.neptuo.service.*;
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.ServletContext;

/**
 *
 * @author Mara
 */
public class DefaultMethodParamsProviderInitializer implements MethodParamsProviderInitializer {

    public Collection<Class<?>> getProviderClasses(ServletContext context) {
        Collection<Class<?>> result = new ArrayList<Class<?>>();

        result.add(HttpParamsProvider.class);
        result.add(DefaultParamsProvider.class);

        return result;
    }

}
