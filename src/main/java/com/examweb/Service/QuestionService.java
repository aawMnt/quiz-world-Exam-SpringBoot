package com.examweb.Service;

import java.util.Set;

import com.examweb.entity.exam.Question;
import com.examweb.entity.exam.Quiz;

public interface QuestionService {
	
	public Question addq(Question q);
	
	public Question updateq(Question q);
	
	public Set<Question> getallq();
	
	public Question getq(Long id);
	
	public Set<Question> getqofQuiz(Quiz quiz);
	
	public void delete(Long id);
	
	public Question getCheckedAns(Long id);

}
