package com.dqpi.Handle;

import javax.servlet.ServletException;
import java.io.IOException;

public class courseHandle {
    public String isNull(String[] course) throws ServletException, IOException {
        if (course == null) {
            return "请选择课程！";
        } else {
            for (String value : course) {
                value = new String(value.getBytes("iso-8859-1"), "utf-8");
            }
            return null;
        }
    }

    public String checked(String[] course) {
        if (course.length < 2) {
            return "选课太少！";
        } else {
            return "选课成功！";
        }
    }
}
