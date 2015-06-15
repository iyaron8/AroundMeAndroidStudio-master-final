package com.aroundme;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import android.util.Log;
import java.util.concurrent.atomic.AtomicInteger;

import com.appspot.enhanced_cable_88320.aroundmeapi.Aroundmeapi;
import com.appspot.enhanced_cable_88320.aroundmeapi.model.Message;
import com.appspot.enhanced_cable_88320.aroundmeapi.model.User;
import com.appspot.enhanced_cable_88320.aroundmeapi.model.UserAroundMe;
import com.appspot.enhanced_cable_88320.aroundmeapi.model.UserAroundMeCollection;
import com.aroundme.deviceinfoendpoint.Deviceinfoendpoint;
import com.aroundme.deviceinfoendpoint.DeviceinfoendpointRequest;
import com.aroundme.deviceinfoendpoint.model.DeviceInfo;
import com.aroundme.messageEndpoint.Chat;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.internal.mw;
import com.google.android.gms.plus.model.people.Person;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;

/**
 * The Main Activity.
 * 
 * This activity starts up the RegisterActivity immediately, which communicates
 * with your App Engine backend using Cloud Endpoints. It also receives push
 * notifications from backend via Google Cloud Messaging (GCM).
 * 
 * Check out RegisterActivity.java for more details.
 */
public class MainActivity extends Activity {

     static final String TAG = "-+-+-+-+-+-+";





	/**
	 * Substitute you own sender ID here. This is the project number you got
	 * from the API Console, as described in "Getting Started."
	 */
	String SENDER_ID = "1047488186224";
    private final static int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
    public static final String EXTRA_MESSAGE = "message";
    public static final String PROPERTY_REG_ID = "registration_id";
    private static final String PROPERTY_APP_VERSION = "appVersion";

    TextView mDisplay;
    TextView loadingTv;
    Button registerButton;
    Button signUpButton;

    LinearLayout ll;


    GoogleCloudMessaging gcm;

    AtomicInteger msgId = new AtomicInteger();
    SharedPreferences prefs;
    Context context;

    String regid;



    @Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
        mDisplay = (TextView) findViewById(R.id.mDisplay);
        registerButton = (Button)findViewById(R.id.registerButton);
        signUpButton = (Button)findViewById(R.id.signUpButton);
        ll = (LinearLayout) findViewById(R.id.linearLayout1);
        loadingTv = (TextView) findViewById(R.id.loadText);

        EndpointApiCreator.initialize(null);

        context = getApplicationContext();
        final EditText mailEt = (EditText)findViewById(R.id.mailEt);
        final EditText passwordEt = (EditText)findViewById(R.id.passwordEt);



        SharedPreferences sharedPref = getSharedPreferences("userInfo",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        final  String email = sharedPref.getString("email","");
        final String pw = sharedPref.getString("pw","");

        mailEt.setVisibility(View.INVISIBLE);
        passwordEt.setVisibility(View.INVISIBLE);
        loadingTv.setVisibility(View.VISIBLE);
        registerButton.setVisibility(View.INVISIBLE);
        signUpButton.setVisibility(View.INVISIBLE);
        signUpButton.setVisibility(View.INVISIBLE);
        ll.setVisibility(View.INVISIBLE);


        if (((email != null)&&(pw != null) && (!email.equals("") && !pw.equals("")))) {



          //  mailEt.setText(email);
          // passwordEt.setText(pw);
            new AsyncTask<Void,Void,Void>()
            {

                @Override
                protected Void doInBackground(Void... params) {

                    login(email, pw);

                    Intent curr_intent = new Intent(MainActivity.this, Login.class);
                    MainActivity.this.startActivity(curr_intent);
                    MainActivity.this.finish();

                    return null;
                }
            }.execute();



        } else {

            mailEt.setVisibility(View.VISIBLE);
            passwordEt.setVisibility(View.VISIBLE);
            registerButton.setVisibility(View.VISIBLE);
            signUpButton.setVisibility(View.VISIBLE);
            ll.setVisibility(View.VISIBLE);
            loadingTv.setVisibility(View.INVISIBLE);
        }



        if (checkPlayServices()) {

            gcm = GoogleCloudMessaging.getInstance(this);
            regid = getRegistrationId(context);

            if (regid.isEmpty()) {
               registerInBackground();
            }


            signUpButton.setOnClickListener(
                    new Button.OnClickListener(){
                        public void onClick(View v){
                            Log.i(TAG, "Clicked the SIGN UP button");

                            Intent myIntent = new Intent(MainActivity.this, SignUp.class);


                                MainActivity.this.startActivity(myIntent);

                        }
                    }
            );



            registerButton.setOnClickListener(
                    new Button.OnClickListener(){
                        public void onClick(View v){
                            Log.i(TAG, "Clicked the LOG IN button");



                            final String mail = mailEt.getText().toString();
                            final String pw = passwordEt.getText().toString();


                            new AsyncTask<Void,Void,Void>()
                            {

                                @Override
                                protected Void doInBackground(Void... params) {
                                    login(mail, pw);
                                    return null;
                                }
                            }.execute();



                        }
                    }
            );







        } else {
            Log.i(TAG, "No valid Google Play Services APK found.");
        }



	}

