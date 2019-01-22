package com.dvd.dao;

import java.util.List;

import com.dvd.entity.User;

public interface UserDao {

	public List<User> getAllUser(int start, int total, String name);
	public List<User> getAllUser(String name);
	public User checkUser(String pass, String user);
	public long countUserInDB();
	public void disableUser(String userName);
}
