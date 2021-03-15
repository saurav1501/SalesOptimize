package com.salesoptimize.landingpage;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.salesoptimize.utility.BaseClass;



public class LoginSalesOptimizeTest extends BaseClass{
	
	  @Test(groups="Sanity", description="Verify if user is able to login with Valid UserName and password")
	  @Parameters({"rowNum","loginSheet"})
	  public void LoginSalesOptimize(int rowNum,String loginSheet) {
		  
		try { 
		
				login.login(rowNum,"Projects", loginSheet);
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);

			} 
				
}
}