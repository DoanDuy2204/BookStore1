package com.dvd.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.dvd.entity.Transaction;

public class TransactionValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Transaction.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		//Convert obj -> Transaction
		Transaction transaction = (Transaction) obj;
		String name = transaction.getName();
		String email = transaction.getEmail();
		String address = transaction.getAddress();
		String phone = transaction.getPhone();
		if(name=="") 
			errors.rejectValue("name","name_required");
		if(email=="") 
			errors.rejectValue("email","email_required");
		if(address=="") 
			errors.rejectValue("address","address_required");
		if(phone=="") 
			errors.rejectValue("phone","phone_required");
		if(email!="")
			if(!email.contains("@gmail.com"))
				errors.rejectValue("email", "email_notcontains");
		boolean check = true;
		for(int i=0;i<phone.length();i++) {
			char c = phone.charAt(i);
			if(c<48 || c > 57 || phone.length()<8 || phone.length() >12)
				check = false;
		}
		if(!check) 
			errors.rejectValue("phone", "phone_notcontains");
	}

}
