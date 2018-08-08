package com.example.supaj.beginnercontent;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DetailActivity extends Activity {

    int image;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);

        TextView title = (TextView)findViewById(R.id.titleDetail);
        TextView detail = (TextView)findViewById(R.id.detail);
        TextView description= (TextView)findViewById(R.id.descriptionDetail);



        Bundle extras = getIntent().getExtras();

        if (extras != null) {


            CharSequence titleText = extras.getString("title");
            title.setText(titleText);

            CharSequence detailText = extras.getString("detail");
            detail.setText(detailText);

            CharSequence descriptionText = extras.getString("description");
            description.setText(descriptionText);



        }

    }

}