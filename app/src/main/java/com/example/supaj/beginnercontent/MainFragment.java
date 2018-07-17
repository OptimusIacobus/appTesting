package com.example.supaj.beginnercontent;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;


public class MainFragment extends Fragment implements View.OnClickListener {

    public MainFragment() {
        // Required empty public constructor
    }

    static String TAG = "MainFragment";

    public Button but1, but2;

    private Button start, stop;

    boolean enable = false;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        start = view.findViewById(R.id.ButtonStart);
        stop = view.findViewById(R.id.ButtonEnd);

        start.setOnClickListener(this);
        stop.setOnClickListener(this);

        ToggleButton buttonMusic = (ToggleButton) view.findViewById(R.id.music);

        buttonMusic.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked == true) {
                    enable = true;
                } else {
                    enable = false;
                    getActivity().stopService(new Intent(getActivity(), MusicService.class));

                }
            }
        });

        View view2 = (View) view.findViewById(R.id.viewthing);
        view.setOnTouchListener(new OnSwipeTouchListener(getActivity()) {
            public void onSwipeTop() {
                Toast.makeText(getActivity(), "top", Toast.LENGTH_SHORT).show();
            }

            public void onSwipeRight() {
                Toast.makeText(getActivity(), "right", Toast.LENGTH_SHORT).show();
                //Intent goTo = new Intent(getActivity(), Misc.class);
                //startActivity(goTo);

            }

            public void onSwipeLeft() {
                Toast.makeText(getActivity(), "left", Toast.LENGTH_SHORT).show();
                //Intent goTo = new Intent(getActivity(), NavigationDrawer.class);
                //startActivity(goTo);
            }

            public void onSwipeBottom() {
                Toast.makeText(getActivity(), "bottom", Toast.LENGTH_SHORT).show();
            }

        });
        init();

        /* This is for the input */
        boolean isOneLetter = true;
        final EditText editText = (EditText) view.findViewById(R.id.letterInput);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_SEND) {
                    String print;
                    if (editText.getText().toString().length() > 1)
                        print = "The letter you typed was " + editText.getText().toString() + " and you did something BAD";
                    else
                        print = "The letter you typed was " + editText.getText().toString();
                    Toast.makeText(getActivity(), print, Toast.LENGTH_SHORT).show();
                    handled = true;
                }
                return handled;
            }
        });

        ImageButton googleBtn = view.findViewById(R.id.toGoogle);
        googleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String google = "https://www.google.com";
                Uri webaddress = Uri.parse(google);
                Intent gotoGoogle = new Intent(Intent.ACTION_VIEW, webaddress);
                if (gotoGoogle.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(gotoGoogle);
                }

            }
        });

        ImageButton googleBtn2 = view.findViewById(R.id.toGoogle);
        googleBtn2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getActivity(), "This button only requires a short click", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }


    public void onClick(View view) {
        if (enable == true) {
            if (view == start) {
                getActivity().startService(new Intent(getActivity(), MusicService.class));
            } else if (view == stop) {
                getActivity().stopService((new Intent(getActivity(), MusicService.class)));
            }
        }
    }

    public void init() {
        but1 = getView().findViewById(R.id.entranceBtn);

        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goTo = new Intent(getActivity(), SecondaryActivity.class);
                startActivity(goTo);
            }
        });

        but2 = getView().findViewById(R.id.misc);

        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goTo = new Intent(getActivity(), Misc.class);
                startActivity(goTo);
            }
        });


    }

    public void onPointerCaptureChanged(boolean hasCapture) {

    }


}
