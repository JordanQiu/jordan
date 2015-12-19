package com.jordan.dao;

import java.util.List;

import com.jordan.domain.User;

public interface UserDao {
     public void createUser(User user) ;
     public void editUser(User user, int id);
     public void deleteUser(int id);
     public List<User> queryUser();
	 public User saveUser(User ser) throws Exception;
}
