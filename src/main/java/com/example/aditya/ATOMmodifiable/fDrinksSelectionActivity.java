package com.example.aditya.ATOMmodifiable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class fDrinksSelectionActivity extends AppCompatActivity {

    String Mdate,Mmonth,Myear,Edate,Emonth,Eyear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.factivity_drinks_selection);

        Log.v("ActivityLogger","We are in the fDrinksSelectionActivity Activity");

    }

    public void bisleri(View view){
        if (aInitialSetupAcitivty.bisleri<1){
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
            Mdate="25";
            Mmonth="10";
            Myear="16";
            Edate="25";Emonth="04";Eyear="17";
            String details="This is the Bisleri";
            TextView tabNameView= (TextView)findViewById(R.id.bisleri_name);
            String tablet_name = tabNameView.getText().toString();
            TextView tabPriceView = (TextView) findViewById(R.id.bisleri_price);
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

    public void wild(View view){
        if (aInitialSetupAcitivty.wild<1){
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
            Mmonth="01";
            Myear="01";
            Edate="02";Emonth="02";Eyear="02";
            String details="This is the Wild Vitamin Drink";
            TextView tabNameView= (TextView)findViewById(R.id.wild_name);
            String tablet_name = tabNameView.getText().toString();
            TextView tabPriceView = (TextView) findViewById(R.id.wild_price);
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

    public void zago(View view){
        if (aInitialSetupAcitivty.zago<1){
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
            Mmonth="01";
            Myear="01";
            Edate="02";Emonth="02";Eyear="02";
            String details="This is the Zago Protein Drink";
            TextView tabNameView= (TextView)findViewById(R.id.zago_name);
            String tablet_name = tabNameView.getText().toString();
            TextView tabPriceView = (TextView) findViewById(R.id.zago_price);
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

    public void aloe(View view){
        if (aInitialSetupAcitivty.aloe<1){
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
            Mmonth="01";
            Myear="01";
            Edate="02";Emonth="02";Eyear="02";
            String details="This is the Wild Vitamin Drink";
            TextView tabNameView= (TextView)findViewById(R.id.aloe_name);
            String tablet_name = tabNameView.getText().toString();
            TextView tabPriceView = (TextView) findViewById(R.id.aloe_price);
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

    public void pulpy(View view){
        if (aInitialSetupAcitivty.pulpy<1){
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
            Mmonth="01";
            Myear="01";
            Edate="02";Emonth="02";Eyear="02";
            String details="This is the Wild Vitamin Drink";
            TextView tabNameView= (TextView)findViewById(R.id.pulpy_name);
            String tablet_name = tabNameView.getText().toString();
            TextView tabPriceView = (TextView) findViewById(R.id.pulpy_price);
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

