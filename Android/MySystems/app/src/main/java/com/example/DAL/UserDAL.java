package com.example.DAL;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.Model.User;
import com.example.Util.SQLHelper;

import java.util.ArrayList;
import java.util.List;

public class UserDAL {
    SQLHelper helper;

    public void insert(String name_ed, String tel_ed, String address_ed, String idNum_ed, String date_ed, String sex, Activity activity) {
        helper = new SQLHelper(activity);
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name",name_ed);
        values.put("telephone",tel_ed);
        values.put("address",address_ed);
        values.put("IDNum",idNum_ed);
        values.put("date",date_ed);
        values.put("sex",sex);
        db.insert("User",null,values);
        db.close();
    }

    public void update(String name_ed, String tel_ed, String address_ed, String idNum_ed, String date_ed, String sex, int id, Activity activity) {
        helper = new SQLHelper(activity);
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Name", name_ed);
        values.put("sex", sex);
        values.put("address", address_ed);
        values.put("telephone", tel_ed);
        values.put("IDNum", idNum_ed);
        values.put("date", date_ed);
        db.update("User", values, "UId=?", new String[]{String.valueOf(id)});
        db.close();
    }

    public List<User> getIDAndName(Activity activity) {
        helper = new SQLHelper(activity);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cr = db.rawQuery("select * from User", null);
        List<User> persons = new ArrayList<>();
        while (cr.moveToNext()) {
            User per = new User();
            per.setId(cr.getInt(cr.getColumnIndex("UId")));
            per.setName(cr.getString(cr.getColumnIndex("name")));
            persons.add(per);
        }
        cr.close();
        db.close();
        return persons;
    }

    public List<User> getUser(Activity activity) {
        helper = new SQLHelper(activity);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cr = db.rawQuery("select * from User", null);
        List<User> persons = new ArrayList<>();
        while (cr.moveToNext()) {
            User per = new User();
            per.setId(cr.getInt(cr.getColumnIndex("UId")));
            per.setName(cr.getString(cr.getColumnIndex("name")));
            per.setSex(cr.getString(cr.getColumnIndex("sex")));
            per.setAddress(cr.getString(cr.getColumnIndex("address")));
            per.setTel(cr.getString(cr.getColumnIndex("telephone")));
            per.setDate(cr.getString(cr.getColumnIndex("date")));
            per.setIdNUm(cr.getString(cr.getColumnIndex("IDNum")));
            persons.add(per);
        }
        cr.close();
        db.close();
        return persons;
    }

    public void delete(int id, Activity activity) {
        helper = new SQLHelper(activity);
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("delete from User where UId=?", new String[]{String.valueOf(id)});
        db.close();
    }
}
