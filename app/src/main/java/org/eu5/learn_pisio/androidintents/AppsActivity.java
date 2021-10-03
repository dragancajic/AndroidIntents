package org.eu5.learn_pisio.androidintents;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class AppsActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int NOTIFY_ID = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apps);

        findViewById(R.id.btnSetAlarm).setOnClickListener(this);
        findViewById(R.id.btnShowMapLoc).setOnClickListener(this);
        findViewById(R.id.btnStartPhoneCall).setOnClickListener(this);
        findViewById(R.id.btnSendAnEmail).setOnClickListener(this);
        findViewById(R.id.btnWebSearch).setOnClickListener(this);
        findViewById(R.id.btnPendIntent).setOnClickListener(this);

        // Set up the notification channel that will be used for
        // the pending intent example
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("my_channel","Android Intents",importance);
            channel.setDescription("Test Notification Channel");
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }


    @Override
    public void onClick(View v) {
        int btnClick = v.getId();

        if (btnClick == R.id.btnSetAlarm) {
            final String message = "Time to wake up!";
            final int hour = 6;
            final int minutes = 30;

            // TODO: Create an intent to tell the system to set an alarm
            // NOTE: your app needs to have the Set Alarm permission
            Intent i = new Intent();

            if (i.resolveActivity(getPackageManager()) != null) {
                startActivity(i);
            }
        }
        else if (btnClick == R.id.btnShowMapLoc) {
            // Locations can be specified using latlongs, queries, addresses, etc.
            String location = "geo:37.4220,-122.0841";
//            String location = "geo:0,0?q=37.4220,-122.0841(GooglePlex)";
//            String location = "geo:0,0?q=20+W+34th+St+10001";
//            String location = "geo:47.6205,-122.3493?q=restaurants";

            // TODO: Parse the location using the Uri class


            // TODO: Pass the Uri directly to the Intent constructor
            Intent i = new Intent();

            if (i.resolveActivity(getPackageManager()) != null) {
                startActivity(i);
            }
        }
        else if (btnClick == R.id.btnSendAnEmail) {
            String[] addresses = { "test@example.com" };
            String[] ccs = { "someone@example.com" };
            String subject = "This is a test";
            String message = "This is a test email message!";

            Intent i = new Intent();

            // TODO: Use setData to ensure that only email apps respond


            // TODO: add the email data to the intent


            if (i.resolveActivity(getPackageManager()) != null) {
                startActivity(i);
            }
        }
        else if (btnClick == R.id.btnStartPhoneCall) {
            String phoneNumber = "1-800-555-1212";

            // TODO: Build the Uri for the phone number


            // TODO: Your application needs the CALL_PHONE permission for this intent
            Intent i = new Intent();
//          Intent i = new Intent(Intent.ACTION_CALL); // Actually makes the call
            // TODO: Set the Uri as the intent data

            if (i.resolveActivity(getPackageManager()) != null) {
                startActivity(i);
            }
        }
        else if (btnClick == R.id.btnWebSearch) {
            String queryStr = "Eiffel Tower";

            // TODO: Create an intent to fire off a web search
            Intent i = new Intent();

            // TODO: pass the query string to the Intent


            if (i.resolveActivity(getPackageManager()) != null) {
                startActivity(i);
            }
        }
        else if (btnClick == R.id.btnPendIntent) {
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "my_channel");

            // TODO: Create the intent that will be fired when the user taps the notification
            Intent intent = new Intent();
            // TODO: Wrap it up in a PendingIntent


            builder.setSmallIcon(R.drawable.ic_launcher_foreground);
            builder.setContentTitle("Sample Notification");
            builder.setContentText("This is a sample notification");
            builder.setAutoCancel(true);
            builder.setSubText("Tap to view");
            // TODO: add the pending intent to the builder


            Notification notification = builder.build();
            NotificationManager mgr = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
            mgr.notify(NOTIFY_ID, notification);
        }
    }
}
