package com.example.ankit.interiit;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Signup extends AppCompatActivity {

    EditText number;
    EditText password;
    String num;
    String pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

    }
    public void onClickSign(View v)
    {
        number=(EditText) findViewById(R.id.text_number);
        password= (EditText) findViewById(R.id.text_pass);
        num=number.getText().toString();
        pass=password.getText().toString();
        startActivity(new Intent(getApplicationContext(), MainActivity.class));

    }
    private class LongOperation extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            try{
                System.out.println(params[0]);
//
                String name    = URLEncoder.encode(params[0], "UTF-8");

                HttpClient Client = new DefaultHttpClient();

                String URL = "http://192.168.0.111/signup.php?auth="+name;
                System.out.println(URL);
                HttpGet httpget = new HttpGet(URL);

                String SetServerString = "";
                try
                {

                    ResponseHandler<String> responseHandler = new BasicResponseHandler();
                    SetServerString = Client.execute(httpget, responseHandler);
                    return  SetServerString;

                }
                catch(Exception ex)
                {
                    System.out.println(ex.toString());
                    return "Fail!";
                }

            }
            catch(UnsupportedEncodingException ex)
            {
                return "Fail2";
            }
        }

        @Override
        protected void onPostExecute(String result) {
            if(result=="Yes") {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Login Failed", Toast.LENGTH_LONG).show();

            }
            System.out.println(result);
        }
//            textView1.setText(result);


    }
}
