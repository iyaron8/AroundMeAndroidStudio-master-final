package com.aroundme.messageEndpoint;

/**
 * Created by nezer14 on 5/27/15.
 */

import java.security.Timestamp;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.format.DateFormat;
import android.util.Log;
import android.widget.Toast;

import com.appspot.enhanced_cable_88320.aroundmeapi.model.Message;
import com.appspot.enhanced_cable_88320.aroundmeapi.model.User;
public class ChatDBHandler {
    public enum OPEN_DB_FOR { READ, WRITE }
    public enum WHO_SEND {
        ME(1), OTHER(0);

        private final int id;
        WHO_SEND(int id) { this.id=id; }
        public int getValue() { return this.id; }
    }

    public static final String _DB_NAME="databasename";
    public static final String _TABLE_NAME[] = {"tblUser", "tblMessage"};
    public static final int _DB_VERSION=1;
    public static final String _TABLE_CREATE[]={"create table tblUser (" +
            "ID integer primary key autoincrement, " +
            "mail text not null, " +
            "name text not null"+
            ");",
            "create table tblMessage ("
                    + "ID integer primary key autoincrement, "
                    + "user_mail text not null, "
                    + "msg text not null, "
                    + "sender integer not null, "
                    + "d_date date not null"
                    + ");" };
    private Context context;
    private DBHelper dbhelper;
    private SQLiteDatabase db;

    public ChatDBHandler(Context context) {
        this.context=context;
        dbhelper = new DBHelper(context);

    }

    public ChatDBHandler open(OPEN_DB_FOR open_for) {
        if(open_for.READ != null)
            db = dbhelper.getReadableDatabase();
        else
            db = dbhelper.getWritableDatabase();
        return(this);
    }

    public void close() {
        dbhelper.close();
    }

    public void saveUser(String mail, String name) {
        Cursor cursor = db.rawQuery("SELECT ID FROM tblUser where mail = '"+mail+"' ", null);
        if(cursor == null || cursor.getCount() == 0) {
            ContentValues content = new ContentValues();
            content.put("mail", mail);
            content.put("name", name);
            db.insert("tblUser", null, content);
        }
        //db.rawQuery("INSERT INTO tblUser (name, mail) VALUES ('"+name+"', '"+mail+"')", null);
    }

    public void yaroon(){
        Cursor cursor = db.rawQuery("SELECT NAME FROM sqlite_master WHERE type= 'table' AND name= 'tblMessage'", null);
        long c = cursor.getCount();
        Log.i("search table", Long.toString(c));
    }

    public ArrayList<User> getAllUsers() {
        Cursor cursor = (db.rawQuery("select tblUser.* FROM tblUser LEFT JOIN tblMessage ON tblUser.ID = tblMessage.user_id order by d_date DESC" , null));
        cursor.moveToFirst();
        ArrayList<User> all_users = new ArrayList<User>();
        do {
            all_users.add(getUser(cursor.getString(cursor.getColumnIndex("mail"))));
        } while(cursor.moveToNext());

        return(all_users);
    }

    public User getUser(String mail) {
        User user = new User();

        Cursor cursor = db.rawQuery("SELECT * FROM tblUser where mail = '"+mail+"' ", null);
        if(cursor==null) {
            cursor.moveToFirst();
            user.setFullName(cursor.getString(cursor.getColumnIndex("name")));
            user.setMail(cursor.getString(cursor.getColumnIndex("mail")));

        }

        return(user);
    }

    public void saveMessage(String mail, String msg, WHO_SEND who_send) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        //db.rawQuery("INSERT INTO tblMessage (user_mail, msg, sender, d_date) VALUES ( '"+mail+"', '"+msg+"', "+who_send.getValue()+", '"+dateFormat.format(cal.getTime())+"')", null);
        ContentValues content = new ContentValues();
        content.put("user_mail", mail);
        content.put("msg", msg);
        content.put("sender", who_send.getValue());
        content.put("d_date", dateFormat.format(cal.getTime()));
        long t = db.insert("tblMessage", null, content);

        Log.i("00000000000000000000",Long.toString(t));
    }

    public ArrayList<Message> getMessages(String mail) {
        Cursor cursor = db.rawQuery("SELECT * FROM tblMessage where user_mail = '"+mail+"' order by d_date ASC", null);
        if(cursor==null) {
            return (null);
        } else {
            ArrayList<Message> all_messages = new ArrayList<Message>();
            cursor.moveToFirst();
            for(int i=0;i<cursor.getCount();i++) {

                Message msg = new Message();
                msg.setFrom(mail);
                msg.setTo(cursor.getString(cursor.getColumnIndex("sender")));
                msg.setContnet(cursor.getString(cursor.getColumnIndex("msg")));



                //SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                //Date date = sdf.parse(cursor.getString(cursor.getColumnIndex("d_date")));
                all_messages.add(msg);
                cursor.moveToNext();
            }
            return(all_messages);
        }
    }



    /*
     * This function goods for: insert,update,delete.
     * It will not return back anything (void)
     */
    public void createSqlWithoutReturn(String query) {
        db.execSQL(query);
    }


    private static class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context) {
            super(context, _DB_NAME, null, _DB_VERSION);

        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try {
                for(int i=0;i<_TABLE_CREATE.length;i++)
                    db.execSQL(_TABLE_CREATE[i]);
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            for(int i=0;i<_TABLE_NAME.length;i++)
                db.execSQL("DROP TABLE IF EXISTS "+_TABLE_NAME[i]);

            onCreate(db);
        }

    }
}