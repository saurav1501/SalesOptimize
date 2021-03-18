package com.salesoptimize.reusablemethods;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.salesoptimize.utility.BaseClass;
import com.salesoptimize.utility.CommonMethod;

public class ReusableMethodsDashboard extends BaseClass {

	public void selectBusinessCountry(int rowNum, String country) throws Exception {

		CommonMethod.testlog("Pass", "Test Starated");
		CommonMethod.scrolldowntoElement("businessdropdown");
		CommonMethod.click("businessdropdown");

		CommonMethod.moveToElement("businessCountryPuls");
		CommonMethod.click("businessCountryPuls");

		CommonMethod.sendKeys("businesscountry", data.getCellData(country, "BusinessLocation", rowNum));

		CommonMethod.visibilityOf("FirstResult", minWait);
		CommonMethod.click("FirstResult");

		Assert.assertEquals(CommonMethod.getText("BusinessCountryText"),
				data.getCellData(country, "BusinessLocation", rowNum), "Success");
		CommonMethod.testlog("Pass", "Test Passed");
	}

	public void selectIndustryRetailAndFashiClothing(int rowNum, String country) throws Exception {
		CommonMethod.testlog("Pass", "Test Starated");

		CommonMethod.moveToElement("industryDropdown");
		CommonMethod.click("industryDropdown");

		CommonMethod.moveToElement("IndustoryPlus");
		CommonMethod.click("IndustoryPlus");

		CommonMethod.moveToElement("Selectindustry");
		CommonMethod.sendKeys("Selectindustry", data.getCellData(country, "Industry", rowNum));

		CommonMethod.visibilityOf("FirstResult", minWait);
		CommonMethod.click("FirstResult");

		Assert.assertEquals(CommonMethod.getText("Industorychosen"), data.getCellData(country, "Industry", rowNum),
				"Success");

		CommonMethod.visibilityOf("SubIndustoryPlus", minWait);
		CommonMethod.elementToBeClickable("SubIndustoryPlus", minWait);
		CommonMethod.click("SubIndustoryPlus");

		CommonMethod.visibilityOf("GlobalRegion", minWait);
		CommonMethod.sendKeys("GlobalRegion", data.getCellData(country, "Industry", 3));

		CommonMethod.visibilityOf("FirstResult", minWait);
		CommonMethod.click("FirstResult");

		Assert.assertEquals(CommonMethod.getText("SubIndustory"), data.getCellData(country, "Industry", 3), "Success");
		CommonMethod.testlog("Pass", "Test Passed");

	}

	public void selectCompanyTurnover1AndAbove(int rowNum, String country) throws Exception {
		CommonMethod.testlog("Pass", "Test Starated");
		CommonMethod.elementToBeClickable("merchantFilter", minWait);
		CommonMethod.click("merchantFilter");
		CommonMethod.scrolldowntoElement("companyTurnoverSliderStart");
		Thread.sleep(2000);
		CommonMethod.dragAndDrop("companyTurnoverSliderStart", "companyTurnoverSliderEnd");
		CommonMethod.testlog("Pass", "Able to select Company Turnover as 1M and above");
		CommonMethod.testlog("Pass", "Test Passed");

	}

	public void searchButtonAndCaptureResult(int rowNum, String searchresult) throws Exception {
		CommonMethod.testlog("Pass", "Test Starated");
		CommonMethod.elementToBeClickable("searchButton", minWait);
		CommonMethod.click("searchButton");
		CommonMethod.visibilityOf("numberOfResult", minWait);
		String data = CommonMethod.getText("numberOfResult");
		Assert.assertEquals(data,"163 results found");
		CommonMethod.testlog("Pass", "Test Passed");
	}

	public void firstRecordCaptureDetail(int rowNum, String country) throws Exception {
		CommonMethod.testlog("Pass", "Test Starated");
		CommonMethod.elementToBeClickable("info", minWait);
		CommonMethod.click("info");
		Thread.sleep(3000);
		CommonMethod.switchToNewTab();
		Thread.sleep(2000);
		CommonMethod.Isdisplayed("newTabValue", minWait);

		for (int i = 2; i <= 11; i++) {
			if (i == 9) {
				System.out.println("Extra Space");
			} else if (i == 10 || i == 11) {
				int j = i;
				j = j - 1;

				data.setCellData(country, "CompanyDetails", j,
						driver.findElement(By.xpath("(//table/tbody/tr[" + i + "]/td[1])[1]")).getText());
				data.setCellData(country, "Values", j,
						driver.findElement(By.xpath("(//table/tbody/tr[" + i + "]/td[2])[1]")).getText());

			} else {
				System.out.println(data.setCellData(country, "CompanyDetails", i,
						driver.findElement(By.xpath(
								"(//table/tbody/tr[" + i + "]/td[1])[1]"))
								.getText()));
				System.out.println(data.setCellData(country, "Values", i,
						driver.findElement(By.xpath(
								"(//table/tbody/tr["+i+"]/td[2])[1]"))
								.getText()));

			}
		}
		CommonMethod.testlog("Pass", "Captured All table values");
		CommonMethod.testlog("Pass", "Test Passed");
	}

}
