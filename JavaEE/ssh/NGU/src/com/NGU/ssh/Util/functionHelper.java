/*
* 该类用来存储项目后台常用方法
* 请有需要的人写入时做好注释与功能解释
*/

package com.NGU.ssh.Util;

import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class functionHelper {

    /*指定格式时间转化*/
    public String dateHandle(Date date) {
        //取出数据库datetime并转为实际需求格式
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = df.format(date);

//        //数据库取出数据值
//        System.out.println(date);
//
//        //处理后的数据值
//        System.out.println(time);

        return time;
    }
}
