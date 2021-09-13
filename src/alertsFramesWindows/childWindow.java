package alertsFramesWindows;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class childWindow {

	static String chromePath ="C:\\Projects\\SeleniumLibaries\\BrowserDrivers\\chromedriver.exe";
	static String strUrl = "https://demoqa.com/browser-windows";
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", chromePath);
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
				
		driver.get(strUrl);
		
		Thread.sleep(1000);
		
		WebElement newWindow = driver.findElement(By.id("windowButton"));
		
		String originalWindow = driver.getWindowHandle();
		
		newWindow.click();
		
		System.out.println(driver.getWindowHandles().size());
		
		for (String handle: driver.getWindowHandles()) {
			
			if (!originalWindow.equalsIgnoreCase(handle)) {
				
				driver.switchTo().window(handle);
				WebElement text = driver.findElement(By.id("sampleHeading"));
				System.out.println("Text in child window is: "+ text.getText());
			}
		}
		
		driver.quit();
		
		
	}

}
