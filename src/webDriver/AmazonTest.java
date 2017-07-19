package webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AmazonTest {
	public static void main(String[] args){
		
	System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\geckodriver-v0.14.0-win64\\geckodriver.exe");
	WebDriver driver;
	//String searchtext= "Mouse";
	driver = new FirefoxDriver ();
	driver.get("https://www.dell.com");
	//driver.get("twotabsearchtextbox");
	driver.findElement(By.id("search-input")) .sendKeys("dell");
	driver.findElement(By.xpath("submit")).click();
	
	
	}
}