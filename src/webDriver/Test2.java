package webDriver;


import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.Assert;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;


public class Test2 {

	private WebDriver driver;

	private String baseURL="http://newtours.demoaut.com/";


 @BeforeMethod
 
 public void checkforHomePage() {

	  System.out.println("Before Method");
	
  String expectedTitle="Mercury Tours";
	
  String actualTitle=driver.getTitle();
	
  boolean b=actualTitle.contains(expectedTitle);

	  System.out.println(expectedTitle+"-"+actualTitle);

	 Assert.assertTrue(b);	

  }
 
 @AfterMethod
 
 public void returnToHomePage() {

	System.out.println("After Method");

	driver.navigate().back();
	
  }
 
 @Test(priority=1)
  
public void testInvalidSignon(){

	  System.out.println("Test Method");
	
  String userName="some_user";
	
  String passwd="some_user";
	
  String expectedTitle="Sign-on: Mercury";	
  
	  signon(userName, passwd, expectedTitle);
 
 }

  @Test(priority=2)
 
 public void testValidSignon(){

	  String userName="tut";

	  String passwd="tut";
	
  String expectedTitle="Flight";

	  signon(userName, passwd, expectedTitle);
 
 }

  private void signon(String userName, String passwd, String expectedTitle) {

	  	WebElement userTextBox=driver.findElement(By.name("userName"));

		userTextBox.sendKeys(userName);
	
	driver.findElement(By.name("password")).sendKeys(passwd);

		driver.findElement(By.name("login")).click();

		String actualTitle=driver.getTitle();
	
	System.out.println(expectedTitle+"-"+actualTitle);
	
	Assert.assertTrue(actualTitle.contains(expectedTitle));
}
 
 @BeforeTest
 
 public void openBrowser() {

	  System.out.println("Before Test");

	  System.setProperty("webdriver.gecko.driver", "C:\\Sundar\\soft\\lib\\geckodriver-v0.14.0-win64\\geckodriver.exe");

	  driver= new FirefoxDriver();

	  driver.get(baseURL);

	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

  }


  @AfterTest

  public void closeBrowser() {

	  System.out.println("After Test");

	  driver.quit();
  }

}



