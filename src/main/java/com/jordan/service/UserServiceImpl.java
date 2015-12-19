package com.jordan.service;

import java.util.List;

import com.jordan.dao.UserDao;
import com.jordan.dao.UserDaoImpl;
import com.jordan.domain.User;

public class UserServiceImpl implements UserService {
      
	private UserDao userDao;
	public UserServiceImpl() {
		userDao = new UserDaoImpl();
	}
	public List<User> findUsers() {
		List<User> userlist = userDao.queryUser();
		return userlist;
	}



	public void createUser(User user) {
		// TODO Auto-generated method stub

	}
	public User saveUsers(User user) throws Exception{
		try {
			return userDao.saveUser(user);
		} catch (Exception e) {
			throw e;
		}
	}
	public void deleteUser(int id) {
		userDao.deleteUser(id);
		
	}
	public void editUser(User user, int id) {
		userDao.editUser(user,id);
		
		
	}

}
