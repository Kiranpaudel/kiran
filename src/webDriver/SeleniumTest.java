package webDriver;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.firefox.FirefoxDriver;
	
	public class SeleniumTest {
		private WebDriver driver;
		private String baseURL="http://newtours.demoaut.com/";
		
		public void openBrowser(){
			System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\geckodriver-v0.14.0-win64\\geckodriver.exe");
			driver= new FirefoxDriver();
			driver.get(baseURL);
		}
		
		public void testHomePage(){
			String expectedTitle="Welcome: Mercury Tours";
			String actualTitle=driver.getTitle();
			if(expectedTitle.equals(actualTitle)){
				System.out.println("Home Title matches");
			}
			else{
				System.out.println("Home Title does not match");
			
			}
			
		}
		
		public void testSignOn(String userName,String passwd, String expectedTitle){
			WebElement userTextBox=driver.findElement(By.name("userName"));
			userTextBox.sendKeys(userName);
			
			driver.findElement(By.name("password")).sendKeys(passwd);
		
			driver.findElement(By.name("login")).click();
			
			String actualTitle=driver.getTitle();
			if(actualTitle.contains(expectedTitle)){
				System.out.println("Tests Passed");
			}
			else{
				System.out.println("Tests Failed");
					
			}
		
		}
		
		
		public void closeBrowser(){
			//driver.quit();
		}
		
		public static void main(String[] args) {
			SeleniumTest t= new SeleniumTest();
			t.openBrowser();
			t.testHomePage();
			t.testSignOn("some", "some", "Sign-on: Mercury Tours");
			t.testSignOn("tutorial", "tutorial", "Flight");
		}

	}



