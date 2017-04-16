package org.coursera.apiRest.model;

import org.coursera.pojo.Users;

import java.util.ArrayList;

/**
 * Created by TouxStudio on 30/03/2017.
 */

public class UserIdResponse {

    ArrayList<Users> users;

    public ArrayList<Users> getMyUsers() {return users;}

    public void setMyUsers(ArrayList<Users> myusers) {
        this.users = myusers;
    }

}
