package org.coursera.apiRest.unserialize;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;

import org.coursera.apiRest.JsonKeys;
import org.coursera.apiRest.model.UserIdResponse;
import org.coursera.mypentagram.MainActivity;
import org.coursera.pojo.SharedPrefsUsers;
import org.coursera.pojo.Users;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by TouxStudio on 30/03/2017.
 */

public class UserUnserialize implements JsonDeserializer<UserIdResponse>  {


    Context applicationContext = MainActivity.getContextOfApplication();

    @Override
    public UserIdResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        Gson gson = new Gson();
        UserIdResponse useridResponse = gson.fromJson(json, UserIdResponse.class);
        JsonArray userIdResponse = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONSE_ARRAY);
        useridResponse.setMyUsers(unserializerJson(userIdResponse));


        return useridResponse;
    }

    private ArrayList<Users> unserializerJson(JsonArray userIdResponseData){

        ArrayList<Users> users = new ArrayList<>();

       for (int i = 0; i <= userIdResponseData.size() ; i++) {

           JsonObject userIdJsonObject = userIdResponseData.get(i).getAsJsonObject();

           JsonObject userJson        = userIdJsonObject.getAsJsonObject();
           String id                  = userJson.get(JsonKeys.USER_ID).getAsString();
           String imageUrl            = userJson.get(JsonKeys.USER_PROFILE_PICTURE).getAsString();
           String userName            = userJson.get(JsonKeys.USER_USERNAME).getAsString();

           //NO VA

           Log.v("SHAREDD", id + imageUrl + userName);
           SharedPrefsUsers sharedPrefsUsers = new SharedPrefsUsers();
           sharedPrefsUsers.saveUserDetails(id, userName, imageUrl);


           Log.v("CAOS4", "DDD" + id  + imageUrl + "\n" + userName);

       }

        return users;

    }

}
