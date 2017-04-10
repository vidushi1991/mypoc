/**
 * 
 */
package com.vidu.model;

/**
 * @author Vidushi Mishra
 *
 */
public class Link {
	
	private String link;
	
	private String status;

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Link() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Link(String link, String status) {
		super();
		this.link = link;
		this.status = status;
	}

	public Link(String link) {
		super();
		this.link = link;
	}
	
	
	

}
