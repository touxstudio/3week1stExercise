package org.coursera.pojo;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import org.coursera.mypentagram.MainActivity;
import org.coursera.mypentagram.R;

import java.util.Map;

/**
 * Created by TouxStudio on 02/04/2017.
 */

public class SharedPrefsUsers {



    private String USERID_NUMERIC;
    private String USERID_USERNAME;
    private String USER_PROFILE_PICTURE;

    private Context context = MainActivity.contextOfApplication;

    private String KEY_USER_NUMERIC         = context.getResources().getString(R.string.KEY_USERID_NUMERIC);
    private String KEY_USERID_USERNAME      = context.getResources().getString(R.string.KEY_USERID_USERNAME);
    private String KEY_USER_PROFILE_PICTURE = context.getResources().getString(R.string.KEY_USER_PROFILE_PICTURE);
    private String KEY_INSTAGRAM_USER       = context.getResources().getString(R.string.KEY_INSTAGRAM_USER);

    private String KEY_SHARED_USER          = context.getResources().getString(R.string.SHARED_PREFS_USER);

    public SharedPrefsUsers(){}

    public SharedPrefsUsers(String USERID_NUMERIC, String USERID_USERNAME, String USER_PROFILE_PICTURE) {
        this.USERID_NUMERIC = USERID_NUMERIC;
        this.USERID_USERNAME = USERID_USERNAME;
        this.USER_PROFILE_PICTURE = USER_PROFILE_PICTURE;
    }

    public String saveKEY_USERID_USERNAME (String user){

        SharedPreferences prefs = context.getSharedPreferences(KEY_SHARED_USER, context.MODE_PRIVATE);

        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(KEY_INSTAGRAM_USER, user);

        Log.v("SHAREDD", user);

        editor.apply();

        return user;
    }

    public String saveUserDetails(String id, String userName, String imageUrl){

        SharedPreferences prefs = context.getSharedPreferences(KEY_SHARED_USER, context.MODE_PRIVATE);

        SharedPreferences.Editor editor = prefs.edit();

        Log.v("SHAREDD33", id + userName + imageUrl);

        editor.putString(KEY_USER_NUMERIC, id);
        editor.putString(KEY_USERID_USERNAME, userName);
        editor.putString(KEY_USER_PROFILE_PICTURE, imageUrl);
        editor.apply();

        return null;
    }

    public String getSharedSingleParam(String KEY){

        SharedPreferences prefs = context.getSharedPreferences(KEY_SHARED_USER, Context.MODE_PRIVATE);
        String KEY_DATA = prefs.getString(KEY, "3409545010");


        return KEY_DATA;
    }




    public String getUSERID_NUMERIC() {
        return USERID_NUMERIC;
    }

    public void setUSERID_NUMERIC(String USERID_NUMERIC) {
        this.USERID_NUMERIC = USERID_NUMERIC;
    }

    public String getUSERID_USERNAME() {
        return USERID_USERNAME;
    }

    public void setUSERID_USERNAME(String USERID_USERNAME) {
        this.USERID_USERNAME = USERID_USERNAME;
    }

    public String getUSER_PROFILE_PICTURE() {
        return USER_PROFILE_PICTURE;
    }

    public void setUSER_PROFILE_PICTURE(String USER_PROFILE_PICTURE) {
        this.USER_PROFILE_PICTURE = USER_PROFILE_PICTURE;
    }


}
