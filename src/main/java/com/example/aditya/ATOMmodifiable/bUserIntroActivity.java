package com.example.aditya.ATOMmodifiable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import static com.example.aditya.ATOMmodifiable.aInitialSetupAcitivty.coins;

public class bUserIntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bactivity_user_intro);
        Log.v("ActivityLogger","We are in the bUserIntroActivity Activity");
    }

    public void toSelectionUIActivity(View view)
    {
        if (coins>20 || aInitialSetupAcitivty.totalnotes<450)
        {
            Intent intent=new Intent(this,cProductSelectionActivity.class);
            startActivity(intent);
        }
        else
        {
            Intent intentToPopUpActivity = new Intent(this,iMessagePopupActivity.class);
            intentToPopUpActivity.putExtra("String","Machine under Servicing");
            startActivity(intentToPopUpActivity);
        }
    }

    public void toIntroActivity(View v){
        aInitialSetupAcitivty.firstTimeSetUpScreen =false;
        Intent intent2=new Intent(this,aInitialSetupAcitivty.class);
        intent2.putExtra("Bluetooth","On");
        startActivity(intent2);
    }

}
