package com.salesoptimize.utility;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.base.Function;
import com.google.common.base.Verify;

public class CommonMethod extends BaseClass {

	static Format formatter = new SimpleDateFormat("YYYY-MM-dd");
	static Date date = new Date();
	public static String fetchedID;
	public static String ProgramID;
	public static String signupID;
	public static String screenshotfile = System.getProperty("user.dir") + "/Screenshots/";
	static WebElement element;


	
	public static WebElement findElement(final String objectLocater) throws IOException {
		Properties OR = new Properties();
		FileInputStream fp = new FileInputStream(
				System.getProperty("user.dir") + "/ObjectRepository/ObjectLocator.properties");
		OR.load(fp);

		String objecttypeandvalues = OR.getProperty(objectLocater);
		String[] splits = objecttypeandvalues.split("~");
		String objecttype = splits[0];

		String objectvalue = splits[1];

		CommonMethod.testlog("Pass", "Finding Locator " +objecttypeandvalues);

		System.out.println("obj val: " + objectvalue);

		switch (objecttype) {

		case "id":
			return driver.findElement(By.id(objectvalue));

		case "xpath":

			return driver.findElement(By.xpath(objectvalue));

		case "name":

			return driver.findElement(By.name(objectvalue));

		case "class":

			return driver.findElement(By.className(objectvalue));

		case "tagname":

			return driver.findElement(By.tagName(objectvalue));

		case "css":

			return driver.findElement(By.cssSelector(objectvalue));

		case "linkText":

			return driver.findElement(By.linkText(objectvalue));
		default:
			CommonMethod.testlog("Fail", "Locator Not Matched " + objectvalue);
			return null;
		}

	}

	public static String stringLocator(final String objectLocater) throws IOException {

		Properties OR = new Properties();
		FileInputStream fp = new FileInputStream(
				System.getProperty("user.dir") + "/ObjectRepository/ObjectLocator.properties");
		OR.load(fp);

		String objecttypeandvalues = OR.getProperty(objectLocater);
		String[] splits = objecttypeandvalues.split("~");
		String objecttype = splits[0];

		String objectvalue = splits[1];

		CommonMethod.testlog("Pass", "Finding Locator " +objecttypeandvalues);

		System.out.println("obj val: " + objectvalue);

		switch (objecttype) {

		case "id":
			return objectvalue;

		case "xpath":

			return objectvalue;


		case "name":

			return objectvalue;


		case "class":

			return objectvalue;


		case "tagname":

			return objectvalue;


		case "css":

			return objectvalue;


		case "linkText":

			return objectvalue;

		default:
			CommonMethod.testlog("Fail", "Locator Not Matched " + objectvalue);
			return null;
		}

	}
	
	
	public static List<WebElement> findElements(String objectLocater) throws IOException {
		Properties OR = new Properties();
		FileInputStream fp = new FileInputStream(
				System.getProperty("user.dir") + "/ObjectRepository/ObjectLocator.properties");
		OR.load(fp);
		String objecttypeandvalues = OR.getProperty(objectLocater);
		String[] splits = objecttypeandvalues.split("~");
		String objecttype = splits[0];
		String objectvalue = splits[1];
		System.out.println("obj val: " + objectvalue);

		switch (objecttype) {

		case "id":
			return driver.findElements(By.id(objectvalue));

		case "xpath":

			return driver.findElements(By.xpath(objectvalue));

		case "name":

			return driver.findElements(By.name(objectvalue));

		case "class":

			return driver.findElements(By.className(objectvalue));

		case "tagname":

			return driver.findElements(By.tagName(objectvalue));

		case "css":

			return driver.findElements(By.cssSelector(objectvalue));

		case "linkText":

			return driver.findElements(By.linkText(objectvalue));
		default:

			return null;
		}

	}

	// user defined click Method
	public static void click(String objectLocater) throws IOException {

		findElement(objectLocater).click();

	}

	public static void click(WebElement objectLocater) throws IOException {

		objectLocater.click();

	}

	// user defined sendkeys Method
	public static void sendKeys(String objectLocater, String value) throws IOException {
		findElement(objectLocater).sendKeys(value);
	}

	// user defined gettext Method
	public static String getText(String objectLocater) throws IOException {

		return findElement(objectLocater).getText();

	}

	public static String getText(WebElement objectLocater) throws IOException {

		return objectLocater.getText();

	}

	public static void refreshBrowser() throws IOException {

		driver.navigate().refresh();

	}

