package com.jordan.controller;

import java.util.List;

import com.jordan.domain.User;
import com.jordan.service.UserService;
import com.jordan.service.UserServiceImpl;

public class UserController {
	private UserService userService;
    private User user;
	public UserController() {
		userService = new UserServiceImpl();
	}
	
	
	public List<User> findUser(){
		return userService.findUsers();
	}


	public void saveUser(User user) {
		try {
			 userService.saveUsers(user);
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("error");
		}
	}





	public void deleteUser(int id) {
		userService.deleteUser(id);
		
	}


	public void editUser(User user, int id) {
		userService.editUser(user,id);
		
	}
	
}
