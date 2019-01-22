package com.dvd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dvd.dao.OrderDao;
import com.dvd.entity.Order;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{
	
	//Autowrite OrderDao
	@Autowired
	private OrderDao orderDao;

	//Add Order
	@Override
	public void addOrder(Order order) {
		orderDao.addOrder(order);
	}

	//Update Order
	@Override
	public void updateOrder(int quantity, Double amount, int id) {
		orderDao.updateOrder(quantity, amount, id);
	}

	//Delete Order
	@Override
	public void deleteOrder(int id) {
		orderDao.deleteOrder(id);
	}
	
	

}
