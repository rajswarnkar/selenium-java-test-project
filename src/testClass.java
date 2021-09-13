import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class testClass {
	

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String chromePath ="C:\\Projects\\SeleniumLibaries\\BrowserDrivers\\chromedriver.exe";
		String url = "http://10.148.191.234:8080/retailportal/logon/logon.html#/selectClientMatch";
		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.get(url);
		//driver.manage().window().maximize();
		
		Thread.sleep(5000);
		
		By clientMatch = By.cssSelector("mat-select#clientmatch_select");
		
	//	WebDriverWait wait = new WebDriverWait(driver, 30);
	//	wait.until(ExpectedConditions.elementToBeClickable(clientMatch));
		driver.findElement(clientMatch).click();
		


		//By selectClientId = By.xpath("//mat-option/span[text()=' 297 - FIS 297 ']");
		By selectClientId = By.xpath("//mat-option/span[text()=' 883 - Weitz Inv ']");
		
		driver.findElement(selectClientId).click();
		
	}

	public void matSelectInput(String id, String value, WebDriver driver) {
			
	    driver.findElement(By.id(id)).click();
	    driver.findElement(By.id(value)).click();
	}
}
