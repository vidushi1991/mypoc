/**
 * 
 */
package com.bookfari.practise.model;

/**
 * @author Vidushi Mishra
 *
 */
public class Employee {
	
	private String fName;
	
	private String lName;
	
	private int age;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Employee(String fName, String lName, int age) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.age = age;
	}
	
	

}
