package com.NGU.ssh.Util;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import com.NGU.ssh.DAO.AdminServiceDao;

@Component
public class ShiroRealm extends AuthorizingRealm {

	public AdminServiceDao getAdminService() {
		return adminService;
	}
	public void setAdminService(AdminServiceDao adminService) {
		this.adminService = adminService;
	}
	@Resource
	  private AdminServiceDao adminService;
	  
	 
	//授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("第二次");
		String uname=principals.getPrimaryPrincipal().toString();
		List<String> roles=new ArrayList<String>();  //这个里面就是为了方便，我就定义了一个死的角色
		List<String> readroles=new ArrayList<>();
		roles=adminService.readRolesByName(uname);
		SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
		info.addRoles(roles); 
		return info;
	}
	//认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.out.println("第一次");
		UsernamePasswordToken usernamePasswordToken=(UsernamePasswordToken)token;
        String uname=usernamePasswordToken.getUsername();
        System.out.println("q1");
        if(uname.equals(""))
        	return null;
        else{
        String pwd=adminService.readPwdByName(uname);
        System.out.println(6666);
        SimpleAuthenticationInfo simpleAuthenticationInfo=new SimpleAuthenticationInfo(uname, pwd, this.getName());
        System.out.println("认证："+uname+"++++"+pwd);
		return simpleAuthenticationInfo;
        }
	}


}
