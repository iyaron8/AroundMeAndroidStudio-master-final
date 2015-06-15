package com.aroundme;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.appspot.enhanced_cable_88320.aroundmeapi.Aroundmeapi;
import com.appspot.enhanced_cable_88320.aroundmeapi.model.Message;
import com.appspot.enhanced_cable_88320.aroundmeapi.model.User;
import com.appspot.enhanced_cable_88320.aroundmeapi.model.UserAroundMe;
import com.appspot.enhanced_cable_88320.aroundmeapi.model.UserAroundMeCollection;
import com.aroundme.messageEndpoint.Chat;
import com.google.api.client.util.DateTime;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


public class Login extends Activity {


    private ListView lv;

    ArrayAdapter<String>arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button logOutBtn = (Button) findViewById(R.id.logOutBtn);
        Button mapBtn = (Button) findViewById(R.id.mapButton);

        lv = (ListView) findViewById(R.id.usersLv);

        List<String> arrList = new ArrayList<String>();



        arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
               arrList);

        lv.setAdapter(arrayAdapter);


     //   SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
       // SharedPreferences.Editor editor = sharedPref.edit();

      //  Toast.makeText(this, editor.)


        Intent intent = getIntent();
        String value = intent.getStringExtra("key");


        logOutBtn.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {

                        SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPref.edit();

                        editor.putString("email", "");
                        editor.putString("pw", "");
                        editor.apply();


                        Intent curr_intent = new Intent(Login.this, MainActivity.class);
                        Login.this.startActivity(curr_intent);
                        Login.this.finish();


                    }
                }
        );



        mapBtn.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){



                      Intent curr_intent = new Intent(Login.this, MapsActivity.class);
                        Login.this.startActivity(curr_intent);


                    }
                }
        );




        SharedPreferences sharedPref = getSharedPreferences("userInfo",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        final String user_email = sharedPref.getString("email","");





        new AsyncTask<Void,Void,Void>()
        {

            @Override
            protected Void doInBackground(Void... params) {
                showUsers(user_email);
                return null;
            }
        }.execute();







       lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position,
                                   long id) {

               String item = ((TextView) view).getText().toString();



               // Toast.makeText(getBaseContext(), item, Toast.LENGTH_SHORT).show();



               //save the name we pressed on , and send it to chat intent.


               Intent myIntent = new Intent(Login.this, Chat.class);

               myIntent.putExtra("item",item);



               Login.this.startActivity(myIntent);


           }
       });


    }




    private void showUsers(String user_email){
        try {


            Aroundmeapi api = EndpointApiCreator.getApi(Aroundmeapi.class);

            UserAroundMeCollection a;
            a = api.getAllUsers(user_email).execute();
            List<UserAroundMe> usersList = a.getItems();


           int size = usersList.size();
            UserAroundMe[] arr = new UserAroundMe[size+1];
            usersList.toArray(arr);

            for (int i=0 ; i<25 ; i++) {

               //final String u = arr[i].getDisplayName();
               final String k = arr[i].getMail();




                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        arrayAdapter.add(k);

                    }
                });



            }


        }catch(Exception e){

            e.printStackTrace();
        }

    }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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
