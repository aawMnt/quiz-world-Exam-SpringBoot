package com.examweb.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examweb.Service.UserService;
import com.examweb.entity.Role;
import com.examweb.entity.User;
import com.examweb.entity.UserRole;
import com.examweb.examHelper.ExamUserFoundException;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	@Autowired
	private BCryptPasswordEncoder bcrytpasswordEncoder;
	
	
	//testing 
	@GetMapping("/test")
	public String test() {
		return "wellcome to exam portal";
	}
	
	
	
	
	

	@PostMapping("/")
	public User creatinguser(@RequestBody User user) throws Exception {
		
		user.setProfile("defult.png");
		
//**************************pasword incoder help with bCript password config Mysecutiry**************************
		 
//		user.setPassword(bcrytpasswordEncoder.encode(user.getPassword()));
		
		Set<UserRole> roles = new HashSet<>();
		
		user.setPassword(bcrytpasswordEncoder.encode(user.getPassword()));
		
		Role role = new Role();
		
		role.setRoleId(02L);
		role.setRoleName("NORMAL");
		
		
		UserRole userrole = new UserRole();
		userrole.setUser(user);
		userrole.setRole(role);
		
		roles.add(userrole);
		
		return userservice.createUser(user,roles);
		
	}
//	***************************************************************************************************
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username) {
		
		return userservice.getUser(username);
		
	}
//	***********************************************************************************************
	@DeleteMapping("/{userId}")
	public void delete(@PathVariable("userId") Long id) {
		userservice.deleteUser(id);
	}
//	*******************************************************************************************************************************
	@PutMapping("/{userid}")
	public User userUpdate(@RequestBody User user ,@PathVariable("userid") Long id) {
		 return userservice.update(user, id);
	}
	
	
	
	
	@ExceptionHandler(ExamUserFoundException.class)
	public ResponseEntity<?> exceptionHandler(ExamUserFoundException ex){ return ResponseEntity.ok().build();}
	
//	******************************************************************************************************************
	
	@GetMapping("/allUsers")
	public List<User> getAlluser() {
		
		return userservice.getallUser();
	}
	
	
	
}
