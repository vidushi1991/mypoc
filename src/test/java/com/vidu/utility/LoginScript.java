/**
 * 
 */
package com.vidu.utility;

import java.io.IOException;
import java.util.List;

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
		useloginutility.loginTesting();
	}
	@Test
	public void saveExceldata() throws IOException{
		ExcelUtility eu = new ExcelUtility();
		List<Customer> cust =eu.readExcel();
		eu.writeExcel(cust);
	}

}
