package com.NGU.ssh.DAO;

import com.NGU.ssh.Model.Admin;
import com.NGU.ssh.Model.Admin_logindate;
import com.NGU.ssh.Model.Member;
import com.NGU.ssh.Model.Power;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public interface AdminDao {
    boolean saveAdmin(Admin admin);

    List<Admin> getAdminMsg();  //获取所有管理员

	List<Power> getPowerMsg();  //获取所有权限

    void saveLoginTime(Admin_logindate admin_logindate);

    Admin author_readAdmin(Admin admin);   //查询具体管理员

	Power author_readPower(int i); //查询具体权限

	void author_saveAdmin(Admin admin);  //存储管理员

	void author_savePower(Power power);  //存储权限

	void author_updateAdmin(Admin admin); //修改管理员描述

	boolean author_deleteAll(String hql); //批量删除管理员

	Admin author_readAdminByAccount(String adminAccount);//根据账号查找管理员
}
