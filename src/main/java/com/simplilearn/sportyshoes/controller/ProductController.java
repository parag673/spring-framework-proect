package com.simplilearn.sportyshoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.sportyshoes.entity.Product;
import com.simplilearn.sportyshoes.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService service;
	
	@GetMapping("/")
	private List<Product> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/{pid}")
	private Product getById(@PathVariable int pid) {
		return service.getById(pid);
	}
	
	@PostMapping("/")
	private Product add(@RequestBody Product prod) {
		return service.addOrUpdate(prod);
	}
	@PutMapping("/{pid}")
	private Product update(@PathVariable int pid, @RequestBody Product prod) {
		prod.setPid(pid);
		return service.addOrUpdate(prod);
	}
	
	@DeleteMapping("/{pid}")
	private void delete(@PathVariable int pid) {
		service.deleteByTd(pid);
	}
	
}
