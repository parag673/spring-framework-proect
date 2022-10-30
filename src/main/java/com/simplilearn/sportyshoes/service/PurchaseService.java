package com.simplilearn.sportyshoes.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.simplilearn.sportyshoes.entity.PurchaseEntity;
import com.simplilearn.sportyshoes.entity.Response;
import com.simplilearn.sportyshoes.repo.PurchaseRepo;

@Service
public class PurchaseService {
	
	@Autowired
	PurchaseRepo repo;
	
	public PurchaseEntity addPurchase (PurchaseEntity purchase) {
		return repo.save(purchase);
	}
	
	public List<PurchaseEntity> getAllPurchase(){
		return repo.findAll();
	}
	
	public PurchaseEntity getPurchaseById(int orderId) {
		if(repo.findById(orderId).isPresent())
			return repo.findById(orderId).get();
		else
			return null;
	}
	
	public List<PurchaseEntity> findByCategory(String category) {
		return repo.findByCategory(category);
	}

	public List<PurchaseEntity> findByDop(String dop) {
		return repo.findByDop(dop);
	}
	
	private RestTemplate template = new RestTemplate();
	
	public Response getPurchasewithProductType(int orderId) {
		
		final String url="http://localhost:8086/type/{orderId}";
		Map<String, Integer> map=new HashMap<String, Integer>();
		map.put("orderId", orderId);
		String type=template.getForObject(url,String.class,map);
		
		PurchaseEntity entity=repo.findById(orderId).get();
		Response resp = new Response();
		resp.setEntity(entity);
		resp.setType(type);
		
		return resp;
	}
}
