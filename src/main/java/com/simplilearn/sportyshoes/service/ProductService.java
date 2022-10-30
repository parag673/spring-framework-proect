package com.simplilearn.sportyshoes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.sportyshoes.entity.Product;
import com.simplilearn.sportyshoes.repo.ProductRepo;

@Service
public class ProductService {
	@Autowired
	private ProductRepo repo;
	
	public Product addOrUpdate(Product prod) {
		return repo.save(prod);
	}
	
	public boolean deleteByTd(int pid) {
		repo.deleteById(pid);
		return true;
	}
	
	public List<Product> getAll(){
		return repo.findAll();
	}
	
	public Product getById(int pid) {
		return repo.findById(pid).get();
		
	}
}
