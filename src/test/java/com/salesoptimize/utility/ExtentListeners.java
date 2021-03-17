package com.salesoptimize.utility;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class ExtentListeners extends BaseClass implements ITestListener {

	/*static Date d = new Date();
	String fileName = new String(System.getProperty("user.dir") + "/Reports/ARC_Automation_"
			 +d.toString().replace(":", "_").replace(" ", "_") + ".html"); */
	

	public static ThreadLocal<ExtentTest> testLog;

	public void onTestStart(ITestResult result) {

		ExtentTest test = extent.createTest(/*result.getTestClass().getName()*/ result.getMethod().getMethodName()+"Test",result.getMethod().getDescription());

		String[] group = result.getMethod().getGroups();
		for (String groups : group) {
			test.assignCategory(groups);
		}
		test.assignAuthor("SalesOptimize " + SuiteName);
		testLog = new ThreadLocal<>();
		testLog.set(test);
		testlog = testLog;

	}

	public void onTestSuccess(ITestResult result) {

		String methodName = result.getMethod().getMethodName();
		//String logText = "<b>" + "TEST CASE:- " + methodName.toUpperCase() + " PASSED" + "</b>";
		String logText = "<b>" + "PASSED" + "</b>";
		
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		testLog.get().pass(m);

	}

	public void onTestFailure(ITestResult result) {

		String excepionMessage = Arrays.toString(result.getThrowable().getStackTrace());

		testLog.get()
				.fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>"
						+ "Exception Occured : Click to see All Exception Logs->" + "</font>" + "</b >" + "</summary>"
						+ excepionMessage.replaceAll(",", "<br>") + "</details>" + " \n");

		String path = System.getProperty("user.dir")+"/Reports/Screenshots/" +result.getTestClass().getName()
				+ result.getMethod().getMethodName() + ".png";

		/*
		 * try {
		 * 
		 * ExtentManager.captureScreenshot(); testLog.get().fail("<b>" + "<font color="
		 * + "red>" + "Screenshot of failure" + "</font>" + "</b>",
		 * MediaEntityBuilder.createScreenCaptureFromPath(ExtentManager.screenshotName)
		 * .build()); } catch (IOException e) {
		 */

		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(700))
				.takeScreenshot(driver);
		try {
			ImageIO.write(screenshot.getImage(), "png", new File(path));

		} catch (IOException e) {
			e.printStackTrace();

		}
		try {
			
			if(System.getProperty("os.name").equalsIgnoreCase("Windows 10")){					
			String jenkinsScreenshot = "http://localhost:8080/job/Test/ws/Reports/Screenshots/"+result.getTestClass().getName()+ result.getMethod().getMethodName() + ".png";
            testLog.get().fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>"
							+ "Screenshot of failure : Click to see the Failure Image ->" + "</font>" + "</b>"
							+ "</summary>" + "<a href=" + jenkinsScreenshot + "><img height=600 width=400 target=_blank src=" + jenkinsScreenshot
							+ "></a>" + "</details>");
			} 
		else
			{					
            testLog.get()
				.fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>"
						+ "Screenshot of failure : Click to see the Failure Image ->" + "</font>" + "</b>"
						+ "</summary>" + "<a href=" + path + "><img height=500 width=300 target=_blank src=" + path
						+ "></a>" + "</details>");
			}
			
		
		}catch (Exception e) {
			e.printStackTrace();
			testLog.get().fail(e);
		}

		String failureLogg = "TEST CASE FAILED";
		Markup m = MarkupHelper.createLabel(failureLogg, ExtentColor.RED);
		testLog.get().log(Status.FAIL, m);

	}

	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		String logText = "<b>" + "Test Case:- " + methodName + " Skipped" + "</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		testLog.get().log(Status.SKIP, m);

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		testLog.get().info("On Test Failed but With Success Percentage :"+result.getName());

	}

	public void onStart(ITestContext context) {
			
	}

	public void onFinish(ITestContext context) {

		extent.flush();

	}

}
