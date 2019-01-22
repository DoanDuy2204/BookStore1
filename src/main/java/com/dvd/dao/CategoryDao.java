package com.dvd.dao;

import java.util.List;

import com.dvd.entity.Category;

public interface CategoryDao {

	public List<Category> getCategory(int total);
	public int getIdFirstCategory();
	public Category getCategoryById(int idCategory);
	
}
