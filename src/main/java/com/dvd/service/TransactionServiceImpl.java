package com.dvd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dvd.dao.TransactionDao;
import com.dvd.entity.Transaction;

/**
 * This class is service where storage service of Transaction.
 * @author Admin
 *
 */
@Service
@Transactional
public class TransactionServiceImpl implements TransactionService{

	/**
	 * Autowrite TransactionDao
	 */
	@Autowired
	private TransactionDao transactionDao;
	
	@Override
	public void addTransaction(Transaction transaction) {
		transactionDao.addTransaction(transaction);
	}

	@Override
	public int getMaxId() {
		return transactionDao.getMaxId();
	}

	@Override
	public long countTransaction() {
		return transactionDao.getCountTransaction();
	}

	@Override
	public double getRevenueOfEarchMounth(int i) {
		return transactionDao.getRevenueOfEarchMounth(i);
	}

	@Override
	public List<Transaction> getTransaction(int start, int total,int id) {
		return transactionDao.getTransaction(start,total,id);
	}

	@Override
	public List<Transaction> getAllTransaction(int id) {
		return transactionDao.getAllTransaction(id);
	}

	@Override
	public void deleteTransaction(int transactionId) {
		transactionDao.deleteTransaction(transactionId);
	}

	
}
