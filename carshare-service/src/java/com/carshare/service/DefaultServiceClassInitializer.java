/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.carshare.service;

import com.neptuo.service.ServiceClassInitializer;
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.ServletContext;

/**
 *
 * @author Mara
 */
public class DefaultServiceClassInitializer implements ServiceClassInitializer {

    public Collection<Class<?>> getServiceClasses(ServletContext context) {
        Collection<Class<?>> result = new ArrayList<Class<?>>();

        result.add(InfoService.class);
        result.add(AccountService.class);

        return result;
    }

}
