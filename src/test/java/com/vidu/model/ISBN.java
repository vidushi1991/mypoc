/**
 * 
 */
package com.vidu.model;

/**
 * @author Vidushi Mishra
 *
 */
public class ISBN {
	
	private String isbn;
	
	private String result;
	
	

	public ISBN(String isbn) {
		super();
		this.isbn = isbn;
		// TODO Auto-generated constructor stub
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	

	

	public ISBN(String isbn, String result) {
		super();
		this.isbn = isbn;
		this.result = result;
	}

	
	
	
	

	
	
	

}
