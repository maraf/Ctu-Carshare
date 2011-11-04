/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.carshare.service.util;

import com.carshare.service.DefaultParamsProvider;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mara
 */
public class ResponseHelper {

    public static String setAuthToken(HttpServletResponse response, String value) {
        response.setHeader(DefaultParamsProvider.AUTH_HEADER_NAME, value);
        return value;
    }
}
