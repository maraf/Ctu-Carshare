/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.carshare.service;

import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.ServletContext;
import com.carshare.service.impl.AccountService;
import com.carshare.service.impl.InfoService;
import com.neptuo.service.ServiceClassInitializer;

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
