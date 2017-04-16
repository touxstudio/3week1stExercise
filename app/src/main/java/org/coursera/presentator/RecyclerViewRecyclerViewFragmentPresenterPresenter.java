package org.coursera.presentator;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import org.coursera.apiRest.ApiRestConstants;
import org.coursera.apiRest.IApiEndPoints;
import org.coursera.apiRest.IApiEndUserPoint;
import org.coursera.apiRest.adapter.RestApiAdapter;
import org.coursera.apiRest.model.PetResponse;
import org.coursera.apiRest.model.UserIdResponse;

import org.coursera.mypentagram.MainActivity;
import org.coursera.mypentagram.R;
import org.coursera.pojo.Pets;
import org.coursera.db.petDbInteractor;
import org.coursera.pojo.SharedPrefsUsers;
import org.coursera.pojo.Users;
import org.coursera.view.FavFragmentView;
import org.coursera.view.IRecyclerViewFragmentView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static org.coursera.mypentagram.R.string.fav;

/**
 * Created by TouxStudio on 21/03/2017.
 */

public class RecyclerViewRecyclerViewFragmentPresenterPresenter implements IRecyclerViewFragmentPresenter {

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private petDbInteractor petDbInteractor;
    private ArrayList<Pets> pets;
    private ArrayList<Users> users;
    Context applicationContext = MainActivity.getContextOfApplication();
    private String UID;


    public RecyclerViewRecyclerViewFragmentPresenterPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context){
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        //getDataDb();




        getUserId();

        //Log.v("CAOSSSSS", UID);
        //SharedPrefsUsers sharedPrefsUsers;
        //sharedPrefsUsers.saveKEY_USERID_USERNAME();



        try {
            getApiData();
        } catch (NullPointerException e){
            Log.v("CAOS2", "Vacio");
        }
    }



    @Override
    public void getDataDb() {

        petDbInteractor = new petDbInteractor(context);
        pets = petDbInteractor.getDbData();
        showData();

    }

    @Override
    public void showData() {
            iRecyclerViewFragmentView.initAdapter(iRecyclerViewFragmentView.createAdapter(pets));
            iRecyclerViewFragmentView.generateGridLayoutVertical();

    }



    @Override
    public void getUserId() {

        SharedPrefsUsers sharedPrefsUsers = new SharedPrefsUsers();
        String userName = sharedPrefsUsers.getSharedSingleParam(context.getResources().getString(R.string.KEY_USERID_USERNAME));

        String UID_URL = ApiRestConstants.SEARCH_PRE_USER + userName + "&" + ApiRestConstants.SEARCH_POST_USER;

        Log.v("SHAREDD", UID_URL);

        RestApiAdapter restApiAdapter = new RestApiAdapter();
        //POSIBLE PROBLEMA
        Gson gsonUserId = RestApiAdapter.buildGsonUnserializerUserId();
        IApiEndUserPoint iApiEndUserPoint = restApiAdapter.establishApiConnectionUser(gsonUserId);
        Call<UserIdResponse> userIdResponseCall = iApiEndUserPoint.getUserIdUri(UID_URL) ;

        userIdResponseCall.enqueue(new Callback<UserIdResponse>() {
            @Override
            public void onResponse(Call<UserIdResponse> call, Response<UserIdResponse> response) {
                UserIdResponse userIdResponse = response.body();
                users = userIdResponse.getMyUsers();
                showData();

                getApiData();
            }

            @Override
            public void onFailure(Call<UserIdResponse> call, Throwable t) {
                Toast.makeText(context, "Hubo un error con la conexión", Toast.LENGTH_SHORT);
            }
        });

    }

    @Override
    public void getApiData() {

        SharedPrefsUsers sharedPrefsUsers = new SharedPrefsUsers();
        String userId = sharedPrefsUsers.getSharedSingleParam(context.getResources().getString(R.string.KEY_USERID_NUMERIC));

        RestApiAdapter restApiAdapter = new RestApiAdapter();
        //POSIBLE PROBLEMA
        Gson gsonMediaRecent = RestApiAdapter.buildGsonUnserializerMediaRecent();
        IApiEndPoints iApiEndPoints = restApiAdapter.establishApiConnection(gsonMediaRecent);

        String URL = ApiRestConstants.RECENT_MEDIA_PRE_USER + userId + ApiRestConstants.RECENT_MEDIA_POST_USER;
        Log.v("SHAREDD", URL);

        Call<PetResponse> petResponseCall = iApiEndPoints.getRecentMedia(URL);

        petResponseCall.enqueue(new Callback<PetResponse>() {
            @Override
            public void onResponse(Call<PetResponse> call, Response<PetResponse> response) {
               PetResponse petResponse = response.body();
                try {
                    pets = petResponse.getMyPets();
                }catch (NullPointerException e){
                    Log.v("SHAREDD", e.toString());
                    FavFragmentView favFragmentView = new FavFragmentView();
                    favFragmentView.arrayInit();
                }

                showData();
            }

            @Override
            public void onFailure(Call<PetResponse> call, Throwable t) {
                Toast.makeText(context, "Hubo un error con la conexión", Toast.LENGTH_SHORT);
            }
        });


    }




}
