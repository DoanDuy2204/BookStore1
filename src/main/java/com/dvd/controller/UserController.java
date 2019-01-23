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
import org.springframework.web.bind.annotation.RequestMethod;

import com.dvd.entity.User;
import com.dvd.service.UserService;
import com.dvd.validator.UserValidator;

/**
 * This class is Controller where used to process request from client send
 * server. With url="\\user\\**"
 * 
 * @author Admin
 *
 */
@Controller
@RequestMapping("user")
public class UserController {

	// Autowrite UserService
	@Autowired
	private UserService userService;

	/**
	 * This method is used to logout User when login.
	 * @param req
	 * @return
	 */
	@RequestMapping("logout")
	public String logoutUser(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.setAttribute("user", null);
		return "home";
	}

	/**
	 * This method is used to forward request with url="\\user\\login" to user/user.
	 * @param model
	 * @return
	 */
	@RequestMapping("login")
	public String loginUser(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("command", "login");
		return "user/user";
	}

	// Autowrite UserValidator
	@Autowired
	private UserValidator userValidator;

	/**
	 * This method is used to process user when login user.
	 * @param model
	 * @param req
	 * @param user : user client input.
	 * @param bindingResult
	 * @return
	 */
	@PostMapping("process-login")
	public String processLoginUser(Model model, HttpServletRequest req, @ModelAttribute("user") User user,
			BindingResult bindingResult) {
		userValidator.validate(user, bindingResult);
		if (bindingResult.hasErrors()) {
			model.addAttribute("command", "login");
			return "user/user";
		} else {
			User u = userService.checkUser(user.getUserName(), user.getPassword());
			if (u == null || u.getEnable() == 0) {
				model.addAttribute("error", "Username and password is not invalidator");
				model.addAttribute("command", "login");
				return "user/user";
			} else {
				HttpSession session = req.getSession();
				session.setAttribute("user", u);
				if (u.getRole().equals("ADMIN"))
					return "admin/admin";
			}
		}
		return "home";
	}
	
	/**
	 * This method id used to forward request to page /user/register.jsp.
	 * @return
	 */
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String registerUser(Model model) {
		model.addAttribute("command", "register");
		model.addAttribute("user", new User());
		return "user/user";
	}
	
	/**
	 * This method is used to Process User when register.
	 * @param User
	 * @return
	 */
	@RequestMapping(value="/process-register")
	public String processRegister(@ModelAttribute("user") User user,Model model,BindingResult bindingResult) {
		userValidator.validate(user, bindingResult);
		if(bindingResult.hasErrors()) {
			model.addAttribute("command", "register");
			return "user/user";
		}
		userService.insertUser(user);
		model.addAttribute("registerSucess", "registerSucess");
		model.addAttribute("command", "login");
		return "user/user";
	}
}
