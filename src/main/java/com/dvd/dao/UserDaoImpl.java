package com.dvd.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.dvd.entity.Customer;
import com.dvd.entity.User;

/**
 * This class is Repository where storage data and accepts data in database.
 * @author Admin
 *
 */
@Repository
public class UserDaoImpl implements UserDao {

	/**
	 * Autowrite sessionFactory Bean
	 */
	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Autowrite BcryptPasswordEncoder Bean.
	 */
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	/**
	 * This method is used to check User in page Login.
	 * @param username : name of user send from client.
	 * @param pass : password of user send from client.
	 * @return 
	 * 	user if it's exists.
	 * 	null if it's not exists.
	 */
	@Override
	public User checkUser(String username, String pass) {
		//Create Session
		Session session = sessionFactory.getCurrentSession();
		//Create Query
		Query<User> rows = session.createQuery("from User u where u.userName=:user and u.enable=1",User.class);
		rows.setParameter("user", username);
		List<User> results = rows.getResultList();
		if(!results.isEmpty()) {
			User user = results.get(0);
			if(bCryptPasswordEncoder.matches(pass, user.getPassword())) 
				return user;
		}
		return null;
	}

	/**
	 * This method is used to count user in DB.
	 * @return
	 * long : number user
	 */
	@Override
	public long countUserInDB() {
		return sessionFactory.getCurrentSession().
			createQuery("SELECT COUNT(u.id) FROM User u WHERE u.role='CUSTOMER'",Long.class)
			.getSingleResult();
	}
	
	/**
	 * This method is used to get All User start = start and length = total
	 * @param start : start of page
	 * @param total : length of page
	 * @param name : name of user
	 * @return
	 * List<User>
	 */
	@Override 
	public List<User> getAllUser(int start,int total,String name){
		String query = "From User u where u.role IN ('CUSTOMER','EMPLOYEE') "+
					(name==null?"":" and lower(u.userName) like concat('%',convert('"+name.toLowerCase()+"',binary),'%')");
		return sessionFactory.getCurrentSession().createQuery(query,User.class).getResultList();
	}
	
	/**
	 * This method is used to get All User and infomation of its.
	 * @return 
	 * List<User>
	 */
	@Override
	public List<User> getAllUser(String name){
		String query = "From User u where u.role IN ('CUSTOMER','EMPLOYEE') "+(name==null ? "" : 
					(" and lower(u.userName) like concat('%',convert('"+name.toLowerCase()+"',binary),'%'"));
		return sessionFactory.getCurrentSession().createQuery(query,User.class).getResultList();
	}

	/**
	 * This method is used to disable User in database.
	 * @param userName : userName of User 
	 */
	@Override
	public void disableUser(String userName) {
		//Create session
		Session session = sessionFactory.getCurrentSession();
		User user = session.get(User.class, userName);
		user.setEnable(0);
	}

	/**
	 * This method is used to get User by userName.
	 * @param userName : userName of User
	 */
	@Override
	public User getUser(String userName) {
		return sessionFactory.getCurrentSession().get(User.class, userName);
	}

	/**
	 * This method is used to insert User in DB.
	 * @param user
	 * @return
	 */
	@Override
	public void insertUser(User user) {
		//create Session 
		Session session = sessionFactory.getCurrentSession();
		//Save user
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRole("CUSTOMER");
		user.setEnable(1);
		session.save(user);
		Customer customer = user.getCustomer();
		Date date = new Date();
		customer.setDoc(sdf.format(date));
		customer.setUser(user);
		session.save(customer);
	}
}
