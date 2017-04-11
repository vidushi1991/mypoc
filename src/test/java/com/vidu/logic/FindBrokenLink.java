/**
 * 
 */
package logic;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author Vidushi Mishra
 *
 */
public class FindBrokenLink {

	public String isLinkBroken(URL url) throws Exception

	{

		//url = new URL("http://yahoo.com");
		
		String response = "";
		
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		
	    Thread.sleep(4000);

		try

		{

		    connection.connect();

		    response = connection.getResponseMessage();
		    
		    Thread.sleep(4000);
		    
		    connection.disconnect();

		    return response;

		}

		catch(Exception exp)

		{

			return exp.getMessage();

		}				

	}
}
