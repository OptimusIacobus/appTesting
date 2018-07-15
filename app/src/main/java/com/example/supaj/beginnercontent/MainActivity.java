package com.example.supaj.beginnercontent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    static String TAG = "MainActivity";

    public Button but1, but2;

    private Button start,stop;

    boolean enable = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "BEGINNING APP");


        start = findViewById(R.id.ButtonStart);
        stop = findViewById(R.id.ButtonEnd);

        start.setOnClickListener(this);
        stop.setOnClickListener(this);

        ToggleButton buttonMusic = (ToggleButton) findViewById(R.id.music);

        buttonMusic.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked == true){
                   enable = true;
                }
                else{
                    enable = false;
                    stopService(new Intent(MainActivity.this, MusicService.class));

                }
            }
        });

        View view = (View) findViewById(R.id.viewthing);
        view.setOnTouchListener(new OnSwipeTouchListener(MainActivity.this) {
            public void onSwipeTop() {
                Toast.makeText(MainActivity.this, "top", Toast.LENGTH_SHORT).show();
            }
            public void onSwipeRight() {
                Toast.makeText(MainActivity.this, "right", Toast.LENGTH_SHORT).show();
                Intent goTo = new Intent(MainActivity.this, Misc.class);
                startActivity(goTo);

            }
            public void onSwipeLeft() {
                Toast.makeText(MainActivity.this, "left", Toast.LENGTH_SHORT).show();
                Intent goTo = new Intent(MainActivity.this, NavigationDrawer.class);
                startActivity(goTo);
            }
            public void onSwipeBottom() {
                Toast.makeText(MainActivity.this, "bottom", Toast.LENGTH_SHORT).show();
            }

        });
        init();

        /* This is for the input */
        boolean isOneLetter = true;
        final EditText editText = (EditText) findViewById(R.id.letterInput);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_SEND) {
                    String print;
                    if(editText.getText().toString().length() > 1)
                        print = "The letter you typed was " + editText.getText().toString() + " and you did something BAD";
                    else
                        print = "The letter you typed was " + editText.getText().toString();
                    Toast.makeText(MainActivity.this, print, Toast.LENGTH_SHORT).show();
                    handled = true;
                }
                return handled;
            }
        });

        ImageButton googleBtn = findViewById(R.id.toGoogle);
        googleBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                String google = "https://www.google.com";
                Uri webaddress = Uri.parse(google);
                Intent gotoGoogle = new Intent(Intent.ACTION_VIEW, webaddress);
                if(gotoGoogle.resolveActivity(getPackageManager()) !=  null){
                    startActivity(gotoGoogle);
                }

            }
        });

        ImageButton googleBtn2 = findViewById(R.id.toGoogle);
        googleBtn2.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v){
                Toast.makeText(MainActivity.this, "This button only requires a short click", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

    }


    @Override
    public void onClick(View view){
        if(enable == true) {
            if (view == start) {
                startService(new Intent(this, MusicService.class));
            } else if (view == stop) {
                stopService((new Intent(this, MusicService.class)));
            }
        }
    }

    public void init(){
        but1 = findViewById(R.id.entranceBtn);

        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goTo = new Intent(MainActivity.this, SecondaryActivity.class);
                startActivity(goTo);
            }
        });

        but2 = findViewById(R.id.misc);

        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goTo = new Intent(MainActivity.this, Misc.class);
                startActivity(goTo);
            }
        });


    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
