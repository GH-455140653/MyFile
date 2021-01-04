package com.dqpi.Handle.UserDaoInterface;

import java.util.List;

public interface UserDao {
    List<String> login(int id, String account, String pwd);

    List<String> Course(String[] course,int id);

    List<String> message(String name, String sex, String age,int id);
}
