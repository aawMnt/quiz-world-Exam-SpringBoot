package com.examweb.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.examweb.Service.QuizService;
import com.examweb.entity.exam.Category;
import com.examweb.entity.exam.Quiz;

@RestController
@CrossOrigin("*")
@RequestMapping("/quiz")
public class QuizControler {

	@Autowired
	private QuizService quizservice;
	
	
	@PostMapping("/")
	public Quiz addquiz(@RequestBody Quiz quiz) {
		Quiz quiz1 = quizservice.addquiz(quiz);
		return quiz1;
	}
	
	@PutMapping("/")
	public Quiz updatequiz(@RequestBody Quiz quiz) {
		return quizservice.updatequiz(quiz);
	}
	
	@GetMapping("/")
	public Set<Quiz> getquizs(){
		return quizservice.getquizs();
	} 
	
	@GetMapping("/{id}")
	public Quiz getquiz(@PathVariable("id") Long id) {
		 
		return quizservice.getquiz(id);
	}
	
	@DeleteMapping("/{id}")
	public void deletequiz(@PathVariable("id") Long id) {
		quizservice.deletequiz(id);
	}
	
	
	
	@GetMapping("/cat/{id}")
	public Set<Quiz> getQuizofCat(@PathVariable("id") Long id){
		
		Category cat = new Category();
		cat.setId(id);
		
		return this.quizservice.getQuizzesOfCat(cat);
	} 
	
	
	// for active quiz
	@GetMapping("/active")
	public List<Quiz> getActiveQuiz(){
		return this.quizservice.getActiveQuizes();
	}
	
	
	@GetMapping("/cat/active/{id}")
	public List<Quiz> getActiveQuizofCat(@PathVariable("id") Long id){
		
		Category cat = new Category();
		cat.setId(id);
		return this.quizservice.getActiveQuizesOfCat(cat);
	}
	
}
