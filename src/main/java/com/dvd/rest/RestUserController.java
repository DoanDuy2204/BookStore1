package com.dvd.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dvd.entity.User;
import com.dvd.service.UserService;

@RestController
@RequestMapping("api/user")
public class RestUserController {

	//Inject Userservice
	@Autowired
	private UserService userService;
	
	@GetMapping("/login")
	public User loginUser(@RequestParam("username")String username
						,@RequestParam("password")String password
						,@RequestParam("role")String role
						,HttpServletRequest req) {
			User user = userService.checkUser(username,password);
			if(user!=null)
				if(user.getRole().toLowerCase().equals(role.toLowerCase())) {
					HttpSession session = req.getSession();
					session.setAttribute("user", user);
					return user;
				}
			return null;
		}
	}
