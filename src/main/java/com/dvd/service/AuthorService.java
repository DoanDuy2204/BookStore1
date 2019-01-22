package com.dvd.service;

import java.util.List;

import com.dvd.entity.Author;

public interface AuthorService {

	public List<Author> getAllAuthor(String name);

	public List<Author> getListAuthorById(int[] idAuthor);
}
