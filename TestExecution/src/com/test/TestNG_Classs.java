package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG_Classs {
	
	public static WebDriver driver;
	
  @Test
	  public void test1() {
		  
			// Find the element that's ID attribute is 'account'(My Account)
		 
		      driver.findElement(By.id("myalnk")).click();
		 
		      // Find the element that's ID attribute is 'log' (Username)
		 
		      // Enter Username on the element found by above desc.
		 
		      driver.findElement(By.id("lea")).sendKeys("vikasgarg.mgl@gmail.com");
		 
		      // Find the element that's ID attribute is 'pwd' (Password)
		 
		      // Enter Password on the element found by the above desc.
		 
		      driver.findElement(By.id("lpasswd")).sendKeys("master1");
		 
		      // Now submit the form. WebDriver will find the form for us from the element
		 
		      driver.findElement(By.id("login_submit")).click();
		 
		      // Print a Log In message to the screen
		 
		      System.out.println(" Login Successfully, now it is the time to Log Off buddy.");
		 
		      // Find the element that's ID attribute is 'account_logout' (Log Out)
		 
		      driver.findElement(By.className("logout"));
		 
		  }

  @BeforeMethod
public void beforeMethod() {
	 
	  // Create a new instance of the Firefox driver
    System.setProperty("webdriver.chrome.driver", "./libs/chromedriver.exe");
    driver = new ChromeDriver();

    //Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception

    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    
    // maximize the browser
   
    driver.manage().window().maximize();
    
    //Launch the Online Store Website

    driver.get("http://www.cilory.com");

}

@AfterMethod

public void afterMethod() {

	  // Close the driver

    driver.quit();

}

}
