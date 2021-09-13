package alertsFramesWindows;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleFrames {
	
	static String chromePath ="C:\\Projects\\SeleniumLibaries\\BrowserDrivers\\chromedriver.exe";
	static String strUrl = "https://demoqa.com/frames";
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", chromePath);
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();				
		driver.get(strUrl);		
		
		Thread.sleep(5000);
		
		//Get the number of iframes by using Java script
		JavascriptExecutor js = (JavascriptExecutor)driver;
		Integer countFrames = Integer.parseInt(js.executeScript("return window.length").toString());
		System.out.println("Total number of iframes using javascript: "+countFrames);
		
		//Get the number of iframes by using tag name
		List<WebElement> iframeList = driver.findElements(By.tagName("iframe"));
		System.out.println("Total number of iframes using Tagname: "+iframeList.size());
		
		
		//switch to frames by index
		try {
			driver.switchTo().frame(countFrames-1);
			System.out.println("Frame text is: "+driver.findElement(By.id("sampleHeading")).getText());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Index out of range");
			e.printStackTrace();
		}
		
		//switch to frame by WebElement
		driver.switchTo().defaultContent();
		WebElement iframeElement = driver.findElement(By.id("frame1"));
		driver.switchTo().frame(iframeElement);
		System.out.println("Frame text is: "+driver.findElement(By.id("sampleHeading")).getText());
		
		//switch to frame by Id
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame2");
		Thread.sleep(1000);
		System.out.println("Frame text is: "+driver.findElement(By.id("sampleHeading")).getText());
		
		driver.switchTo().defaultContent();
		driver.quit();
		
	}

}
