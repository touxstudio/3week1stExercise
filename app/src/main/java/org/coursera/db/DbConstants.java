package org.coursera.db;

/**
 * Created by TouxStudio on 22/03/2017.
 */

public final class DbConstants {

    public static final String DB_NAME               = "pets";
    public static final int DB_VERSION               = 1;

    // Create table 1
    public static final String TABLE_NAME_PETS       = "mascotas";
    public static final String TABLE_PETS_ID         = "id";
    public static final String TABLE_PETS_NAME       = "name";
    public static final String TABLE_PETS_PIC        = "pic";

    // Create table 2
    public static final String TABLE_NAME_LIKES      = "likes";
    public static final String TABLE_LIKES_ID        = "id";
    public static final String TABLE_LIKES_LIKES     = "likes";
    public static final String TABLE_PET_ID          = "id_pet";

    public static final String API_INSTAGRAM_URI     =
            "https://api.instagram.com/oauth/authorize/?client_id=49428ac70486429f90888c4b8a45255b&redirect_uri=http://llautoux.com&response_type=code&scope=basic+comments+likes+follower_list+public_content+follower_list";
}
