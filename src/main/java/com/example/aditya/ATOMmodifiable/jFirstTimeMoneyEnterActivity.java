package com.example.aditya.ATOMmodifiable;

import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.AsyncTask;
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
import java.io.InputStream;

public class jFirstTimeMoneyEnterActivity extends AppCompatActivity {
    public static String namestr=null,pricestr=null;
    public static int quantityint,totalPrice,ten,twenty,fifty,hundred;
    int suggestedPriceToEnter;
    TextView tv1,tv2;
    ImageView iv1;
    //----------
    BluetoothSocket btSocket = null;
    int readBufferPosition;
    public InputStream mmInputStream;
    public inputReceiver receiver;
    boolean jOkButtonisNotClickedOnce;
    //------------------------------
    int itmPrice=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jactivity_first_time_money_enter);

        iv1=(ImageView)findViewById(R.id.iconView);
        tv1=(TextView)findViewById(R.id.productIDName);
        tv2=(TextView)findViewById(R.id.productPrice2);

        Log.v("ActivityLogger","We are in the jFirstTimeMoneyEnterActivity Activity");

        jOkButtonisNotClickedOnce =true;
        ten=0;
        twenty=0;
        fifty=0;
        hundred=0;
        //---------------
        btSocket= aInitialSetupAcitivty.btSocket;
        try {
            mmInputStream = btSocket.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //--------------------
        Bundle extra = getIntent().getExtras();
        namestr=extra.getString("Name");
        pricestr=extra.getString("Price");
        itmPrice=Integer.parseInt(pricestr);
        quantityint=extra.getInt("Quantity");

        totalPrice=itmPrice*quantityint;
        if (namestr.equals("Sanitary Napkins"))
            tv1.setText(" Whisper Ultra XXL 360mm\n");
        else
            tv1.setText(" "+namestr +"\n");

        if (totalPrice<=10)
            suggestedPriceToEnter =10;
        else if (totalPrice<=20)
            suggestedPriceToEnter =20;
        else if (totalPrice<=50)
            suggestedPriceToEnter =50;
        else if (totalPrice<=100)
            suggestedPriceToEnter =100;
        else
        suggestedPriceToEnter =100;

        if(suggestedPriceToEnter > 50)
        tv2.setText("Price : ₹"+totalPrice+".00"+"\n\nPlease Enter :  ₹ "+ suggestedPriceToEnter + ".00\nand Tap OK");
        //
        else if (namestr.equals("RiteBite\nNutri Bar\n(Merry Berry)")){
            tv2.setText("Price : ₹"+totalPrice+".00"+"\n\nAtom accepting only\n₹10, ₹20, ₹50 INR notes for\n"+"RiteBite Nutribar\n(Merry Berry)"+"\n\nPlease Enter :  ₹ "+ suggestedPriceToEnter + ".00\nand Tap OK");
            namestr="Merry Berry";
        }
        else if (namestr.equals("RiteBite\nNutri bar\n(Choco Delite)")){
            tv2.setText("Price : ₹"+totalPrice+".00"+"\n\nAtom accepting only\n₹10, ₹20, ₹50 INR notes for\n"+"RiteBite Nutribar\n(Choco Delite)"+"\n\nPlease Enter :  ₹ "+ suggestedPriceToEnter + ".00\nand Tap OK");
            namestr="Choco Delite";
        }
        else
        tv2.setText("Price : ₹"+totalPrice+".00"+"\n\nAtom accepting only\n₹10, ₹20, ₹50 INR notes for\n"+namestr+"\n\nPlease Enter :  ₹ "+ suggestedPriceToEnter + ".00\nand Tap OK");

        iconSet(namestr);
    }

    public void iconSet(String string){
        if ("Snickers".equals(string))
            iv1.setImageResource(R.drawable.snickers);
        else if ("Hand Sanitizer".equals(string))
            iv1.setImageResource(R.drawable.detsanz);
        else if ("Condoms Packets".equals(string))
            iv1.setImageResource(R.drawable.condimg);
        else if ("Sanitary Napkins".equals(string))
            iv1.setImageResource(R.drawable.whisper);
        else if ("Wet Wipes".equals(string))
            iv1.setImageResource(R.drawable.wetwipes);
        else {
            switch (string){
                case "OKACET COLD":
                    iv1.setImageResource(R.drawable.okacetcold);
                    break;
                case "METROGYL - 400":
                    iv1.setImageResource(R.drawable.metrogyl);
                    break;
                case "ELDOPER":
                    iv1.setImageResource(R.drawable.eldoper);
                    break;
                case "DOLO - 650":
                    iv1.setImageResource(R.drawable.dolo650);
                    break;
                case "GELUSIL":
                    iv1.setImageResource(R.drawable.gelusil);
                    break;
                case "PARACIP - 500":
                    iv1.setImageResource(R.drawable.paracip500);
                    break;
                case "MEFTAL SPAS":
                    iv1.setImageResource(R.drawable.meftalspas);
                    break;
                case "Merry Berry":
                    iv1.setImageResource(R.drawable.nutria);
                    break;
                case "Choco Delite":
                    iv1.setImageResource(R.drawable.nutrib);
                    break;
                case "Water Bottle":
                    iv1.setImageResource(R.drawable.bottle);
                    break;
                case "Wild Vitamin Drink\n(Dragon Fruit)":
                    iv1.setImageResource(R.drawable.wild);
                    break;
                case "Zago Protein Drink\n(Chocolate)":
                    iv1.setImageResource(R.drawable.zago);
                    break;
                case "Aloevera Litchi Drink":
                    iv1.setImageResource(R.drawable.aloe);
                    break;
                case "Minute Maid Pulpy Orange":
                    iv1.setImageResource(R.drawable.pulpy);
                    break;
                default:
                    iv1.setImageResource(R.drawable.commontablet1);
                    break;
            }
        }
    }

    public void okButtonIsClicked(View view){
        Handler handlerDelay = new Handler();
        handlerDelay.postDelayed(new Runnable() {
            @Override
            public void run() {

                //receive the amount entered into the note validator and toast it!
                if (jOkButtonisNotClickedOnce){
                    jOkButtonisNotClickedOnce =false;
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            sender("Money Entered");
                            receiverInput();//What does it do? It Does 3 steps: 1) Executes Async inputReceiver task 2)Which executes inputReception in Background 3)The input reception rreturns the string that the arduino sends us!
                        }
                    },1);
                }
                else{
                    Toast toast = Toast.makeText(getApplicationContext(), "Please Wait, Processing Cash", Toast.LENGTH_SHORT);
                    ViewGroup group = (ViewGroup) toast.getView();
                    TextView messageTextView = (TextView) group.getChildAt(0);
                    messageTextView.setTextSize(32);
                    toast.show();
                }
            }
        },1500);
    }

    public void receiverInput(){
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                receiver=new inputReceiver();
                try {
                    mmInputStream=btSocket.getInputStream();
                    receiver.execute();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }, 2000);
    }

    public class inputReceiver extends AsyncTask<Void,Void,String> {

        @Override
        protected String doInBackground(Void... voids) {
            String str="";
            while(str.equals(""))
                str = inputReception();
            return str;
        }
        @Override
        protected void onPostExecute(String str1) {
            super.onPostExecute(str1);
                Log.v("onpostMD", "The output is:" + str1);
                if (!"".equals(str1)){
                    int outputPrice = Integer.parseInt(str1);
                    Log.v("Note Entered", "The entered note is: " + outputPrice);
                    if (outputPrice >= 10 && outputPrice <= 100) {
                        if (outputPrice==10){
                            ten++;
                            aInitialSetupAcitivty.totalnotes++;
                        }
                        if (outputPrice==20) {
                            twenty++;
                            aInitialSetupAcitivty.totalnotes++;
                        }
                        if (outputPrice==50){
                            fifty++;
                            aInitialSetupAcitivty.totalnotes++;
                        }
                        if (outputPrice==100){
                            hundred++;
                            aInitialSetupAcitivty.totalnotes++;
                        }
                        Intent lastIntent = new Intent(getApplicationContext(), kRemainingTimesMoneyEnterActivity.class);
                        lastIntent.putExtra("Balance", outputPrice - totalPrice);
                        startActivity(lastIntent);
                    }
                    else if (outputPrice > 100||outputPrice<10) {
                        Toast toast = Toast.makeText(getApplicationContext(), "Cannot Accept Notes Less that ₹ 10/- or greater than ₹ 100/-", Toast.LENGTH_SHORT);
                        ViewGroup group = (ViewGroup) toast.getView();
                        TextView messageTextView = (TextView) group.getChildAt(0);
                        messageTextView.setTextSize(32);
                        toast.show();
                        jOkButtonisNotClickedOnce =true;
                    }
                }
                else
                {
                    Toast toast = Toast.makeText(getApplicationContext(), "You haven't entered any money!", Toast.LENGTH_SHORT);
                    ViewGroup group = (ViewGroup) toast.getView();
                    TextView messageTextView = (TextView) group.getChildAt(0);
                    messageTextView.setTextSize(32);
                    toast.show();
                    jOkButtonisNotClickedOnce =true;
                }

        }
    }

    public String inputReception(){
        readBufferPosition = 0;
        byte[] readBuffer = new byte[2048];
        String inputData;
        try {
            int bytesAvailable = mmInputStream.available();
            if (bytesAvailable>0){
                int mBytes;
                byte[] packetBytes;
                packetBytes=new byte[bytesAvailable];
                mBytes=mmInputStream.read(packetBytes,0,bytesAvailable);
                for (int pstn = 0;pstn<mBytes;pstn++){
                    readBuffer[readBufferPosition]=packetBytes[pstn];
                    readBufferPosition++;
                }
            }
            inputData=new String(readBuffer,0,bytesAvailable);
            Log.v("Reception","The string is:"+inputData);
            readBufferPosition=0;
            return inputData;
        }
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void sender(final String i){

        final Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            public void run() {
                try {
                    btSocket.getOutputStream().write(i.getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }, 1);
    }

    public  void backMoneyClick(View view){
        Intent intent= new Intent(this,bUserIntroActivity.class);
        startActivity(intent);
    }

    public static void maxQuantity(){
        if ("Condoms Packets".equals(namestr))
            aInitialSetupAcitivty.condomQuant= aInitialSetupAcitivty.condomQuant-quantityint;
        else if ("Hand Sanitizer".equals(namestr))
            aInitialSetupAcitivty.sanzQuant= aInitialSetupAcitivty.sanzQuant-quantityint;
        else if ("Sanitary Napkins".equals(namestr))
            aInitialSetupAcitivty.whisperQuant= aInitialSetupAcitivty.whisperQuant-quantityint;
        else if ("Wet Wipes".equals(namestr))
            aInitialSetupAcitivty.wipesQuant= aInitialSetupAcitivty.wipesQuant-quantityint;
        else {
            switch (namestr){
                case "OKACET COLD":
                    aInitialSetupAcitivty.okacetQuant= aInitialSetupAcitivty.okacetQuant-quantityint;
                    break;
                case "METROGYL - 400":
                    aInitialSetupAcitivty.metrogylQuant= aInitialSetupAcitivty.metrogylQuant-quantityint;
                    break;
                case "ELDOPER":
                    aInitialSetupAcitivty.eldoperQuant= aInitialSetupAcitivty.eldoperQuant-quantityint;
                    break;
                case "DOLO - 650":
                    aInitialSetupAcitivty.doloQuant= aInitialSetupAcitivty.doloQuant-quantityint;
                    break;
                case "GELUSIL":
                    aInitialSetupAcitivty.gelusil= aInitialSetupAcitivty.gelusil-quantityint;
                    break;
                case "MEFTAL SPAS":
                    aInitialSetupAcitivty.meftalQuant= aInitialSetupAcitivty.meftalQuant-quantityint;
                    break;
                case "Merry Berry":
                    aInitialSetupAcitivty.nutriaQuant= aInitialSetupAcitivty.nutriaQuant-quantityint;
                    break;
                case "Choco Delite":
                    aInitialSetupAcitivty.nutribQuant= aInitialSetupAcitivty.nutribQuant-quantityint;
                    break;
                case "Water Bottle":
                    aInitialSetupAcitivty.bisleri= aInitialSetupAcitivty.bisleri-quantityint;
                    break;
                case "Wild Vitamin Drink\n(Dragon Fruit)":
                    aInitialSetupAcitivty.wild= aInitialSetupAcitivty.wild-quantityint;
                    break;
                case "Zago Protein Drink\n(Chocolate)":
                    aInitialSetupAcitivty.zago= aInitialSetupAcitivty.zago-quantityint;
                    break;
                case "Aloevera Litchi Drink":
                    aInitialSetupAcitivty.aloe= aInitialSetupAcitivty.aloe-quantityint;
                    break;
                case "Minute Maid Pulpy Orange":
                    aInitialSetupAcitivty.pulpy= aInitialSetupAcitivty.pulpy-quantityint;
                    break;
                default:
                    break;
            }
        }
    }

//Steps on inserting money are:
    //1)flg=0;
    //2)flag++;
    //3)sender("Text") to be sent to arduino
    //4)Call the receiveInput() method;
    //5)if(Flag==1):
                //5a)flag++
                //5b)sender("Text"); to be sent to arduino



}
