package com.examweb.Service.Impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examweb.Service.QuestionService;
import com.examweb.entity.exam.Question;
import com.examweb.entity.exam.Quiz;
import com.examweb.repo.QuestionRepo;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	QuestionRepo qrepo;
	
	@Override
	public Question addq(Question q) {
		
		return qrepo.save(q);
	}

	@Override
	public Question updateq(Question q) {
		
		return qrepo.save(q);
	}

	@Override
	public Set<Question> getallq() {
		
		return new HashSet<>(qrepo.findAll());
	}

	@Override
	public Question getq(Long id) {
		
		return qrepo.findById(id).get();
	}

	@Override
	public Set<Question> getqofQuiz(Quiz quiz) {
		
		return qrepo.findByQuiz(quiz);
	}

	@Override
	public void delete(Long id) {
		
		qrepo.deleteById(id);
		
	}

	@Override
	public Question getCheckedAns(Long id) {
		
		return qrepo.getOne(id);
	}

}
