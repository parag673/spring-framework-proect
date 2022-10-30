package com.simplilearn.sportyshoes.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.sportyshoes.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

}
