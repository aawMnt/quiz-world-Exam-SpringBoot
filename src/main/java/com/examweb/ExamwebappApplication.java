package com.examweb;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.examweb.Service.UserService;
import com.examweb.entity.Role;
import com.examweb.entity.User;
import com.examweb.entity.UserRole;
import com.examweb.examHelper.ExamUserFoundException;

@SpringBootApplication
public class ExamwebappApplication implements CommandLineRunner{
	@Autowired
	private UserService service;
	
	@Autowired
	private BCryptPasswordEncoder bcrytpasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(ExamwebappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		try {
			User user = new User();
			
			user.setFirstName("ashish");
			user.setLastName("wankar");
			user.setEmail("aaa@wankae.com");
			user.setUsername("ashish17");
			user.setPassword(bcrytpasswordEncoder.encode("ashu@17"));
			user.setProfile("defoult.png");
			
			Role role1 = new Role();
			
			role1.setRoleId(01L);
			role1.setRoleName("ADMIN");
			
			
			Set<UserRole> userRoleSet = new HashSet<>();
			
			UserRole userRole = new UserRole();
			
			userRole.setRole(role1);
			userRole.setUser(user);
			
			userRoleSet.add(userRole);
			
			User user1 = service.createUser(user, userRoleSet);
			System.out.println(user1.getUsername());
			
		} catch (ExamUserFoundException e) {
			e.printStackTrace();
		}
	}

	
}
