package com.NGU.UserDao.Interface;

import java.util.List;

import com.NGU.Moduel.Dialog;;

public interface DialogDAOI {
    List<Dialog> read();//   查询留言
    List<Dialog> readByDno();   //根据留言编号查询留言
    List<Dialog> readByno();   //根据员工编号查询留言
    void delete();  //删除留言
    List<Dialog> update();  //修改留言
    List<Dialog> readMaxDno();   //查询最大留言编号
    List<Dialog> create();   // 添加新留言
}
