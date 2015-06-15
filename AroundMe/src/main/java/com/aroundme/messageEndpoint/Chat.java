package com.aroundme.messageEndpoint;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.appspot.enhanced_cable_88320.aroundmeapi.Aroundmeapi;
import com.appspot.enhanced_cable_88320.aroundmeapi.model.Message;

import com.aroundme.EndpointApiCreator;
import com.aroundme.MessagesListAdapter;
import com.aroundme.Msg;
import com.aroundme.R;

import com.aroundme.SignUp;
import com.google.api.client.util.DateTime;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Chat extends Activity {

    private ArrayList<String> arrayListToDo;
    private ArrayAdapter<String> arrayAdapterToDo;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_chat);
       // Intent intent = getIntent();

        arrayListToDo = new ArrayList<String>();
        arrayAdapterToDo = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayListToDo);
        final ListView listViewToDo = (ListView) findViewById(R.id.listViewToDo);
        listViewToDo.setAdapter(arrayAdapterToDo);
        TextView name = (TextView) findViewById(R.id.textView);



        final EditText sendEt = (EditText)findViewById(R.id.sendEt);
        Button sendBtn = (Button)findViewById(R.id.sendBtn);
        registerForContextMenu(listViewToDo);



        SharedPreferences sharedPref = getSharedPreferences("userInfo",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        final String user_email = sharedPref.getString("email","");




       final ArrayList<Msg> listMessage = new ArrayList<Msg>();







        //create a list view adapter and throw inside all the messages with the sender as prefix
        Intent chatIntent = getIntent();

       final String item = chatIntent.getStringExtra("item");




         //String from = chatIntent.getStringExtra("from");
     //   final String message = chatIntent.getStringExtra("message");


        //if (from==null){
          //  from = "yaron@gmail.com";
       // }



        /*
        cdb.open(ChatDBHandler.OPEN_DB_FOR.WRITE);


       // cdb.saveUser(from,"unknown"); //
        cdb.saveMessage(from,message, ChatDBHandler.WHO_SEND.OTHER); // from == sender's email
        cdb.close();


*/

        name.setText(item);


        Thread t = new Thread() {

            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(100);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {


                                ChatDBHandler cdb = new ChatDBHandler(getApplicationContext());
                                cdb = new ChatDBHandler(getApplicationContext());
                                cdb.open(ChatDBHandler.OPEN_DB_FOR.READ);

                                arrayAdapterToDo.clear();


                                ArrayList<Message> msgs_from_db = cdb.getMessages(item);
                                Message msg;

                                if ( (msgs_from_db.size()) > (listMessage.size())){

                                    listMessage.clear();

                                if (msgs_from_db == null)
                                    Toast.makeText(getApplicationContext(), "No msg got from db..", Toast.LENGTH_LONG).show();
                                else {
                                    for (int i = 0; i < msgs_from_db.size(); i++) {
                                        msg = msgs_from_db.get(i);

                                        //1 shared prefences
                                        //0 from


                                        if (msg.getTo().equals("1")) {            // message is sent from my user

                                            listMessage.add(new Msg(user_email, "unkown", msg.getContnet(), "18:00", "15/6/15", "1"));

                                        } else {
                                            listMessage.add(new Msg(item, "unkown", msg.getContnet(), "18:00", "15/6/15", "0"));
                                        }

                                    }
                                }
                                MessagesListAdapter adapter = new MessagesListAdapter(getApplicationContext(), listMessage);


                                listViewToDo.setAdapter(adapter);
                                listViewToDo.setSelection(adapter.getCount() - 1);


                                cdb.close();
                            }
                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };

        t.start();



















        sendBtn.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){


                        final String msg = sendEt.getText().toString();
                        Message m = new Message();
                        m.setContnet(msg);
                        m.setTo(item);//** who u send to: yaron@gmail.com | nezer14@gmail.com **
                        m.setFrom(user_email);
                        m.setTimestamp(new DateTime(new Date()));
                        sendMessage(m);
                        Log.i("$$$$$$","Clicked on send button");
                        sendEt.setText("");

                        //save msg to db and to adapter


                        ChatDBHandler cdb = new ChatDBHandler(getApplication());
                        cdb.open(ChatDBHandler.OPEN_DB_FOR.WRITE);


                        cdb.saveUser(item,"unknown");//** who u send to: yaron@gmail.com | nezer14@gmail.com **
                        cdb.saveMessage(item,msg, ChatDBHandler.WHO_SEND.ME); //** who u send to: yaron@gmail.com | nezer14@gmail.com **
                        cdb.close();

                        arrayAdapterToDo.add(user_email +" : "+msg);





                    }
                }
        );




/*
        Toast.makeText(getApplicationContext(),from,
                Toast.LENGTH_LONG).show();

        Toast.makeText(getApplicationContext(),message,
                Toast.LENGTH_LONG).show();



*/


    }


    private void sendMessage(final Message m)
    {
        new AsyncTask<Void,Void,Void>()
        {

            @Override
            protected Void doInBackground(Void... params) {
                try {
                    Aroundmeapi api =  EndpointApiCreator.getApi(Aroundmeapi.class);
                    api.sendMessage(m).execute();

                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }


        }.execute();
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_chat, menu);
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
