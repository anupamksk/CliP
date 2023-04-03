package jse;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FIndEleNotInViewPortArea {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://www.google.com/doodles");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		for(;;) {
		try {
			WebElement israelDoodle = driver.findElement(By.linkText("Israel Independence Day 2022"));
			
			 israelDoodle.click();
			break;
		} catch (NoSuchElementException e) {
			//System.out.println("Ele is Not their In the viewport area");
			jse.executeScript("window.scrollBy(0,500)");
		}

}
}
}