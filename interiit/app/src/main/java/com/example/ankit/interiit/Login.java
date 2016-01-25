package com.example.ankit.interiit;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.test.SingleLaunchActivityTestCase;
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

public class Login extends AppCompatActivity {
    String number1;
    String password1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }
    public void buttonOnClicklogin(View v) {
       EditText number=(EditText) findViewById(R.id.textlogin);
        EditText password= (EditText) findViewById(R.id.textlogpass);
        number1=number.getText().toString();
        password1=password.getText().toString();
//        contacts = (Button) findViewById(R.id.button_contacts);
        new LongOperation().execute(number1 + "_" + password1);


    }
    public void buttonOnClicksignup(View v) {
//        contacts = (Button) findViewById(R.id.button_contacts);
        EditText number=(EditText) findViewById(R.id.textlogin);
        EditText password= (EditText) findViewById(R.id.textlogpass);
        number1=number.getText().toString();
        password1=password.getText().toString();
//        contacts = (Button) findViewById(R.id.button_contacts);
        new LongOperation1().execute(number1 + "_" + password1);
//        startActivity(new Intent(getApplicationContext(), Signup.class));
    }
    private class LongOperation extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            try{
                System.out.println(params[0]);
//
                String name    = URLEncoder.encode(params[0], "UTF-8");

                HttpClient Client = new DefaultHttpClient();

                String URL = "http://192.168.0.111/login.php?auth="+name;
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
            if(result.equals("Yes"))
            {
                Toast.makeText(getApplicationContext(), "Logged In", Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Login Failed", Toast.LENGTH_LONG).show();

            }
            System.out.println(result.getClass().getName());
        }
//            textView1.setText(result);


        }
    private class LongOperation1 extends AsyncTask<String, Void, String> {
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
            if(result.equals("Yes"))
            {
                Toast.makeText(getApplicationContext(), "Signed Up", Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Account Exist", Toast.LENGTH_LONG).show();

            }
            System.out.println(result.getClass().getName());
        }
//            textView1.setText(result);


    }
}
