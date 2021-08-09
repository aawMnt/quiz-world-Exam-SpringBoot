package com.examweb.controller;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examweb.Service.QuestionService;
import com.examweb.Service.QuizService;
import com.examweb.entity.exam.Question;
import com.examweb.entity.exam.Quiz;







@RestController
@CrossOrigin("*")
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	private QuestionService qservice;
	
	@Autowired
	private QuizService quizservice;
	
	
	@PostMapping("/")
	public Question addq(@RequestBody Question q) {
		
		Question q1 = qservice.addq(q);
		return q1;
	}
	@PutMapping("/")
	public Question updateq(@RequestBody Question q) {
		return qservice.updateq(q);
	}
	
	@GetMapping("/allQuestions")
		public Set<Question> getallq(){
			return qservice.getallq();
		}
	
	
	
	@GetMapping("/quiz/all/{id}")
	public ResponseEntity<?> getqOfquizAdmin(@PathVariable("id") Long id){
		
		Quiz quiz = new Quiz();
		quiz.setId(id);
		Set<Question> quizOfQuestion = this.qservice.getqofQuiz(quiz);
		return ResponseEntity.ok(quizOfQuestion);
	
	}
	
	
	
	
	
	
	
	
	
	@GetMapping("/{id}")
	public Question getq(@PathVariable("id")Long id)
	{
		return qservice.getq(id);
	}
	
//	*****************************************************************************************************
	@GetMapping("/quiz/{id}")
	public ResponseEntity<?> getqOfquiz(@PathVariable("id") Long id){
		
//		Quiz quiz = new Quiz();
//		quiz.setId(id);
//		Set<Question> quizOfQuestion = this.qservice.getqofQuiz(quiz);
//		return ResponseEntity.ok(quizOfQuestion);  *****find all quizOfQuestion***********
	
	Quiz quiz  = quizservice.getquiz(id);
	Set<Question> q = quiz.getQuestion();
	 List<Question> list = new ArrayList(q);
	
	if(list.size()>Integer.parseInt(quiz.getNumberOfQuestions()))
	{
		list = list.subList(0,Integer.parseInt(quiz.getNumberOfQuestions()+1));
	}
	
//	list.forEach((e)->{
//		e.setAns("");
//	});
	
	
	java.util.Collections.shuffle(list);
	return ResponseEntity.ok(list);
	}
//	**********************************************************************************************************
	
	@DeleteMapping("/{id}")
	public void delete (@PathVariable("id") Long id)
	{
		qservice.delete(id);
	}
	
	
	
//	checked ans in backend
//	@PostMapping("/checked-questions")
//	public ResponseEntity<?> checkedquestion(@RequestBody List<Question> questions) {
//		 double marskGot=0;
//		  int cAns=0;
//		  int attemt=0;
//		 
//		  
//		 for(Question q :questions) {
////			 singal question
//			 Question question = qservice.getCheckedAns(q.getId());
//			 
//			 if(question.getAns().equals(q.getGivenAns())) {
//				 //correcct
//				 cAns++;
//				 
//				 double marksSingal = Double.parseDouble(questions.get(0).getQuiz().getMaxMarks())/questions.size();
//				 
//				 marskGot +=marksSingal;
//				 
//				
//				 
//			 }
//			 if(q.getGivenAns() !=null ) {
//				 attemt++;
//			 }
//		 }
//		 Map<Object, Object> map = Map.of("marskGot",marskGot,"correntAns",cAns,"Attempted",attemt);
//		return ResponseEntity.ok(map);
//	}
}
