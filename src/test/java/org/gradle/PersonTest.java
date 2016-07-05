package org.gradle;

import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PersonTest {
	
	//@FindBy(id= "username") private WebElement userName;
	//@FindBy(id= "password") private WebElement password;
	//@FindBy(id= "login") private WebElement loginBtn;
    
	@Test
    public void canConstructAPersonWithAName() {
        Person person = new Person("Larry");
        assertEquals("Larry1", person.getName());
    }
		
	
	@Test
	public void canConstructAPersonWithAName3() {
		//System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
	
		  ChromeDriver chromeDriver = new ChromeDriver();
		  System.out.print("Window maximise");
		  chromeDriver.get("http://www.ufthelp.com/2015/01/Java-Interface-example-in-Selenium.html");
		  System.out.print("Site Open");
		  System.out.println(chromeDriver.getTitle());		    
		  System.out.print("End of Test");
		  chromeDriver.close();
    }	
}
