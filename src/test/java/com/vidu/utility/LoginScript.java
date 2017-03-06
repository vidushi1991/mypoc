/**
 * 
 */
package com.vidu.utility;

import java.io.IOException;
import java.util.List;

import org.eclipse.jetty.util.Scanner.Listener;
import org.testng.annotations.Test;

import com.vidu.model.Customer;

/**
 * @author Vidushi Mishra
 *
 */
public class LoginScript {
	@Test
	public void userLogin() throws  InterruptedException, IOException{
		LoginUtility useloginutility = new LoginUtility();
		List<Customer> cust =useloginutility.loginTesting();
		ExcelUtility eu = new ExcelUtility();
		eu.writeExcel(cust);
	
		
		
		
	}
	

}
