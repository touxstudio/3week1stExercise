package org.coursera.mypentagram;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

/**
 * Created by TouxStudio on 07/03/2017.
 */

public class PetDetails extends AppCompatActivity {

    private TextView tvName;
    private TextView tvRate;
    private ImageView imPicDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pet_details_image);

        tvName = (TextView) findViewById(R.id.tvName);
        tvRate = (TextView) findViewById(R.id.tvRate);
        imPicDetail = (ImageView) findViewById(R.id.imPicDetail);

//        getSupportActionBar().setDisplayUseLogoEnabled(true);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        getSupportActionBar().setIcon(R.drawable.logoo);

        Bundle extras = getIntent().getExtras();
        int rate = extras.getInt(getResources().getString(R.string.pRate));
        String url = extras.getString(getResources().getString(R.string.pImgUrl));
        String name = extras.getString(getResources().getString(R.string.pName));
        //String pi = extras.getString(getResources().getString(R.string.pPic));
        //Log.v("HHH" , pi);
        //finish();


        Toast.makeText(this, name, Toast.LENGTH_SHORT);

        Picasso.with(this)
                .load(url)
                .placeholder(R.drawable.image1)
                .into(imPicDetail);

        tvName.setText(name);
        tvRate.setText(String.valueOf(rate));
        //imPicDetail.setImageResource(Integer.parseInt(url));


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
