package com.examweb.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examweb.entity.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {

}
