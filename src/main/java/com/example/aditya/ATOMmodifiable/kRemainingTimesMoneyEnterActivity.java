package com.example.aditya.ATOMmodifiable;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import static com.example.aditya.ATOMmodifiable.aInitialSetupAcitivty.btSocket;

public class kRemainingTimesMoneyEnterActivity extends AppCompatActivity {

    Button btlostbtn,kOkButton;
    int Balance;//The balance to be entered into the machine by consumer: Balance = moneyEntered - totalMoneyPurchase (Yea -ve value...check out the rest of the code for a better understanding!)
    TextView lastMsg;
    public static String data="";
    int noteReceivedInt=0;
    Session session = null;
    ProgressDialog pdialog = null;
    Context context = null;
    public int changeRs;
    ImageView icon;
    Boolean shouldIAutoClick;
    //------------------------
    int readBufferPosition;
    public InputStream mmInputStream;
    public inputReceiver receiver;
    boolean flag2 = false;
    boolean needToInstertMoney = false;
    boolean kOkButtonIsNotClicked;


    //----------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //You will need to work those Grey cells out to figure out this part of the app...
        shouldIAutoClick =true;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kactivity_remaining_times_money_enter);

        Log.v("ActivityLogger","We are in the kRemainingTimesMoneyEnterActivity");

        lastMsg = (TextView) findViewById(R.id.lasMessage);
        kOkButton=(Button)findViewById(R.id.kOkButton);
        TextView tnks = (TextView)findViewById(R.id.thanyou);
        icon = (ImageView)findViewById(R.id.lastImgIcon);
        btlostbtn=(Button)findViewById(R.id.btLost);

        kOkButtonIsNotClicked =true;

        kOkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kOkButtonClick();
            }
        });
        btlostbtn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent=new Intent(getApplicationContext(),aInitialSetupAcitivty.class);
                startActivity(intent);
                return false;
            }
        });

        changeRs=0;
        context = this;


        Bundle extras = getIntent().getExtras();
        Balance = extras.getInt("Balance");

        if (Balance == 0) {
            icon.setImageResource(R.drawable.atom);
            Log.v("Balance","the Balance is 0");
            needToInstertMoney =false;//Thank You!
            tnks.setTextSize(86);
            tnks.setText("ThankYou!");
            sender("Activate");//Activate motor AND Email
            Handler handler2 = new Handler();
            handler2.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (!shouldIAutoClick)
                        kOkButtonClick();
                }
            },10000);
        }

        else if (Balance < 0) {            //means the user should insert more money
            Log.v("Balance","the User must Enter Money,Balance is: "+Balance);
            needToInstertMoney = true;
            Balance = -Balance;
            Log.v("NewBalance",""+Balance);
            if (Balance <= 10) {
                lastMsg.setText("Balance Amount to be Entered: ₹ "+Balance+"\n"+"Please enter  ₹ 10 more\nAnd click OK");
            }
            else if (Balance > 10 && Balance <= 20) {
                lastMsg.setText("Balance Amount to be Entered: ₹ "+Balance+"\n"+"Please enter  ₹ 20 more\nAnd click OK");
            }
            else if (Balance > 20 && Balance <= 50) {
                lastMsg.setText("Balance Amount to be Entered: ₹  "+Balance+"\n"+"Please enter  ₹ 50 more\nAnd click OK");
            }
            else if (Balance > 50 && Balance <= 100) {
                lastMsg.setText("Balance Amount to be Entered: ₹ "+Balance+"\n"+"Please enter  ₹ 100 more\nAnd click OK");
            }
            else if (Balance>100){
                lastMsg.setText("Balance Amount to be Entered: ₹ "+Balance+"\n"+"Please enter ₹ 100 more\nAnd click OK");
            }
        }

        else if (Balance > 0) {
            icon.setImageResource(R.drawable.atom);
            aInitialSetupAcitivty.coins= aInitialSetupAcitivty.coins-(Balance/10);
            Log.v("Balance","the User must get Change,Balance is: "+Balance);
            Log.v("CoinsLA","The number of coins remaining are: "+ aInitialSetupAcitivty.coins);
            needToInstertMoney =false;
            sender("CoinDispenser "+Balance);
            changeRs=Balance;
            tnks.setTextSize(86);
            tnks.setText("ThankYou!");
            lastMsg.setText("Please Collect your product and "+ "₹ "+Balance+".00 Rupees\n And Click OK to End Transaction\n"+
                    "Stay Healthy!" );

            Handler handler3 = new Handler();
            handler3.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (!shouldIAutoClick)
                        kOkButtonClick();
                }
            },10000);
        }
    }
    public void kOkButtonClick(){
        shouldIAutoClick =false;//Because I have Already Clicked
        if (kOkButtonIsNotClicked){
            kOkButtonIsNotClicked =false;
            if (needToInstertMoney)
            {
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        sender("Money Entered");
                        receiverInput();
                    }
                },1);
            }
            else if (!needToInstertMoney){
                jFirstTimeMoneyEnterActivity.maxQuantity();
                aInitialSetupAcitivty.transNumb++;
                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat simpleDateFormat= new SimpleDateFormat("dd-MM-yyyy HH:mm:ss ");
                String date = simpleDateFormat.format(calendar.getTime());
                data=data+"<br />"+"|"+date+"|"+"|"+ jFirstTimeMoneyEnterActivity.namestr +"|"+"|"+ jFirstTimeMoneyEnterActivity.quantityint+"|"+"|"+ jFirstTimeMoneyEnterActivity.pricestr+"|"+"|"+ jFirstTimeMoneyEnterActivity.ten+"|"+"|"+ jFirstTimeMoneyEnterActivity.twenty+"|"+"|"+ jFirstTimeMoneyEnterActivity.fifty+"|"+"|"+ jFirstTimeMoneyEnterActivity.hundred+"|"+"|"+changeRs+"|"+"|"+ aInitialSetupAcitivty.coins+"|"+"|"+ aInitialSetupAcitivty.okacetQuant+"|"+"|"+ aInitialSetupAcitivty.metrogylQuant+"|"+"|"+ aInitialSetupAcitivty.eldoperQuant+"|"+"|"+ aInitialSetupAcitivty.doloQuant+"|"+"|"+ aInitialSetupAcitivty.gelusil+"|"+"|"+ aInitialSetupAcitivty.meftalQuant+"|"+ aInitialSetupAcitivty.nutriaQuant+"|"+"|"+ aInitialSetupAcitivty.nutribQuant+"|"+"|"+ aInitialSetupAcitivty.sanzQuant+"|"+"|"+ aInitialSetupAcitivty.condomQuant+"|"+"|"+ aInitialSetupAcitivty.whisperQuant+"|"+"|"+ aInitialSetupAcitivty.wipesQuant+"|"+"|"+ aInitialSetupAcitivty.bisleri+"|"+"|"+ aInitialSetupAcitivty.wild+"|"+"|"+ aInitialSetupAcitivty.zago+"|"+"|"+ aInitialSetupAcitivty.aloe+"|"+"|"+ aInitialSetupAcitivty.pulpy+"|";//1) Name: Dolo-650 Quantity: 100 Price: 1000 TotalPrice: 100000
                Log.v("Transaction",data);
                //-----------
                Properties props = new Properties();
                props.put("mail.smtp.host", "smtp.gmail.com");
                props.put("mail.smtp.socketFactory.port", "465");
                props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.port", "465");
                session = Session.getDefaultInstance(props, new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("grietmsme@gmail.com", "grietmsm");
                    }
                });

                pdialog = ProgressDialog.show(context, "", "Completing Transaction...", true);

                RetreiveFeedTask task = new RetreiveFeedTask();
                task.execute();
                //-----------
            }
        }

        else{
            Toast toast = Toast.makeText(this, "Please Wait, Processing Cash", Toast.LENGTH_SHORT);
            ViewGroup group = (ViewGroup) toast.getView();
            TextView messageTextView = (TextView) group.getChildAt(0);
            messageTextView.setTextSize(32);
            toast.show();
        }
    }//The Actual action of clicking OK Button
    public void receiverInput(){
        //Receive Data from Bluetooth(I Hate this cause it is a workaround, If you can please find a batter way)
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

    public class inputReceiver extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... voids) {
            String str = "";
            while (str.equals("")) {
                str = inputReception();
            }
            return str;
        }

        @Override
        protected void onPostExecute(String str1) {
            //The logic is strong with this one! Take a paper, and do all the possible combinations of inputs to understand thoroughly
            super.onPostExecute(str1);
                Log.v("onpostLA", "The output is:" + str1);
                if (!"".equals(str1)){
                    flag2=true;
                    noteReceivedInt=Integer.parseInt(str1);
                    Log.v("onpostLA", "4) The output Integer is:" + noteReceivedInt);
                    Log.v("Note Entered","The entered note is: "+ noteReceivedInt);
                    if (noteReceivedInt>=10 && noteReceivedInt<=100){
                        if (noteReceivedInt==10)
                            jFirstTimeMoneyEnterActivity.ten++;
                        if (noteReceivedInt==20)
                            jFirstTimeMoneyEnterActivity.twenty++;
                        if (noteReceivedInt==50)
                            jFirstTimeMoneyEnterActivity.fifty++;
                        if (noteReceivedInt==100)
                            jFirstTimeMoneyEnterActivity.hundred++;
                        Intent lastIntent = new Intent(getApplicationContext(),kRemainingTimesMoneyEnterActivity.class);
                        lastIntent.putExtra("Balance", noteReceivedInt-Balance);
                        startActivity(lastIntent);
                    }
                    else if (noteReceivedInt>100||noteReceivedInt<10){
                        Toast toast = Toast.makeText(getApplicationContext(), "Cannot Accept Notes Less that ₹ 10/- or greater than ₹ 100/-", Toast.LENGTH_SHORT);
                        ViewGroup group = (ViewGroup) toast.getView();
                        TextView messageTextView = (TextView) group.getChildAt(0);
                        messageTextView.setTextSize(32);
                        toast.show();
                        kOkButtonIsNotClicked =true;
                    }
                }

                else
                {
                    Toast toast = Toast.makeText(getApplicationContext(), "You haven't entered any money!", Toast.LENGTH_SHORT);
                    ViewGroup group = (ViewGroup) toast.getView();
                    TextView messageTextView = (TextView) group.getChildAt(0);
                    messageTextView.setTextSize(32);
                    toast.show();
                    kOkButtonIsNotClicked =true;
                }
        }
    }

    public String inputReception() {
        //For receiving input data
        readBufferPosition = 0;
        byte[] readBuffer = new byte[2048];
        String inputData = null;
        try {
            int bytesAvailable = mmInputStream.available();
            if (bytesAvailable > 0) {
                int mBytes;
                byte[] packetBytes = null;
                packetBytes = new byte[bytesAvailable];
                mBytes = mmInputStream.read(packetBytes, 0, bytesAvailable);
                Log.v("inputReception", "mBytes Value: " + mBytes);
                for (int pstn = 0; pstn < mBytes; pstn++) {
                    readBuffer[readBufferPosition] = packetBytes[pstn];
                    readBufferPosition++;
                }
            }
            inputData = new String(readBuffer, 0, bytesAvailable);
            Log.v("ReceptionLA", "The string is:" + inputData);
            readBufferPosition = 0;
            return inputData;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void sender(final String i) {
        //To Write data to the bluetooth(I Love this, cause its not a workaround!)
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

    class RetreiveFeedTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {

            try{
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("testfrom354@gmail.com"));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("indooriaditya@gmail.com"));
                message.setSubject("Testing");
                message.setContent(data, "text/html; charset=utf-8");
                Transport.send(message);
            } catch(MessagingException e) {
                e.printStackTrace();
            } catch(Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            pdialog.dismiss();

            Toast toast = Toast.makeText(getApplicationContext(), "Transaction Complete", Toast.LENGTH_SHORT);
            ViewGroup group = (ViewGroup) toast.getView();
            TextView messageTextView = (TextView) group.getChildAt(0);
            messageTextView.setTextSize(32);
            toast.show();
            Intent intent=new Intent(kRemainingTimesMoneyEnterActivity.this,bUserIntroActivity.class);
            startActivity(intent);
        }
    }
}

