package com.example.Util;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

public class ActivityFinishUtil {
    //实现程序退出
    private static List<Activity> activityList = new ArrayList<>();

    public static void addActivity(Activity activity) {
        //添加某个activity
        activityList.add(activity);
    }

    public static void removeActivity(Activity activity) {
        //删除某个activity
        activityList.remove(activity);
    }

    public static void finishAllActivity() {
        //结束获取的activity
        for (Activity item : activityList) {
            item.finish();
        }
    }
}
