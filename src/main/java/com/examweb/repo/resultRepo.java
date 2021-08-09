package com.examweb.repo;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examweb.entity.User;
import com.examweb.entity.UsersResult;

public interface resultRepo extends JpaRepository<UsersResult, Long> {
	
	Set<UsersResult> findByUsers(User users);

}
