package com.admin;

public class Events {
	private int id;
	private String title;
	private String description;
	private String organizer;
	private String email;
	private String phone;
	private String price;
	private String date;
	
	//overloaded constructor
	public Events(int id, String title, String description, String organizer, String email, String phone, String price,String date) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.organizer = organizer;
		this.email = email;
		this.phone = phone;
		this.price = price;
		this.date = date;
	}


	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getOrganizer() {
		return organizer;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public String getPrice() {
		return price;
	}

	public String getDate() {
		return date;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	public void setDate(String date) {
		this.date = date;
	}
	
	

	
	

}