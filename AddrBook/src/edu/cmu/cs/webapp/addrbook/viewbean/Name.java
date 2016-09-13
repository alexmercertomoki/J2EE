package edu.cmu.cs.webapp.addrbook.viewbean;

public class Name {
	private int id;
	private String lastName;
	private String firstNames;
	
	public int getId() {
		return id;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getFirstNames() {
		return firstNames;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setFirstNames(String firstNames) {
		this.firstNames = firstNames;
	}
}
