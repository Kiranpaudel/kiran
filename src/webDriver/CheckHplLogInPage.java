package webDriver;
import org.testng.annotations.Test;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CheckHplLogInPage {

	@Test
public void checkTitle (){	
 System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\geckodriver-v0.14.0-win64\\geckodriver.exe");
WebDriver driver = new FirefoxDriver();
driver.get("http://www.gmail.com");
String pageTitle = driver.getTitle();
Assert.assertEquals(pageTitle, "Gmail");

/* if (pageTitle.equals("Gmail")){
	 System.out.println("Test Pass");
 } 
	 else {
		 System.out.println("Test Fail");
		 
		 
	 }
	*/
 }


		}
		
	
	