	public static String getattributeValue(String objectLocater) throws IOException {

		return findElement(objectLocater).getAttribute("value");

	}

	public static String getattributeLabel(String objectLocater) throws IOException {

		return findElement(objectLocater).getAttribute("label");

	}

	// user defined clear Method
	public static void clear(String objectLocater) throws IOException {
		findElement(objectLocater).clear();

	}

	public static void uploadFile(String objectLocater, String file) throws IOException {
		findElement(objectLocater).sendKeys(file);
		;

	}

	public static void navigateBack() {

		driver.navigate().back();
	}

	public static void assertTruegetAttributeComparision(String objectLocater, String name, String message)
			throws IOException {
		Assert.assertTrue(findElement(objectLocater).getAttribute("value").equalsIgnoreCase(name), message);
	}

	public static void moveToElement(String objectLocator) throws IOException {
		Actions action = new Actions(driver);
		action.moveToElement(findElement(objectLocator)).build().perform();

	}

	public static void moveToElementAndClick(String objectLocator) throws IOException {
		Actions action = new Actions(driver);
		action.moveToElement(findElement(objectLocator)).click().build().perform();

	}

	public static void moveToElementAndClick(WebElement objectLocator) throws IOException {

		Actions action = new Actions(driver);
		action.moveToElement(objectLocator).click().build().perform();

	}

	public static boolean isSelected(WebElement objectLocater) throws IOException {

		return objectLocater.isSelected();

	}

	public static boolean isSelected(String objectLocater) throws IOException {

		return findElement(objectLocater).isSelected();

	}

	public static void ClickFirstElementInList(String objectLocator) throws IOException, InterruptedException {

		if (IsDimensionOK(objectLocator)) {
			List<WebElement> li = findElements(objectLocator);
			if (!CommonMethod.isSelected(li.get(0))) {
				Thread.sleep(2000);
				li.get(0).click();
			}
		}
	}

	public static void ClickSecondElementInList(String objectLocator) throws IOException {

		List<WebElement> li = findElements(objectLocator);
		if (!CommonMethod.isSelected(li.get(1))) {
			li.get(1).click();
		}
	}

	public static void OpenNewTab(String objectLocator) throws IOException {

		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
		findElement(objectLocator).sendKeys(selectLinkOpeninNewTab);
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
	}

	public static void OpenNewTab(WebElement objectLocator) throws IOException {

		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
		objectLocator.sendKeys(selectLinkOpeninNewTab);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
	}

	public static void switchToParentTab() throws Exception {

		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());

