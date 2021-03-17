package com.salesoptimize.landingpage;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.salesoptimize.utility.BaseClass;

public class FirstRecordCaptureDetailTest extends BaseClass{
	
	  @Test(groups="Sanity", description="Verify if User is able to click on 'Info' for the first record and see values for fields 'Group Turnover', 'Business Location', 'Industry', and 'Sub-Industry'")
	  @Parameters({"rowNum","dashboardSheet"})
	  public void FirstRecordCaptureDetail(int rowNum,String dashboardSheet) {
		  
		try { 
			
				dashboard.firstRecordCaptureDetail(rowNum, dashboardSheet);
				
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);

			} 
				
}
}