package com.HCPAssessment.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@JsonPropertyOrder({"id", "name", "username", "email" })
public class user {


	Integer id;
	String name;
	String username;
	String email;
	public user () {
		
	}
	public user(Integer id, String name, String username, String email) {
		super();
	
		this.id = id;
		this.name = name;
		this.username = username;
		this.email = email;

	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	
    public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + this.name + '\'' +
                ", username='" + this.username + '\'' +
                ", email='" + this.email + '\'' +
                '}';
    }

}