    private void login(String mail, String pw) {
        try {
            Aroundmeapi api = EndpointApiCreator.getApi(Aroundmeapi.class);
            User u = new User();// create new user

            //initialize the user object with mail , password and regid.
             u.setMail(mail);
             u.setPassword(pw);
             u.setRegistrationId(regid);




            //check if user is registered or not , if not registered -it will return a null obj.
           User logedinuser = api.login(u.getMail(),u.getPassword(),u.getRegistrationId()).execute(); //login user(confirm with db)




            //save data to shared pref
            SharedPreferences sharedPref = getSharedPreferences("userInfo",Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();

            editor.putString("email", mail );
            editor.putString("pw", pw );
            editor.apply();

           // String Tryname = sharedPref.getString("username","");

           // Toast.makeText(getApplicationContext(),Tryname,
              //      Toast.LENGTH_LONG).show();


            Intent myIntent = new Intent(MainActivity.this, Login.class);

            if(logedinuser != null){//if the user is already registered , we did a log in , so we want to change intent
                //goto other intent
               MainActivity.this.startActivity(myIntent);

            }

            if(logedinuser == null){
                Log.i(TAG,"GOT INTO THE FUNCTION");

                MainActivity.this.runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, "The user or password is incorrect", Toast.LENGTH_SHORT).show();

                    }
                });

            }


            /*
            //if not, register him.
            if(logedinuser == null){

                logedinuser =  api.register(u).execute(); // register user to db
                logedinuser = api.login(u.getMail(),u.getPassword(),u.getRegistrationId()).execute(); // login
               MainActivity.this.startActivity(myIntent);
                UserAroundMeCollection a;
                a = api.getAllUsers("a").execute();
                Message m;
                Log.i(TAG,"registered: "+mail);

            }

            */


            // Toast.makeText(getApplicationContext(),Tryname,
            //      Toast.LENGTH_LONG).show();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendRegistrationIdToBackend() {
        try {
            com.aroundme.deviceinfoendpoint.Deviceinfoendpoint endpoint = EndpointApiCreator
                    .getApi(Deviceinfoendpoint.class);
            DeviceInfo existingInfo = endpoint.getDeviceInfo(regid).execute();

            boolean alreadyRegisteredWithEndpointServer = false;
            if (existingInfo != null
                    && regid.equals(existingInfo.getDeviceRegistrationID())) {
                alreadyRegisteredWithEndpointServer = true;
            }

            if (!alreadyRegisteredWithEndpointServer) {
				/*
				 * We are not registered as yet. Send an endpoint message
				 * containing the GCM registration id and some of the device's
				 * product information over to the backend. Then, we'll be
				 * registered.
				 */
                DeviceInfo deviceInfo = new DeviceInfo();
                endpoint.insertDeviceInfo(
                        deviceInfo
                                .setDeviceRegistrationID(regid)
                                .setTimestamp(System.currentTimeMillis())
                                .setDeviceInformation(
                                        URLEncoder
                                                .encode(android.os.Build.MANUFACTURER
                                                                + " "
                                                                + android.os.Build.PRODUCT,
                                                        "UTF-8"))).execute();
            }
        } catch (Exception e) {

        }

    }


