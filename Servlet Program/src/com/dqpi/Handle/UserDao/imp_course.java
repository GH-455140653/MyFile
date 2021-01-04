package com.dqpi.Handle.UserDao;

import com.dqpi.Handle.UserDaoInterface.UserDaoI;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class imp_course implements UserDaoI {

    @Override
    public List<String> login(String account, String pwd) {
        return null;
    }

    @Override
    public List<String> Course(String[] course) {
        List<String> list = new ArrayList<>();
        if (course.length < 2) {
            list.add("b");
            list.add("课程选择少于2门！<br>已选课程为：");
        } else {
            list.add("c");
            list.add("已选课程为：");
        }
        return list;
    }
}
