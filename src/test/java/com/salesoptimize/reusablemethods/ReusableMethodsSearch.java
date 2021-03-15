package com.salesoptimize.reusablemethods;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.testng.Assert;

import com.salesoptimize.utility.BaseClass;
import com.salesoptimize.utility.CommonMethod;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class ReusableMethodsSearch extends BaseClass{

	

	public void SearchProgram(String Leedid)throws IOException, InterruptedException {
		CommonMethod.IsEnabled("SearchField", "Search field is not enabled");
		CommonMethod.clear("SearchField");
		CommonMethod.testlog("Pass", "Clearing values in search field");
		CommonMethod.sendKeys("SearchField",Leedid);
		CommonMethod.click("SearchField");
		CommonMethod.testlog("Pass", "Entering Project name in searchfield "+ Leedid);
		
	}

	

	public void VerifySearchedProgram(String Leedid)
		throws IOException, InterruptedException {
		SearchProgram(Leedid);
		Thread.sleep(3000);
		CommonMethod.fluentWait("NumberOfProject");
		String NoOfProject=CommonMethod.getText("NumberOfProject");
		System.out.println(NoOfProject);
		
		
		Assert.assertEquals("Project (1 project)", NoOfProject);
		CommonMethod.testlog("Pass", "Searched total (1 project) Number of Projects");
		CommonMethod.click("fetchedSearchResult");
		CommonMethod.testlog("Pass", "Clicking on searched project from search bar");
	  
		
		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		ImageIO.write(screenshot.getImage(), "jpg", new File(".\\screenshot\\ashotimgelement.jpg"));
		
		
	}

}
