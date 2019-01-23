package com.dvd.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dvd.entity.Author;
/**
 * This is repository where contain data/object of author and enable accept author in BD.
 * @author Admin
 *
 */
@Repository
public class AuthorDaoImpl implements AuthorDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * This method is used to get All AUthor in DB.
	 * @param name : name of Author want to search.
	 * @return 
	 * 	List<Author>
	 */
	@Override
	public List<Author> getAllAuthor(String name) {
		String query = "From Author a " + ((name==null)?"" : ("where a.name="+name));
		return sessionFactory.getCurrentSession().createQuery(query,Author.class).getResultList();
	}

	/**
	 * This method id used to get Author by IdAuthor.
	 * @param idAuthor : id of Author
	 * @return 
	 * 		Author.class
	 */
	@Override
	public List<Author> getListAuthorById(int[] idAuthor) {
		String arr = "";
		for(int i=0;i<idAuthor.length;i++)
			arr += ""+ idAuthor[i]+","; 
		String newArr = arr.substring(0, arr.length()-1);
		System.out.println(newArr);
		String query = "From Author a where a.id IN("+newArr+")";
		return sessionFactory.getCurrentSession().createQuery(query,Author.class).getResultList();
	}

}
