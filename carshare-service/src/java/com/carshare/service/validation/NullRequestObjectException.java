/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.carshare.service.validation;

import com.neptuo.service.ServiceException;

/**
 *
 * @author Mara
 */
public class NullRequestObjectException extends ServiceException {

    public NullRequestObjectException(String message) {
        super(message);
    }
}