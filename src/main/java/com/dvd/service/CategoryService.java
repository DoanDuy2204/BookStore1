package com.dvd.service;

import java.util.List;

import com.dvd.entity.Category;

public interface CategoryService {

	public Category getCategoryById(int idCategory);
	public List<Category> getCategories(int total);
	public int getIdCateogryFirst();
}