		String i = tabs.get(0);
		System.out.println(i);
		for (String handle : tabs) {

			if (handle != i) {
				driver.switchTo().window(handle);
				driver.close();
				Thread.sleep(2);

			}
		}
		driver.switchTo().window(i);
		Thread.sleep(2);

	}
	public static void switchToIframe(String objectLocato) throws IOException {
		driver.switchTo().frame(findElement(objectLocato));
		
	}
	
	
	public static void checkTextFieldIsNotEmpty(String objectLocator, String Message) throws IOException {

		String textInsideInputBox = CommonMethod.getattributeValue(objectLocator);

		if (textInsideInputBox.isEmpty()) {
			//testlog.error(Message);
		}
	}

	public static void assertTruebooleanCondition(boolean boo, String message) {

		Assert.assertTrue(boo, message);
	}

	public static void assertEqualsmessage(String objectLocator, String expected, String message) throws IOException {

		System.out.println(getText(objectLocator));
		Assert.assertEquals(getText(objectLocator), expected, message);
	}

	public static void assertEqualsmessageAttributevalue(String objectLocator, String expected, String message)
			throws IOException {

		Assert.assertEquals(getattributeValue(objectLocator), expected, message);
	}

	public static void assertNotSame(String objectLocator, String expected, String message) throws IOException {
		System.out.println(CommonMethod.getText("ErrorMessage"));
		Assert.assertNotSame((findElement(objectLocator)).getText(), expected, message);
	}

	public static void assertcontainsmessage(String objectLocater, String expected, String message) throws IOException {

		System.out.println(CommonMethod.getText(objectLocater));
		Assert.assertTrue(getText(objectLocater).contains(expected), message);
	}

	public static void assertstringcontainsmessage(String actual, String expected, String message) throws IOException {

		Assert.assertTrue(actual.contains(expected), message);
	}

	public static void assertcontainsattributevalue(String objectLocator, String expected, String message)
			throws IOException {

		System.out.println((findElement(objectLocator)).getAttribute("value"));
		Assert.assertTrue((findElement(objectLocator)).getAttribute("value").contains(expected), message);
	}

	public static void assertisElementPresentTrue(String objectLocator, String message) throws IOException {

		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		boolean boo = findElements(objectLocator).size() > 0;
		System.out.println(boo);
		Assert.assertTrue(boo, message);

	}

	public static boolean IsElementPresentTrue(String objectLocator) throws IOException {

		boolean boo = (findElement(objectLocator) != null);
		System.out.println(boo);
		return boo;

	}

	public static boolean isElementsExist(String objectLocator, int TimeInSec) throws IOException {
		boolean boo = findElements(objectLocator).size() > 0;
		System.out.println(boo);
		return boo;
	}

	public static boolean isElementsExistRaw(String xpath, int TimeInSec) throws IOException {
		boolean boo = driver.findElements(By.xpath(xpath)).size() > 0;
		System.out.println(boo);
		return boo;
	}

	public static void assertisElementPresentFalse(String objectLocator, String message) throws IOException {

		boolean boo = findElements(objectLocator).size() > 0;
		System.out.println(boo);
		Assert.assertFalse(boo, message);

	}

	public static void selectdropdownrandom(String objectLocator) throws IOException, InterruptedException {

		Select se = new Select(findElement(objectLocator));
		List<WebElement> ele = se.getOptions();
		int n = new Random().nextInt(ele.size());
		if (n != 0) {
			se.selectByIndex(n);
			Thread.sleep(2000);
			WebElement option = se.getFirstSelectedOption();
			System.out.println(option.getText());
		} else {
			selectdropdownrandom(objectLocator);
		}
	}

	public static void selectdropdown(String objectLocator, String value) throws IOException {

		Select se = new Select(findElement(objectLocator));
		se.selectByVisibleText(value);

	}

	public static String getSelectedDropdownValue(String objectLocator) throws IOException {

		Select select = new Select(findElement(objectLocator));
		WebElement option = select.getFirstSelectedOption();
		String defaultItem = option.getText();
		return defaultItem;

	}

	public static void verifySelectedDropdownValue(String objectLocator, String value) throws IOException {

		Select select = new Select(findElement(objectLocator));
		WebElement option = select.getFirstSelectedOption();
		String defaultItem = option.getText();
		Assert.assertEquals(defaultItem, value, "Dropdown selected value is not correct");

	}

	public static void ClickRandomWebElement(String objectLocator) throws IOException {

		List<WebElement> options = CommonMethod.findElements(objectLocator);
		Random random = new Random();
		int index = random.nextInt(options.size());
		scrolldowntoElement(options.get(index));
		elementToBeClickable(objectLocator, 10);
		if (!CommonMethod.isSelected(options.get(index))) {
			options.get(index).click();
		}
	}

	// Is displayed Method (Assertion)
	public static void Isdisplayed(String objectLocater, String message) throws IOException {

		Assert.assertTrue(findElement(objectLocater).isDisplayed(), message);

	}

	public static boolean Isdisplayed(String objectLocater, int Timeout) throws IOException {
		Boolean boo = null;
		try {
			boo = findElement(objectLocater).isDisplayed();
			System.out.println(boo);

		}

		catch (Exception e) {
			System.out.println("Not displayed");
		}
		return boo;

	}

	public static void IsEnabled(String objectLocater, String message) throws IOException {

		Assert.assertTrue(findElement(objectLocater).isEnabled(), message);

	}

	public static boolean IsEnabled(String objectLocater) throws IOException {

		Boolean boo = findElement(objectLocater).isEnabled();
		System.out.println(boo);
		return boo;

	}

	public static boolean IsDimensionOK(String objectLocater) throws IOException {

		Dimension d = findElement(objectLocater).getSize();
		boolean isVisible = (d.getHeight() > 0 && d.getWidth() > 0);
		System.out.println(isVisible);
		return isVisible;

	}

	public static void assertcontentPageSource(String expectedtext, String message, String SheetName) {
		try {

			Assert.assertTrue(driver.getPageSource().toLowerCase().contains(expectedtext.toLowerCase()), message);
		} catch (AssertionError err) {
		//	testlog.fail(err.toString());
			System.out.println("Inside Catch 2");
			data.setCellData(SheetName, "Status", rownumber, "FAIL");

			// switchToParentTab(); testlog.info("Switching back to parent tab");

		}
	}

	public static void assertFalse(Boolean boo, String message, String SheetName, String CreditName, String URL) {
		try {

			Assert.assertFalse(boo, message);
			System.out.println("Current Rownumber : " + rownumber);
			data.setCellData(SheetName, "RatingSystem", rownumber, TestNGTestName);
			data.setCellData(SheetName, "CreditName", rownumber, CreditName);
			data.setCellData(SheetName, "RedirectedCreditLink", rownumber, URL);
			data.setCellData(SheetName, "Status", rownumber, "PASS");
			rownumber++;
		} catch (AssertionError err) {
			//testlog.fail(err.toString());
			System.out.println("Inside Catch 1");
			System.out.println("Fail Rownumber : " + rownumber);
			data.setCellData(SheetName, "RatingSystem", rownumber, TestNGTestName);
			data.setCellData(SheetName, "CreditName", rownumber, CreditName);
			data.setCellData(SheetName, "RedirectedCreditLink", rownumber, URL);
			data.setCellData(SheetName, "Status", rownumber, "FAIL");
			rownumber++;

			// switchToParentTab(); testlog.info("Switching back to parent tab");

		}
	}

	public static void verifycontentPageSource(String expectedtext, String message) {

		Verify.verify(driver.getPageSource().contains(expectedtext), message);
	}

	public static void assertcurrentUrl(String expectedUrl, String message) {
		System.out.println(driver.getCurrentUrl());
		System.out.println(expectedUrl);
		Assert.assertTrue(driver.getCurrentUrl().equals(expectedUrl), message);

	}

	public static void CheckExternalLink(String objectLink, String expectedUrl, String message)
			throws IOException, InterruptedException {

		moveToElement(objectLink);
		Thread.sleep(1000);
		click(objectLink);
		Thread.sleep(3000);
		Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, message);

	}

	public static void CheckExternalLinkMiddleElements(String objectLink, String expectedUrl, String message)
			throws IOException, InterruptedException {

		scrolldowntoElement(objectLink);
		scrollUp();
		click(objectLink);
		Thread.sleep(3000);
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, message);
		driver.close();
		driver.switchTo().window(tabs2.get(0));
		Thread.sleep(3000);

	}

	public static void CheckExternalLinkNewTab(String objectLink, String expectedUrl, String message)
			throws IOException, InterruptedException {

		moveToElement(objectLink);
		Thread.sleep(1000);
		click(objectLink);
		Thread.sleep(3000);
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, message);
		driver.close();
		driver.switchTo().window(tabs2.get(0));
		Thread.sleep(3000);

	}

	public static void scrolldowntoLast() {

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public static void scrollUp() {

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, 0)", "");
	}

	public static void scrollDown() {

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollBy(0,1500)", "");
	}

	//

	public static void scrolldowntoElement(String objectLocater) throws IOException {

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", findElement(objectLocater));
	}

	public static void scrolldowntoElement(WebElement objectLocater) throws IOException {

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", objectLocater);
	}

	public static boolean isFileDownloaded(String downloadPath, String fileName) {
		boolean flag = false;
		File dir = new File(downloadPath);
		File[] dir_contents = dir.listFiles();

		for (int i = 0; i < dir_contents.length; i++) {
			if (dir_contents[i].getName().equals(fileName))
				return flag = true;
		}

		return flag;
	}

	public static void VerifyDownloadWithFileName(String filename) {

		Assert.assertTrue(isFileDownloaded(downloadPath, filename), "Failed to download Expected document");
	}

	public static void VerifyFileDownloadWithExtension(String filename, String extension) {

		Assert.assertTrue(isFileDownloaded(downloadPath, filename), "Failed to download Expected document");
	}

	

	public static String setDateFormat(String Dateformat) {

		Format formatter = new SimpleDateFormat(Dateformat);
		String date = formatter.format(new Date());
		return date;
	}

	public static String setDateFormatFuture(String Dateformat, int FutureDays) {
		Format formatter = new SimpleDateFormat(Dateformat);
		formatter.format(new Date());
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, FutureDays);
		String newDate = formatter.format(c.getTime());
		return newDate;
	}

	public static List<String> fetchTableData(String objectLocator) throws IOException {

		List<String> value = new ArrayList<String>();

		WebElement table = (findElement(objectLocator));

		// Now get all the TR elements from the table
		List<WebElement> allRows = table.findElements(By.tagName("tr"));
		// And iterate over them, getting the cells
		for (WebElement row : allRows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			for (WebElement cell : cells) {
				System.out.println("content >>   " + cell.getText());
				value.add(cell.getText());
			}
		}
		return value;

	}

	public static String takeScreenshot(String methodname) throws IOException {
		try {

			TakesScreenshot ts = (TakesScreenshot) driver;
			File Source = ts.getScreenshotAs(OutputType.FILE);
			String Dest = screenshotfile + methodname + ".png";
			File Destination = new File(Dest);
			FileHandler.copy(Source, Destination);

			return Dest;
		}

		catch (Exception e) {

			System.out.println("Exception Taking screenshot" + e.getMessage());
			return e.getMessage();
		}

	}

	public static String randomNumber() throws IOException, InterruptedException {

		int random_num = 1;
		Random t = new Random();

		// random integers in [1000, 800000]
		random_num = (t.nextInt(800000));
		ProgramID = String.valueOf(random_num);

		System.out.println(ProgramID);
		Thread.sleep(1000);
		return ProgramID;

	}

	
	
	public static String filereadID(String url) throws IOException {

		FileReader inputFile = new FileReader(url);

		// Instantiate the BufferedReader Class
		BufferedReader bufferReader = new BufferedReader(inputFile);

		// Variable to hold the one line data

		String text;
		// Read file line by line and print on the console
		while ((text = bufferReader.readLine()) != null) {

			fetchedID = text;
			// System.out.println(CommonMethod.ProgramID);

		}

		// Close the buffer reader
		bufferReader.close();
		return fetchedID;
	}

	public static void waitForPageLoaded() throws IOException {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};
		try {
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(driver, 70);
			wait.until(expectation);
		} catch (Exception e) {
			System.out.println("Timeout waiting for Page Load Request to complete.");
			refreshBrowser();
		}
	}

	public static WebElement presenceOfElementLocated(String objectlocator, int TimeinSeconds) throws IOException {
		wait = new WebDriverWait(driver, TimeinSeconds);
		return wait.until(ExpectedConditions.presenceOfElementLocated((By) findElement(objectlocator)));

	}

	public static Boolean WaitUntilStaleness(WebElement objectlocator, int TimeinSeconds) throws IOException {
		WebDriverWait wait = new WebDriverWait(driver, TimeinSeconds);
		return wait.until(ExpectedConditions.stalenessOf(objectlocator));

	}

	public static Boolean invisibilityOf(String objectlocator, int TimeinSeconds) throws IOException {
		WebDriverWait wait = new WebDriverWait(driver, TimeinSeconds);
		return wait.until(ExpectedConditions.invisibilityOf(findElement(objectlocator)));

	}
	
	public static WebElement visibilityOf(String objectlocator, int TimeinSeconds) throws IOException {
		 wait = new WebDriverWait(driver, TimeinSeconds);
		return wait.until(ExpectedConditions.visibilityOf(findElement(objectlocator)));

	}

	public static WebElement elementToBeClickable(String objectlocator, int TimeinSeconds) throws IOException {
		 wait = new WebDriverWait(driver, TimeinSeconds);
		return wait.until(ExpectedConditions.elementToBeClickable(findElement(objectlocator)));
	}

	public static void displayhiddenElement(String objectLocator) throws IOException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'display:block !important;')", findElement(objectLocator));
	}

	public static void setClipboardData(String string) {
		// StringSelection is a class that can be used for copy and paste operations.
		StringSelection stringSelection = new StringSelection(string);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	}

	public static void removeReadOnly(String id) {

		((JavascriptExecutor) driver)
				.executeScript("document.getElementById('" + id + "').removeAttribute('readonly',0);");

	}

	public static void ArcSpecifictoggle(String objectLocator) throws IOException, InterruptedException {

		click("ProjectsSideBar");
		moveToElement(objectLocator);
		Thread.sleep(2000);
		click(objectLocator);
		testlog("Pass", "Clicking " + objectLocator);
	}

	public static void fluentWait(final String objectLocater) {

		 FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(maxWait))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class)
			    .withMessage("Element Not Found");

		wait.until(new Function<WebDriver, WebElement>() {

			
			public WebElement apply(WebDriver input) {
					try {
						  element = findElement(objectLocater);
					} catch (IOException e) {
						e.printStackTrace();
						throw new RuntimeException(e);
					}
					return element;
			}
			
			
			
		});

	}

	public static void testlog(String log, String message) {
		System.out.println(log);
		switch (log) {
		case "Pass":
			testlog.get().pass(message);
			break;
		case "Info":
			testlog.get().info(message);
			break;

		case "Fail":
			testlog.get().fail(message);
			break;
		default:
			System.out.println("Not Valid Input");
		}

	}

	
	
	public static void poll(long milis) {
		try {
			Thread.sleep(milis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}