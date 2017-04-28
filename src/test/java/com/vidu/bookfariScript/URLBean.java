/**
 * 
 */
package bookfariScript;

/**
 * @author Vidushi Mishra
 *
 */
public class URLBean {

	private String url;
	
	private int status;

	public URLBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public URLBean(String url, int status) {
		super();
		this.url = url;
		this.status = status;
	}

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

	public URLBean(String url) {
		super();
		this.url = url;
	}
	
	
}
