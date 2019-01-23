package com.dvd.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//import com.dvd.entity.Book;
import com.dvd.entity.Category;
import com.dvd.entity.PublishingHouse;
//import com.dvd.service.BookService;
import com.dvd.service.CategoryService;
import com.dvd.service.PublishingHouseService;

//Declare class is Controller, process data, requests from client
@Controller
public class HomeController {

	/**
	//Declare BookService, CategoryService, PublishingHouseService
	 * @Autowired
	private BookService bookService;
		private List<Book> booksByCategory;
	private List<Book> booksByPublishingHouse;
	private List<Book> booksByTrend;
	
	//Set data for list : Books, categories, publishingHouses
	@PostConstruct
	public void setData() {
		booksByCategory = bookService.getAllBookByCategoryId(0, 8, categoryService.getIdCateogryFirst());
		booksByTrend = bookService.getAllBookByTrend(0, 6);
		booksByPublishingHouse = bookService.getAllBookByPublishingHouseId(0, 8, publishingHouseService.getIdPublishingHouseFirst());
		categories = categoryService.getAllCategories();
	}
	
	//Mapping "Home"
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("booksByCategory", booksByCategory);
		model.addAttribute("booksByTrend",booksByTrend);
		model.addAttribute("booksByPublishingHouse", booksByPublishingHouse);
		model.addAttribute("categories", categories);
		return "home";
	}*/	
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private PublishingHouseService publishingHouseService;
	
	private List<Category> categories;
	private List<PublishingHouse> publishingHouses;
	
	@PostConstruct
	public void setData() {
		categories = categoryService.getCategories(4);
		publishingHouses = publishingHouseService.getPublishingHouse(4);
	}
	@RequestMapping("/")
	public String home(Model model,HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.setAttribute("categories", categories);
		session.setAttribute("publishingHouses", publishingHouses);
		model.addAttribute("categories", categories);
		model.addAttribute("publishingHouses", publishingHouses);
		return "home";
	}
	
	@RequestMapping("/contact")
	public String contact(Model model) {
		model.addAttribute("contact", "contact");
		return "home";
	}
}
