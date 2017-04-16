package org.coursera.apiRest;

import org.coursera.apiRest.model.PetResponse;
import org.coursera.apiRest.model.TokenResponse;
import org.coursera.apiRest.model.UserIdResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * Created by TouxStudio on 29/03/2017.
 */

public interface IApiEndPoints {

    @GET
    public Call<PetResponse> getRecentMedia(@Url String url);

    @FormUrlEncoded
    @POST(ApiRestConstants.KEY_POST_TOKEN_ID)
    Call<TokenResponse> sendTokenId(@Field("token") String token, @Field("instagram_id") String instagram_id);
}