/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.carshare.service;

import com.carshare.service.dto.AppInfo;
import com.neptuo.service.HttpMethodType;
import com.neptuo.service.annotation.ServiceClass;
import com.neptuo.service.annotation.ServiceMethod;
import com.neptuo.service.result.EntityResult;

/**
 *
 * @author Mara
 */
@ServiceClass(url="/info")
public class InfoService {

    @ServiceMethod(transactional=false, httpMethod=HttpMethodType.GET)
    public EntityResult<AppInfo> test() {
        return new EntityResult<AppInfo>(new AppInfo("alfa", "car-share", "Hello there, from car-share service!"));
    }
}
