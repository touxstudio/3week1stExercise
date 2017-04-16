package org.coursera.apiRest.adapter;

import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.coursera.apiRest.IApiEndPoints;
import org.coursera.apiRest.ApiRestConstants;
import org.coursera.apiRest.IApiEndUserPoint;
import org.coursera.apiRest.model.PetResponse;
import org.coursera.apiRest.model.UserIdResponse;
import org.coursera.apiRest.unserialize.PetUnserializer;
import org.coursera.apiRest.unserialize.UserUnserialize;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by TouxStudio on 29/03/2017.
 */

public class RestApiAdapter {

    public IApiEndPoints connectToken (){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiRestConstants.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                ;
        return retrofit.create(IApiEndPoints.class);
    }

    public IApiEndPoints establishApiConnection(Gson gson){

        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        clientBuilder.addInterceptor(loggingInterceptor);

       Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiRestConstants.BASE_URL)
                .client(clientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(IApiEndPoints.class);


    }

    public IApiEndUserPoint establishApiConnectionUser(Gson gson){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiRestConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(IApiEndUserPoint.class);

    }

    @NonNull
    public static Gson buildGsonUnserializerMediaRecent(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(PetResponse.class, new PetUnserializer());
        return gsonBuilder.create();
    }

    @NonNull
    public static Gson buildGsonUnserializerUserId(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(UserIdResponse.class, new UserUnserialize());
        return gsonBuilder.create();
    }

}
