package com.dqpi.Handle.UserDaoInterface;

import java.util.List;

public interface UserDaoI {
    List<String> login(String account, String pwd);

    List<String> Course(String[] course);
}
