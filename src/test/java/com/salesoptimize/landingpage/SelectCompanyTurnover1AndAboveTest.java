package com.salesoptimize.landingpage;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.salesoptimize.utility.BaseClass;

public class SelectCompanyTurnover1AndAboveTest extends BaseClass{
	
	  @Test(groups="Sanity", description="Verify if User is able to select Company Turnover as 1M and above")
	  @Parameters({"rowNum","dashboardSheet"})
	  public void SelectCompanyTurnover1AndAbove(int rowNum,String dashboardSheet) {
		  
		try { 
			
				dashboard.selectCompanyTurnover1AndAbove(rowNum, dashboardSheet);
				

			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);

			} 
				
}
}