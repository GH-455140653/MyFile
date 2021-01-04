package com.NGU.UserDao.Interface;

import java.util.List;

import com.NGU.Moduel.Sign;

public interface SignDAOI {
    List<Sign> read();//查询考勤表信息

    List<Sign> read(int no);//按编号查询考勤表信息

    List<Sign> update(String no, String time, int statues);//对考勤表信息修改

    void insertintosign(int no, String time);

    int readstatues(int no, String time);//普通用户登录时查看签到状态
}
