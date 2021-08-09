package com.examweb.Service;

import java.util.List;
import java.util.Set;

import com.examweb.entity.exam.Category;
import com.examweb.entity.exam.Quiz;

public interface QuizService {
	
	
	public Quiz addquiz( Quiz quiz);
	
    public Quiz updatequiz (Quiz quiz);
    
    public Set<Quiz> getquizs();
    
   public Quiz getquiz(Long id);
   
   public void deletequiz(Long id);

public Set<Quiz> getQuizzesOfCat(Category cat);

public List<Quiz> getActiveQuizes();

public List<Quiz> getActiveQuizesOfCat(Category c);

  
}
