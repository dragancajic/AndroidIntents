package org.eu5.learn_pisio.androidintents;

import android.content.Intent;
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
		Intent callingIntent = getIntent();
		// getIntent() -> Return the intent that started this activity.
		
		// use the appropriate getter functions to extract the data for the intent
		if (callingIntent != null) {
			// public String getStringExtra(String name) | key was: "StringData"
			String stringValue = callingIntent.getStringExtra("StringData");
			
			// public int getIntExtra(String name, int defaultValue)
			int integerValue = callingIntent.getIntExtra("IntData", -1);
			
			String data = stringValue + "\n" + Integer.toString(integerValue);
			values.setText(data); // resulting data
		}
	}
}
