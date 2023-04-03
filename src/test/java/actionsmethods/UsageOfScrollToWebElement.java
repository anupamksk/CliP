package actionsmethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UsageOfScrollToWebElement {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		Actions actions = new Actions(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://www.cowin.gov.in/");
		WebElement searchButton = driver.findElement(By.xpath("//button[text()='Search']"));
		WebElement viewMore = driver.findElement(By.xpath("//a[contains(@href,'dashboard.cowin') and text()='View More']"));
		
		//actions.scrollToElement(viewMore).pause(1000).scrollByAmount(0, 700).perform();
	}

}
