package com.simplilearn.sportyshoes.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.sportyshoes.entity.AdminEntity;

@Repository
public interface AdminRepo extends JpaRepository<AdminEntity, Integer> {

}
