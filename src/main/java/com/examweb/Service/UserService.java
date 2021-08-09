package com.examweb.Service;

import java.util.List;
import java.util.Set;

import com.examweb.entity.User;
import com.examweb.entity.UserRole;

public interface UserService {

	public User createUser(User user,Set<UserRole> userRoles) throws Exception;
	
	//getUser
	
	public User getUser(String username);
	
	//delete
	public void deleteUser(Long id);
	//upate
	public User update(User user, Long id);
	
	
	public List<User> getallUser();
}
