/**
 * @author:朱思博
 * @date:2020/11/18-{15:37}
 * @ManyToMany(cascade = CascadeType.ALL)
 * @JoinTable(name = "pg",joinColumns = @JoinColumn(name = "pid"),inverseJoinColumns = @JoinColumn(name = "gid"))
 */
package com.NGU.ssh.Model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.springframework.stereotype.Component;


@Component
@Entity(name = "power")
public class Power {
    private int power_id;//权限id
    private String power_name;//权限名称

    private Set<Admin> admins = new HashSet<Admin>();//权限表和管理员表的多对多，一个管理员可以有多个功能，一个功能可以有多个管理员管理

    @Id
    @GeneratedValue
    public int getPower_id() {
        return power_id;
    }

    public void setPower_id(int power_id) {
        this.power_id = power_id;
    }

    public String getPower_name() {
        return power_name;
    }

    public void setPower_name(String power_name) {
        this.power_name = power_name;
    }

    @ManyToMany()
    @JoinTable(name = "admin_power", joinColumns = @JoinColumn(name = "power_id"), inverseJoinColumns = @JoinColumn(name = "admin_account"))
    public Set<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(Set<Admin> admins) {
        this.admins = admins;
    }
}
