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
        return new ArrayList<Class<?>>();
    }

}
