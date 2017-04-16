package org.coursera.apiRest.unserialize;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import org.coursera.apiRest.JsonKeys;
import org.coursera.apiRest.model.PetResponse;
import org.coursera.pojo.Pets;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by TouxStudio on 29/03/2017.
 */

public class PetUnserializer implements JsonDeserializer<PetResponse>{


    @Override
    public PetResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        Gson gson = new Gson();
        PetResponse petResponse = gson.fromJson(json, PetResponse.class);
        JsonArray petResponseData = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONSE_ARRAY);

       petResponse.setMyPets(unserializerJson(petResponseData));

        return petResponse;
    }

    private ArrayList<Pets> unserializerJson(JsonArray petResponseData){

        ArrayList<Pets> pets = new ArrayList<>();

        for (int i = 0; i < petResponseData.size() ; i++) {

            JsonObject petResJsonObject = petResponseData.get(i).getAsJsonObject();

            JsonObject userJson         = petResJsonObject.getAsJsonObject(JsonKeys.USER);
            String id                   = userJson.get(JsonKeys.USER_ID).getAsString();
            String full_name            = userJson.get(JsonKeys.USER_NAME).getAsString();

            JsonObject jsonImage        = petResJsonObject.getAsJsonObject(JsonKeys.MEDIA_IMAGES);

            Log.v("CAOSS", full_name);

            JsonObject stdImage         = jsonImage.getAsJsonObject(JsonKeys.MEDIA_IMAGE_RESOLUTION);
            String imageUrl             = stdImage.get(JsonKeys.MEDIA_IMAGE_URL).getAsString();

            JsonObject userLikes        = petResJsonObject.getAsJsonObject(JsonKeys.MEDIA_LIKES);
            int likesCount              = userLikes.get(JsonKeys.MEDIA_LIKES_COUNT).getAsInt();

            Pets petss = new Pets();
            petss.setId(id);
            petss.setName(full_name);
            petss.setPic(imageUrl);
            petss.setRate(likesCount);

            pets.add(petss);


        }

       return pets;

    }
}
