package com.admin;

//Admin model class
public class Admin {
	
	private int id;
	private String name;
	private String email;
	private String telephone;
	private String type;
	private String username;
	private String password;
	
	// overloaded constructor
	public Admin(int id, String name, String email, String telephone, String type, String username, String password) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.telephone = telephone;
		this.type = type;
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getTelephone() {
		return telephone;
	}

	public String getType() {
		return type;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
