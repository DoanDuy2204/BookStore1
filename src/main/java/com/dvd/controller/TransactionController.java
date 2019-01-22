package com.dvd.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dvd.entity.Order;
import com.dvd.entity.Transaction;
import com.dvd.entity.User;
import com.dvd.service.OrderService;
import com.dvd.service.TransactionService;
import com.dvd.validator.TransactionValidator;

/**
 * This class is controller used to process requests from clinet with url'/transaction'.
 * @author Admin
 *
 */
@Controller
@RequestMapping("transaction")
public class TransactionController {
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * @Autowrite TransactionService
	 */
	@Autowired
	private TransactionService transactionService;
	/**
	 * @Autowrite TransactionService
	 */
	@Autowired
	private OrderService orderService;

	/**
	 * This method is used to process url='/transaction/create'.
	 * Forward request to view 'cart/transaction.jsp'.
	 * @param model
	 * @return
	 */
	@GetMapping("creat")
	public String create(Model model) {
		Transaction transaction = new Transaction();
		model.addAttribute("transaction", transaction);
		model.addAttribute("command", "transaction-form");
		return "cart/transaction";
	}

	/**
	 * Autowrite TransactionValidator
	 */
	@Autowired
	private TransactionValidator transactionValidator;

	/**
	 * This method is used to process request from client with url'/transaction/process-transaction'.
	 * Used to create and confirm Transaction new And forward request to view 'cart/transaction.jsp'
	 * @param req
	 * @param model
	 * @param transaction
	 * @param bindingResult
	 * @return
	 */
	@GetMapping("process-transaction")
	public String processTransaction(HttpServletRequest req, Model model,
			@ModelAttribute("transaction") Transaction transaction, BindingResult bindingResult) {
		transactionValidator.validate(transaction, bindingResult);
		if (bindingResult.hasErrors()) {
			return "cart/transaction-form";
		}
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		List<Order> orders = (List<Order>) session.getAttribute("cart");
		transaction.setDoc(sdf.format(new Date()));
		transaction.setUser(user);
		transaction.setOrders(orders);
		session.setAttribute("transaction", transaction);
		model.addAttribute("command", "transaction-confirm");
		return "cart/transaction";
	}

	/**
	 * This method is used to Confirm-transaction.
	 * @param command
	 * @param req
	 * @param model
	 * @return
	 */
	@GetMapping("confirm-transaction")
	public String confirmTransaction(@RequestParam("command") String command, HttpServletRequest req, Model model) {
		HttpSession session = req.getSession();
		if (command.equals("confirm")) {
			Transaction transaction = (Transaction) session.getAttribute("transaction");
			if (transaction != null) {
				transactionService.addTransaction(transaction);
				transaction.setId(transactionService.getMaxId());
				List<Order> orders = transaction.getOrders();
				for (Order o : orders) {
					o.setTransaction(transaction);
					orderService.addOrder(o);
				}
				session.setAttribute("cart", null);
				session.setAttribute("transaction", null);
			}
			model.addAttribute("notice", "Success");
			return "cart/transaction";
		}
		if (command.equals("delete")) {
			session.setAttribute("transaction", null);
			return "home";
		}
		return "redirect:/create";
	}
}
