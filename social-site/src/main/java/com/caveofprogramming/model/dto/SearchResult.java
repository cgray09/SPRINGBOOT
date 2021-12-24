package com.caveofprogramming.model.dto;

import java.util.Set;

import com.caveofprogramming.model.entity.Interest;
import com.caveofprogramming.model.entity.Profile;

public class SearchResult {
	private Long userId;
	private String firstname;
	private String surname;
	private String photo;
	private Set<Interest> interests;

	public SearchResult(Profile profile) {
		userId = profile.getUser().getId();
		firstname = profile.getUser().getFirstname();
		surname = profile.getUser().getSurname();
		photo = profile.getPhotoName();
		interests = profile.getInterests();
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Set<Interest> getInterests() {
		return interests;
	}

	public void setInterests(Set<Interest> interests) {
		this.interests = interests;
	}

	@Override
	public String toString() {
		return "SearchResult [userId=" + userId + ", firstname=" + firstname + ", surname=" + surname + ", interests="
				+ interests + "]";
	}

}
