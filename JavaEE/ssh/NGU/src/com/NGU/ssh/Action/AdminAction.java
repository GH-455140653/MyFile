package com.NGU.ssh.Action;

import com.NGU.ssh.Model.Admin;
import com.NGU.ssh.Model.Power;
import com.NGU.ssh.DAO.AdminServiceDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@Scope("prototype")
public class AdminAction extends ActionSupport {


	public String getPowers() {
		return powers;
	}

	public void setPowers(String powers) {
		this.powers = powers;
	}

	public String getIdAll() {
		return idAll;
	}

	public void setIdAll(String idAll) {
		this.idAll = idAll;
	}

	public AdminServiceDao getAdminService() {
		return adminService;
	}

    @Resource
	public void setAdminService(AdminServiceDao adminService) {
		this.adminService = adminService;
	}
    private String powers;	//权限分配权限号
    private String idAll;	//批量删除管理员账号
	private Admin admin;
    private Power power;
    private AdminServiceDao adminService;
    
    //注册账号
    public String register() {
        boolean flag = adminService.adminRegister(admin);
        if (flag) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }
    //管理员退出
    public String loginout() {
        ActionContext.getContext().getSession().clear();
        return SUCCESS;
    }
    
    //管理员登录
	public String login() {
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(admin.getAdmin_account(),admin.getAdmin_password());
		try { 
             //会自动去MyRealm这个类中的doGetAuthentication@RequiresPermissionsInfo和doGetAuthorizationInfo方法走一走，验证并授权
			 subject.login(token);
//             System.out.println("11111");
             adminService.adminLogin(admin);
             return SUCCESS;
     } catch (Exception e) {
             e.printStackTrace();
//             System.out.println("222+sda sad");
             ActionContext.getContext().put("errorMsg","账号或密码错误!");
             return ERROR;
     }
	}
	
	//权限添加
	public String add() {
		boolean flag = adminService.addAdmin(admin);
//		System.out.println(admin.getAdmin_desc()+"9999999999999");
        if (flag) {
            return SUCCESS;
        } else {
            return ERROR;
       }
	}
	//权限删除
	public String delete() {
		boolean flag = adminService.deleteAdmin(admin);
        if (flag) {
            return SUCCESS;
        } else {
            return ERROR;
       }
	}
	//批量删除
	public String deleteAll() {
		if(!idAll.equals("")){
			boolean flag = adminService.deleteAllAdmin(idAll);
			if (flag) {
	            return SUCCESS;
	        } else {
	            return ERROR;
	       }
		}else{
			ActionContext.getContext().put("errorMsg","没有进行批量选择!");
			return ERROR;
		}
		
        
	}
	//权限更新
	public String update() {
       
		boolean flag = adminService.author_updateAdmin(admin);	
//		System.out.println(admin.getAdmin_account()+"9999999999999");
        if (flag) {
            return SUCCESS;
        } else {
            return ERROR;
       }
	}
	
	//权限分配
	public String apport() {   
//		System.out.println(powers+"++++++++++++++++++++++");
//		System.out.println(admin.getAdmin_account()+"-------------");
		String fString=SUCCESS;
		if(!powers.equals(", ")){
			boolean flag = adminService.apportAdmin(admin,powers);	
			if(flag)
				fString=SUCCESS;
		}else{
			ActionContext.getContext().put("errorMsg","未分配权限!");
			fString=ERROR;
		}
		return fString;
       }
	
	//权限分页
	public String authorPagination() { 
		 adminService.readAdmin();
		 return SUCCESS;
	}

    public Power getPower() {
        return power;
    }

    @Resource
    public void setPower(Power power) {
        this.power = power;
    }

    public Admin getAdmin() {
        return admin;
    }

    @Resource
    public void setAdmin(Admin admin) {
        this.admin = admin;
    }


}
