/**
 * 
 */
package com.vidu.model;

/**
 * @author Vidushi Mishra
 *
 */
public class URL {
	
	private String url; 
	
	private int status;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public URL(String url, int status) {
		super();
		this.url = url;
		this.status = status;
	}

	public URL(String url) {
		super();
		this.url = url;
	}

	public URL() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean contains(String string) {
		// TODO Auto-generated method stub
		return false;
	}

	

	
	
	

}
