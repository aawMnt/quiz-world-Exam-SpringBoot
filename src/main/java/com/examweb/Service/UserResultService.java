package com.examweb.Service;

import java.util.List;
import java.util.Set;

import com.examweb.entity.AdminResult;
import com.examweb.entity.User;
import com.examweb.entity.UsersResult;

public interface UserResultService {
	
	public UsersResult saveResult(UsersResult result);
	
	public Set<UsersResult> findbyUser(User user);
	
	public void deleteResult(Long rid);
	
	//for admin view
	public List<AdminResult> adminResultfindAll();
	
	public AdminResult postResults(AdminResult admin);
	
	public void delete(Long rid);
	
	

}
