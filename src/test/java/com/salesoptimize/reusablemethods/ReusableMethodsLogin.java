package com.salesoptimize.reusablemethods;

import java.io.IOException;

import com.salesoptimize.utility.BaseClass;
import com.salesoptimize.utility.CommonMethod;

public class ReusableMethodsLogin extends BaseClass {


	public String cemail;
	public String cpass;

	public void clickSignin() throws IOException, InterruptedException {
		CommonMethod.fluentWait("SignIn");
		CommonMethod.click("SignIn");
		Thread.sleep(1000);
		CommonMethod.testlog("Pass", "Clicking on signIn Button");

	}

		public void getDataForLogin(String sheetName, int col) {
		cemail = username;
		cpass = password;
		CommonMethod.testlog("Info", "Getting Login data from Property File");
	}

	// filling contact form
	public void fillLoginDetails() throws IOException {
		CommonMethod.clear("EmailID");
		CommonMethod.sendKeys("EmailID", cemail);
		CommonMethod.clear("Password");
		CommonMethod.sendKeys("Password", cpass);
		CommonMethod.testlog("Pass", "Filling Login Details");

	}

	// click on submit button
	public void clickOnSubmit() throws IOException, Exception {
		CommonMethod.click("LoginSubmit");
		CommonMethod.testlog("Info", "Clicking on submit button");
		//CommonMethod.waitUntilAngularReady();
		Thread.sleep(5000);

	}

	public void clickAccept() throws IOException, Exception {
		CommonMethod.click("Accept");
		CommonMethod.testlog("Pass", "Accepting Checkbox");
		Thread.sleep(1000);

	}

	public void assertPostLoginText(String Exp_PostLoginText) throws IOException {
		CommonMethod.visibilityOf("Projects",maxWait);
		CommonMethod.assertEqualsmessage("Projects", Exp_PostLoginText, "Welcome Text is not correct");
		CommonMethod.testlog("Pass", "Navigate to Welcome Page");

	}
	public void clickOnProject() throws  Exception {
		CommonMethod.click("Projects");
		CommonMethod.testlog("Pass", "Clicked on Project Button");
		
	}
	
public void login(int col, String Postlogintext, String sheetName) throws Exception {
		CommonMethod.elementToBeClickable("SignIn", minWait);
		clickSignin();
		getDataForLogin(sheetName, col);
		fillLoginDetails();
		clickAccept();
		clickOnSubmit();
		assertPostLoginText(Postlogintext);
		clickOnProject();
	}
	
	}
