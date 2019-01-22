package com.dvd.dao;

import java.util.List;

import com.dvd.entity.Author;

public interface AuthorDao {
	
	public List<Author> getAllAuthor(String name);
	public List<Author> getListAuthorById(int[] idAuthor);	
}
