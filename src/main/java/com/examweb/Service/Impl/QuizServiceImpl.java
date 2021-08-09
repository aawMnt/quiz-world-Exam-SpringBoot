package com.examweb.Service.Impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examweb.Service.QuizService;
import com.examweb.entity.exam.Category;
import com.examweb.entity.exam.Quiz;
import com.examweb.repo.QuizRepo;

@Service
public class QuizServiceImpl implements QuizService{
	
	@Autowired
	QuizRepo quizrepo;

	@Override
	public Quiz addquiz(Quiz quiz) {
		
		return quizrepo.save(quiz);
	}

	@Override
	public Quiz updatequiz(Quiz quiz) {
		
		return quizrepo.save(quiz) ;
	}

	@Override
	public Set<Quiz> getquizs() {
		
		return new HashSet<>(quizrepo.findAll()) ;
	}

	@Override
	public Quiz getquiz(Long id) {
		
		return quizrepo.findById(id).get();
	}

	@Override
	public void deletequiz(Long id) {
		 
		
		
		quizrepo.deleteById(id);
	}

	@Override
	public Set<Quiz> getQuizzesOfCat(Category cat) {
		
		return this.quizrepo.findBycategory(cat);
	}
	
	//user active function

	@Override
	public List<Quiz> getActiveQuizes() {
		
		return quizrepo.findByActive(true);
	}

	@Override
	public List<Quiz> getActiveQuizesOfCat(Category c) {
		
		return quizrepo.findByCategoryAndActive(c, true);
	}

}
