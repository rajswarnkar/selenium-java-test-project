package alertsFramesWindows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IFrameDemo {
	static String chromePath ="C:\\Projects\\SeleniumLibaries\\BrowserDrivers\\chromedriver.exe";
	static String strUrl = "https://demoqa.com/frames";
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", chromePath);
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();				
		driver.get(strUrl);		
		
		Thread.sleep(5000);
		
        //Switch to Frame using id of the frame
        driver.switchTo().frame("frame1");
        
        //Identifying the heading in webelement
        WebElement frame1Heading= driver.findElement(By.id("sampleHeading"));
        
        //Finding the text of the heading
        String frame1Text=frame1Heading.getText();
        
        //Print the heading text
        System.out.println(frame1Text);
        
        //closing the driver
        driver.close();
	}

}
