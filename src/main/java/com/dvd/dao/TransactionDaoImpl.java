package com.dvd.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dvd.entity.Transaction;
/**
 * This class is repository where storage data and accept database.
 * @author Admin
 *
 */
@Repository
public class TransactionDaoImpl implements TransactionDao {

	/**
	 * @Autowrite SessionFactory
	 */
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * This method is used to Add Transaction new in DB.
	 * 
	 * @Override method of TransactionDao
	 */
	@Override
	public void addTransaction(Transaction transaction) {
		// Create Session
		Session session = sessionFactory.getCurrentSession();
		// Add Transaction in database
		session.save(transaction);
	}

	/**
	 * This is method used to Get Max(Id) in Database.
	 * 
	 * @Override Method of TransactionDao
	 */
	@Override
	public int getMaxId() {
		// create session
		Session session = sessionFactory.getCurrentSession();
		// Create Query
		Query<Integer> row = session.createQuery("SELECT MAX(t.id) from Transaction t", Integer.class);
		row.setFirstResult(0);
		row.setMaxResults(1);
		return row.getSingleResult();
	}

	/**
	 * This method is used to counter Transaction have in Database.
	 * 
	 * @Override Method of transactionDao
	 */
	@Override
	public long getCountTransaction() {
		// Create Session
		Session session = sessionFactory.getCurrentSession();
		// Create Query
		Query<Long> row = session.createQuery("SELECT COUNT(t.id) from Transaction t", Long.class);
		return row.getSingleResult();
	}

	/**
	 * Override Method getRevenuOfEarchMount() Of TransactionDao. This method is
	 * used to calculator revenue in Database.
	 */
	@Override
	public double getRevenueOfEarchMounth(int i) {
		// Create session
		Session session = sessionFactory.getCurrentSession();
		// Create Query
		Query<Double> row = session.createQuery("SELECT AVG(amount) FROM Transaction t where month(t.doc)=:i",
				Double.class);
		row.setParameter("i", i);
		Double revenue = (Double) row.getSingleResult();
		if (revenue == null)
			return 0;
		return row.getSingleResult();
	}

	/**
	 * Override Method getTransaction(int start, int total) of transactionDao. This
	 * method is used to get List<Transaction> begin = start and size = total
	 */
	@Override
	public List<Transaction> getTransaction(int start, int total, int id) {
		// Create session
		Session session = sessionFactory.getCurrentSession();
		// Create Query
		Query<Transaction> queries = session.createQuery("FROM Transaction t "+((id==(-1))?"":(" Where t.id="+id)), Transaction.class);
		queries.setFirstResult(start);
		queries.setMaxResults(total);
		return queries.getResultList();
	}

	/**
	 * This method is used to Get All Transaction in DB.
	 * 
	 * @Override Method getAllTransaction() of TransactionDao.
	 */
	@Override
	public List<Transaction> getAllTransaction(int id) {
		String query = "From Transaction t" + ((id == -1) ? "" : ("where t.id=" + id));
		return sessionFactory.getCurrentSession().createQuery(query, Transaction.class).getResultList();
	}

	/**
	 * This method is used to delete transaction in DB with transactionId.
	 * @param transactionId : id of transaction want to delete.
	 */
	@Override
	public void deleteTransaction(int transactionId) {
		//Create sesssion
		Session session = sessionFactory.getCurrentSession();
		session.delete(session.get(Transaction.class,transactionId));
	}

}
