package com.simplilearn.sportyshoes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.sportyshoes.entity.AdminEntity;
import com.simplilearn.sportyshoes.service.AdminService;

@RestController
@RequestMapping("api/admin/")
public class AdminController {
	
	@Autowired
	private AdminService service;
	@PostMapping("/")
	public ResponseEntity<Object> addAdminEntity(@RequestBody AdminEntity admin){
		
		AdminEntity data= service.addAdmin(admin);
		if(data!=null)
			return new ResponseEntity<Object>(data,HttpStatus.CREATED);
		else
			return new ResponseEntity<Object>("Error while adding Admin", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PutMapping("/{aid}")
	public ResponseEntity<Object> updateAdminEntity(@RequestBody AdminEntity admin,@PathVariable int aid){
		AdminEntity data= service.updateAdmin(admin, aid);
		if(data!=null)
		return new ResponseEntity<Object>(data,HttpStatus.OK);
		else
			return new ResponseEntity<Object>("Admin is not available for update",
					HttpStatus.NOT_FOUND);
	}

}
