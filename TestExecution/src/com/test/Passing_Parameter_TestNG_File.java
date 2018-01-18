package com.test;
 import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
 import org.apache.log4j.xml.DOMConfigurator;
 import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Passing_Parameter_TestNG_File {
 
	private static WebDriver driver;
 
	private static Logger Log = Logger.getLogger(Passing_Parameter_TestNG_File.class.getName());
  
	@Test
	@Parameters({"UserName","Password"})
        public void testing(String UserName, String Password) {
        
    	DOMConfigurator.configure("log4j.xml");
 
		System.setProperty("webdriver.chrome.driver", "./libs/chromedriver.exe");
		
        driver = new ChromeDriver();
        
        driver.manage().window().maximize();
 
        Log.info("New driver instantiated");
 
        driver.manage().timeouts().implicitlyWait(11, TimeUnit.SECONDS);
 
        Log.info("Implicit wait applied on the driver for 10 seconds");
 
        driver.get("http://www.cilory.com");
 
        Log.info("Web application launched");
 
        // Our first step is complete, so we produce a main event log here for our reports.
 
        Reporter.log("Application Lauched successfully | ");
 
        driver.findElement(By.id("myalnk")).click();
 
        Log.info("Click action performed on My Account link");
 
        driver.findElement(By.id("lea")).sendKeys(UserName);
 
        Log.info("Username entered in the Username text box");
 
        driver.findElement(By.id("lpasswd")).sendKeys(Password);
 
        Log.info("Password entered in the Password text box");
 
        driver.findElement(By.id("login_submit")).click();
 
        Log.info("Click action performed on Submit button");
 
        // Here we are done with our Second main event
 
        Reporter.log("Sign In Successful | " );
        
        WebElement Logout = driver.findElement(By.xpath("//a[@title='Log out']"));
        
        Assert.assertTrue(Logout.isDisplayed());
        
        Assert.assertEquals(Logout.getText(), "Log Out");
 
        driver.findElement(By.className("logout"));
 
        Log.info("Click action performed on Log out link");
 
        driver.quit();
 
        Log.info("Browser closed");
 
        // This is the third main event
 
        Reporter.log("User is Logged out and Application is closed | ");
 
	}
 
}