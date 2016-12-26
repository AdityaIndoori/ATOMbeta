package com.example.aditya.ATOMmodifiable;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class iMessagePopupActivity extends AppCompatActivity {

    TextView msgDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.iactivity_message_popup);

        Log.v("ActivityLogger","We are in the iMessagePopupActivity");

        Bundle extras = getIntent().getExtras();
        String message = extras.getString("String");
        msgDisplay = (TextView)findViewById(R.id.popupTxt);
        msgDisplay.setText(message);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        },6500);
    }
}
