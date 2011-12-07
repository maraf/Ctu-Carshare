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
public class NullRequstObjectException extends ServiceException {

    public NullRequstObjectException(String message) {
        super(message);
    }
}