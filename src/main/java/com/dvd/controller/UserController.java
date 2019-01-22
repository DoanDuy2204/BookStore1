package com.dvd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dvd.entity.User;
import com.dvd.service.UserService;
import com.dvd.validator.UserValidator;

@Controller
@RequestMapping("user")
public class UserController {
	
	//Autowrite UserService
	@Autowired
	private UserService userService;
	
	//LogOut user
	@RequestMapping("logout")
	public String logoutUser(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.setAttribute("user", null);
		return "home";
	}
	
	//Login user
	@RequestMapping("login")
	public String loginUser(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("command", "login");
		return "user/user";
	}
	
	//Autowrite UserValidator
	@Autowired
	private UserValidator userValidator;
	
	//Process login
	@PostMapping("process-login")
	public String processLoginUser(Model model,HttpServletRequest req,
									@ModelAttribute("user")User user,
									BindingResult bindingResult) {
		userValidator.validate(user, bindingResult);
		if(bindingResult.hasErrors()) {
			model.addAttribute("command", "login");
			return "user/user";
		}else {
			User u = userService.checkUser(user.getUserName(), user.getPassword());
			if(u==null || u.getEnable()==0) {
				model.addAttribute("error", "Username and password is not invalidator");
				model.addAttribute("command", "login");
				return "user/user";
			}else {
				HttpSession session = req.getSession();
				session.setAttribute("user", u);
				if(u.getRole().equals("ADMIN")) 
					return "admin/admin";
			}
		}
		return "home";
	}
}
