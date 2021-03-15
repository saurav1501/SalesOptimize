package com.salesoptimize.reusablemethods;

import java.io.IOException;

import com.salesoptimize.utility.BaseClass;
import com.salesoptimize.utility.CommonMethod;

public class ReusableMethodsNavigation extends BaseClass{
	
	    public void navigateToGetStarted() throws IOException {
	    	CommonMethod.visibilityOf("HomeTab",maxWait);
	    	CommonMethod.click("HomeTab");
	    	log.info("clicked on the home button");
	    	
	    }
	    
}
