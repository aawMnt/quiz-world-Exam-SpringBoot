package com.examweb.Service;

import java.util.Set;

import com.examweb.entity.exam.Category;

public interface CatService {

	public Category addcat(Category cat);
	public Category updatecat(Category cat);
	public Category getcat(Long id);
	public void deletecat(Long id);
	
	public Set<Category> getcats();
	
}
