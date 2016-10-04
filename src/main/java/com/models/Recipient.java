package com.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "recipient")
public class Recipient {

	int id;
	private String email;

	
	public Recipient() {
		super();
	}
	
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
