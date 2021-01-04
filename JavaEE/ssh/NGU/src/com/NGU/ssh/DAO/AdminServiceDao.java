package com.NGU.ssh.DAO;

import java.io.IOException;
import java.util.List;

import com.NGU.ssh.Model.Admin;
import com.NGU.ssh.Model.Power;

public interface AdminServiceDao {
	public String readPwdByName(String adminAccount) ;
	public boolean adminRegister(Admin admin);
	public boolean adminLogin(Admin admin);
	public List<String> readRolesByName(String adminAccount);
	public boolean addAdmin(Admin admin);
	boolean author_updateAdmin(Admin admin);
    boolean deleteAdmin(Admin admin);
    boolean deleteAllAdmin(String idAll);
    boolean readAdmin();
    public boolean registerSuperAdmin();
    boolean apportAdmin(Admin admin, String powers);
}
