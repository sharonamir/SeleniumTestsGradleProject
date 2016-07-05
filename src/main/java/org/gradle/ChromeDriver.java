package org.gradle;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeDriver implements WebDriverInterface {

	private ChromeDriver driver;

	public ChromeDriver() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();	
		this.DesiredCapabilities();
	}

	public void get(String url) {
		driver.get(url);
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public List<WebElement> findElements(By by) {
		return driver.findElements(by);
	}

	public WebElement findElement(By by) {
		return driver.findElement(by);
	}

	public String getPageSource() {
		return driver.getPageSource();
	}

	public void close() {
		driver.close();
	}

	public void quit() {
		driver.quit();
	}

	public Set<String> getWindowHandles() {
		return driver.getWindowHandles();
	}

	public String getWindowHandle() {
		return driver.getWindowHandle();
	}

	public TargetLocator switchTo() {
		return driver.switchTo();
	}

	public Navigation navigate() {
		return driver.navigate();
	}

	public Options manage() {
		return driver.manage();
	}

	public void DesiredCapabilities() {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setJavascriptEnabled(true);
		desiredCapabilities.setCapability("databaseEnabled", true);
		desiredCapabilities.setCapability("locationContextEnabled", true);
		desiredCapabilities.setCapability("locationContextEnabled", true);
		desiredCapabilities.setCapability("unexpectedAlertBehaviour","accept");				
	}

}
