package webDriver;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class MurcuryTourTest {
	private WebDriver driver;
	private String baseURL="http://newtours.demoaut.com/";
WebDriverWait wt;

@BeforeMethod
public void checkforHomePage() {
	  System.out.println("Before Method");
	  String expectedTitle="Welcome";
	  wt.until(ExpectedConditions.titleContains(expectedTitle));
	  		String actualTitle=driver.getTitle();
	  boolean b=actualTitle.contains(expectedTitle);
	  System.out.println(expectedTitle+"-"+actualTitle);
	 AssertJUnit.assertTrue(b);
}

@AfterMethod
public void returnToHomePage(){
System.out.println("After Method");
	driver.findElement(By.linkText("Home")).click();
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
	  String userName="tutorial";
	  String passwd="tutorial";
	  String expectedTitle="Flight";
	  signon(userName, passwd, expectedTitle);
}
private void signon(String userName, String passwd, String expectedTitle) {
  	WebElement userTextBox=driver.findElement(By.name("userName"));
	userTextBox.sendKeys(userName);
	driver.findElement(By.name("password")).sendKeys(passwd);
	driver.findElement(By.name("login")).click();
	wt.until(ExpectedConditions.titleContains(expectedTitle));
	String actualTitle=driver.getTitle();
	System.out.println(expectedTitle+"-"+actualTitle);
	AssertJUnit.assertTrue(actualTitle.contains(expectedTitle));
}

 @BeforeTest
 public void openBrowser() {
	  System.out.println("Before Test");
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\kiran\\Downloads\\chromedriver_win32\\chromedriver.exe");
    driver = new ChromeDriver();
	  wt= new WebDriverWait(driver,10);
	  driver.get(baseURL);
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 }
@AfterTest
public void closeBrowser() {
	  System.out.println("After Test");
	  driver.quit();

}
}
