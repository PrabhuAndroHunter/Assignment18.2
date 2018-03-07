package com.assignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // init layout
        setContentView(R.layout.activity_main);
    }

    // This method will show incoming sms as toast
    public void showSms(String sms) {
        Toast.makeText(this, sms, Toast.LENGTH_SHORT).show();
    }
}
