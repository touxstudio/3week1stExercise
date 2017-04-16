package org.coursera.mypentagram;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.firebase.iid.FirebaseInstanceId;

import org.coursera.apiRest.IApiEndPoints;
import org.coursera.apiRest.adapter.RestApiAdapter;
import org.coursera.apiRest.model.TokenResponse;
import org.coursera.pojo.SharedPrefsUsers;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyNotification extends AppCompatActivity {

    public String instagram_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_notification);
    }

    public void showNotification (View v){
        String token = FirebaseInstanceId.getInstance().getToken();
        Log.v("TOUX", token);
        sendToken(token);
    }

    //METHOD SEND TOKEN
    private void sendToken(String token){

        SharedPrefsUsers sharedPrefsUsers = new SharedPrefsUsers();

        Log.v("TOUX", token);
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        IApiEndPoints iApiEndPoints = restApiAdapter.connectToken();
        String instagram_id = sharedPrefsUsers.getSharedSingleParam(this.getResources().getString(R.string.KEY_USERID_NUMERIC));
        Call<TokenResponse> tokenResponseCall = iApiEndPoints.sendTokenId(token, instagram_id);
        Log.v("TOUX - Id" , instagram_id);

        tokenResponseCall.enqueue(new Callback<TokenResponse>() {
            @Override
            public void onResponse(Call<TokenResponse> call, Response<TokenResponse> response) {
              TokenResponse tokenResponse =  response.body();
                Log.v("TOUX - ID", tokenResponse.getId());
                Log.v("TOUX - Token", tokenResponse.getToken());

            }

            @Override
            public void onFailure(Call<TokenResponse> call, Throwable t) {

            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_favorites) {
            Intent i = new Intent(this, Favorites.class);
            startActivity(i);
        }

        if (id == R.id.action_notification) {
            Intent i = new Intent(this, MyNotification.class);
            startActivity(i);
        }

        if(id == R.id.action_contacts){
            Intent i = new Intent(this, ContactActivity.class);
            startActivity(i);;
        }
        if(id == R.id.action_about){
            Intent i = new Intent(this, AboutActivity.class);
            startActivity(i);
        }
        if(id == R.id.action_account){
            Intent i = new Intent(this, AccountConfigActivity.class);
            startActivity(i);
        }



        return super.onOptionsItemSelected(item);
    }


}
