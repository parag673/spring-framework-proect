package com.simplilearn.sportyshoes.entity;

import java.util.Set;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product {
	
	@Id
	@Column(name = "product_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	private String prodname;
	private String descr;
	private double price;
	private String category;
	
	/*@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name = "product_user_mapping",
	joinColumns=@JoinColumn(name = "product_id"),
	inverseJoinColumns=@JoinColumn(name = "user_id"))*/
	
	@JsonIgnore
	@ManyToMany(mappedBy = "product")
	private Set<UserEntity> user;
	
	
	public Set<UserEntity> getUser() {
		return user;
	}
	public void setUser(Set<UserEntity> user) {
		this.user = user;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getProdname() {
		return prodname;
	}
	public void setProdname(String prodname) {
		this.prodname = prodname;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Product() {
		super();
			}
	
	public Product(int pid, String prodname, String descr, double price, String category) {
		super();
		this.pid = pid;
		this.prodname = prodname;
		this.descr = descr;
		this.price = price;
		this.category = category;
	}
	public Product(Set<UserEntity> user) {
		super();
		this.user = user;
	}

}
