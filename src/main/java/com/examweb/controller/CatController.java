package com.examweb.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examweb.Service.CatService;
import com.examweb.entity.exam.Category;

@RestController
@CrossOrigin("*")
@RequestMapping("/category")
public class CatController {
	
	@Autowired
	private CatService catservice;
	
	@PostMapping("/")
	public ResponseEntity<?> addcat(@RequestBody Category cat){
		Category cat1 = catservice.addcat(cat);
		return ResponseEntity.ok(cat1);
	}
	
	@GetMapping("/{id}")
	public Category getcat(@PathVariable("id") Long id) {
		
		return catservice.getcat(id);
		
	}
	
	@GetMapping("/")
	public Set<Category> getall (){
		return catservice.getcats();
	}
	
	
	@PutMapping("/")
	public Category updatecat(@RequestBody Category cat) {
		return catservice.updatecat(cat);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		catservice.deletecat(id);
	}
	
	

}
