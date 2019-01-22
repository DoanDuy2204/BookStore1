package com.dvd.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.dvd.entity.User;

public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		User user = (User)obj;
		String password = user.getPassword();
		if(user.getUserName()==null || user.getUserName().equals("")) {
			errors.rejectValue("userName", "username.required");
		}
		if(user.getPassword()==null || user.getPassword().equals("")) {
			errors.rejectValue("password", "password.required");
		}
		if(password.contains("`") || password.contains("!") || password.contains("@") || 
				password.contains("#") || password.contains("$") || password.contains("%") ||
				password.contains("^") || password.contains("&") || password.contains("*") ||
				password.contains("(") || password.contains(")") || password.contains("-") ||
				password.contains("+") || password.contains("[") || password.contains("]") ||
				password.contains("{") || password.contains("}") || password.contains("|") || 
				password.contains("|") || password.contains(">") || 
				password.contains(".") || password.contains(",") || password.contains("<") || 
				password.contains("'") || password.contains(":") || password.contains(";")) {
			errors.rejectValue("password", "password.contain");
		}
	}

}
