package jse;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InteractElementsByJse {
	public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.actitime.com/login.do");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		Thread.sleep(5000);
		jse.executeScript("document.getElementById('keepLoggedInCheckBox').click();");
		Thread.sleep(2000);
		jse.executeScript("document.getElementById('loginButton').click();");
		Thread.sleep(5000);
		driver.manage().window().minimize();
		driver.quit();
		
	}

}
