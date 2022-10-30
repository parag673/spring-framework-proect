package com.simplilearn.sportyshoes.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class UserEntity {
	
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uid;
	private String name;
	private long phone;
	private String email;
	private String address;
	
	@ManyToMany(cascade = CascadeType.ALL )//{CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name = "user_product_mapping",
	joinColumns=@JoinColumn(name = "user_id"),
	inverseJoinColumns=@JoinColumn(name = "product_id"))
	
	private Set<Product> product;
	
	public Set<Product> getProduct() {
		return product;
	}
	public void setProduct(Set<Product> product) {
		this.product = product;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public UserEntity(int uid, String name, long phone, String email, String address,
			Set<Product> product) {
		super();
		this.uid = uid;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
	
		this.product = product;
	}
	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
		
	}
	
	


