package com.dqpi.hibernate.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Student {
    private int id;
    private String name;
    private int age;
    private String sex;
//    private Set<Teacher> teacher = new HashSet<>();
//
//    @ManyToMany(mappedBy = "students",fetch = FetchType.LAZY)
//    public Set<Teacher> getTeacher() {
//        return teacher;
//    }
//
//    public void setTeacher(Set<Teacher> teacher) {
//        this.teacher = teacher;
//    }

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
