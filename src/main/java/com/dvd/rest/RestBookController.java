package com.dvd.rest;

//import java.util.HashMap;
import java.util.List;
//import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dvd.entity.Book;
import com.dvd.service.BookService;
import com.dvd.service.CategoryService;
import com.dvd.service.PublishingHouseService;

@RestController
@RequestMapping("api")
public class RestBookController {

	//Autowrite BookService, Category Service
	@Autowired
	private BookService bookService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private PublishingHouseService publishingHouseService;
	
	//Get book Trend 
	@GetMapping("getBookTrend")
	public List<Book> getBookTrend(@RequestParam("d")int i) {
		int start = (i-1)*6;
		List<Book> listBookByTrend = bookService.getAllBookByTrend(start, 6);
		return listBookByTrend;
	}
	
	//Get book by category
	@GetMapping("getBookByCategory")
	public List<Book> getBookByCategory(@RequestParam("numberPage")int numberPage){
		int start = (numberPage -1)*10;
		List<Book> listBookByCategory = bookService.getAllBookByCategoryId(start, 10, categoryService.getIdCateogryFirst());
		return listBookByCategory;
	}
	
	//Get book by categoryId
	@GetMapping("getBookByCategoryId")
	public List<Book> getBookByCategoryId(HttpServletRequest req){
		int numberPage = Integer.parseInt(req.getParameter("numberPage"));
		int id = Integer.parseInt(req.getParameter("categoryId"));
		int total = Integer.parseInt(req.getParameter("total"));
		int start = (numberPage - 1 )* total;
		List<Book> listBookByCategory = bookService.getAllBookByCategoryId(start, total,id);
		return listBookByCategory;
	}
	
	//Get book by publishingHouseId
	@GetMapping("getBookByPublishingHouseId")
	public List<Book> getBookByPublishingId(HttpServletRequest req){
		int numberPage = Integer.parseInt(req.getParameter("numberPage"));
		int id = Integer.parseInt(req.getParameter("publishingHouseId"));
		int total = Integer.parseInt(req.getParameter("total"));
		int start = (numberPage - 1 )*total;
		List<Book> listBookByPublishingHouse = bookService.getAllBookByPublishingHouseId(start,total,id);
		return listBookByPublishingHouse;
	}
//	@GetMapping("getBookByCategory")
//	public Map<String,List<Book>> getBookByCategory(@RequestParam("numberPage")int numberPage){
//		int start = (numberPage - 1) *8;
//		List<Book> listBookByCategory = bookService.getAllBookByCategoryId(start, 8, CategoryService.getIdCateogryFirst());
//		List<Book> listAllBookByCategory = bookService.getAllBookByCategoryId(0, 0,CategoryService.getIdCateogryFirst());
//		Map<String,List<Book>> mapBooks = new HashMap<>();
//		mapBooks.put("listBookByCategory", listBookByCategory);
//		mapBooks.put("listAllBookByCategory", listAllBookByCategory);
//		return mapBooks;
//	}
	
	//Get books by PublishingHouse
	@GetMapping("getBookByPublishingHouse")
	public List<Book> getBookByPublishingHouse(@RequestParam("numberPage")int numberPage){
		int start = (numberPage -1)*10;
		List<Book> listBookByPublishingHouse = bookService.getAllBookByPublishingHouseId(start, 10, publishingHouseService.getIdPublishingHouseFirst());
		return listBookByPublishingHouse;
	}
	
	//Get books by NameSearch
	@GetMapping("getBookByName")
	public List<Book> getBookByName(@RequestParam("numberPage")int numberPage,@RequestParam("name")String name){
		int start = (numberPage-1)*12;
		List<Book> listBook = bookService.getAllBookSearch(start, 12, name,0);
		return listBook;
	}
	
	//Get books by SoldNumber
	@GetMapping("getBookBySoldNumber")
	public List<Book> getBookBySoldNumber(@RequestParam("numberPage")int numberPage){
		int start = (numberPage-1)*6;
		List<Book> books = bookService.getAllBookBySoldNumber(start, 6);
		return books;
	}

	// Get books by view
	@GetMapping("getBookByView")
	public List<Book> getBookByView(@RequestParam("numberPage") int numberPage) {
		int start = (numberPage - 1) * 6;
		List<Book> books = bookService.getAllBookViewDese(start, 6);
		return books;
	}

	// Get books by Discount
	@GetMapping("getBookByDiscount")
	public List<Book> getBookByDiscount(@RequestParam("numberPage") int numberPage) {
		int start = (numberPage - 1) * 6;
		List<Book> books = bookService.getAllBookByDiscount(start, 6);
		return books;
	}
}
