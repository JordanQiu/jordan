package com.jordan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jordan.domain.User;
import com.jordan.utility.JDBCUtilily;

public class UserDaoImpl implements UserDao {
   private Connection connection;
   private Statement statement;
   private PreparedStatement prepareStatement;
   private ResultSet resultSet;
	public void createUser(User user) {
		// TODO Auto-generated method stub

	}

	public void editUser(User user) {
		// TODO Auto-generated method stub

	}

	public void deleteUser(User user) {
		// TODO Auto-generated method stub

	}

	public List<User> queryUser() {
		List<User> userlist = new ArrayList();
	   
		connection =JDBCUtilily.getConnection();
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from user");
		while(resultSet.next()){
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				int age = resultSet.getInt(3);
				String pol_code = resultSet.getString(4);
				User user = new User();
				user.setAge(age);
				user.setName(name);
				user.setId(id);
				user.setPol_code(pol_code);
				userlist.add(user);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtilily.release(resultSet, statement, connection);
		}
		
		return userlist;
		
	}

	public User saveUser(User user) throws Exception{

		connection =JDBCUtilily.getConnection();
		try {
			statement = connection.createStatement();
//			statement.execute("INSERT INTO `user` (`id`, `name`, `age`, `pol_code`) VALUES ('23', 'wwww', '2', '442')");
			prepareStatement = connection.prepareStatement("INSERT INTO `user` (`id`, `name`, `age`, `pol_code`) VALUES (?,?,?,?)");
			prepareStatement.setInt(1, user.getId());
			prepareStatement.setString(2, user.getName());
			prepareStatement.setInt(3, user.getAge());
			prepareStatement.setString(4, user.getPol_code());
			
			prepareStatement.execute();
		} 

		catch (SQLException e) {
			throw e;
		}
		catch (Exception e) {
			throw e;
		}
		finally{
			
			JDBCUtilily.release(resultSet, prepareStatement, connection);
		}
		
		return null;
		
	
	}

	public void deleteUser(int id) {
		
		connection =JDBCUtilily.getConnection();
		try {
			
			prepareStatement = connection.prepareStatement("delete from user where id = ?");
			prepareStatement.setInt(1, id);
			
			prepareStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtilily.release(resultSet, prepareStatement, connection);
		}
		
	
		
	
		
	}

	public void editUser(User user, int id) {
		connection = JDBCUtilily.getConnection();
		try {
			prepareStatement = connection.prepareStatement("update user set id = ?,name=?,age=?,pol_code =? where id = ?");
			prepareStatement.setInt(1, user.getId());
			prepareStatement.setString(2, user.getName());
			prepareStatement.setInt(3, user.getAge());
			prepareStatement.setString(4, user.getPol_code());
			prepareStatement.setInt(5, id);
			prepareStatement.execute();
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			JDBCUtilily.release(resultSet, prepareStatement, connection);
		}
		
	}

}
