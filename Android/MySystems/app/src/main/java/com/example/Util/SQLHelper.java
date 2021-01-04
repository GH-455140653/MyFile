package com.example.Util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLHelper extends SQLiteOpenHelper {
    //创建数据库
    public SQLHelper(@Nullable Context context) {
        super(context, "rantSys.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建表
        db.execSQL("create table Account(" +
                "Id integer primary key autoincrement," +
                "Account varchar(20)," +
                "Password varchar(20)" +
                ")");
        db.execSQL("create table User(" +
                "UId integer primary key autoincrement," +
                "name varchar(20)," +
                "sex varchar(20)," +
                "address varchar(20)," +
                "telephone varchar(20)," +
                "IDNum varchar(20)," +
                "date varchar(20)" +
                ")");
        db.execSQL("create table House(" +
                "Uid integer," +
                "Hid integer primary key," +
                "Size varchar(20)," +
                "foreign key (Uid) references User(UId) on delete cascade on update cascade" +
                ")");
        db.execSQL("create table Finance (" +
                "Fid integer primary key autoincrement," +
                "Hid integer not null," +
                "Uid integer not null," +
                "time varchar(20)," +
                "Electricity float," +
                "Water float," +
                "houseRant float," +
                "netRant float," +
                "summary float," +
                "foreign key (Uid) references User(UId) on delete cascade on update cascade," +
                "foreign key (Hid) references House(Hid) on delete cascade on update cascade)");
        db.execSQL("create table EandW(" +
                "Id integer primary key autoincrement," +
                "Uid integer not null," +
                "Hid integer not null," +
                "time varchar(20)," +
                "Ele float," +
                "lastEle float," +
                "nowEle float," +
                "preEle float," +
                "Wat float," +
                "lastWat float," +
                "nowWat float," +
                "preWat float," +
                "foreign key (Uid) references User(UId) on delete cascade on update cascade," +
                "foreign key (Hid) references House(Hid) on delete cascade on update cascade)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        //实现级联删除和修改
        super.onOpen(db);
        if (!db.isReadOnly()) {
            //Enable foreign key constraints
//            Log.e("sqLite", "open foreign_key success");
            db.execSQL("PRAGMA foreign_keys = ON;");
        }
    }
}
