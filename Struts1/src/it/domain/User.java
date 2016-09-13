package it.domain;

public class User {
	
	private String username;

	private String password;
	
	private int cityId;
	
	private String[] userInterest;
	
	public String[] getUserInterest() {
		return userInterest;
	}

	public void setUserInterest(String[] userInterest) {
		this.userInterest = userInterest;
	}

	public User(){
		
	}

	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

}
