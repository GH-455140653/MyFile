package com.NGU.ssh.DAO.Imp;

import com.NGU.ssh.DAO.AdminDao;
import com.NGU.ssh.Model.Admin;
import com.NGU.ssh.Model.Admin_logindate;
import com.NGU.ssh.Model.Power;
import com.NGU.ssh.Service.AdminService;
import com.NGU.ssh.Util.functionHelper;
import com.mysql.fabric.xmlrpc.base.Array;
import com.opensymphony.xwork2.ActionContext;
import com.sun.net.httpserver.Authenticator.Success;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class AdminDaoImp implements AdminDao {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// 存储管理员
	@Override
	public boolean saveAdmin(Admin admin) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.save(admin);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	// 存储登录时间
	@Override
	public void saveLoginTime(Admin_logindate admin_logindate) {
		Session session = sessionFactory.getCurrentSession();
		session.save(admin_logindate);
	}

	// 删除所有管理员
	@Override
	public boolean author_deleteAll(String hql) {
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("delete from admin where " + hql);
		q.executeUpdate();
		return true;
	}

	// 查询所有管理员
	@Override
	public List<Admin> getAdminMsg() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from admin");
		return (List<Admin>) query.list();
	}

	// 查询所有权限
	public List<Power> getPowerMsg() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from power");
		return (List<Power>) query.list();
	}

	// 修改管理员描述
	public void author_updateAdmin(Admin admin) {
		Session session = sessionFactory.getCurrentSession();
		session.update(admin);
	}

	// 查询出具体管理员
	public Admin author_readAdmin(Admin admin) {
		Session session = sessionFactory.getCurrentSession();
		Admin a = (Admin) session.get(Admin.class, admin.getAdmin_account());
		return a;
	}

	// 根据账号查询出具体管理员
	public Admin author_readAdminByAccount(String adminAccount) {
		Session session = sessionFactory.getCurrentSession();
		System.out.println(adminAccount + "zzzzzzzzz");
		Query query = session.createQuery("from admin where admin_account=" + "'" + adminAccount + "'");
		List<Admin> list = (List<Admin>) query.list();
		System.out.println(list.get(0).getAdmin_account() + "zzzzzzzz");
		return list.get(0);
	}

	// 查询出具体权限
	public Power author_readPower(int i) {
		Session session = sessionFactory.getCurrentSession();
		Power power = (Power) session.get(Power.class, i);
		return power;
	}

	// 存储权限
	public void author_savePower(Power power) {
		Session session = sessionFactory.getCurrentSession();
		session.save(power);
	}

	// 存储管理员
	public void author_saveAdmin(Admin admin) {
		Session session = sessionFactory.getCurrentSession();
		session.save(admin);
	}

}
