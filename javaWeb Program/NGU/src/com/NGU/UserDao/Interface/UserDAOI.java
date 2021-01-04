package com.NGU.UserDao.Interface;

import com.NGU.Moduel.User;

import java.util.List;

public interface UserDAOI {
    List<User> read();//查询
    List<User> update();//更新
}
