package com.dvd.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
//import java.util.Date;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dvd.entity.Book;

/**
 * This class is Repository where storage data and provide accepts to database.
 * @author Admin
 *
 */
@Repository
public class BookDaoImpl implements BookDao {

	/**
	 * @Autowrite SessionFactory bean 
	 */
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * This method is used to Get All Book in DB.
	 * @return
	 * List<Book>
	 */
	@Override
	public List<Book> getAllBook() {
		return sessionFactory.getCurrentSession()
				.createQuery("From Book",Book.class).getResultList();
	}

	/**
	 * This method is used to Get All Book by Trend and start = start and size = total.
	 * @return 
	 * List<Book>
	 */
	@Override
	public List<Book> getAllBookByTrend(int start, int total) {
		Session session = sessionFactory.getCurrentSession();
		Query<Book> rows = session.createQuery("from Book b order by b.star desc",Book.class);
		rows.setFirstResult(start);
		rows.setMaxResults(total);
		return rows.getResultList();
	}
	
	/**
	 * This method is used to get All Book by Price and sort by DESC.
	 * Start = start and Length = total.
	 * @param start
	 * @param total
	 * @param check
	 * @return
	 * List<Book>
	 */
	@Override
	public List<Book> getAllBookPriceDesc(int start, int total, int check) {
		//Create Session
		Session session = sessionFactory.getCurrentSession();
		//Create Query
		Query<Book> rows = session.createQuery("from Book b order by b.price desc",Book.class);
		if(check!=-1) {
			rows.setFirstResult(start);
			rows.setMaxResults(total);
		}
		//Create List<Book>
		List<Book> books = rows.getResultList();
		/** Use javacore collection 
		List<Book> books1 = sessionFactory.getCurrentSession().createQuery("from Book",Book.class).getResultList();
		Collections.sort(books1, new Comparator<Book>() {

			@Override
			public int compare(Book b1, Book b2) {
				return b1.getPrice()>b2.getPrice() ? 1 : -1;
			}
		}); */
		return books;
	}

	/**
	 * This method is used to Get All Book follow Price and sort by ASC.
	 * It starts = start and Length = total.
	 * @return
	 * List<Book>
	 */
	@Override
	public List<Book> getAllBookPriceAsc(int start, int total,int check) {
		// Create Session
		Session session = sessionFactory.getCurrentSession();
		// Create Query
		Query<Book> rows = session.createQuery("from Book b order by b.price asc", Book.class);
		if(check!=-1) {
			rows.setFirstResult(start);
			rows.setMaxResults(total);
		}
		// Create List<Book>
		List<Book> books = rows.getResultList();
		/**
		 * Use javacore collection List<Book> books1 =
		 * sessionFactory.getCurrentSession().createQuery("from Book",Book.class).
		 * getResultList(); Collections.sort(books1, new Comparator<Book>() {
		 * 
		 * @Override public int compare(Book b1, Book b2) { return
		 * b1.getPrice()>b2.getPrice() ? -1 : 1; } });
		 */
		return books;
	}
	
	/**
	 * This method is used to Get All Book follow View and sort by Desc.
	 * It starts = start and length = total.
	 * @return
	 * List<Book>
	 */
	@Override
	public List<Book> getAllBookViewDese(int start, int total) {
		//Create session
		Session session = sessionFactory.getCurrentSession();
		//Create Object Query
		Query<Book> rows = 	session.createQuery("from Book b order by b.view desc",Book.class)
									.setFirstResult(start).setMaxResults(total);
		//Create List<Book>
		List<Book> books = rows.getResultList();
		//Use java core
		/** List<Book> books1 = sessionFactory.getCurrentSession().createQuery("from Book",Book.class).getResultList();
		Collections.sort(books1, new Comparator<Book>() {

			@Override
			public int compare(Book b1, Book b2) {
				return b1.getView()>b2.getView() ? 1 : -1;
			}
		});
		List<Book> booksThen = new ArrayList<Book>();
		for(int i=0;i<books1.size()-1;i++)
			if(i>=start || i< total) 
				booksThen.add(books1.get(i)); */
		return books;
	}

