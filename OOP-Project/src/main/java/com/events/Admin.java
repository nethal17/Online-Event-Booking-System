package com.events;

public class Admin {
	
	private int id;
	private String name;
	private String email;
	private String telephone;
	private String type;
	private String username;
	private String password;
	
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
	
}
