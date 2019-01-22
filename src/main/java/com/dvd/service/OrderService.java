package com.dvd.service;

import com.dvd.entity.Order;

public interface OrderService {

	public void addOrder(Order order);

	public void updateOrder(int quantity, Double amount, int id);

	public void deleteOrder(int id);
}
