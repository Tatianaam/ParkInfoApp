package com.techelevator.npgeek.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;


public class SurveyResult {

	private long surveyId;
	private String parkCode;
	
	@NotBlank(message = "Email is required!")
	@Email(message = "Please enter a valid email address")
	private String email;
	
	private String state;
	
	@NotBlank(message = "Activity level is required!")
	private String activityLevel;
	

	public long getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(long surveyId) {
		this.surveyId = surveyId;
	}

	public String getParkCode() {
		return parkCode;
	}

	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getActivityLevel() {
		return activityLevel;
	}

	public void setActivityLevel(String activityLevel) {
		this.activityLevel = activityLevel;
	}
}
