package com.example.beast.psvr_textalert;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e("Message: ", "I'm in onCreate()");

        SmsReceiver.bindListener(new SmsListener() {

            public void messageReceived(String messageText) {
                Log.e("Message", messageText);
                Toast.makeText(MainActivity.this, "Message: " + messageText, Toast.LENGTH_LONG).show();
            }
        });
    }
}
