package org.eu5.learn_pisio.androidintents;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DestinationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination);

        TextView values = (TextView) findViewById(R.id.txtValues);

        // TODO: extract any data passed by the caller
	    
    }
}
