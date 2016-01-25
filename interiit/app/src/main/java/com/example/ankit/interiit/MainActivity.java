package com.example.ankit.interiit;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.telephony.SmsManager;
import android.widget.TextView;
import android.widget.Toast;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    //    String phoneNumber;
//    ListView lv;
//    ArrayList<String> aa= new ArrayList<String>();
    Button help;
    Button contacts;
    String url;
    String lattitude;
    String longitude;
    TextView text;
//    private LocationControl locationControlTask;
//    private boolean hasLocation = false;
//    LocationHelper locHelper;
    Double currentLocation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyLocation.LocationResult locationResult = new MyLocation.LocationResult(){
            @Override
            public void gotLocation(Location location){
                lattitude=Double.toString(location.getLatitude());
                longitude=Double.toString(location.getLongitude());
                //Got the location!
            }
        };
        MyLocation myLocation = new MyLocation();
        myLocation.getLocation(this, locationResult);
//        myLocation.
        System.out.println("yeah________________________________________________");
//        System.out.println();
//        new LocationControl().execute(this);
//        GPSTracker gps = new GPSTracker(this);
//        double latitude = gps.getLatitude();
//        double longitude = gps.getLongitude();
//        Location currentLocation;
//        System.out.println(currentLocation.getLatitude());
//        LocationListener locListener = new MyLocationListener();
//        LocationManager locManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
//        locManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locListener);
////        final ProgressDialog mDialog = new ProgressDialog(MainActivity.this);
////        final ProgressDialog dialog = new ProgressDialog(MainActivity.this);
////        dialog.setTitle("Loading...");
////        dialog.setMessage("Please wait.");
////        dialog.setIndeterminate(true);
////        dialog.setCancelable(false);
////        dialog.show();
////
////        long delayInMillis = 60000;
////        Timer timer = new Timer();
////        timer.schedule(new TimerTask() {
////            @Override
////            public void run() {
////                dialog.dismiss();
////            }
////        }, delayInMillis);
////        sleep(2000)
//        text=(TextView)findViewById(R.id.texttest);
//        text.setText(Double.toString(latitude));
//        Double ye=location.getLatitude();
        System.out.println("yesh");
//        System.out.println(latitude);
    }




//    public class MyLocationListener implements LocationListener {
//        @Override
//        public void onLocationChanged(Location location) {
//// Retrieving Latitude
//            location.getLatitude();
//// Retrieving getLongitude
//            location.getLongitude();
////            EditText textInfo;
////            textInfo.setText("");
//            String text = "My Current Location is:\nLatitude = "
//                    + location.getLatitude() + "\nLongitude = "
//                    + location.getLongitude();
////            textInfo.setText(text);
////            Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
//// set Google Map on webview
//            url = "http://maps.google.com?q="
//                    + location.getLatitude() + "," + location.getLongitude();
////            position.loadUrl(url);
//            System.out.println(url);
//        }
//
//        @Override
//        public void onProviderDisabled(String provider) {
//            Toast.makeText(getApplicationContext(), "GPS Disabled",
//                    Toast.LENGTH_SHORT).show();
//        }
//
//        @Override
//        public void onProviderEnabled(String provider) {
//            Toast.makeText(getApplicationContext(), "GPS Enabled",
//                    Toast.LENGTH_SHORT).show();
//        }
//
//        @Override
//        public void onStatusChanged(String provider, int status, Bundle extras) {
//        }
//    }
//
//



    public void buttonOnClick(View v) {
        contacts = (Button) findViewById(R.id.button_contacts);
        startActivity(new Intent(getApplicationContext(), Activity2.class));
    }



    public void buttonOnClickhelp(View v) {
        contacts = (Button) findViewById(R.id.button_help);
//        startActivity(new Intent(getApplicationContext(), Activity2.class));
        sendSMSMessage();
//        sendBtn.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view) {
//
//            }
//        });

    }




    protected void sendSMSMessage() {
//        Log.i("Send SMS", "");
        String file = "mydata";
        String temp = "";
        try {
            FileInputStream fin = openFileInput(file);
            int c;


            while ((c = fin.read()) != -1) {

                temp = temp + Character.toString((char) c);
            }
            System.out.println(temp);
//            Toast.makeText(getBaseContext(),"file read", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
        }
        String[] con_num = temp.split("#");
//        temp;
        ArrayList<String> finalcontact = new ArrayList<String>();
        ArrayList<String> finalnumber = new ArrayList<String>();
        for (int i = 0; i < con_num.length; i++) {
            String[] temp1 = con_num[i].split("_");
            finalcontact.add(temp1[0].toString());
            finalnumber.add(temp1[1].toString());
            String phoneNo = temp1[1].toString();

            String message = "Yo Bitchesss!!    http://maps.google.com/?q="
                    + lattitude + "," + longitude;
            System.out.println(message);
            try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo, null, message, null, null);
            Toast.makeText(getApplicationContext(), "SMS sent.", Toast.LENGTH_LONG).show();
        }

        catch (Exception e) {
            Toast.makeText(getApplicationContext(), "SMS faild, please try again.", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }

        }
        System.out.println(finalcontact);
//        String phoneNo = "+918601461142";
//        String message = "Yo Bitchesss!!";
//
//        try {
//            SmsManager smsManager = SmsManager.getDefault();
//            smsManager.sendTextMessage(phoneNo, null, message, null, null);
//            Toast.makeText(getApplicationContext(), "SMS sent.", Toast.LENGTH_LONG).show();
//        }
//
//        catch (Exception e) {
//            Toast.makeText(getApplicationContext(), "SMS faild, please try again.", Toast.LENGTH_LONG).show();
//            e.printStackTrace();
//        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
