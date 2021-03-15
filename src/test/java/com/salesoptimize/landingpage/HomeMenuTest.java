package com.salesoptimize.landingpage;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.salesoptimize.utility.BaseClass;

public class HomeMenuTest extends BaseClass{
	
	  @Test(groups="Sanity", description="Verify if user is able to navigate to home page")
	  public void HomeMenu() {
		  
		try { 
		         navigation.navigateToGetStarted();
				
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);

			} 
				
}
}