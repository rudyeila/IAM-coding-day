package com.iamcd.team4.backend.logic.model;

import java.util.ArrayList;
import java.util.List;

public class Hobby {

	private int userId;
	private List<String> hobbies;
	

	public Hobby(int userId, List<String> hobbies) {
		super();
		this.userId = userId;
		this.hobbies = hobbies;
	}
	
	public Hobby() {
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + userId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hobby other = (Hobby) obj;
		if (userId != other.userId)
			return false;
		return true;
	}


	
}
