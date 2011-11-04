/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.carshare.service;

import com.neptuo.service.annotation.*;


/**
 *
 * @author Mara
 */
@TransactionProvider
public class DefaultTransactionProvider {

    @TransactionBegin
    public void begin() throws Exception {
        
    }

    @TransactionCommit
    public void commit() throws Exception {
        
    }

    @TransactionRollback
    public void rollback() throws Exception {
        
    }
}