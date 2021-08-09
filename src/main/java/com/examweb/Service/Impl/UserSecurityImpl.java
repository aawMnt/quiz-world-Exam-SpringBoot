package com.examweb.Service.Impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.examweb.entity.User;
import com.examweb.repo.UserRepo;

@Service
public class UserSecurityImpl implements UserDetailsService {

	@Autowired
	private UserRepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = this.repo.findByUsername(username);
		
		if(user==null) {
			System.out.println("User Not Found");
			throw new UsernameNotFoundException("No user Found!!!!!!");
		}
		
		return user;
	}

}
