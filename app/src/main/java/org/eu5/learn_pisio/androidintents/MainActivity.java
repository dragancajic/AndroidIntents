package org.eu5.learn_pisio.androidintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// Set up the UI controls
		findViewById(R.id.create_explicit).setOnClickListener(this);
		findViewById(R.id.create_implicit).setOnClickListener(this);
		findViewById(R.id.btnMediaIntents).setOnClickListener(this);
		findViewById(R.id.btnAppIntents).setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		// Figure out which button was clicked
		int viewClicked = v.getId();
		
		if (viewClicked == R.id.create_explicit) {
			// TODO: Build an explicit Intent to launch our Activity
			Intent explicitIntent = new Intent(this, DestinationActivity.class);
			
			// TODO: send data along with the Intent to the destination
			explicitIntent.putExtra("StringData", "This is a string");
			explicitIntent.putExtra("IntData", 1234);
			
			// TODO: Start the activity with our explicit intent
			startActivity(explicitIntent);
		}
		else if (viewClicked == R.id.create_implicit) {
			// TODO: Build an implicit intent to handle a type of action
			// create an intent to send a piece of text data to another app
			String textMessage = "This is a sample message";
			
			// first, create the intent, and then...
			Intent implicitIntent = new Intent();
			
			// ...set the intent action along with the MIME type of data that I'm sending
			implicitIntent.setAction(Intent.ACTION_SEND);
			implicitIntent.setType("text/plain");
			
			// specify the data that will actually be sent
			implicitIntent.putExtra(Intent.EXTRA_TEXT, textMessage);
			
			// TODO: use an intent chooser to force a choose dialog
			
			// TODO: Verify that the intent will resolve to an activity
			// In the place where you call startActivity() for your implicit intent,
			// use the resolveActivity() function to ensure that there is at least
			// one app that can handle this intent.
			// > on the intent, call resolveActivity()
			// Return the Activity component that should be used to handle this intent.
			// Consider adding a <queries> declaration to your manifest when calling this method;
			// see https://g.co/dev/packagevisibility for details
			if (implicitIntent.resolveActivity(getPackageManager()) != null) {
				// Return PackageManager instance to find global package information.
				startActivity(implicitIntent);
			}
			
			// Typically you would handle the null case here by informing the user
			// that there is no installed app to handle this intent or
			// by taking some other action
		}
		
		// Handle button clicks to start the other intent examples
		if (viewClicked == R.id.btnAppIntents) {
			Intent i = new Intent(this, AppsActivity.class);
			startActivity(i);
		}
		else if (viewClicked == R.id.btnMediaIntents) {
			Intent i = new Intent(this, MediaActivity.class);
			startActivity(i);
		}
	}
}
