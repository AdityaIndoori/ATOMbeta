package com.example.aditya.ATOMmodifiable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class cProductSelectionActivity extends AppCompatActivity {

    String Mdate,Mmonth,Myear,Edate,Emonth,Eyear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cactivity_product_selection_main);

        Log.v("ActivityLogger","We are in the cProductSelectionActivity Activity");
    }

    public void tabletClick(View view){
        Log.v("Click","Tablet");
        Intent intent=new Intent(this,dTabletSelectionActivty.class);
        startActivity(intent);
    }

    public void barClick(View view){
        Intent intent=new Intent(this,eNutribarSelectionActivity.class);
        startActivity(intent);
    }

    public void sanzClick(View view){
        if (aInitialSetupAcitivty.sanzQuant<1){
            Intent popIntent = new Intent(this,iMessagePopupActivity.class);
            popIntent.putExtra("String","The product you have chosen is out of stock");
            startActivity(popIntent);
        }
        else {
            Mdate="01";
            Mmonth="01";
            Myear="16";
            Edate="02";Emonth="02";Eyear="19";
            Intent intent=new Intent(this,hSelectedItemPopUpActivity.class);
            intent.putExtra("ItemName","Hand Sanitizer");
            intent.putExtra("ItemPrice","80");
            intent.putExtra("mfg",Mdate+"/"+Mmonth+"/"+Myear);
            intent.putExtra("exp",Edate+"/"+Emonth+"/"+Eyear);
            startActivity(intent);
        }
    }

    public void condClick(View view){
        if (aInitialSetupAcitivty.condomQuant<1){
            Intent popIntent = new Intent(this,iMessagePopupActivity.class);
            popIntent.putExtra("String","The product you have chosen is out of stock");
            startActivity(popIntent);
        }
        else {
            Mdate="01";
            Mmonth="07";
            Myear="16";
            Edate="01";Emonth="10";Eyear="18";
            Intent intent=new Intent(this,hSelectedItemPopUpActivity.class);
            intent.putExtra("ItemName","Condoms Packets");
            intent.putExtra("ItemPrice","40");
            intent.putExtra("mfg",Mdate+"/"+Mmonth+"/"+Myear);
            intent.putExtra("exp",Edate+"/"+Emonth+"/"+Eyear);
            startActivity(intent);
        }
    }

    public void sanClick(View view){

        if (aInitialSetupAcitivty.whisperQuant<1){
            Intent popIntent = new Intent(this,iMessagePopupActivity.class);
            popIntent.putExtra("String","The product you have chosen is out of stock");
            startActivity(popIntent);
        }
        else {
            Mdate="01";
            Mmonth="08";
            Myear="16";
            Edate="01";Emonth="01";Eyear="17";
            Intent intent=new Intent(this,hSelectedItemPopUpActivity.class);
            intent.putExtra("ItemName","Sanitary Napkins");
            intent.putExtra("ItemPrice","100");
            intent.putExtra("mfg",Mdate+"/"+Mmonth+"/"+Myear);
            intent.putExtra("exp",Edate+"/"+Emonth+"/"+Eyear);
            startActivity(intent);
        }
    }

    public void wipesClick(View view){
        if (aInitialSetupAcitivty.condomQuant<1){
            Intent popIntent = new Intent(this,iMessagePopupActivity.class);
            popIntent.putExtra("String","The product you have chosen is out of stock");
            startActivity(popIntent);
        }
        else {
            Mdate="01";
            Mmonth="06";
            Myear="16";
            Edate="01";Emonth="06";Eyear="18";
            Intent intent=new Intent(this,hSelectedItemPopUpActivity.class);
            intent.putExtra("ItemName","Wet Wipes");
            intent.putExtra("ItemPrice","80");
            intent.putExtra("mfg",Mdate+"/"+Mmonth+"/"+Myear);
            intent.putExtra("exp",Edate+"/"+Emonth+"/"+Eyear);
            startActivity(intent);
        }
    }

    public void drinkClick(View view){
        Intent intent=new Intent(this,fDrinksSelectionActivity.class);
        startActivity(intent);
    }

    public void backSelClick(View view){
        Intent intent= new Intent(this,bUserIntroActivity.class);
        startActivity(intent);
    }

}
