package handlingdropdowns;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectionRelatedMethods {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://www.facebook.com/signup");
		Select monthSelect = new Select(driver.findElement(By.id("month")));
		//Select Feb - index = 1
		monthSelect.selectByIndex(1);
		//Select Mar - Index = 2
		monthSelect.selectByIndex(2);
		//Select Sep - value ="9"
		monthSelect.selectByValue("9");
		//Select visible Text May 
		monthSelect.selectByVisibleText("May");
	}

}
