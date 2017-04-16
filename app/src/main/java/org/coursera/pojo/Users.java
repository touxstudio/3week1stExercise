package org.coursera.pojo;

/**
 * Created by TouxStudio on 30/03/2017.
 */

public class Users {


    private String id;
    private String user_picture;
    private String user_name;


    public Users(){}

    public Users(String id, String user_picture, String user_name) {
        this.id = id;
        this.user_picture = user_picture;
        this.user_name = user_name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_picture() {
        return user_picture;
    }

    public void setUser_picture(String user_picture) {
        this.user_picture = user_picture;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Users{" +
                "id='" + id + '\'' +
                ", user_picture='" + user_picture + '\'' +
                ", user_name='" + user_name + '\'' +
                '}';
    }
}
