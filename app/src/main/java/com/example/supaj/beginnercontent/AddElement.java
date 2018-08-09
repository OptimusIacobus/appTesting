package com.example.supaj.beginnercontent;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddElement extends AppCompatActivity {


    List<Data> data = Collections.emptyList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_element);


        Button addNew = (Button) findViewById(R.id.addToListBtn);
        addNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText titleInput = (EditText) findViewById(R.id.titleInput);
                EditText detailInput = (EditText) findViewById(R.id.detailInput);
                EditText descInput = (EditText) findViewById(R.id.descInput);

                //fill_with_data(titleInput.getText().toString(), detailInput.getText().toString(), descInput.getText().toString());
                String[] rawdata = {titleInput.getText().toString(), detailInput.getText().toString(), descInput.getText().toString()};

                Toast.makeText(AddElement.this, "Add Element Success", Toast.LENGTH_SHORT).show();
                Intent goBack = new Intent(AddElement.this, ListActivity.class);
                goBack.putExtra("message", "success");
                goBack.putExtra("DataList", rawdata);
                startActivity(goBack);

            }
        });
    }

    public void fill_with_data(String title, String detail, String desc) {

            //data.add(new Data(title, detail, R.drawable.github, desc));
            Intent sendingData = new Intent(AddElement.this, ListActivity.class);
            String[] rawdata = {title, detail, desc};

            sendingData.putExtra("message", "success");
            sendingData.putExtra("DataList", rawdata);
            startActivity(sendingData);

    }
}
