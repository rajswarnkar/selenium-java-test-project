package alertsFramesWindows;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAlerts {

	static String chromePath ="C:\\Projects\\SeleniumLibaries\\BrowserDrivers\\chromedriver.exe";
	static String strUrl = "https://demoqa.com/alerts";
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", chromePath);
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
				
		driver.get(strUrl);
		
		Thread.sleep(5000);
		
		//Handle simple alert
		driver.findElement(By.id("alertButton")).click();
		Alert simpleAlert = driver.switchTo().alert();
		Thread.sleep(2000);
		simpleAlert.accept();
		
		
		//handle prompt alert
		WebElement element = driver.findElement(By.id("promtButton"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
		Alert promptAlert = driver.switchTo().alert();
		System.out.println(promptAlert.getText());
		Thread.sleep(2000);
		promptAlert.sendKeys("Testing Prompt alert");
		Thread.sleep(2000);
		promptAlert.accept();
		System.out.println(driver.findElement(By.id("promptResult")).getText());
		
		//handle confirmation alert
		driver.findElement(By.id("confirmButton")).click();
		Alert confirmAlert = driver.switchTo().alert();
		System.out.println(confirmAlert.getText());
		Thread.sleep(2000);
		confirmAlert.dismiss();
		System.out.println(driver.findElement(By.id("confirmResult")).getText());
		
		//handle unexpected alert using try-catch block.
		driver.findElement(By.id("timerAlertButton")).click();
		try {
			Alert timerAlert = driver.switchTo().alert();
			System.out.println(timerAlert.getText());
			Thread.sleep(1000);
			timerAlert.accept();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("No alert is found.");
		}
		
		driver.quit();
	}

}
