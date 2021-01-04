package com.example.DAL;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.Model.Account;
import com.example.Util.SQLHelper;

import java.util.ArrayList;
import java.util.List;

public class AccountDAL {
    SQLHelper helper;

    public List<Account> getList(Activity activity) {
        helper = new SQLHelper(activity);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cr = db.rawQuery("select * from Account", null);
        List<Account> persons = new ArrayList<>();
        while (cr.moveToNext()) {
            Account per = new Account();
            per.setAccount(cr.getString(cr.getColumnIndex("Account")));
            per.setPassword(cr.getString(cr.getColumnIndex("Password")));
            persons.add(per);
        }
        cr.close();
        db.close();
        return persons;
    }

    public List<Account> getNameList(Activity activity) {
        helper = new SQLHelper(activity);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cr = db.rawQuery("select * from Account", null);
        List<Account> persons = new ArrayList<>();
        while (cr.moveToNext()) {
            Account per = new Account();
            per.setAccount(cr.getString(cr.getColumnIndex("Account")));
            persons.add(per);
        }
        cr.close();
        db.close();
        return persons;
    }

    public void insert(String act, String pwd, Activity activity) {
        helper = new SQLHelper(activity);
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("insert into Account(Account,Password) values(?,?)", new String[]{act, pwd});
        db.close();
    }

    public List<Account> getIdAndName(Activity activity) {
        helper = new SQLHelper(activity);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cr = db.rawQuery("select * from Account", null);
        List<Account> persons = new ArrayList<>();
        while (cr.moveToNext()) {
            Account per = new Account();
            per.setId(cr.getInt(cr.getColumnIndex("Id")));
            per.setAccount(cr.getString(cr.getColumnIndex("Account")));
            persons.add(per);
        }
        cr.close();
        db.close();
        return persons;
    }

    public void update(String act, String pwd, int id, Activity activity) {
        helper = new SQLHelper(activity);
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Account", act);
        values.put("Password", pwd);
        db.update("Account", values, "Id=?", new String[]{String.valueOf(id)});
        db.close();
    }
}
