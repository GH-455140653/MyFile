package com.example.DAL;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.Model.Finance;
import com.example.Model.User;
import com.example.Util.SQLHelper;
import com.example.mysystems.FinanceActivity;
import com.example.mysystems.Finance_add;
import com.example.mysystems.Finance_show;

import java.util.ArrayList;
import java.util.List;

public class FinanceDAL {
    SQLHelper helper;

    public List<Finance> getMsgByHid(String hid, List<User> userList, FinanceActivity financeActivity) {
        helper = new SQLHelper(financeActivity);
        List<Finance> finances = new ArrayList<>();
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cr = db.rawQuery("select * from Finance where Hid=?", new String[]{hid});
        while (cr.moveToNext()) {
            Finance finance = new Finance();
            finance.setHid(cr.getInt(cr.getColumnIndex("Hid")));
            finance.setUid(cr.getInt(cr.getColumnIndex("Uid")));
            finance.setDate(cr.getString(cr.getColumnIndex("time")));

            //获取指定uid的姓名
            for (User user : userList) {
                if (user.getId() == finance.getUid()) {
                    finance.setUserName(user.getName());
                }
            }

            finances.add(finance);
        }
        cr.close();
        db.close();

        return finances;
    }

    public void delete(String hid, String uid, String time, FinanceActivity financeActivity) {
        helper = new SQLHelper(financeActivity);
        SQLiteDatabase db = helper.getWritableDatabase();
        db.delete("Finance", "Hid=? and Uid=? and time=?", new String[]{hid, uid, time});
        db.delete("EandW", "Hid=? and Uid=? and time=?", new String[]{hid, uid, time});
        db.close();
    }

    public List<Finance> getMsg(List<User> userList, FinanceActivity financeActivity) {
        helper = new SQLHelper(financeActivity);
        List<Finance> finances = new ArrayList<>();
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cr = db.rawQuery("select * from Finance", null);
        while (cr.moveToNext()) {
            Finance finance = new Finance();
            finance.setHid(cr.getInt(cr.getColumnIndex("Hid")));
            finance.setUid(cr.getInt(cr.getColumnIndex("Uid")));
            finance.setDate(cr.getString(cr.getColumnIndex("time")));

            //获取指定uid的姓名
            for (User user : userList) {
                if (user.getId() == finance.getUid()) {
                    finance.setUserName(user.getName());
                }
            }

            finances.add(finance);
        }
        cr.close();
        db.close();

        return finances;
    }

    public void addFinance(String hid, String uid, String time, float electricity, float water, float netRant, float houseRant, float summary, Finance_add finance_add) {
        helper = new SQLHelper(finance_add);
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Hid", hid);
        values.put("Uid", uid);
        values.put("time", time);
        values.put("Electricity", electricity);
        values.put("Water", water);
        values.put("netRant", netRant);
        values.put("houseRant", houseRant);
        values.put("summary", summary);
        db.insert("Finance", null, values);
        db.close();
    }

    public void addEandW(String hid, String uid, String date, float preEle, float preWat, float nowEle, float nowWat, float ele, float wat, float lastEle, float lastWat, Finance_add finance_add) {
        helper = new SQLHelper(finance_add);
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Hid", hid);
        values.put("Uid", uid);
        values.put("time", date);
        values.put("Ele", ele);
        values.put("lastEle", lastEle);
        values.put("nowEle", nowEle);
        values.put("preEle", preEle);
        values.put("Wat", wat);
        values.put("lastWat", lastWat);
        values.put("nowWat", nowWat);
        values.put("preWat", preWat);
        db.insert("EandW", null, values);
        db.close();
    }

    public List<Finance> getEandW(String houseNum, String userId, Finance_add finance_add) {
        helper = new SQLHelper(finance_add);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cr = db.rawQuery("select * from EandW where Hid=? and Uid=?", new String[]{houseNum, userId});
        List<Finance> finances = new ArrayList<>();
        while (cr.moveToNext()) {
            Finance finance = new Finance();
            finance.setNowEle(cr.getFloat(cr.getColumnIndex("nowEle")));
            finance.setNowWat(cr.getFloat(cr.getColumnIndex("nowWat")));
            finance.setLastEle(cr.getFloat(cr.getColumnIndex("lastEle")));
            finance.setLastWat(cr.getFloat(cr.getColumnIndex("lastWat")));
            finance.setDate(cr.getString(cr.getColumnIndex("time")));
            finances.add(finance);
        }
        cr.close();
        db.close();
        return finances;
    }

