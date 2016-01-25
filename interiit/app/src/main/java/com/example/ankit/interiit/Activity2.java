package com.example.ankit.interiit;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {
    Button addcontacts;
    ListView lv;
    ArrayList<String> finalcontact = new ArrayList<String>();
    ArrayList<String> finalnumber = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String file = "mydata";
        String temp="";
        try{
            FileInputStream fin = openFileInput(file);
            int c;


            while( (c = fin.read()) != -1){

                temp = temp + Character.toString((char)c);
            }
            System.out.println(temp);
//            Toast.makeText(getBaseContext(),"file read", Toast.LENGTH_SHORT).show();
        }
        catch(Exception e){
        }
        String [] con_num=temp.split("#");
//        temp;
//        if (con_num.length>1)
//        {
            for(int i=0;i<con_num.length;i++)
            {
                String[] temp1=con_num[i].split("_");
                finalcontact.add(temp1[0].toString());
                finalnumber.add(temp1[1].toString());

            }

//        }

        System.out.println(con_num[0]);
        System.out.println(finalcontact);
        String[] stockArr = new String[finalcontact.size()];
        stockArr = finalcontact.toArray(stockArr);
        ArrayAdapter<String> myAdapter=new
                ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                stockArr);
        ListView myList=
                (ListView) findViewById(R.id.list_added);
        myList.setAdapter(myAdapter);

//        new LongOperation().execute("yeah");
//        String[] array=finalcontacts.split("_");
//        System.out.println(array[0]);
//        finalcontacts=loadArray("contact_name",this);
//        System.out.println(finalcontacts.length);

    }
    public String[] loadArray(String arrayName, Context mContext) {
        SharedPreferences prefs = mContext.getSharedPreferences("preferencename", 0);
        int size = prefs.getInt(arrayName + "_size", 0);
        String array[] = new String[size];
        for(int i=0;i<size;i++)
            array[i] = prefs.getString(arrayName + "_" + i, null);
        return array;
    }
    public void buttonOnClickadd(View v)
    {
        addcontacts=(Button)findViewById(R.id.button_add);
        startActivity(new Intent(getApplicationContext(), Activity3.class));
    }





}
