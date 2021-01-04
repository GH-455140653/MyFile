package com.dqpi.edu.User.Service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.dqpi.edu.User.Dao.UserDao;
import com.dqpi.edu.User.Model.User;

@Component
public class UserService {
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	@Resource(name="u2")
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public void add(User user) {
		this.userDao.add(user);
	}
}
