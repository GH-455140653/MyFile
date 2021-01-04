package com.NGU.UserDao.Interface;

import com.NGU.Moduel.Advice;


import java.util.List;

public interface AdviceDAOI {
    List<Advice> fileInput();//文件读取

    List<Advice> fileOutput();//文件写入

    List<Advice> read();//   查询反馈

    List<Advice> readBySno();   //根据留言编号查询反馈

    List<Advice> readByno();   //根据员工编号查询反馈

    public void delete();  //删除留言

    List<Advice> readMaxSno();   //查询最大编号

    List<Advice> create();   // 添加反馈信息
}
