package com.dvd.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dvd.entity.Order;

@Controller
@RequestMapping("cart")
public class CartController {
	
	@RequestMapping("carts")
	public String cart(HttpServletRequest req,Model model) {
		HttpSession session = req.getSession();
		List<Order> orders =(List<Order>) session.getAttribute("cart");
		if(orders==null) {
			model.addAttribute("notice", "Không có sản phẩm nào trong giỏ hàng.");
		}else {
			model.addAttribute("cart", orders);
		}
		return "cart/cart";
	}
	
}
