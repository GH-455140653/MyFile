/**
 * @author:朱思博
 * @date:2020/11/18-{15:37}
 */
package com.NGU.ssh.Model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;


@Component
@Entity(name = "admin")
public class Admin {
    private String admin_account;//管理员账号，唯一，主键
    private String admin_name;//管理员的昵称
    private String admin_icon;//管理员头像地址
    private String admin_password;//管理员密码
    private Date admin_borndate;//管理员账号的注册日期，对应数据库中datetime类型数据
    private String admin_desc;//管理员的描述

    private Set<Admin_logindate> admin_logindates = new HashSet<Admin_logindate>();//管理员表和管理员登录记录表的一对多   一个管理员可以有多个登录记录     一条登录记录只能属于一个管理员
    private Set<Power> powers = new HashSet<Power>();//功能表和管理员表的多对多，一个管理员可以有多个功能，一个功能可以有多个管理员管理


    @Id
    public String getAdmin_account() {
        return admin_account;
    }

    public void setAdmin_account(String admin_account) {
        this.admin_account = admin_account;
    }

    public String getAdmin_name() {
        return admin_name;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }

    public String getAdmin_icon() {
        return admin_icon;
    }

    public void setAdmin_icon(String admin_icon) {
        this.admin_icon = admin_icon;
    }

    public String getAdmin_password() {
        return admin_password;
    }

    public void setAdmin_password(String admin_password) {
        this.admin_password = admin_password;
    }

    public Date getAdmin_borndate() {
        return admin_borndate;
    }

    public void setAdmin_borndate(Date admin_borndate) {
        this.admin_borndate = admin_borndate;
    }

    public String getAdmin_desc() {
        return admin_desc;
    }

    public void setAdmin_desc(String admin_desc) {
        this.admin_desc = admin_desc;
    }

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "admin_account", updatable = false)      //管理员表的主键admin_account对应管理员登录记录表的外键：admin_account
    public Set<Admin_logindate> getAdmin_logindates() {
        return admin_logindates;
    }

    public void setAdmin_logindates(Set<Admin_logindate> admin_logindates) {
        this.admin_logindates = admin_logindates;
    }

    @ManyToMany(mappedBy = "admins")
    public Set<Power> getPowers() {
        return powers;
    }

    public void setPowers(Set<Power> powers) {
        this.powers = powers;
    }
}
