package com.dvd.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dvd.dao.BookDao;
import com.dvd.entity.Book;

@Service
@Transactional
public class BookServiceImpl implements BookService {

	@Autowired 
	private BookDao bookDao;
	@Override
	public List<Book> getAllBooks() {
		return bookDao.getAllBook();
	}
	@Override
	public List<Book> getAllBookByTrend(int start, int total) {
		return bookDao.getAllBookByTrend(start, total);
	}
	@Override
	public List<Book> getAllBookPriceDesc(int start, int total, int check) {
		return bookDao.getAllBookPriceDesc(start, total, check);
	}
	@Override
	public List<Book> getAllBookPriceAsc(int start, int total, int check) {
		return bookDao.getAllBookPriceAsc(start, total,check);
	}
	@Override
	public List<Book> getAllBookViewDese(int start, int total) {
		return bookDao.getAllBookViewDese(start, total);
	}
	@Override
	public List<Book> getAllBookSearch(int start, int total, String name,int check) {
		return bookDao.getAllBookSearch(start, total, name,check);
	}
	@Override
	public List<Book> getAllBookByDate(int start, int total) {
		return bookDao.getAllBookByDate(start,total);
	}
	@Override
	public List<Book> getAllBookByCategoryId(int start, int total, int category_id) {
		return bookDao.getAllBookByCategory(start, total, category_id);
	}
	@Override
	public List<Book> getAllBookByPublishingHouseId(int start, int total, int publishingHouse_id) {
		return bookDao.getAllBookByPublishingHouse(start, total, publishingHouse_id);
	}
	@Override
	public List<Book> getAllBook(int start, int total) {
		return bookDao.getAllBook(start, total);
	}
	@Override
	public List<Book> getAllBookByCategory(int id) {
		return bookDao.getAllBookbyCategory(id);
	}
	@Override
	public List<Book> getAllByPublishingHouseId(int id) {
		return bookDao.getAllBookByPublishingHouse(id);
	}
	@Override
	public List<Book> getAllBookByCost(int nPage, int total,double min, double max,int check) {
		return bookDao.getAllBookByCost(nPage, total, min, max,check);
	}
	@Override
	public List<Book> getAllBookBySoldNumber(int nPage, int total) {
		return bookDao.getAllBookBySoldNumber(nPage,total);
	}
	@Override
	public List<Book> getAllBook() {
			return bookDao.getAllBook();
	}
	@Override
	public List<Book> getAllBookByDiscount(int nPage, int total) {
		return bookDao.getAllBookByDiscount(nPage, total);
	}
	@Override
	public Book getBookById(int bookId) {
		return bookDao.getBookById(bookId);
	}
	@Override
	public long getSumViewOfAllBook() {
		return bookDao.getSumViewOfAllBook();
	}
	@Override
	public void deleteBook(int bookId) {
		bookDao.deleteBook(bookId);
	}
	@Override
	public void updateBook(Book book) {
		bookDao.updateBook(book);
	}
	

}
