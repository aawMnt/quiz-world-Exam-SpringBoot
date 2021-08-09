package com.examweb.Service.Impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examweb.Service.CatService;
import com.examweb.entity.exam.Category;
import com.examweb.repo.CatgRepo;

@Service
public class CatServiceImpl implements CatService {
	
	@Autowired
	private CatgRepo catrepo;

	@Override
	public Category addcat(Category cat) {
		
		return catrepo.save(cat);
	}

	@Override
	public Category updatecat(Category cat) {
		
		return catrepo.save(cat);
	}

	@Override
	public Category getcat(Long id) {
		
		return catrepo.findById(id).get();
	}

	@Override
	public void deletecat(Long id) {
		
		Category cat = new Category();
		cat.setId(id);
		catrepo.deleteById(id);
		
	}

	@Override
	public Set<Category> getcats() {
		
		return new LinkedHashSet<>(catrepo.findAll());
	}

	
}
