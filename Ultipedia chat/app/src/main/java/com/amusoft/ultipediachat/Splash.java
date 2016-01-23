package com.amusoft.ultipediachat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

public class Splash extends ActionBarActivity {
    SharedPreferences mUltiChatSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mUltiChatSettings =
                getSharedPreferences(Constants.PREFERENCES, Context.MODE_PRIVATE);
        if(getSupportActionBar()!=null){
            getSupportActionBar().hide();

        }


        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {
                final SharedPreferences.Editor editor22 =  mUltiChatSettings.edit();
                editor22.putString(Constants.PREF_SOUND,"true");
                editor22.commit();

                Intent i = new Intent(getBaseContext(), MainActivity.class);
                startActivity(i);

                //Remove activity
                finish();


            }
        }, 3 * 1000); // wait for 3 seconds
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_splash, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
