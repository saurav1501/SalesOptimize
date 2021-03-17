package com.salesoptimize.landingpage;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.salesoptimize.utility.BaseClass;

public class SelectIndustryRetailAndFashiClothingTest extends BaseClass{
	
	  @Test(groups="Sanity", description="Verify if User is able to select Industry as Retail and Sub Industry as Fashion & Clothing")
	  @Parameters({"rowNum","dashboardSheet"})
	  public void SelectIndustryRetailAndFashiClothing(int rowNum,String dashboardSheet) {
		  
		try { 
			
				dashboard.selectIndustryRetailAndFashiClothing(rowNum, dashboardSheet);
			
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);

			} 
				
}
}