package com.salesoptimize.reusablemethods;

import org.testng.Assert;

import com.salesoptimize.utility.BaseClass;
import com.salesoptimize.utility.CommonMethod;

public class ReusableMethodsLogin extends BaseClass {

public void login() throws Exception {
		CommonMethod.elementToBeClickable("Email", minWait);
		CommonMethod.sendKeys("Email", username);
		CommonMethod.sendKeys("Password", password);
		CommonMethod.click("LoginButton");
		CommonMethod.isElementsExist("Profile", minWait);
		Assert.assertEquals(CommonMethod.getText("Profile"), username);
		
	}
	
	}
