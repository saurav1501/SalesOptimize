package com.salesoptimize.landingpage;

import org.testng.annotations.Test;

import com.salesoptimize.utility.BaseClass;



public class LoginSalesOptimizeTest extends BaseClass{
	
	  @Test(groups="Sanity", description="Verify if User was able to successfully sign in the app")
	  public void LoginSalesOptimize() {
		  
		try { 
		
				login.login();
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);

			} 
				
}
}