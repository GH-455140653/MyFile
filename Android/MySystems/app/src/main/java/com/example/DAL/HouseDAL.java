package com.example.DAL;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.Model.House;
import com.example.Util.SQLHelper;

import java.util.ArrayList;
import java.util.List;

public class HouseDAL {
    SQLHelper helper;

    public List<House> getHouseAll(Activity activity) {
        helper = new SQLHelper(activity);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cr = db.rawQuery("select * from House", null);
        List<House> houses = new ArrayList<>();
        while (cr.moveToNext()) {
            House house = new House();
            house.setUid(cr.getInt(cr.getColumnIndex("Uid")));
            house.setHid(cr.getInt(cr.getColumnIndex("Hid")));
            house.setSize(cr.getString(cr.getColumnIndex("Size")));
            houses.add(house);
        }
        cr.close();
        db.close();
        return houses;
    }

    public void update(String uid, String hid, Activity activity) {
        helper = new SQLHelper(activity);
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Uid", uid);
        db.update("House", values, "hId=?", new String[]{hid});
        db.close();
    }

    public List<House> getId(Activity activity) {
        helper = new SQLHelper(activity);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cr = db.rawQuery("select * from House", null);
        List<House> houses = new ArrayList<>();
        while (cr.moveToNext()) {
            House house = new House();
            house.setHid(cr.getInt(cr.getColumnIndex("Hid")));
            houses.add(house);
        }
        cr.close();
        db.close();
        return houses;
    }

    public void insert(String hid, String hSize, Activity activity) {
        helper = new SQLHelper(activity);
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("insert into House(Hid,Size) values(?,?)", new String[]{hid, hSize});
        db.close();
    }

    public void delete(int hid, Activity activity) {
        helper = new SQLHelper(activity);
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("delete from House where Hid=?", new String[]{String.valueOf(hid)});
        db.close();
    }

    public List<House> getCustomerMsg(Activity activity) {
        helper = new SQLHelper(activity);
        SQLiteDatabase db = helper.getReadableDatabase();

        //查房间表
        Cursor cr_house = db.rawQuery("select * from House", null);
        List<House> houses = new ArrayList<>();
        while (cr_house.moveToNext()) {
            String userName = "", userDate = "";
            House house = new House();

            int uid = cr_house.getInt(cr_house.getColumnIndex("Uid"));

            Cursor cr_user = db.rawQuery("select * from User", null);
            while (cr_user.moveToNext()) {
                if (cr_user.getInt(cr_user.getColumnIndex("UId")) == uid) {
                    userName = cr_user.getString(cr_user.getColumnIndex("name"));
                    userDate = cr_user.getString(cr_user.getColumnIndex("date"));
                    break;
                }
            }
            cr_user.close();
            house.setUid(uid);
            house.setHid(cr_house.getInt(cr_house.getColumnIndex("Hid")));
            house.setSize(cr_house.getString(cr_house.getColumnIndex("Size")));
            house.setUserName(userName);
            house.setUserDate(userDate);
            houses.add(house);
        }
        cr_house.close();
        db.close();
        return houses;
    }
}
