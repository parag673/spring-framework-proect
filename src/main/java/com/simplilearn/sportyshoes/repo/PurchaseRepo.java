package com.simplilearn.sportyshoes.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.simplilearn.sportyshoes.entity.PurchaseEntity;

@Repository
public interface PurchaseRepo extends JpaRepository<PurchaseEntity, Integer> {
	
	
	
	public List<PurchaseEntity> findByCategory(String category);

	
	
	public List<PurchaseEntity> findByDop(String dop);
}
