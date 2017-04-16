package org.coursera.apiRest;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by TouxStudio on 29/03/2017.
 */


public final class ApiRestConstants {



    // INSTAGAM CONSTANTS
    public static final String VERSION = "/v1/";
    public static final String BASE_URL = "http://api.instagram.com" + VERSION;
    public static final String ACCESS_TOKEN = "3409545010.49428ac.1af077e3045441be9d31fb3e70af1916";
    public static final String KEY_ACCESS_TOKEN = "access_token=";
    public static final String KEY_SELF_MEDIA_RECENT = "users/3409545010/media/recent/?";
    public static final String URI_SELF_MEDIA_RECENT = KEY_SELF_MEDIA_RECENT + KEY_ACCESS_TOKEN + ACCESS_TOKEN;
    public static final String KEY_SEARCH = "users/search?q=";
    public static final String KEY_USERS = "users/";

    public static final String KEY_MEDIA = "/media/recent/?";


    // HEROKU CONSTANTS
    public static final String ROOT_URL = "https://calm-badlands-10084.herokuapp.com/";
    public static final String KEY_POST_TOKEN_ID = "registrar-usuario/";




    //https://api.instagram.com/v1/users/search?q=QUERY
    public static final String URI_SELF_MEDIA_UI = KEY_SELF_MEDIA_RECENT + KEY_ACCESS_TOKEN + ACCESS_TOKEN;

    //GET API SOURCE

    //https://api.instagram.com/v1/users/{user-id}/media/recent/?access_token=ACCESS-TOKEN

    public static final String RECENT_MEDIA_PRE_USER = BASE_URL + KEY_USERS;

    public static final String RECENT_MEDIA_POST_USER = KEY_MEDIA + KEY_ACCESS_TOKEN + ACCESS_TOKEN;

    //https://api.instagram.com/v1/users/search?q=jack&access_token=ACCESS-TOKEN

    public static final String SEARCH_PRE_USER = BASE_URL  + KEY_SEARCH;
    public static final String SEARCH_POST_USER = KEY_ACCESS_TOKEN + ACCESS_TOKEN;


    // 1c8b577ad63942dfb19806acbffa708e

    //https://api.instagram.com/v1/users/self/media/recent/?access_token=ACCESS-TOKEN

    //https://api.instagram.com/v1/users/self/?access_token=ACCESS-TOKEN

}
