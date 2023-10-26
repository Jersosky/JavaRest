package com.example.Prueba.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Julian")
public class Julian {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "clave")
	private String clave;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	@Override
	public String toString() {
		return "Julian [id=" + id + ", email=" + email + ", clave=" + clave + "]";
	}
	
	
	

}
