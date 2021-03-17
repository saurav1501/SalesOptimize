package com.salesoptimize.landingpage;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.salesoptimize.utility.BaseClass;

public class SelectBusinessCountryTest extends BaseClass{
	
	  @Test(groups="Sanity", description="Verify if User was able to select Business Country as United Kingdom")
	  @Parameters({"rowNum","dashboardSheet"})
	  public void SelectBusinessCountry(int rowNum,String dashboardSheet) {
		  
		try { 
			
				dashboard.selectBusinessCountry(rowNum, dashboardSheet);
				

			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);

			} 
				
}
}