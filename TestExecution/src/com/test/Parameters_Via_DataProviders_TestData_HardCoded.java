package com.test;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class Parameters_Via_DataProviders_TestData_HardCoded {

	private static WebDriver driver;

	private static Logger Log = Logger.getLogger(Parameters_Via_DataProviders_TestData_HardCoded.class.getName());

	@DataProvider(name="Authentication")
	public static Object[][] details(){
		return new Object[][] 
				
	{{"vikasgarg.mgl@gmail.com","master1", ""},
	{"vikasgarg.mgl@gmail.com","master","Invalid email or password specified. "
			+ "Forgot your password?"},
	{"vikasgarg.mgl@gmail.com","","Invalid email or password specified. "
			+ "Forgot your password?"},
	{"","master1","Invalid email or password specified. "
			+ "Forgot your password?"},
	{"","","Invalid email or password specified. "
			+ "Forgot your password?"}};
    }

	
	@BeforeTest
	public void startDriver() {

		System.setProperty("webdriver.chrome.driver", "./libs/chromedriver.exe");

		driver = new ChromeDriver();
		
		driver.manage().window().maximize();

		Log.info("New driver instantiated");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		Log.info("Implicit wait applied on the driver for 10 seconds");

		driver.get("http://www.cilory.com");
		
	

	}
	
	

	
	  @Test(dataProvider="Authentication")
	//@Parameters({"UserName","Password"})
	  public void testing(String UserName, String Password, String message) throws InterruptedException {

		DOMConfigurator.configure("log4j.xml");

		Log.info("Web application launched");

	   // Our first step is complete, so we produce a main event log here for our reports.

		Reporter.log("Application Lauched successfully | ");
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		WebElement loginLink= driver.findElement(By.xpath("//a[@class='login']"));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='login']")));

		JavascriptExecutor executor = (JavascriptExecutor)driver;
		
		executor.executeScript("arguments[0].click();", loginLink);

		Log.info("Click action performed on My Account link");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lea")));
				
		driver.findElement(By.xpath("//input[@id='lea']")).sendKeys(UserName);

		Log.info("Username entered in the Username text box");

		driver.findElement(By.id("lpasswd")).sendKeys(Password);

		Log.info("Password entered in the Password text box");

		driver.findElement(By.id("login_submit")).click();

		Log.info("Click action performed on Submit button");

		SoftAssert a= new SoftAssert();

		
		try {
			if(driver.findElement(By.className("logout")).isDisplayed()==true) {

				Reporter.log("Sign In Successful | " );

				a.assertEquals(driver.findElement(By.className("logout")).getText(), "Log out");

				driver.findElement(By.className("logout")).click();

				Log.info("Application Logged Out");


			}

			else if(driver.findElement(By.xpath("//div[@class='errorbox']")).isDisplayed()) {

				String s=driver.findElement(By.xpath("//div[@class='errorbox']")).getText();

				a.assertEquals(s, message);

				Log.info("Wrong passwrd validation checked");
				
				driver.findElement(By.id("fancybox-close")).click();
				Thread.sleep(2000L);

			}
			
		} catch (NoSuchElementException e) 
		
		{e.getMessage();}
		
		a.assertAll();

		Log.info("Browser closed");

		// This is the third main event

		Reporter.log("User is Logged out and Application is closed | ");
	}
	
	  
	/**
	 * 
	 */
  	@AfterTest
	public void qudruvert() {
		driver.quit();
	}

}

