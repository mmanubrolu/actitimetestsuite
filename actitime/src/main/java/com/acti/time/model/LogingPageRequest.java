package com.acti.time.model;

public class LogingPageRequest {
	public String tcId;
	public String priority;
	public String userName;
	public String password;
	
	
	@Override
	public String toString() {
		return "LogingPageRequest [tcId=" + tcId + ", priority=" + priority + ", userName=" + userName + ", password="
				+ password + ", getTcId()=" + getTcId() + ", getPriority()=" + getPriority() + ", getUserName()="
				+ getUserName() + ", getPassword()=" + getPassword() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

	public LogingPageRequest() {
		
	}
	public LogingPageRequest(String tcId, String priority, String userName, String password) {
		super();
		this.tcId = tcId;
		this.priority = priority;
		this.userName = userName;
		this.password = password;
	}

	public String getTcId() {
		return tcId;
	}

	public void setTcId(String tcId) {
		this.tcId = tcId;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
