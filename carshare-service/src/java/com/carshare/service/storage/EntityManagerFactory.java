/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.carshare.service.storage;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Mara
 */
public class EntityManagerFactory {
    private static javax.persistence.EntityManagerFactory factory;

    public static EntityManager create() {
        if(factory == null) {
            factory = Persistence.createEntityManagerFactory("carshare-pu");
        }

        return factory.createEntityManager();
    }
}
