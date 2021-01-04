package com.NGU.ssh.Service;

import com.NGU.ssh.DAO.AdminDao;
import com.NGU.ssh.DAO.AdminServiceDao;
import com.NGU.ssh.Model.Admin;
import com.NGU.ssh.Model.Admin_logindate;
import com.NGU.ssh.Model.Power;
import com.NGU.ssh.Util.functionHelper;
import com.opensymphony.xwork2.ActionContext;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class AdminService implements AdminServiceDao {
	private AdminDao adminDao;
	private Admin_logindate admin_logindate;
	private functionHelper helper;
	//管理员注册
	@Transactional
	public boolean adminRegister(Admin admin) {
		Date bornDate = new Date();
		List<Admin> adminList = adminDao.getAdminMsg();
		/* 管理员存在性判断 */

		// 超管写入
		if (adminList.size() == 0) {
			registerSuperAdmin();
			// 更新列表，防止普通用户和超管重名
			adminList = adminDao.getAdminMsg();
		}

		/* 管理员存在性判断 */

		for (Admin ad : adminList) {
			if (admin.getAdmin_account().equals(ad.getAdmin_account())) {
				System.out.println("管理员账号已存在！");
				return false;
			}
		}
		admin.setAdmin_borndate(bornDate);
		return adminDao.saveAdmin(admin);
	}

	// 管理员登录
	@Transactional
	public boolean adminLogin(Admin admin) {
		Date loginDate = new Date();
		List<Admin> adminList = adminDao.getAdminMsg();
		List<Admin> admins = new ArrayList<>();
		for (Admin admin_member : adminList) {
			if (!admin_member.getAdmin_account().equals("sadmin")) {
				admins.add(admin_member);
			}
		}
		ActionContext.getContext().getSession().put("adminList", admins);
		// 返回前台数据
		System.out.println(admin.getAdmin_account());
		for (Admin admin2 : adminList) {
			if (admin2.getAdmin_account().equals(admin.getAdmin_account())) {
				ActionContext.getContext().getSession().put("adminName", admin2.getAdmin_name());
				ActionContext.getContext().getSession().put("adminImage", admin2.getAdmin_icon());
				ActionContext.getContext().getSession().put("adminAccount", admin2.getAdmin_account());
				ActionContext.getContext().getSession().put("adminRegisterDate", helper.dateHandle(admin2.getAdmin_borndate()));
//				ActionContext.getContext().getSession().put("adminLastLoginTime", admin2.getAdmin_logindates());
				ActionContext.getContext().getSession().put("PowerList", null);
			}
		}
		return true;
	}

	public functionHelper getHelper() {
		return helper;
	}

	@Resource
	public void setHelper(functionHelper helper) {
		this.helper = helper;
	}

	public Admin_logindate getAdmin_logindate() {
		return admin_logindate;
	}

	@Resource
	public void setAdmin_logindate(Admin_logindate admin_logindate) {
		this.admin_logindate = admin_logindate;
	}

	public AdminDao getAdminDao() {
		return adminDao;
	}

	@Resource
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}
	//根据账号查询密码
	@Transactional(readOnly = true)
	public String readPwdByName(String adminAccount) {
		String pwd = "";
		List<Admin> admins = adminDao.getAdminMsg();
		for (Admin admin_get : admins) {
			if (adminAccount.equals(admin_get.getAdmin_account())) {
				pwd = admin_get.getAdmin_password();
//				System.out.println("cccccc");
			}
		}
		return pwd;
	}
	//根据账号查询权限
	@Transactional(readOnly = true)
	public List<String> readRolesByName(String adminAccount) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<>();
		Admin a = adminDao.author_readAdminByAccount(adminAccount);
		Iterator<Power> it = a.getPowers().iterator();
		while (it.hasNext()) {
			list.add(it.next().getPower_name());
//			System.out.println("哈哈哈哈哈哈");
		}
		return list;
	}

	// 添加管理员
	@Transactional
	public boolean addAdmin(Admin admin) {
		Admin a = adminDao.author_readAdmin(admin);
		a.setAdmin_desc(admin.getAdmin_desc());
		adminDao.author_updateAdmin(a);
		List<Admin> admins = new ArrayList<>();
		List<Admin> adminList = adminDao.getAdminMsg();
		List<Power> powers = new ArrayList<>();
		for (Admin admin2 : adminList) {
			if (admin2.getAdmin_desc() != null) {
				if (!admin2.getAdmin_account().equals("sadmin")) {
					admins.add(admin2);
					Iterator<Power> iterator = admin2.getPowers().iterator();
					while (iterator.hasNext()) {
						powers.add(iterator.next());
					}
				}
			} else {
//				System.out.println("111");
			}
		}
		author_Page(admins);
		if (powers.size() == 0) {
			ActionContext.getContext().getSession().put("PowerList", null);
		} else {
			ActionContext.getContext().getSession().put("PowerList", powers);
		}
		return true;
	}

	// 删除管理员
	@Transactional
	public boolean deleteAdmin(Admin admin) {
		Admin a = adminDao.author_readAdmin(admin);
		for (Power power : a.getPowers()) {
			System.out.println(power.getPower_name());
			power.getAdmins().remove(a);
//			System.out.println("111111");
		}
		adminDao.author_updateAdmin(a);
		List<Admin> adminList = adminDao.getAdminMsg();
		List<Admin> admins = new ArrayList<>();
		for (Admin admin2 : adminList) {
			if (!admin2.getAdmin_account().equals("sadmin")) {
				if (!admin2.getAdmin_account().equals(a.getAdmin_account()))
					admins.add(admin2);
			}
		}
		author_Page(admins);
		return true;
	}

	// 修改管理员
	@Transactional
	public boolean author_updateAdmin(Admin admin) {
		Admin a = adminDao.author_readAdmin(admin);
		a.setAdmin_desc(admin.getAdmin_desc());
		adminDao.author_updateAdmin(a);
		List<Admin> adminList = adminDao.getAdminMsg();
		List<Admin> admins = new ArrayList<>();
		for (Admin admin2 : adminList) {
			if (!admin2.getAdmin_account().equals("sadmin"))
				admins.add(admin2);
		}
		author_Page(admins);
		return true;
	}

	// 实现分页
	public boolean author_Page(List<Admin> adminList) {
		int pageNos; // 当前页数
		int count=0;
		if(adminList!=null){
			count = adminList.size();// 总条数
		}else{
			count=0;
		}
		System.out.println("修改修改修改总条数为:" + count);
		int countPage;// 总页数
		// 取决于每页的数目奇数还是偶数，现在为偶数
		if (count % 2 == 0) {
			countPage = count / 2;// 每页两条数目的总页数
			System.out.println(count + "总条数");
			System.out.println(countPage + "总页数");
		} else {
			countPage = count / 2 + 1;
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		if (request.getParameter("pageNos") == null || Integer.parseInt(request.getParameter("pageNos")) < 1) {
			pageNos = 1;
		} else {
			pageNos = Integer.parseInt(request.getParameter("pageNos"));
		}
		System.out.println("当前页数为" + pageNos);
		ActionContext.getContext().getSession().put("pageNos", pageNos);
		ActionContext.getContext().getSession().put("AdminList", adminList);
		ActionContext.getContext().getSession().put("countPage", countPage);
		return true;
	}

	// 批量删除管理员
	@Transactional
	public boolean deleteAllAdmin(String idAll) {
		// TODO Auto-generated method stub
		String[] idAllOne = null;
		if (!idAll.equals("")) {
			idAllOne = idAll.split(",");
		}
		for (int i = 0; i < idAllOne.length; i++) {
			System.out.println("六点四十打的");
			Admin a = adminDao.author_readAdminByAccount(idAllOne[i]);
			for (Power power : a.getPowers()) {
				power.getAdmins().remove(a);
			}
			adminDao.author_updateAdmin(a);
		}
		List<Admin> AdminList = adminDao.getAdminMsg();
		List<Admin> admins = new ArrayList<>();
		for (Admin admin : AdminList) {
			if (!admin.getAdmin_account().equals("sadmin")) {
				for (int i = 0; i < idAllOne.length; i++) {
					Admin a = adminDao.author_readAdminByAccount(idAllOne[i]);
					if (!admin.getAdmin_account().equals(a.getAdmin_account())) {
//						System.out.println(admin.getAdmin_account()+"zzzzzzzzzzz");
						admins.add(admin);
					}
				}
			}
		}
		admins=null;
		List<Admin> admins2=adminDao.getAdminMsg();
		for(Admin admin:admins2){
			if(!admin.getAdmin_account().equals("sadmin")){
				admin.setAdmin_desc(null);
				adminDao.author_updateAdmin(admin);
			}
		}
		author_Page(admins);
		return true;
	}

	// 查询管理员
	@Transactional(readOnly = true)
	public boolean readAdmin() {
		List<Admin> admins = new ArrayList<>();
		List<Admin> adminList = adminDao.getAdminMsg();
		for (Admin admin : adminList) {
			if (!admin.getAdmin_account().equals("sadmin")) {
				admins.add(admin);
			}
		}
		author_Page(admins);
		return true;
	}

	// 存储超管信息
	@Transactional
	public boolean registerSuperAdmin() {
		String[] str = { "超管", "评论管理", "用户管理", "报表管理", "视频管理", "分类管理" };
		for (int i = 0; i < str.length; i++) {
			Power power2 = new Power();
			power2.setPower_id(i + 1);
			power2.setPower_name(str[i]);
			adminDao.author_savePower(power2);
		}
		Admin admin = new Admin();
		admin.setAdmin_account("sadmin");
		Date date = new Date(1);
		admin.setAdmin_borndate(date);
		admin.setAdmin_desc("超管");
		admin.setAdmin_icon("SuperAdmin.png");
		admin.setAdmin_name("超管");
		admin.setAdmin_password("123");
		Power power = adminDao.author_readPower(1);
		admin.getPowers().add(power);
		power.getAdmins().add(admin);
		adminDao.author_saveAdmin(admin);
		adminDao.author_savePower(power);
		return true;
	}

	// 权限分配
	@Transactional
	public boolean apportAdmin(Admin admin, String powers) {
		// TODO Auto-generated method stub
		Admin a = adminDao.author_readAdmin(admin);
		String[] stringPowers = null;
		int[] array = new int[6];
		String newPowers=powers.trim();
		if (!newPowers.equals("")) {
			stringPowers = newPowers.split(",");
		}
		for (int j = 0; j < stringPowers.length ; j++) {
			array[j] = Integer.parseInt(stringPowers[j]);
		}
		for (int i = 0; i < stringPowers.length ; i++) {
			Power power = adminDao.author_readPower(array[i]);
			a.getPowers().add(power);
			power.getAdmins().add(a);
			adminDao.author_saveAdmin(a);
			adminDao.author_savePower(power);
		}
		List<Power> adminpowers = new ArrayList<>();
		List<Power> list = adminDao.getPowerMsg();
		System.out.println(list.size());
		System.out.println(list + "权限list");
		for (Power power2 : list) {
			Iterator<Admin> iterator = power2.getAdmins().iterator();
			System.out.println(iterator + "权限权限iterator");
			while (iterator.hasNext()) {
				String adminname = iterator.next().getAdmin_account();
				System.out.println(adminname + "账号账号");
				if (adminname.equals(admin.getAdmin_account())) {
					adminpowers.add(power2);
				}
			}
		}
		ActionContext.getContext().getSession().put("PowerList", adminpowers);
		return true;
	}
}