    public List<String> getItemsList(String hid, String uid, String time, Finance_show finance_show) {
        helper = new SQLHelper(finance_show);
        List<String> itemsList = new ArrayList<>();
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cr = db.rawQuery("select * from Finance where Hid=? and Uid=? and time=?", new String[]{hid, uid, time});
        while (cr.moveToNext()) {
            itemsList.add(cr.getString(cr.getColumnIndex("time")));
            itemsList.add(String.valueOf(cr.getInt(cr.getColumnIndex("Hid"))));
            itemsList.add(String.valueOf(cr.getFloat(cr.getColumnIndex("Electricity"))));
            itemsList.add(String.valueOf(cr.getFloat(cr.getColumnIndex("Water"))));
            itemsList.add(String.valueOf(cr.getFloat(cr.getColumnIndex("houseRant"))));
            itemsList.add(String.valueOf(cr.getFloat(cr.getColumnIndex("netRant"))));
            itemsList.add(String.valueOf(cr.getFloat(cr.getColumnIndex("summary"))));
        }
        cr.close();
        db.close();

        return itemsList;
    }

    public String[] getWaterMsg(String hid, String uid, String time, Finance_show finance_show) {
        helper = new SQLHelper(finance_show);
        List<String> EandWList = new ArrayList<>();
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cr = db.rawQuery("select * from EandW where Hid=? and Uid=? and time=?", new String[]{hid, uid, time});
        while (cr.moveToNext()) {
            EandWList.add("每方水" + cr.getFloat((cr.getColumnIndex("preWat"))) + "元");
            EandWList.add("上月用水：" + cr.getFloat((cr.getColumnIndex("lastWat"))) + "方");
            EandWList.add("该月用水：" + cr.getFloat((cr.getColumnIndex("nowWat"))) + "方");
            EandWList.add("该月实用水：" + cr.getFloat((cr.getColumnIndex("Wat"))) + "方");
        }
        cr.close();
        db.close();

        String[] arr = new String[EandWList.size()];
        EandWList.toArray(arr);

        return arr;
    }

    public String[] getElectricityMsg(String hid, String uid, String time, Finance_show finance_show) {
        helper = new SQLHelper(finance_show);
        List<String> EandWList = new ArrayList<>();
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cr = db.rawQuery("select * from EandW where Hid=? and Uid=? and time=?", new String[]{hid, uid, time});
        while (cr.moveToNext()) {
            EandWList.add("每度电" + cr.getFloat((cr.getColumnIndex("preEle"))) + "元");
            EandWList.add("上月用电：" + cr.getFloat((cr.getColumnIndex("lastEle"))) + "度");
            EandWList.add("该月用电：" + cr.getFloat((cr.getColumnIndex("nowEle"))) + "度");
            EandWList.add("该月实用电度：" + cr.getFloat((cr.getColumnIndex("Ele"))) + "度");
        }
        cr.close();
        db.close();

        String[] arr = new String[EandWList.size()];
        EandWList.toArray(arr);

        return arr;
    }

    public List<Finance> getAddBeforeMsg(String username, String hid, String date, List<User> userList, Finance_add finance_add) {
        helper = new SQLHelper(finance_add);
        SQLiteDatabase db = helper.getReadableDatabase();

        String uid = "";
        for (User user : userList) {
            if (user.getName().equals(username)) {
                uid = String.valueOf(user.getId());
            }
        }

        Cursor cr = db.rawQuery("select * from Finance where Hid=? and Uid=? and time=?", new String[]{hid, uid, date});
        List<Finance> finances = new ArrayList<>();
        while (cr.moveToNext()) {
            Finance finance = new Finance();
            finance.setNetRant(cr.getFloat(cr.getColumnIndex("netRant")));
            finance.setHouseRant(cr.getFloat(cr.getColumnIndex("houseRant")));

            Cursor cr_EandW = db.rawQuery("select * from EandW where Hid=? and Uid=? and time=?", new String[]{hid, uid, date});
            while (cr_EandW.moveToNext()) {
                finance.setPreWat(cr_EandW.getFloat(cr_EandW.getColumnIndex("preWat")));
                finance.setPreEle(cr_EandW.getFloat(cr_EandW.getColumnIndex("preEle")));
                finance.setNowEle(cr_EandW.getFloat(cr_EandW.getColumnIndex("nowEle")));
                finance.setNowWat(cr_EandW.getFloat(cr_EandW.getColumnIndex("nowWat")));

            }
            cr_EandW.close();

            finances.add(finance);
        }
        cr.close();
        db.close();

        return finances;
    }

    public boolean getDate(String hid, String username, String date, List<User> userList, Finance_add finance_add) {
        helper = new SQLHelper(finance_add);
        boolean flag = false;

        String uid = "";
        for (User user : userList) {
            if (user.getName().equals(username)) {
                uid = String.valueOf(user.getId());
            }
        }

        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cr = db.rawQuery("select * from Finance where Hid=? and Uid=? and time=?", new String[]{hid, uid, date});
        List<Finance> finances = new ArrayList<>();
        while (cr.moveToNext()) {
            Finance finance = new Finance();
            finance.setDate(cr.getString(cr.getColumnIndex("time")));
            finances.add(finance);
        }
        cr.close();
        db.close();

        if (finances.size() != 0) flag = true;

        return flag;
    }
}
