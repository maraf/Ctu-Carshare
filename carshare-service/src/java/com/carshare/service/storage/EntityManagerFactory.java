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
    private static javax.persistence.EntityManagerFactory factory = Persistence.createEntityManagerFactory("carshare-pu");

    public static EntityManager create() {
        return factory.createEntityManager();
    }
}
