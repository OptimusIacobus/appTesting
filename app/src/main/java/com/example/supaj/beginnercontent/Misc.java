package com.example.supaj.beginnercontent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Misc extends AppCompatActivity {

    //name of file
    String fileName = "";

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
                Intent goTo = new Intent(Misc.this, ListActivity.class);
                startActivity(goTo);
            }
        });

        Button addElement = (Button) findViewById(R.id.addListElement);
        addElement.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent goTo = new Intent(Misc.this, AddElement.class);
                startActivity(goTo);
            }
        });


        //camera activity
        Button camera= (Button) findViewById(R.id.camera);
        camera.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                dispatchTakePictureIntent();

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


    }


    // CAMERA CODE

    static final int REQUEST_TAKE_PHOTO = 1;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    final String TAG = "CameraActivity";

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                // Error occurred while creating the FilE
                Log.d(TAG, "Error occurred creating the file");
            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(this,
                        "com.example.android.fileprovider",
                        photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
            }
        }
    }

    //when camera intent is finished
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent){
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
                Intent goTo = new Intent(Misc.this, Camera.class);

                goTo.putExtra("FILENAME", fileName);
                startActivity(goTo);
            }
    }

    //Save image to file
    String mCurrentPhotoPath;

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";



        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        mCurrentPhotoPath = image.getAbsolutePath();

        //CUSTOM CODE: global variable to add to access it is used here
        fileName = mCurrentPhotoPath;
        return image;
    }

}
