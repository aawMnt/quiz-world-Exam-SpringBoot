package com.examweb.Service.Impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examweb.Service.UserResultService;
import com.examweb.Service.UserService;
import com.examweb.entity.AdminResult;
import com.examweb.entity.User;
import com.examweb.entity.UsersResult;
import com.examweb.repo.AdminResultRepo;
import com.examweb.repo.resultRepo;

@Service

public class UserResultServiceImpl implements UserResultService {
	
	@Autowired
	private resultRepo repo;
	
	@Autowired
	private AdminResultRepo arepo;

	@Override
	public UsersResult saveResult(UsersResult result) {

       
		return repo.save(result);
	}

	@Override
	public Set<UsersResult> findbyUser(User user) {
		
		return repo.findByUsers(user);
	}

	@Override
	public void deleteResult(Long rid) {
		
		repo.deleteById(rid);
		
	}

	
	//for admin view
	@Override
	public List<AdminResult> adminResultfindAll() {
		
		return arepo.findAll();
	}

	@Override
	public AdminResult postResults(AdminResult admin) {
		
		return arepo.save(admin);
	}

	@Override
	public void delete(Long rid) {
		arepo.deleteById(rid);
		
	}

	


}
