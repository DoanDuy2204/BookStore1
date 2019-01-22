package com.dvd.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dvd.entity.Order;

@Repository
public class OrderDaoImpl implements OrderDao{

	//Autowrite SessionFactory
	@Autowired
	private SessionFactory sessionFactory;

	//Add a Order
	@Override
	public void addOrder(Order order) {
		//Create Session
		Session session = sessionFactory.getCurrentSession();
		//Save order
		session.save(order);
	}

	@Override
	public void updateOrder(int quantity, Double amount, int id) {
		//Create session
		Session session = sessionFactory.getCurrentSession();
		//Get Order
		Order order = session.get(Order.class, id);
		//Update Order
		order.setQuantity(quantity);
		order.setAmount(amount);
	}

	//Delete Order by Id
	@Override
	public void deleteOrder(int id) {
		//Create Session
		Session session = sessionFactory.getCurrentSession();
		//Delete Order
		Order order = session.get(Order.class, id);
		session.delete(order);
	}
	

}
