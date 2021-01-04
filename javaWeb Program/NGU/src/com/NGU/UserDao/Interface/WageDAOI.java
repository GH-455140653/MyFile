package com.NGU.UserDao.Interface;

import com.NGU.Moduel.Salary;

import java.util.List;

public interface WageDAOI {
    List<Salary> readWage(); // 查询
    public List<Salary> readby(int no);//按编号查询
    public void changeWage(int no,String Sum); //更改数据库

}
