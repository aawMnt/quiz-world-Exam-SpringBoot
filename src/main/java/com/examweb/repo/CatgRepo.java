package com.examweb.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examweb.entity.exam.Category;

public interface CatgRepo extends JpaRepository<Category, Long> {

}
