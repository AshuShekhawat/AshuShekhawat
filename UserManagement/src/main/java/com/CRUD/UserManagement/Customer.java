package com.CRUD.UserManagement;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cId;
	private String cName;
	private String cEmail;
	public Customer() {
		
	}
	public Customer(String cName, String cEmail) {
		super();
		this.cName = cName;
		this.cEmail = cEmail;
	}
	public Customer(Long cId, String cName, String cEmail) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.cEmail = cEmail;
	}
	
	public Long getcId() {
		return cId;
	}
	public void setcId(Long cId) {
		this.cId = cId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getcEmail() {
		return cEmail;
	}
	public void setcEmail(String cEmail) {
		this.cEmail = cEmail;
	}
	

}
