/**
 * @author:朱思博
 * @date:2020/11/18-{15:37}
 */
package com.NGU.ssh.Model;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;


@Component
@Entity(name = "member_logindate")
public class Member_logindate implements Serializable {
    private static final long serialVersionUID = 1L;
    private String member_account;//登录的用户账号	外键member表中的account
    private Date login_date;//账号的登录时间

    @Id
    public String getMember_account() {
        return member_account;
    }

    public void setMember_account(String member_account) {
        this.member_account = member_account;
    }

    @Id
    public Date getLogin_date() {
        return login_date;
    }

    public void setLogin_date(Date login_date) {
        this.login_date = login_date;
    }
}
