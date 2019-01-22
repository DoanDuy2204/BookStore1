package com.dvd.service;

import java.util.List;

import com.dvd.entity.Book;

public interface BookService {

	public List<Book> getAllBooks();
	public List<Book> getAllBook(int start, int total);
	public List<Book> getAllBookByTrend(int start,int total);
	public List<Book> getAllBookPriceDesc(int start,int total, int check);
	public List<Book> getAllBookPriceAsc(int start,int total, int check);
	public List<Book> getAllBookViewDese(int start,int total);
	public List<Book> getAllBookSearch(int start,int total,String name,int check);
	public List<Book> getAllBookByDate(int start, int total);
	public List<Book> getAllBookByCategoryId(int start,int total,int category_id);
	public List<Book> getAllBookByPublishingHouseId(int start,int total,int publishingHouse_id);
	public List<Book> getAllBookByCategory(int id);
	public List<Book> getAllByPublishingHouseId(int id);
	public List<Book> getAllBookByCost(int nPage,int total,double min, double max, int check);
	public List<Book> getAllBookBySoldNumber(int nPage, int total);
	public List<Book> getAllBook();
	public List<Book> getAllBookByDiscount(int nPage, int total);
	public Book getBookById(int bookId);
	public long getSumViewOfAllBook();
	public void deleteBook(int bookId);
	public void updateBook(Book book);
	
}
