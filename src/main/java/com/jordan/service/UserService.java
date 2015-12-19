package com.jordan.service;

import java.util.List;

import com.jordan.domain.User;

public interface UserService {
   public List<User> findUsers();
   public void createUser(User user);
  public User saveUsers(User user) throws Exception;
public void deleteUser(int id);
public void editUser(User user, int id);
}
