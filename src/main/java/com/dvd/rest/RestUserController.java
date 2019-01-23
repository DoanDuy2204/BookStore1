package com.dvd.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dvd.entity.User;
import com.dvd.service.UserService;
/**
 * This class is RestController where process api and  no return view.
 * @author Admin
 *
 */
@RestController
@RequestMapping("api/user")
public class RestUserController {

	// Inject Userservice
	@Autowired
	private UserService userService;

	/**
	 * This method is used to process request url="/api/user/login".
	 * @param username :username of client
	 * @param password : password of client
	 * @param role : role of client
	 * @param req
	 * @return
	 * 		User.class
	 */
	@GetMapping("/login")
	public User loginUser(@RequestParam("username") String username, @RequestParam("password") String password,
			@RequestParam("role") String role, HttpServletRequest req) {
		User user = userService.checkUser(username, password);
		if (user != null)
			if (user.getRole().toLowerCase().equals(role.toLowerCase())) {
				HttpSession session = req.getSession();
				session.setAttribute("user", user);
				return user;
			}
		return null;
	}

	/**
	 * This method is used to process url="user/api/check/{username}" and check userName is existed.
	 *	@param userName : username of client.
	 *	@return
	 *		Boolean : true if exist.
	 *				  false if not exist.
	 */
	@GetMapping("/check/{userName}")
	public boolean checkUser(@PathVariable String userName) {
		if(userService.getUser(userName)!=null) 
			return true;
		return false;
	}
}