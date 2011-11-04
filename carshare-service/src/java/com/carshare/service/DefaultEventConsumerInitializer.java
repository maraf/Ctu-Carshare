/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.carshare.service;

import com.neptuo.service.EventConsumerInitializer;
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.ServletContext;

/**
 *
 * @author Mara
 */
public class DefaultEventConsumerInitializer implements EventConsumerInitializer {

    public Collection<Class<?>> getEventConsumers(ServletContext sc) {
        return new ArrayList<Class<?>>();
    }

}
