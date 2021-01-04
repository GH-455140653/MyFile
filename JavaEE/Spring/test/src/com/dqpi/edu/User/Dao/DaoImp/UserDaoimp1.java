package com.dqpi.edu.User.Dao.DaoImp;

import org.springframework.stereotype.Component;

import com.dqpi.edu.User.Dao.UserDao;
import com.dqpi.edu.User.Model.User;

@Component("u1")
public class UserDaoimp1 implements UserDao{
	
	@Override
	public void add(User user) {
		System.out.println("Oracle useradd!!!");
		
	}
}
