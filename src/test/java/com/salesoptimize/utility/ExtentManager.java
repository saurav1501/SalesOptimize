package com.salesoptimize.utility;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentManager extends BaseClass {
	
	public static ExtentReports extent;

	        public static ExtentReports createInstance(String fileName) {
	       
	        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);        
	        htmlReporter.config().setTheme(Theme.STANDARD);
	        htmlReporter.config().setDocumentTitle(fileName);
	        htmlReporter.config().setEncoding("utf-8");
	        htmlReporter.config().setReportName(fileName);
	        htmlReporter.setAppendExisting(false);
	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	        extent.setSystemInfo("Host Name", "jenkins");
			extent.setSystemInfo("OS", "Linux 64bit");
			extent.setSystemInfo("Environment", environment);
			extent.setSystemInfo("BrowserName", browserName);
			extent.setSystemInfo("User Name", "Saurav Sinha");
			extent.setAnalysisStrategy(AnalysisStrategy.TEST);

	        return extent;
	    }

	    
	  /*  public static String screenshotPath;
		public static String screenshotName;
		
		public static void captureScreenshot() {

			File scrFile = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);

			Date d = new Date();
			screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

			try {
				FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "\\reports\\" + screenshotName));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
		}*/
	

	}
