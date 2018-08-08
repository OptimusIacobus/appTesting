package com.example.supaj.beginnercontent;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class MiscFragment extends Fragment {


    public MiscFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_misc, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        Button webview = (Button) view.findViewById(R.id.webview);
        webview.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent goTo = new Intent(getActivity(), Webview.class);
                startActivity(goTo);
            }
        });

        Button listView = (Button) view.findViewById(R.id.listview);
        listView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goTo = new Intent(getActivity(), ListActivity.class);
                startActivity(goTo);
            }
        });

        Switch aSwitch = (Switch) view.findViewById(R.id.switch1);

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked == true){
                    Toast.makeText(getActivity(), "It is on", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getActivity(), "It is turned off.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Fab Button
        /*
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    }

