/**
 * @author:朱思博
 * @date:2020/11/18-{15:37}
 */
package com.NGU.ssh.Model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;


@Component
@Entity(name = "admin_logindate")
public class Admin_logindate implements Serializable {
    private static final long serialVersionUID = 1L;
    private String admin_account;//登录的管理员账号	外键admin表中的account
    private Date login_date;//账号的登录时间


    @Id
    @Column(name = "admin_account")
    public String getAdmin_account() {
        return admin_account;
    }

    public void setAdmin_account(String admin_account) {
        this.admin_account = admin_account;
    }

    @Id
    @Column(name = "login_date")
    public Date getLogin_date() {
        return login_date;
    }

    public void setLogin_date(Date login_date) {
        this.login_date = login_date;
    }

    @Override
    public String toString() {
        return "Admin_logindate [admin_account=" + admin_account + ", login_date=" + login_date + "]";
    }
}
