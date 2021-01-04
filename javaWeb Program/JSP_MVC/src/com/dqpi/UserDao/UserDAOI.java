package com.dqpi.UserDao;

import java.util.List;

import com.dqpi.Model.User;

public interface UserDAOI {
    public List<User> add();

    public void delet(String id);

    public void update(String id, String name, String password);
}
