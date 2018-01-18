package com.test;
 
import org.openqa.selenium.WebDriver;
 
import org.testng.annotations.Test;
 
public class Prioritisation_SetPrority {
 
	public WebDriver driver;
	
	// Always start priority with 0 value
 
  @Test(priority = 0)
 
  public void One() {
 
      System.out.println("This is the Test Case number One");
 
  }
 
  @Test(priority = 2)
 
  public void Two() {
 
	  System.out.println("This is the Test Case number Two");
 
  }
 
  @Test(priority = 3)
 
  public void Three() {
 
	  System.out.println("This is the Test Case number Three");
 
  }
 
  @Test(priority = 4)
 
  public void Four() {
 
	  System.out.println("This is the Test Case number Four");
 
  }
 
}