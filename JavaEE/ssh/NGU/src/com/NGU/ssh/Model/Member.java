/*
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
import javax.persistence.OneToMany;


import org.springframework.stereotype.Component;

@Component
@Entity(name = "member")
public class Member {
    private String member_account;//普通用户的账号，唯一
    private String member_name;//普通用户的昵称
    private String member_icon;//普通用户的头像地址
    private String member_password;//普通用户密码
    private Date member_borndate;//普通用户账号的注册日期，对应数据库中datetime类型数据

    private Set<Record> records = new HashSet<Record>();//普通用户表和观看记录表的一对多   一个普通用户可以有多个观看记录     一条观看记录只能属于一个普通用户
    private Set<Comment> comments = new HashSet<Comment>();//普通用户表和评论表的一对多   一个普通用户可以有多个评论     一条评论只能属于一个普通用户
    private Set<Member_logindate> member_logindates = new HashSet<Member_logindate>();//普通用户表和用户登陆时间表的一对多   一个普通用户可以有多个登录时间数据     一条登录时间只能属于一个普通用户
    @Id
    public String getMember_account() {
        return member_account;
    }

    public void setMember_account(String member_account) {
        this.member_account = member_account;
    }

    public String getMember_name() {
        return member_name;
    }

    public void setMember_name(String member_name) {
        this.member_name = member_name;
    }

    public String getMember_icon() {
        return member_icon;
    }

    public void setMember_icon(String member_icon) {
        this.member_icon = member_icon;
    }

    public String getMember_password() {
        return member_password;
    }

    public void setMember_password(String member_password) {
        this.member_password = member_password;
    }

    public Date getMember_borndate() {
        return member_borndate;
    }

    public void setMember_borndate(Date member_borndate) {
        this.member_borndate = member_borndate;
    }

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "member_account", updatable = false)      //用户表的主键member_account对应播放记录表的外键：member_account
    public Set<Record> getRecords() {
        return records;
    }

    public void setRecords(Set<Record> records) {
        this.records = records;
    }

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "member_account", updatable = false)      //用户表的主键member_account对应评论记录表的外键：member_account
    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "member_account", updatable = false)      //用户表的主键member_account对应用户登录事件表的外键：member_account
    public Set<Member_logindate> getMember_logindates() {
        return member_logindates;
    }

    public void setMember_logindates(Set<Member_logindate> member_logindates) {
        this.member_logindates = member_logindates;
    }
}
