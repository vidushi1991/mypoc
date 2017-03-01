/**
 * 
 */
package com.vidu.utility;

import java.io.IOException;

import org.testng.annotations.Test;

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

}
