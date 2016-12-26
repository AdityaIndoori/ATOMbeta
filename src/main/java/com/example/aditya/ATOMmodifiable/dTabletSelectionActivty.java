package com.example.aditya.ATOMmodifiable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class dTabletSelectionActivty extends AppCompatActivity {

    String Mdate,Mmonth,Myear,Edate,Emonth,Eyear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dactivity_tablet_selection);

        Log.v("ActivityLogger","We are in the dTabletSelectionActivty Activity");

    }

    public void tablet2Click(View view){
        if (aInitialSetupAcitivty.doloQuant<1){
            Intent popIntent = new Intent(this,iMessagePopupActivity.class);
            popIntent.putExtra("String","The product you have chosen is out of stock");
            startActivity(popIntent);
            /*
            Toast toast = Toast.makeText(this, "The product you have chosen is out of stock", Toast.LENGTH_SHORT);
            ViewGroup group = (ViewGroup) toast.getView();
            TextView messageTextView = (TextView) group.getChildAt(0);
            messageTextView.setTextSize(38);
            toast.show();*/
        }

        else {
            Mdate="01";
            Mmonth="08";
            Myear="16";
            Edate="01";Emonth="01";Eyear="20";
            TextView tabNameView= (TextView)findViewById(R.id.tablet2_name);
            String tablet_name = tabNameView.getText().toString();
            TextView tabPriceView = (TextView) findViewById(R.id.tablet2_price);
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

    public void tablet3Click(View view){
        if (aInitialSetupAcitivty.metrogylQuant<1){
            Intent popIntent = new Intent(this,iMessagePopupActivity.class);
            popIntent.putExtra("String","The product you have chosen is out of stock");
            startActivity(popIntent);
        }
        else {
            Mdate="01";
            Mmonth="08";
            Myear="16";
            Edate="01";Emonth="07";Eyear="20";
            TextView tabNameView= (TextView)findViewById(R.id.tablet3_name);
            String tablet_name = tabNameView.getText().toString();
            TextView tabPriceView = (TextView) findViewById(R.id.tablet3_price);
            String tablet_price = tabPriceView.getText().toString();
            String substr = tablet_price.substring(2);
            Intent intent=new Intent(this,hSelectedItemPopUpActivity.class);
            intent.putExtra("ItemName",tablet_name);
            intent.putExtra("ItemPrice",substr);
            intent.putExtra("mfg",Mdate+"/"+Mmonth+"/"+Myear);
            intent.putExtra("exp",Edate+"/"+Emonth+"/"+Eyear);
            startActivity(intent);
        }
    }

    public void tablet4Click(View view){
        if (aInitialSetupAcitivty.okacetQuant<1){
            Intent popIntent = new Intent(this,iMessagePopupActivity.class);
            popIntent.putExtra("String","The product you have chosen is out of stock");
            startActivity(popIntent);
        }
        else {
            Mdate="01";
            Mmonth="09";
            Myear="16";
            Edate="01";Emonth="03";Eyear="18";
            TextView tabNameView = (TextView) findViewById(R.id.tablet4_name);
            String tablet_name = tabNameView.getText().toString();
            TextView tabPriceView = (TextView) findViewById(R.id.tablet4_price);
            String tablet_price = tabPriceView.getText().toString();
            String substr = tablet_price.substring(2);
            Log.v("SUBSTRING", substr);
            Intent intent=new Intent(this,hSelectedItemPopUpActivity.class);
            intent.putExtra("ItemName",tablet_name);
            intent.putExtra("ItemPrice",substr);
            intent.putExtra("mfg",Mdate+"/"+Mmonth+"/"+Myear);
            intent.putExtra("exp",Edate+"/"+Emonth+"/"+Eyear);
            startActivity(intent);
        }
    }

    public void tablet5Click(View view){
        if (aInitialSetupAcitivty.eldoperQuant<1){
            Intent popIntent = new Intent(this,iMessagePopupActivity.class);
            popIntent.putExtra("String","The product you have chosen is out of stock");
            startActivity(popIntent);
        }
        else {
            Mdate="01";
            Mmonth="04";
            Myear="16";
            Edate="01";Emonth="09";Eyear="17";
            TextView tabNameView = (TextView) findViewById(R.id.tablet5_name);
            String tablet_name = tabNameView.getText().toString();
            TextView tabPriceView = (TextView) findViewById(R.id.tablet5_price);
            String tablet_price = tabPriceView.getText().toString();
            String substr = tablet_price.substring(2);
            Log.v("SUBSTRING", substr);
            Intent intent=new Intent(this,hSelectedItemPopUpActivity.class);
            intent.putExtra("ItemName",tablet_name);
            intent.putExtra("ItemPrice",substr);
            intent.putExtra("mfg",Mdate+"/"+Mmonth+"/"+Myear);
            intent.putExtra("exp",Edate+"/"+Emonth+"/"+Eyear);
            startActivity(intent);
        }
    }

    public void tablet6Click(View view){
        if (aInitialSetupAcitivty.gelusil<1){
            Intent popIntent = new Intent(this,iMessagePopupActivity.class);
            popIntent.putExtra("String","The product you have chosen is out of stock");
            startActivity(popIntent);
        }
        else {
            Mdate="01";
            Mmonth="03";
            Myear="16";
            Edate="01";Emonth="05";Eyear="19";
            TextView tabNameView = (TextView) findViewById(R.id.tablet6_name);
            String tablet_name = tabNameView.getText().toString();
            TextView tabPriceView = (TextView) findViewById(R.id.tablet6_price);
            String tablet_price = tabPriceView.getText().toString();
            String substr = tablet_price.substring(2);
            Log.v("SUBSTRING", substr);
            Intent intent=new Intent(this,hSelectedItemPopUpActivity.class);
            intent.putExtra("ItemName",tablet_name);
            intent.putExtra("ItemPrice",substr);
            intent.putExtra("mfg",Mdate+"/"+Mmonth+"/"+Myear);
            intent.putExtra("exp",Edate+"/"+Emonth+"/"+Eyear);
            startActivity(intent);
        }
    }

    public void tablet7Click(View view){
        if (aInitialSetupAcitivty.meftalQuant<1){
            Intent popIntent = new Intent(this,iMessagePopupActivity.class);
            popIntent.putExtra("String","The product you have chosen is out of stock");
            startActivity(popIntent);
        }
        else {

            Mdate="01";
            Mmonth="07";
            Myear="16";
            Edate="01";Emonth="07";Eyear="19";
            TextView tabNameView = (TextView) findViewById(R.id.tablet7_name);
            String tablet_name = tabNameView.getText().toString();
            TextView tabPriceView = (TextView) findViewById(R.id.tablet7_price);
            String tablet_price = tabPriceView.getText().toString();
            String substr = tablet_price.substring(2);
            Log.v("SUBSTRING", substr);
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
