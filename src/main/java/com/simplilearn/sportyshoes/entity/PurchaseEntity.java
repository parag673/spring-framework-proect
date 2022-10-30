package com.simplilearn.sportyshoes.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PurchaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderId;
	
	@Column(name = "Date_of_Purchase")
	private String dop;
	
	@Column(name = "Total_Cost")
	private float totalcost;
	
	@Column(name = "Quantity")
	private int quantity;
	
	@Column(name = "Product_Name")
	private String prodname;
	
	@Column(name = "Category")
	private String category;
	
	@Column(name = "Cust_Name")
	private String name;
	
	@Column(name = "Cust_Phone")
	private long phone;
	
	@Column(name = "Cust_Email")
	private String email;
	
	@Column(name = "Cust_Address")
	private String address;

	

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getDop() {
		return dop;
	}

	public void setDop(String dop) {
		this.dop = dop;
	}

	public float getTotalcost() {
		return totalcost;
	}

	public void setTotalcost(float totalcost) {
		this.totalcost = totalcost;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getProdname() {
		return prodname;
	}

	public void setProdname(String prodname) {
		this.prodname = prodname;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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

	
	
}
