package com.NGU.UserDao.Interface;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.NGU.Moduel.Person;

public interface PersonDAOI {
    public List<Person> read();

    public void delete(String no);

    public void update(String type, String value, String no);

    public List<Person> search(String no, String dept);

    public void insert(String no, String name, String dept, String age, String sex, String salary, String tel);

    public List<Person> change(String no, String name, String dept, String age, String sex, String tel);

    public List<Person> lookInfo(String no);

    public void writeTxt(String path, String name, String sex, String age, String dept, String tel);

    public void download(String path, HttpServletRequest request, HttpServletResponse response) throws FileNotFoundException;

    public List<Integer> readno();
}
