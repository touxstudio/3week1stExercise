package org.coursera.mypentagram;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.coursera.pojo.Pets;
import org.coursera.pojo.SharedPrefsUsers;
import org.coursera.pojo.Users;

import java.util.ArrayList;

public class AccountConfigActivity extends AppCompatActivity {

    private Button button;
    private Context context;
    private EditText instagram;
    private SharedPreferences sharedPreferences;
    private ArrayList<Users> users;
    private ArrayList<Pets> pets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_config);

        //ArrayList<Users> users = new ArrayList<>();
        //users.add(new Users("6465453653", "ksdkljasjkd", "asdkjhasd"));
        //users.add(new Users("6465453659", "ksdkljasjk9", "asdkjhasd9"));

  // Log.v("CAOS444", pets.get(0).getName().toString());

        button = (Button) findViewById(R.id.BAccount);
        instagram = (EditText) findViewById(R.id.account);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPrefsUsers sharedPrefsUsers = new SharedPrefsUsers();
                //instagram.getText().toString()
                sharedPrefsUsers.saveKEY_USERID_USERNAME("disenosdeunasaura");

                /*SharedPreferences prefs = getApplicationContext().getSharedPreferences("user", getApplicationContext().MODE_PRIVATE);

                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("instagram_acc", instagram.getText().toString());

                editor.apply(); */

                Toast.makeText(getApplicationContext(), "Saved ...", Toast.LENGTH_SHORT);


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
