/**
 * 
 */
package com.vidu.model;

/**
 * @author Vidushi Mishra
 *
 */
public class Customer {
	
	private String userName;
	
	private String password;
	
	private String result;
	
	

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Customer(String userName, String password, String result) {
		super();
		this.userName = userName;
		this.password = password;
		this.result = result;
	}

	public Customer(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	
	

}
