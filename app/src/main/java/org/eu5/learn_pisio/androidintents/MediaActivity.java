package org.eu5.learn_pisio.androidintents;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MediaActivity extends AppCompatActivity implements View.OnClickListener {

    private final static int GET_IMAGE_CAPTURE = 1000;

    private ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);

        findViewById(R.id.btnStartCamera).setOnClickListener(this);
        findViewById(R.id.btnOpenURL).setOnClickListener(this);
        findViewById(R.id.btnCapturePic).setOnClickListener(this);
        findViewById(R.id.btnSendText).setOnClickListener(this);

        imgView = (ImageView)findViewById(R.id.imgCapturePic);
    }

    @Override
    public void onClick(View v) {
        int btnClick = v.getId();

        if (btnClick == R.id.btnStartCamera) {
            // TODO: Start the camera in photo mode
            Intent i = new Intent();

            if (i.resolveActivity(getPackageManager()) != null) {
                startActivity(i);
            }
        }
        else if (btnClick == R.id.btnCapturePic) {
            // Take a picture and consume the returned result bitmap
            Intent i = new Intent();

            if (i.resolveActivity(getPackageManager()) != null) {
                // TODO: start the activity and indicate that we expect a result back

            }
        }
        else if (btnClick == R.id.btnSendText) {
            final String message = "This is a text message";

            Intent i = new Intent();

            // TODO: Use the setData function to indicate the type of data that will be sent
            // this will help the system figure out what apps to include in the chooser

            if (i.resolveActivity(getPackageManager()) != null) {
                startActivity(i);
            }
        }
        else if (btnClick == R.id.btnOpenURL) {
            String url = "http://www.google.com";

            // TODO: Parse the URL string using the Uri class

            Intent i = new Intent();

            if (i.resolveActivity(getPackageManager()) != null) {
                startActivity(i);
            }
        }
    }

    // This function will be called when an activity that was started for the purpose
    // of returning a result has some data for our app to process
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	    super.onActivityResult(requestCode, resultCode, data);
	    if (requestCode == GET_IMAGE_CAPTURE && resultCode == RESULT_OK) {
		    // TODO: Retrieve the data from the result intent and look for the bitmap
		
	    }
    }
}
