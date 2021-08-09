package com.examweb.Service.Impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examweb.Service.UserService;
import com.examweb.entity.User;
import com.examweb.entity.UserRole;
import com.examweb.examHelper.ExamUserFoundException;
import com.examweb.repo.RoleRepo;
import com.examweb.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {
 
	@Autowired
	private UserRepo userrepo;
	
	@Autowired
	private RoleRepo rolerepo;
	
	//creating user
	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		
		User local =this.userrepo.findByUsername(user.getUsername());
		
		if(local!=null) {
			System.out.println("user is rady..!!!!");
			throw new ExamUserFoundException();
		}else {
			for(UserRole ur:userRoles) {
				rolerepo.save(ur.getRole());
                  	        }
			user.getUserRoles().addAll(userRoles);
			local = this.userrepo.save(user);
		}
		
		return local;
	}
	
//*****************************************************************************************	
  //geting user by user name
	@Override
	public User getUser(String username) {
		
		return userrepo.findByUsername(username);
	}
//***************************************************************************************
	//delete
	@Override
	public void deleteUser(Long id) {
		userrepo.deleteById(id);
		
	}
//*************************************************************************************************
	
	@Override
	public User update( User user,Long id) {
		
		User u = userrepo.findById(id).get();
		u.setUsername(user.getUsername());
		u.setPassword(user.getPassword());
		u.setFirstName(user.getFirstName());
		u.setLastName(user.getLastName());
		u.setEmail(user.getEmail());
//		u.setPhineNo(user.getPhoneNo());
		u.setProfile(user.getProfile());
		
		return userrepo.save(u);
		
	}

	@Override
	public List<User> getallUser() {
		
		return userrepo.findAll();
	}

}
