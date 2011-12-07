/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.carshare.domain.dto;

import com.neptuo.service.io.annotation.*;
import java.util.ArrayList;

/**
 *
 * @author Mara
 */
@Serializable(name="passenger-list")
@Deserializable(name="passenger-list")
public class PassengerList extends ArrayList<UserDetail> implements java.io.Serializable {

}
