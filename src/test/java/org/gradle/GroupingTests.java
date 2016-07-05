package org.gradle;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GroupingTests {

	WebDriver driver;
	/*
	 * @Test(dataProvider = "dp") public void f(Integer n, String s) { }
	 */
		
	@Test(enabled=false)
	public void VerifyPopIsOpenWithAvialableColumns() {
		
		Grid grid = new Grid(driver);

		HashMap<String, WebElement> columnsList = grid.GetTableHeader();

		grid.OpenGroupScreen();

		assertEquals(driver.findElements(By.className("ui-picklist-caption")).get(0).getText(), "Available Columns");

		assertEquals(driver.findElements(By.className("ui-picklist-caption")).get(1).getText(), "Chosen Columns");

		List<WebElement> liTagsList = driver.findElements(By.className("ui-dialog")).get(0)
				.findElements(By.className("ui-widget-content")).get(0).findElements(By.tagName("li"));

		for (WebElement li : liTagsList) {
			if (!columnsList.containsKey(li.findElement(By.tagName("div")).getText())) {
				assertFalse(li.findElement(By.tagName("div")).getText() + " is not part of table header", true);
			}

		}

		if (liTagsList.size() != columnsList.size())
			assertEquals("Avilable columns is not complete", columnsList.size(), liTagsList.size());
	}
	
	@Parameters({"column"})
	@Test
	public void ChooseOneColumn(String column) {
		
		Grid grid = new Grid(driver);

		HashMap<String, WebElement> columnsList = grid.GetTableHeader();

		grid.OpenGroupScreen();

		List<WebElement> liTagsList = driver.findElements(By.className("ui-dialog")).get(0)
				.findElements(By.className("ui-widget-content")).get(0).findElements(By.tagName("li"));

		for(WebElement li : liTagsList){
			if(li.getText().equalsIgnoreCase(column)){
				li.click();
				driver.findElement(By.xpath("//button[@icon='fa-angle-right']")).click();
				driver.findElement(By.xpath("//button[@icon='fa-check']")).click();
			}
					
		}
	}

	@BeforeMethod
	public void beforeMethod() {

	}

	@AfterMethod
	public void afterMethod() {
	}

	@DataProvider
	public Object[][] dp() {
		return new Object[][] { new Object[] { 1, "a" }, new Object[] { 2, "b" }, };
	}

	@BeforeClass
	public void beforeClass() {
	}

	@AfterClass
	public void afterClass() {
	}

	@BeforeTest
	@Parameters("browser")
	public void beforeTest(@Optional("Chrome")String browser) {
		if (browser.equalsIgnoreCase("Chrome")) {
			DesiredCapabilities caps = DesiredCapabilities.chrome();
			driver = new ChromeDriver(caps);			
		} else if (browser.equalsIgnoreCase("IE")) {
			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
			driver = new InternetExplorerDriver(caps);
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://192.168.168.177:8080/");
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

	@BeforeSuite
	public void beforeSuite() {
	}

	@AfterSuite
	public void afterSuite() {
	}

}