	/**
	 * 
	 * This method is used to Get All Book follow Name from client send Server.
	 * @return
	 * List<Book>
	 */
	@Override
	public List<Book> getAllBookSearch(int start, int total,String name, int check) {
		//Create Session
		Session session = sessionFactory.getCurrentSession();
		//Create Query<Book>
		Query<Book> rows = session.createQuery("from Book b where lower(b.name) "
									+ "like concat('%',convert(lower(:name),Binary),'%')",Book.class)
									.setParameter("name", name);
		if(check!=-1) {
			rows.setFirstResult(start);
			rows.setMaxResults(total);
		}
		//Get result list
		List<Book> books = rows.getResultList();
		//Use java core
		/** List<Book> book1s = session.createQuery("from Book ",Book.class).getResultList();
		List<Book> book1new = new ArrayList<Book>();
		for(int i=0;i<book1s.size()-1;i++) {
			if(i>=start || i< total ) {
				Book book = book1s.get(i);
				String bName = book.getName().toLowerCase();
				if(bName.contains(name.toLowerCase())) {
					book1new.add(book);
				}
			}
		} */
		return books;
	}
	
	/**
	 * This method is get All Book follow Date.
	 * @return
	 * List<Book>
	 */
	@Override 
	public List<Book> getAllBookByDate(int start, int total){
		//Create 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//Create session
		Session session = sessionFactory.getCurrentSession();
		//Create Query
		Query<Book> rows = session.createQuery("from Book ",Book.class);
		//Create List<Book> 
		List<Book> books = rows.getResultList();
		Collections.sort(books, new Comparator<Book>() {
			@Override
			public int compare(Book o1, Book o2) {
				try {
					return sdf.parse(o1.getDoc()).after(sdf.parse(o2.getDoc())) ? 1:-1;
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return 0;
			}
		});
		List<Book> booksNew = new ArrayList<Book>();
		int count = 0;
		for(int i=0;i<books.size();i++) {
			if(i>=start && count<total) {
				booksNew.add(books.get(i));
				count++;
			}
		}
		return booksNew; 
	}

	/**
	 * This method is used to Get All Book follow category.
	 * @return 
	 * List<Book>
	 */
	@Override
	public List<Book> getAllBookByCategory(int start, int total, int category_id) {
		//Create Session
		Session session = sessionFactory.getCurrentSession();
		//Create Query 
		Query<Book> querys = session.createQuery("from Book b where b.category.id= :category_id",Book.class)
									.setParameter("category_id", category_id); 
		//Check total
		if(total!=0) {
			querys.setFirstResult(start);
			querys.setMaxResults(total);
		}
		return querys.getResultList();
	}

	/**
	 * This method is used to Get All Book follow PublishingHouse.
	 * It starts = start and length = total.
	 * @return
	 * List<Book>
	 */
	@Override
	public List<Book> getAllBookByPublishingHouse(int start, int total, int publishingHouse_id) {
		return sessionFactory.getCurrentSession()
				.createQuery("from Book b where b.publishingHouse.id = :publishingHouse_id",Book.class)
				.setParameter("publishingHouse_id", publishingHouse_id)
				.setFirstResult(start).setMaxResults(total).getResultList();
	}
	
	/**
	 * This method is used to Get All Book and start = start, length = total.
	 * @return
	 * List<Book>
	 */
	@Override
	public List<Book> getAllBook(int start, int total) {
		//Create session
		Session session = sessionFactory.getCurrentSession();
		//Create Query 
		Query<Book> querys = session.createQuery("from Book b",Book.class);
		querys.setFirstResult(start);
		querys.setMaxResults(total);
		return querys.getResultList();
	}

	/**
	 * This method is used to get All Book follow CategoryId.
	 * @return
	 * List<Book>
	 */
	@Override
	public List<Book> getAllBookbyCategory(int id) {
		return sessionFactory.getCurrentSession().createQuery("from Book b where b.category.id=:id",Book.class)
							.setParameter("id", id).getResultList();
	}

	/**
	 * This method is used to Get All Book follow PublishingHouse Id.
	 * @return
	 * List<Book>
	 */
	@Override
	public List<Book> getAllBookByPublishingHouse(int id) {
		return sessionFactory.getCurrentSession().createQuery("from Book b where b.publishingHouse.id=:id",Book.class)
							.setParameter("id", id).getResultList();
	}
	
	/**
	 * This method is used to Get All Book follow cost.
	 * @param nPage : start of  Page
	 * @param total : lenght of page
	 * @param min : value min of cost
	 * @param max : value max of cost
	 * @param check : examples (-1 : prints all getBookByCost) reverse ...
	 * @return
	 * List<Book>
	 */
	@Override
	public List<Book> getAllBookByCost(int nPage, int total, double min, double max, int check){
		//Create session
		Session session = sessionFactory.getCurrentSession();
		//Create query
		Query<Book> rows = session.createQuery("from Book b where (b.price > :min)" 
							+( max>0 ? " and (b.price < :max)" :" " ) 
							+ " order by b.price asc",Book.class);
		rows.setParameter("min", min);
		if(max!=(-1))
			rows.setParameter("max", max);
		if(check==-1) {
			rows.setFirstResult(nPage);
			rows.setMaxResults(total);
		}
		return rows.getResultList();
	}

	/**
	 * This method is Get All Book follow SoldNumber.
	 * @param start : start of page
	 * @param total : length  of page
	 * @return List<Book>
	 */
	@Override
	public List<Book> getAllBookBySoldNumber(int start, int total) {
		return sessionFactory.getCurrentSession().createQuery("from Book b order by b.soldNumber Desc",Book.class)
												.setFirstResult(start).setMaxResults(total).getResultList();
	}

	/**
	 * This method is used to get All Book follow Discount.
	 * @param start : start of Page
	 * @param total : length of Page
	 * @return List<Book>
	 */
	@Override
	public List<Book> getAllBookByDiscount(int start, int total) {
		return sessionFactory.getCurrentSession().createQuery("from Book b order by b.discount Desc",Book.class)
							.setFirstResult(start).setMaxResults(total).getResultList();
	}

	/**
	 * This method is used to Get Sum View Of All Book in DataBase.
	 * @return sum : sum view all book.
	 */
	@Override
	public long getSumViewOfAllBook() {
		//Create session 
		Session session = sessionFactory.getCurrentSession();
		//Create Query 
		Query<Long> row = session.createQuery("SELECT SUM(b.view) FROM Book b ",Long.class);
		long sum = row.getSingleResult();
		return sum;
	}
	
	/**
	 * This method is used to delete book pass Id of Book.
	 * @param bookId : id of Book
	 */
	@Override
	public void deleteBook(int bookId) {
		//create session
		Session session = sessionFactory.getCurrentSession();
		session.delete(session.get(Book.class, bookId));
	}	
	
	/**
	 * This method is used to get Book by Id.
	 * @param bookId : Id of Book
	 * @return Book
	 */
	@Override
	public Book getBookById(int bookId) {
		return sessionFactory.getCurrentSession().get(Book.class, bookId);
	}
	
	/**
	 * This method is used to update book.
	 * @param book : new Book 
	 * @return 
	 */
	@Override
	public void updateBook(Book book) {
		//Create session
		Session session = sessionFactory.getCurrentSession();
		Book bookOld = session.get(Book.class, book.getId());
		bookOld.setName(book.getName());
		bookOld.setCategory(book.getCategory());
		bookOld.setPublishingHouse(book.getPublishingHouse());
		bookOld.setAuthors(book.getAuthors());
		bookOld.setDiscount(book.getDiscount());
		bookOld.setQuantity(book.getQuantity());
	}
}
