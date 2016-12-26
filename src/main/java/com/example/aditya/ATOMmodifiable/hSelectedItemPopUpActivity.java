package com.example.aditya.ATOMmodifiable;

import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class hSelectedItemPopUpActivity extends AppCompatActivity {

    TextView otherName,otherPrice,otherQuantity,otherMfg,otherExp;
    int quantityH;
    ImageView imageViewOfH;
    String itemName,itemPrice,Mfg,Exp;
    BluetoothSocket btSocket = null;//Creating a Bluetooth Socket to send data from Tablet to Arduino
    int remainingQuantityofH;//The number of products of a selected items remaining

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hactivity_selected_item_popup);
        btSocket= aInitialSetupAcitivty.btSocket;

        Log.v("ActivityLogger","We are in the hSelectedItemPopUpActivity Activity");

        otherName=(TextView)findViewById(R.id.otherItemName);
        otherPrice=(TextView)findViewById(R.id.otherItemPrice);
        otherQuantity=(TextView)findViewById(R.id.otherItemQuant);
        imageViewOfH =(ImageView)findViewById(R.id.otherItemImage);
        otherMfg=(TextView) findViewById(R.id.MfgDate);
        otherExp=(TextView)findViewById(R.id.ExpDate);

        Bundle extras = getIntent().getExtras();
        itemName=extras.getString("ItemName");
        itemPrice=extras.getString("ItemPrice");
        Mfg=extras.getString("mfg");
        Exp=extras.getString("exp");

        if (itemName.equals("Sanitary Napkins"))
            otherName.setText("Whisper Ultra XXL 360mm");
        else
            otherName.setText(itemName);

        otherPrice.setText("₹ "+itemPrice+".00");
        displayImagesH(itemName);
        quantityH =1;
        otherQuantity.setText(""+ quantityH);
        otherMfg.setText(Mfg);
        otherExp.setText(Exp);
    }

    public void displayImagesH(String string){
        if ("Condoms Packets".equals(string)){
            imageViewOfH.setImageResource(R.drawable.condimg);
            remainingQuantityofH = aInitialSetupAcitivty.condomQuant;
        }
        else if("Hand Sanitizer".equals(string)){
            imageViewOfH.setImageResource(R.drawable.detsanz);
            remainingQuantityofH = aInitialSetupAcitivty.sanzQuant;
        }
        else if ("Sanitary Napkins".equals(string)){
            imageViewOfH.setImageResource(R.drawable.whisper);
            remainingQuantityofH = aInitialSetupAcitivty.whisperQuant;
        }
        else if("Wet Wipes".equals(string)){
            imageViewOfH.setImageResource(R.drawable.wetwipes);
            remainingQuantityofH = aInitialSetupAcitivty.wipesQuant;
        }
        else if ("Water Bottle".equals(string)){
            imageViewOfH.setImageResource(R.drawable.bottle);
            remainingQuantityofH = aInitialSetupAcitivty.bisleri;
        }
        else{
            switch (string){
                case "OKACET COLD":
                    imageViewOfH.setImageResource(R.drawable.okacetcold);
                    remainingQuantityofH = aInitialSetupAcitivty.okacetQuant;
                    break;
                case "METROGYL - 400":
                    imageViewOfH.setImageResource(R.drawable.metrogyl);
                    remainingQuantityofH = aInitialSetupAcitivty.metrogylQuant;
                    break;
                case "ELDOPER":
                    imageViewOfH.setImageResource(R.drawable.eldoper);
                    remainingQuantityofH = aInitialSetupAcitivty.eldoperQuant;
                    break;
                case "DOLO - 650":
                    imageViewOfH.setImageResource(R.drawable.dolo650);
                    remainingQuantityofH = aInitialSetupAcitivty.doloQuant;
                    break;
                case "GELUSIL":
                    imageViewOfH.setImageResource(R.drawable.gelusil);
                    remainingQuantityofH = aInitialSetupAcitivty.gelusil;
                    break;
                case "MEFTAL SPAS":
                    imageViewOfH.setImageResource(R.drawable.meftalspas);
                    remainingQuantityofH = aInitialSetupAcitivty.meftalQuant;
                    break;
                case "RiteBite\nNutri Bar\n(Merry Berry)":
                    imageViewOfH.setImageResource(R.drawable.nutria);
                    remainingQuantityofH = aInitialSetupAcitivty.nutriaQuant;
                    break;
                case "RiteBite\nNutri bar\n(Choco Delite)":
                    imageViewOfH.setImageResource(R.drawable.nutrib);
                    remainingQuantityofH = aInitialSetupAcitivty.nutribQuant;
                    break;
                case "Water Bottle":
                    imageViewOfH.setImageResource(R.drawable.bottle);
                    remainingQuantityofH = aInitialSetupAcitivty.bisleri;
                    break;

                case "Wild Vitamin Drink\n(Dragon Fruit)":
                    imageViewOfH.setImageResource(R.drawable.wild);
                    remainingQuantityofH= aInitialSetupAcitivty.wild;
                    break;

                case "Zago Protein Drink\n(Chocolate)":
                    imageViewOfH.setImageResource(R.drawable.zago);
                    remainingQuantityofH = aInitialSetupAcitivty.zago;
                    break;

                case "Aloevera Litchi Drink":
                    imageViewOfH.setImageResource(R.drawable.aloe);
                    remainingQuantityofH = aInitialSetupAcitivty.aloe;
                    break;

                case "Minute Maid Pulpy Orange":
                    imageViewOfH.setImageResource(R.drawable.pulpy);
                    remainingQuantityofH = aInitialSetupAcitivty.pulpy;
                    break;

                default:
                    imageViewOfH.setImageResource(R.drawable.commontablet1);
                    remainingQuantityofH = 0;
                    break;
            }
        }
    }

    public void confirmButtonClickH(View view){
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (remainingQuantityofH <1){
                    Toast toast = Toast.makeText(getApplicationContext(), "0 " + itemName + " Remaining", Toast.LENGTH_SHORT);
                    ViewGroup group = (ViewGroup) toast.getView();
                    TextView messageTextView = (TextView) group.getChildAt(0);
                    messageTextView.setTextSize(38);
                    toast.show();
                }
                else{
                    sender(itemName+"%"+itemPrice+"%"+ quantityH);
                    Intent intent= new Intent(hSelectedItemPopUpActivity.this,jFirstTimeMoneyEnterActivity.class);
                    intent.putExtra("Name",itemName);
                    intent.putExtra("Quantity", quantityH);
                    intent.putExtra("Price",itemPrice);
                    startActivity(intent);
                }
            }
        },1500);
    }

    public void sender(final String i){
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    btSocket.getOutputStream().write(i.getBytes());

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        },1);
    }

    public void exitActi(View view){
        finish();
    }



}
