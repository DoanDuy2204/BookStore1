package com.dvd.service;

import java.util.List;

import com.dvd.entity.User;

public interface UserService {

	public List<User> getAllUser(int start, int total, String name);
	public List<User> getAllUser(String name);
	public User checkUser(String usarname, String pass);
	public long countUserInDB();
	public void disableUser(String userName);
}
