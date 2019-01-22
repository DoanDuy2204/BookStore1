package com.dvd.dao;

import java.util.List;

import com.dvd.entity.Transaction;

public interface TransactionDao {

	public List<Transaction> getAllTransaction(int id);
	public void addTransaction(Transaction transaction);
	public int getMaxId();
	public long getCountTransaction();
	public double getRevenueOfEarchMounth(int i);
	public List<Transaction> getTransaction(int start,int total, int id);
	public void deleteTransaction(int transactionId);
}
