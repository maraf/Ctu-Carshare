/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carshare.service.impl;

import com.carshare.domain.dto.*;
import com.carshare.service.util.*;
import com.neptuo.service.*;
import com.neptuo.service.annotation.*;
import com.neptuo.service.io.*;
import com.neptuo.service.result.*;
import java.io.*;
import java.net.*;

/**
 *
 * @author Mara
 */
@ServiceClass(url = "/info")
public class InfoService {

    @ServiceMethod(transactional = false, httpMethod = HttpMethodType.GET)
    public EntityResult<AppInfo> info() {
        return new EntityResult<AppInfo>(new AppInfo("alfa", "car-share", "Hello there, from car-share service!"));
    }

    @ServiceMethod(name = "test", transactional = false, httpMethod = HttpMethodType.GET)
    public EntityResult<AppInfo> test() throws HttpException, Exception {
        try {
            URL url = new URL("http://car-share.appspot.com/service/info");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", ResponseHelper.MimeTypes.XML);
            connection.setRequestProperty("Content-type", ResponseHelper.MimeTypes.XML);

            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                AutoDeserializerItem appInfoItem = new AutoDeserializerItem("app-info", null, AppInfo.class);
                AutoDeserializer.factory(new XmlDeserializer(), connection.getInputStream(), appInfoItem).deserialize();
                AppInfo info = (AppInfo) appInfoItem.getItem();

                return new EntityResult<AppInfo>(info);
            } else {
                throw new HttpInternalServerErrorException("Bad http result");
            }
        } catch (MalformedURLException e) {
            throw new HttpInternalServerErrorException(e.getMessage());
        } catch (IOException e) {
            throw new HttpInternalServerErrorException(e.getMessage());
        }
    }
}
