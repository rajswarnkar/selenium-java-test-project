package alertsFramesWindows;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchbackParentWinow {
	
	static String chromePath ="C:\\Projects\\SeleniumLibaries\\BrowserDrivers\\chromedriver.exe";
	static String strUrl = "https://demoqa.com/browser-windows";

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", chromePath);
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
				
		driver.get(strUrl);
		
		Thread.sleep(1000);
		
		//Open all the child windows
		WebElement newWindow = driver.findElement(By.id("windowButton"));		
		newWindow.click();
		
		String originalWindow = driver.getWindowHandle();
		System.out.println("Main window handle is: "+ originalWindow);
		
		//Handle all new opened window
		Set<String> s1 = driver.getWindowHandles();
		System.out.println("All child window handles are: "+ s1);
		Iterator<String> i1 = s1.iterator();
				
		// Here we will check if child window has other child windows and when child window
	    //is the main window it will come out of loop.
		
		/*
		 * while(i1.hasNext()){
		 * 
		 * String childWindow = i1.next();
		 * 
		 * if(!originalWindow.equalsIgnoreCase(childWindow)) {
		 * 
		 * driver.switchTo().window(childWindow);
		 * System.out.println("Child window title is: "+ driver.getTitle());
		 * driver.close(); System.out.println("Child window is closed now"); } }
		 */
		
	      while (i1.hasNext()) {
	          String ChildWindow = i1.next();
	          System.out.println("Child window is: "+ ChildWindow);
	          
	          if (!originalWindow.equalsIgnoreCase(ChildWindow)) {
	        	  
	              driver.switchTo().window(ChildWindow);
	              System.out.println("Window text: " + driver.findElement(By.tagName("body")).getText());
	              driver.close();
	              System.out.println("Child window closed");
	           }
	       }
	      
		//Switch to main window
		driver.switchTo().window(originalWindow);
        System.out.println("Original window title is: "+ driver.findElement(By.className("main-header")).getText());
		driver.quit();

	}

}
