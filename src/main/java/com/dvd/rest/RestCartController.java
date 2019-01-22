package com.dvd.rest;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dvd.entity.Book;
import com.dvd.entity.Order;
import com.dvd.service.BookService;

@RestController
@RequestMapping("api/cart")
public class RestCartController {

	@Autowired
	private BookService bookService;

	//Add cart
	@GetMapping("/{bookId}")
	public void addCart(@PathVariable int bookId, HttpServletRequest req) {
		HttpSession session = req.getSession();
		List<Order> orders = (List<Order>) session.getAttribute("cart");
		Book book = bookService.getBookById(bookId);
		Order order = new Order();
		order.setBook(book);
		double amounta = book.getPrice()-(book.getPrice()*(book.getDiscount()/100));
		order.setAmount(amounta);
		order.setQuantity(1);
		order.setStatus(0);
		order.setTransaction(null);
		if (orders == null) {
			orders = new ArrayList<Order>();
			orders.add(order);
			session.setAttribute("cart", orders);
		} else {
			for (Order o : orders)
				if (o.getBook().getId() == bookId) {
					o.setQuantity(o.getQuantity() + 1);
					double amount = o.getAmount() + o.getBook().getPrice()-
									(o.getBook().getPrice()*(o.getBook().getDiscount()/100));
					o.setAmount(amount);
					return;
				}
			orders.add(order);
		}
	}
	
	//Douwn or up Product
	@GetMapping("change")
	public Order changeCart(@RequestParam("num")int num, @RequestParam("id")int id,
							HttpServletRequest req) {
		HttpSession session = req.getSession();
		List<Order> orders = (List<Order>) session.getAttribute("cart");
		Order order = new Order();
		int i = 0;
		int check = -1 ;
		for(Order o:orders) {
			if(o.getId()==id) {
				order = o;
				o.setQuantity(o.getQuantity()+num);
				double price = o.getBook().getPrice();
				double discount = o.getBook().getDiscount();
				double aMount = o.getAmount() + num * (price-price*(discount/100));
				o.setAmount(aMount);
				if(o.getQuantity()==0) {
					check = i;
				}
			}
			i++;
		}
		if(check!=(-1)) 
			orders.remove(check);
		if(!orders.isEmpty()) {
			session.setAttribute("cart", orders);
		}else {
			session.setAttribute("cart", null);
		}
		return order;
	}
}
