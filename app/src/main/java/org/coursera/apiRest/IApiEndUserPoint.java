package org.coursera.apiRest;

import org.coursera.apiRest.ApiRestConstants;
import org.coursera.apiRest.model.UserIdResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by TouxStudio on 31/03/2017.
 */

public interface IApiEndUserPoint{



   // @GET(ApiRestConstants.BASE_URL + ApiRestConstants.KEY_SEARCH + ApiRestConstants.KEY_ACCESS_TOKEN + ApiRestConstants.ACCESS_TOKEN)
   @GET
    Call<UserIdResponse> getUserIdUri(@Url String url);
}