package com.HCPAssessment.models;

import java.util.ArrayList;
import java.util.List;

public class userlist {
    private List<user> users;

    public userlist() {
        users = new ArrayList<>();
    }

	public List<user> getUsers() {
		return users;
	}

	public void setUsers(List<user> users) {
		this.users = users;
	}
    
    
}
