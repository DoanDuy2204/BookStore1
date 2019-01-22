package com.dvd.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dvd.entity.Category;

/**
 * This class is repository which used to contain data/object and accept DB to get Data.
 * @author Admin
 *
 */
@Repository // is a store to contain data/object
public class CategoryDaoImpl implements CategoryDao{

	//Autowrite
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * This method is used to get category in DB.
	 * @param total : total of category .
	 * @return 
	 * 		List<Category>
	 */
	@Override
	public List<Category> getCategory(int total) {
		Session session = sessionFactory.getCurrentSession();
		Query<Category> query = session.createQuery("from Category",Category.class);
		if(total!=-1) query.setFirstResult(0).setMaxResults(total);
		return query.getResultList();
	}

	/**
	 * This method is used to get Id of First Category in List<Category>.
	 * @return int : id of category.
	 */
	@Override
	public int getIdFirstCategory() {
		//Create Session 
		Session session = sessionFactory.getCurrentSession();
		//Create Query
		Query<Category> rows = session.createQuery("from Category",Category.class)
												.setFirstResult(0).setMaxResults(1);
		//Create Category
		Category category = rows.getSingleResult();
		return category.getId() ;
	}

	/**
	 * This method is used to getCategory by Id.
	 * @param int : id of Category
	 * @return
	 * 		Category.class
	 */
	@Override 
	public Category getCategoryById(int idCategory) {
		return sessionFactory.getCurrentSession().get(Category.class, idCategory);
	}
	
}
