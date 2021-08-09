package com.examweb.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examweb.Service.UserResultService;
import com.examweb.entity.AdminResult;
import com.examweb.entity.User;
import com.examweb.entity.UsersResult;

@RestController
@CrossOrigin("*")
@RequestMapping("/result")
public class UserResultController {
	
	@Autowired
	private UserResultService service;
	
	//for User
	
	@PostMapping("/usersResults")
	public UsersResult save(@RequestBody UsersResult result) {
		return service.saveResult(result);
	}
	
	@GetMapping("/findResultByUser/{id}")
	public ResponseEntity<?> findbyUserid(@PathVariable("id") Long id){
		
		User user = new User();
		user.setId(id);
		Set<UsersResult> resulOfUsers =service.findbyUser(user);
		
		return ResponseEntity.ok(resulOfUsers);
		
	}
	
	@DeleteMapping("/deleteResult/{id}")
	public void deleteresult(@PathVariable("id") Long rid) {
		service.deleteResult(rid);
	}
	
 //for admin view 
	
	@GetMapping("/adminResultView")
	public List<AdminResult> findAll(){
		
		return service.adminResultfindAll();
	}
	@PostMapping("/postResultinAdmin")
	public AdminResult postresult(@RequestBody AdminResult admin) {
		return service.postResults(admin);
	}
	
	@DeleteMapping("/deleteHistory/{id}")
	public void delete(@PathVariable("id") Long rid) {
		service.delete(rid);
	}
	
	

}
