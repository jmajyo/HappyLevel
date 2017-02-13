package com.jmajyo.happylevel.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.jmajyo.happylevel.R;
import com.jmajyo.happylevel.model.Entry;

import java.util.Date;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {

    private static final int SAD = 0;
    private static final int NEUTRAL = 1;
    private static final int HAPPY = 2;

    private ImageView sadView;
    private ImageView neutralView;
    private ImageView happyView;

    private Button saveButton;

    private int state;
    private Entry mod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mod = new Entry();

        sadView = (ImageView) findViewById(R.id.activity_main___sad_icon);
        neutralView = (ImageView) findViewById(R.id.activity_main___neutral_icon);
        happyView = (ImageView) findViewById(R.id.activity_main___happy_icon);

        saveButton = (Button) findViewById(R.id.activity_main_save_button);



        sadView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sadView.setImageResource(R.drawable.sad_color);
                neutralView.setImageResource(R.drawable.normal_gray);
                happyView.setImageResource(R.drawable.happy_gray);
                mod.setState(SAD);
                saveButton.setVisibility(View.VISIBLE);
            }
        });
        neutralView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                neutralView.setImageResource(R.drawable.normal_color);
                sadView.setImageResource(R.drawable.sad_gray);
                happyView.setImageResource(R.drawable.happy_gray);
                mod.setState(NEUTRAL);
                saveButton.setVisibility(View.VISIBLE);
            }
        });
        happyView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                happyView.setImageResource(R.drawable.happy_color);
                sadView.setImageResource(R.drawable.sad_gray);
                neutralView.setImageResource(R.drawable.normal_gray);
                mod.setState(HAPPY);
                saveButton.setVisibility(View.VISIBLE);
            }
        });
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveMod();
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_main___action_statistics) {

            Intent i = new Intent(MainActivity.this, HistoricalActivity.class);
            startActivity(i);

            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void saveMod(){

        mod.setDate(new Date());
        Realm realm = Realm.getDefaultInstance();

        realm.beginTransaction();
        realm.copyToRealm(mod);
        realm.commitTransaction();

        /*Comprobar que se guardan en REALM
        RealmResults<Entry> hats = realm.where(Entry.class).findAll();
        for (Entry h:hats ) {
            Log.d("REALM","Date: " + h.getDate() + " - Estate: " + h.getState());
        }*/
    }
}
