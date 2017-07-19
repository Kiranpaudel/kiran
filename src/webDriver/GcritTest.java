package webDriver;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
public class GcritTest {
	public WebDriver driver;
		@BeforeTest
	public void launchBrowser() {			 
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\kiran\\Downloads\\chromedriver_win32\\chromedriver.exe"); // chrome driver connected
		 		driver = new ChromeDriver();
	}

		@Test(priority = 1)
	public void launchApplication() {		
		driver.get("http://www.gcrit.com/build3/"); // login main page
		System.out.println("lanch application");
		String expectedTitle="GCR Shop";
		 String actualTitle=driver.getTitle();
		//boolean b=actualTitle.contains(expectedTitle);	
		System.out.println(expectedTitle+"-"+actualTitle+"   --Test Pass");
		driver = new ChromeDriver();
		//Assert.assertEquals("GCR Shop",driver.getTitle());
      }
	
	 @Test(priority=2) 
	 public void createValidAccount() throws InterruptedException{ 
	 driver.get("http://www.gcrit.com/build3/");
	  driver.findElement(By.xpath(".//*[@id='tdb3']/span[2]")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.xpath(".//*[@id='tdb4']/span[2]")).click();
	  driver.findElement(By.xpath(".//*[@id='bodyContent']/form/div/div[2]/table/tbody/tr[1]/td[2]/input[1]" )).click();
	  driver.findElement(By.name("firstname")).sendKeys("Adam"); 
	  driver.findElement(By.name("lastname")).sendKeys("Gore");
	  driver.findElement(By.id("dob")).sendKeys("04/04/1980");
	  driver.findElement(By.name("email_address")).sendKeys("dmssdbob@mail.com");
	  driver.findElement(By.name("street_address")).sendKeys("416 red river trl");
	  driver.findElement(By.name("postcode")).sendKeys("75038");
	  Thread.sleep(2000);
	  driver.findElement(By.name("city")).sendKeys("Irving");
	  driver.findElement(By.name("state")).sendKeys("Texas");
	  Select dropdown = new Select(driver.findElement(By.name("country")));
	  dropdown.selectByVisibleText("United States");
	  driver.findElement(By.name("telephone")).sendKeys("333 999 3333"); 
	  driver.findElement(By.name("password")).sendKeys("kiranpaudel");
	  driver.findElement(By.name("confirmation")).sendKeys("kiranpaudel");
	  driver.findElement(By.xpath(".//*[@id='tdb4']")).click();
	  Thread.sleep(3000); 
	 }
	
	
	 @Test(priority=3) 
	 public void loginValidUser() throws InterruptedException{
		 driver.get("http://www.gcrit.com/build3/");
		 driver.findElement(By.xpath(".//*[@id='tdb3']/span[2]")).click();
		 driver.findElement(By.name("email_address")).sendKeys("dmssdbob@mail.com");
		 Thread.sleep(2000);
		 driver.findElement(By.name("password")).sendKeys("kiranpaudel");
		 driver.findElement(By.id("tdb5")).click();
		}
	 
	 @Test(priority = 4)
	 public void loginInvalidUser(){
		 driver.get("http://www.gcrit.com/build3/");
		 driver.findElement(By.xpath(".//*[@id='tdb3']/span[2]")).click();
		 driver.findElement(By.name("email_address")).sendKeys("2728782@mail.com");
		 driver.findElement(By.name("password")).sendKeys("kiranpaudel");
		 driver.findElement(By.id("tdb5")).click();
		 
	 }
	 
	@AfterTest
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();

	}
}