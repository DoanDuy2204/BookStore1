package com.dvd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dvd.dao.AuthorDao;
import com.dvd.entity.Author;
/**
 * This class is service which use to provide service for data.
 * @author Admin
 *
 */
@Service 
@Transactional
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorDao authorDao;
	
	@Override
	public List<Author> getAllAuthor(String name) {
		return authorDao.getAllAuthor(name);
	}

	@Override
	public List<Author> getListAuthorById(int[] idAuthor) {
		return authorDao.getListAuthorById(idAuthor);
	}

}
