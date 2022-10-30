package com.simplilearn.sportyshoes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.sportyshoes.entity.AdminEntity;

import com.simplilearn.sportyshoes.repo.AdminRepo;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepo repo;
	
	public AdminEntity addAdmin(AdminEntity admin) {
		return repo.save(admin);
	}
	
	public AdminEntity updateAdmin(AdminEntity admin, int aid) {
		if(repo.findById(aid).isPresent())
		{
			AdminEntity old= repo.findById(aid).get();
			old.setPassword(admin.getPassword());
			
			return repo.save(old);
		}
		else
			return null;
	}

}
