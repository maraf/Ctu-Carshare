/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.carshare.service.util;

/**
 *
 * @author Mara
 */
public class StringUtils {

    public static boolean  isNullOrEmpty(String value) {
        if(value == null)
            return true;

        if("".equals(value))
            return true;

        return false;
    }
}
