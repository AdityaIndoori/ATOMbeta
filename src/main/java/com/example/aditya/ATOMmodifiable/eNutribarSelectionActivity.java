package com.example.aditya.ATOMmodifiable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class eNutribarSelectionActivity extends AppCompatActivity {

    String Mdate,Mmonth,Myear,Edate,Emonth,Eyear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eactivity_nutribar_selection);

        Log.v("ActivityLogger","We are in the eNutribarSelectionActivity Activity");

    }

    public void nutria(View view){
        if (aInitialSetupAcitivty.nutriaQuant<1)
        {
            Intent popIntent = new Intent(this,iMessagePopupActivity.class);
            popIntent.putExtra("String","The product you have chosen is out of stock");
            startActivity(popIntent);
        }
        else
        {
            Mdate="13";
            Mmonth="09";
            Myear="16";
            Edate="13";Emonth="16";Eyear="17";
            TextView tabNameView= (TextView)findViewById(R.id.nutria_name);
            String tablet_name = tabNameView.getText().toString();
            TextView tabPriceView = (TextView) findViewById(R.id.nutria_price);
            String tablet_price = tabPriceView.getText().toString();
            String substr = tablet_price.substring(2);
            Log.v("SUBSTRING",substr);
            Intent intent=new Intent(this,hSelectedItemPopUpActivity.class);
            intent.putExtra("ItemName",tablet_name);
            intent.putExtra("ItemPrice",substr);
            intent.putExtra("mfg",Mdate+"/"+Mmonth+"/"+Myear);
            intent.putExtra("exp",Edate+"/"+Emonth+"/"+Eyear);
            startActivity(intent);
        }
    }

    public void nutrib(View view){
        if (aInitialSetupAcitivty.nutribQuant<1){
            Intent popIntent = new Intent(this,iMessagePopupActivity.class);
            popIntent.putExtra("String","The product you have chosen is out of stock");
            startActivity(popIntent);
        }
        else {
            Mdate="30";
            Mmonth="09";
            Myear="16";
            Edate="30";Emonth="06";Eyear="17";
            TextView tabNameView= (TextView)findViewById(R.id.nutrib_name);
            String tablet_name = tabNameView.getText().toString();
            TextView tabPriceView = (TextView) findViewById(R.id.nutrib_price);
            String tablet_price = tabPriceView.getText().toString();
            String substr = tablet_price.substring(2);
            Log.v("SUBSTRING",substr);
            Intent intent=new Intent(this,hSelectedItemPopUpActivity.class);
            intent.putExtra("ItemName",tablet_name);
            intent.putExtra("ItemPrice",substr);
            intent.putExtra("mfg",Mdate+"/"+Mmonth+"/"+Myear);
            intent.putExtra("exp",Edate+"/"+Emonth+"/"+Eyear);
            startActivity(intent);
        }
    }

    public void exitActiv(View view){
        finish();
    }

}