/*
    public void onClick(final View view) {
        if (view == findViewById(R.id.send)) {
            Log.i(TAG, "called the onClick function");
            new UpstreamMsg().execute();
        }
    }
*/

   class UpstreamMsg extends AsyncTask<Void, Integer, String>{

        @Override
        protected String doInBackground(Void... params) {
            String msg = "";
            try {
                Bundle data = new Bundle();
                data.putString("my_message", "Hello World");
                data.putString("my_action",
                        "com.google.android.gcm.demo.app.ECHO_NOW");
                String id = Integer.toString(msgId.incrementAndGet());
                gcm.send(SENDER_ID + "@gcm.googleapis.com", id, data);
                msg = "Sent message";
            } catch (IOException ex) {
                msg = "Error :" + ex.getMessage();
            }
            return msg;
        }


        @Override
        protected void onPostExecute(String msg) {

          //  mDisplay.append(msg + "\n");
        }

    }






    private void registerInBackground() {
        new RegistrationTask().execute();
    }


    class RegistrationTask extends AsyncTask<Void, Integer, String>{

        @Override
        protected String doInBackground(Void... params) {
            String msg = "";
            try {
                if (gcm == null) {
                    gcm = GoogleCloudMessaging.getInstance(context);
                }
                regid = gcm.register(SENDER_ID);
                msg = "Device registered, registration ID=" + regid;

                // You should send the registration ID to your server over HTTP,
                // so it can use GCM/HTTP or CCS to send messages to your app.
                // The request to your server should be authenticated if your app
                // is using accounts.
                sendRegistrationIdToBackend();

                // For this demo: we don't need to send it because the device
                // will send upstream messages to a server that echo back the
                // message using the 'from' address in the message.

                // Persist the registration ID - no need to register again.
                //  storeRegistrationId(context, regid);
            } catch (IOException ex) {
                msg = "Error :" + ex.getMessage();
                // If there is an error, don't just keep trying to register.
                // Require the user to click a button again, or perform
                // exponential back-off.
            }
            return msg;
        }

        @Override
        protected void onPostExecute(String msg) {
          //  mDisplay.append(msg + "\n");
        }

    }






    private String getRegistrationId(Context context) {

        final SharedPreferences prefs = getGCMPreferences(context);
        String registrationId = prefs.getString(PROPERTY_REG_ID, "");
        if (registrationId.isEmpty()) {
            Log.i(TAG, "Registration not found.");
            return "";
        }
        // Check if app was updated; if so, it must clear the registration ID
        // since the existing registration ID is not guaranteed to work with
        // the new app version.
        int registeredVersion = prefs.getInt(PROPERTY_APP_VERSION, Integer.MIN_VALUE);
        int currentVersion = getAppVersion(context);
        if (registeredVersion != currentVersion) {
            Log.i(TAG, "App version changed.");
            return "";
        }
        return registrationId;
    }

    private void storeRegistrationId(Context context, String regId) {
        final SharedPreferences prefs = getGCMPreferences(context);
        int appVersion = getAppVersion(context);
        Log.i(TAG, "Saving regId on app version " + appVersion);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(PROPERTY_REG_ID, regId);
        editor.putInt(PROPERTY_APP_VERSION, appVersion);
        editor.commit();
    }



    private static int getAppVersion(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager()
                    .getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionCode;
        } catch (NameNotFoundException e) {
            // should never happen
            throw new RuntimeException("Could not get package name: " + e);
        }
    }


    private SharedPreferences getGCMPreferences(Context context) {
        // This sample app persists the registration ID in shared preferences, but
        // how you store the registration ID in your app is up to you.
        return getSharedPreferences(MainActivity.class.getSimpleName(),
                Context.MODE_PRIVATE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        checkPlayServices();
    }

    private boolean checkPlayServices() {
        int resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        if (resultCode != ConnectionResult.SUCCESS) {
            if (GooglePlayServicesUtil.isUserRecoverableError(resultCode)) {
                GooglePlayServicesUtil.getErrorDialog(resultCode, this,
                        PLAY_SERVICES_RESOLUTION_REQUEST).show();
            } else {
                Log.i("HELLO", "This device is not supported.");
                finish();
            }
            return false;
        }
        return true;
    }




}
