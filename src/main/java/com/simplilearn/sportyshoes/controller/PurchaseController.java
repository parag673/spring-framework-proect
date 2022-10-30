package com.simplilearn.sportyshoes.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.sportyshoes.entity.PurchaseEntity;
import com.simplilearn.sportyshoes.service.PurchaseService;

@RestController
@RequestMapping("/api/admin/purchase")
public class PurchaseController {
	
	@Autowired
    PurchaseService service;
	
	@PostMapping("/")
	public ResponseEntity<Object> addPurchase(@RequestBody PurchaseEntity purchase){
		PurchaseEntity resp=service.addPurchase(purchase);
		if(resp!=null)
			return new ResponseEntity<Object>(resp,HttpStatus.CREATED);
		else
			return new ResponseEntity<Object>("Error while inserting data",
					HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/")
	public List<PurchaseEntity> getAllPurchase(){
		return service.getAllPurchase();
	}
	
	@GetMapping("/orderId/{orderId}")
	public ResponseEntity<Object> getPurchasewithProductType(@PathVariable int orderId){
		
		if(service.getPurchasewithProductType(orderId)!=null)
			return new ResponseEntity<Object>(service.getPurchasewithProductType(orderId),HttpStatus.FOUND);
		else
			return new ResponseEntity<Object>(" No Purchase is made with given id",
					HttpStatus.NOT_FOUND);
	}  
	
	@GetMapping("/dop/{dop}")
	public List<PurchaseEntity> getAllPurchasebyDate(@PathVariable String dop)
	{
		return service.findByDop(dop);
	}
	
	@GetMapping(value="/category/{category}")
	public List<PurchaseEntity> getAllPurchasebyCategory(@PathVariable String category)
	{
		return service.findByCategory(category);
	}
}
