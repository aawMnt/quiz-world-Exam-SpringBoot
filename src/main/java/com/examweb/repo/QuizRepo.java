package com.examweb.repo;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examweb.entity.exam.Category;
import com.examweb.entity.exam.Quiz;

public interface QuizRepo extends JpaRepository<Quiz, Long> {

	 public Set<Quiz> findBycategory(Category category);
	 
	 
	 // this is for active user
	 
	 public List<Quiz> findByActive(Boolean b);
	 
	 public List<Quiz> findByCategoryAndActive(Category c,Boolean b);

}
