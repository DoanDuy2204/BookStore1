package com.dvd.service;

import java.util.List;

import com.dvd.entity.Transaction;

public interface TransactionService {

	public List<Transaction> getAllTransaction(int id);
	public void addTransaction(Transaction Transaction);
	public int getMaxId();
	public long countTransaction();
	public double getRevenueOfEarchMounth(int i);
	public List<Transaction> getTransaction(int start,int total,int id);
	public void deleteTransaction(int transactionId);
}
