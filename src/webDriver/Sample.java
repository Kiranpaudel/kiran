package webDriver;

import org.testng.annotations.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Sample {
	
public static WebDriver driver;

@Test (priority=1)

public void lunchBrower(){
	System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\geckodriver-v0.14.0-win64\\geckodriver.exe");
	driver = new FirefoxDriver();
	
}
@Test(priority=2)
public void nevigatePage() throws InterruptedException{
	driver.get("http://www.gmail.com");
	//Assert.assertEquals("Gmail", driver.getTitle());
	driver.findElement(By.id("Email")).sendKeys("mrpaudelkiran@gmail.com");
	driver.findElement(By.id("next")).click();
	Thread.sleep(1000);
	driver.findElement(By.id("Passwd")).sendKeys("paudelkiran09");
	driver.findElement(By.id("signIn")).click();
	Thread.sleep(1000);
	driver.getClass();
	//("T-I J-J5-Ji T-I-KE L3").click();
	
}
@Test(enabled =false)
public void veryfyPageTitle(){
driver.navigate().to("http://in.yahoo.com/");
Assert.assertEquals("Yahoo", driver.getTitle());

}
@Test (priority=4)
public void closeBrowser(){
	driver.close();
}

}
