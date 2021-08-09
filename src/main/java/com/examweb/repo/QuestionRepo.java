package com.examweb.repo;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examweb.entity.exam.Question;
import com.examweb.entity.exam.Quiz;

public interface QuestionRepo extends JpaRepository<Question, Long> {

	Set<Question> findByQuiz(Quiz quiz);

}
