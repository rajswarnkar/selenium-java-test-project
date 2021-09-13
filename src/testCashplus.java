import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class testCashplus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		String chromePath ="C:\\Projects\\SeleniumLibaries\\BrowserDrivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		
		//Instantiate the webdriver
		WebDriver driver = new ChromeDriver();
		
		//Set the username
		String username = "TAQATEST";
		
		//Set the password
		String password = "Welcome@521";
		
		String URL = "http://" +username +":" +password +"@"+ "cashplus.taservices.fisglobal.com/";
		System.out.println("The page url is "+URL);
		driver.get(URL);
		
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		String title = driver.getTitle();
		
		System.out.println("The page title is "+title);
		
		String text = driver.findElement(By.tagName("a")).getText();
		
		System.out.println("The test present in page is ==> "+text);
		
		driver.close();
		driver.quit();
	}

}
