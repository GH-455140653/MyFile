package com.dqpi.hibernate.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Teacher {
    private int id;
    private String name;
    private int age;
    private String sex;
    private List<Student> students;

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "T_D", joinColumns = @JoinColumn(name = "t_id"), inverseJoinColumns = @JoinColumn(name = "s_id"))
    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
