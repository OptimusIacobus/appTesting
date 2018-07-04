package com.example.supaj.beginnercontent;

import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.Settings;
import android.util.Log;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    static String TAG = "MainActivity";

    public Button but1;

    private Button start,stop;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "BEGINNING APP");

        start = (Button) findViewById(R.id.ButtonStart);
        stop = (Button) findViewById(R.id.ButtonEnd);

        start.setOnClickListener(this);
        stop.setOnClickListener(this);

        init();
    }

    @Override
    public void onClick(View view){
        if(view == start){
            startService(new Intent(this, MusicService.class));
        }else if(view == stop){
            stopService((new Intent(this, MusicService.class)));
        }
    }

    public void init(){
        but1 = (Button)findViewById(R.id.entranceBtn);

        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goTo = new Intent(MainActivity.this, SecondaryActivity.class);
                startActivity(goTo);
            }
        });


    }
}
