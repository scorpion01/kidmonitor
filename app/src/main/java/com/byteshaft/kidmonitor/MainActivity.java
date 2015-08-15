package com.byteshaft.kidmonitor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    LocationService mLocationService;
    Helpers mHelpers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHelpers = new Helpers(getApplicationContext());
        Button locationButton = (Button) findViewById(R.id.button);
        locationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLocationService = new LocationService(getApplicationContext());
                if (!mHelpers.isAnyLocationServiceAvailable()) {
                    Log.i("Location", "GPS disabled");
                    /* TODO: Implement Response */
                } else {
                mLocationService.connectingGoogleApiClient();
                mLocationService.locationTimer().start();
                }
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
