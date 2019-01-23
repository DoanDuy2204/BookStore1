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
		User user = (User) obj;
		String password = user.getPassword();
		if (user.getPassAgain() != null) {
			if (!user.getPassAgain().equals(password)) {
				errors.rejectValue("password", "password.passAgain");
				errors.rejectValue("passAgain", "password.passAgain");
				return;
			}
		}
		if (user.getUserName().equals(""))
			errors.rejectValue("userName", "username.required");
		if (user.getPassword().equals(""))
			errors.rejectValue("password", "password.required");
		String[] c = new String[] { "~", "!", "@", "$", "%", "^", "&", "*", "(", ")", "_", "-", "+", "=", "{", "}", ":",
				",", "\\", "|", "/", "?", "." };
		boolean check = true;
		for (String s : c)
			if (password.contains(s)) {
				check = false;
				break;
			}
		if (!check)
			errors.rejectValue("password", "password.contain");
		if (user.getCustomer() != null) {
			if (user.getCustomer().getName().equals(""))
				errors.rejectValue("customer.name", "customer.name.required");
			if (user.getCustomer().getEmail().equals(""))
				errors.rejectValue("customer.email", "customer.email.required");
			else {
				if (!user.getCustomer().getEmail().contains("@gmail.com"))
					errors.rejectValue("customer.email", "customer.email.format");
			}
			if (user.getCustomer().getAddress().equals(""))
				errors.rejectValue("customer.address", "customer.address.required");
		}
	}

}
