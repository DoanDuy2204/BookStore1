package com.dvd.dao;

import com.dvd.entity.Order;

public interface OrderDao {
	
	public void addOrder(Order order);

	public void updateOrder(int quantity, Double amount, int id);

	public void deleteOrder(int id);
}
