/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.carshare.service.util;

import com.carshare.service.DefaultParamsProvider;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Mara
 */
public class RequestHelper {

    public static String getAuthToken(HttpServletRequest request) {
        return request.getHeader(DefaultParamsProvider.AUTH_HEADER_NAME);
    }
}
