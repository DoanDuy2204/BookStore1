package com.dvd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dvd.dao.UserDao;
import com.dvd.entity.User;

/**
 * This class is Service where is storage some service of User.
 * @author Admin
 *
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

	//Autowrite UserDao
	@Autowired
	private UserDao userDao;
	
	@Override
	public User checkUser(String username, String pass) {
		return userDao.checkUser(username, pass);
	}

	@Override
	public long countUserInDB() {
		return userDao.countUserInDB();
	}

	@Override
	public List<User> getAllUser(String name) {
		return userDao.getAllUser(name);
	}
	
	@Override
	public List<User> getAllUser(int start, int total, String name){
		return userDao.getAllUser(start, total, name);
	}

	@Override
	public void disableUser(String userName) {
		userDao.disableUser(userName);
	}

	@Override
	public User getUser(String userName) {
		return userDao.getUser(userName);
	}

	@Override
	public void insertUser(User user) {
		userDao.insertUser(user);
	}
}
