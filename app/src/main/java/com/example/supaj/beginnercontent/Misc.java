package com.example.supaj.beginnercontent;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class Misc extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_misc);

        Button webview = (Button) findViewById(R.id.webview);
        webview.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent goTo = new Intent(Misc.this, Webview.class);
                startActivity(goTo);
            }
        });

        Button listView = (Button) findViewById(R.id.listview);
        listView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goTo = new Intent(Misc.this, List.class);
                startActivity(goTo);
            }
        });

        Switch aSwitch = (Switch) findViewById(R.id.switch1);

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked == true){
                    Toast.makeText(Misc.this, "It is on", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(Misc.this, "It is turned off.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //TODO: Use this button lol
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
