package com.examweb.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.examweb.entity.User;


public interface UserRepo extends JpaRepository<User, Long> {

	public User findByUsername(String username);

}
