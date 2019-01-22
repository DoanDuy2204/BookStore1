package com.dvd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dvd.dao.CategoryDao;
import com.dvd.entity.Category;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	// Autowrite CateogryDAO
	@Autowired
	private CategoryDao categoryDao;

	//Get All Category
	@Override
	public List<Category> getCategories(int total) {
		return categoryDao.getCategory(total);
	}

	// Get Category first as ID
	@Override
	public int getIdCateogryFirst() {
		return categoryDao.getIdFirstCategory();
	}

	@Override
	public Category getCategoryById(int idCategory) {
		return categoryDao.getCategoryById(idCategory);
	}

}
