package com.salesoptimize.landingpage;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.salesoptimize.utility.BaseClass;

public class SearchButtonAndCaptureResultTest extends BaseClass{
	
	  @Test(groups="Sanity", description="Verify if User is be able to click on the Search button and see the no. of results returned")
	  @Parameters({"rowNum","dashboardSheet"})
	  public void SearchButtonAndCaptureResult(int rowNum,String dashboardSheet) {
		  
		try { 
			
				dashboard.searchButtonAndCaptureResult(rowNum, dashboardSheet);
				

			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);

			} 
				
}
}