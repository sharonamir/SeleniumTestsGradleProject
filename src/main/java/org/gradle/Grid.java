package org.gradle;

import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Grid {
	WebDriver driver;

	public Grid(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Return HashMap with TableHeader - column's name and input element
	 * 
	 * @return HashMap<String, WebElement>
	 */
	public HashMap<String, WebElement> GetTableHeader() {
		HashMap<String, WebElement> columnsNameList = new HashMap<String, WebElement>();
		WebElement tableHead = driver.findElement(By.className("ui-state-default"));
		List<WebElement> cellHeadList = tableHead.findElements(By.tagName("th"));
		for (WebElement cellHead : cellHeadList) {
			cellHead.findElement(By.className("ui-column-title")).getText();
			columnsNameList.put(cellHead.findElement(By.className("ui-column-title")).getText(),
					cellHead.findElement(By.className("ui-column-filter")));
		}
		return columnsNameList;
	}
	
	/**
	 * Click on Grouping button
	 */
	public void OpenGroupScreen() {
		WebElement GroupingClass = driver.findElement(By.className("ui-widget-header"));
		GroupingClass.findElement(By.xpath("//button[@label='Grouping...']")).click();
	}

	public void VerifyGroupingPopUp(HashMap<String, WebElement> columnsList) {				
		WebElement avilableColumnsContent = driver.findElements(By.className("ui-widget-content")).get(0);		
				
	}

	public void VerifyList(WebElement webElement, HashMap<String, WebElement> list) {
		for(WebElement li : webElement.findElements(By.tagName("li"))){
			
		}
		
	}
	
	
	

}
