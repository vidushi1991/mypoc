/**
 * 
 */
package bookfariscripts;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;

import com.vidu.model.Customer;
import com.vidu.utility.ExcelUtility;
import com.vidu.utility.LoginUtility;

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
