package actionsmethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScrollByActions {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		Actions actions = new Actions(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://www.facebook.com/");
		WebElement login = driver.findElement(By.linkText("Log in"));
		WebElement help = driver.findElement(By.linkText("Help"));
		actions.scrollToElement(login).pause(2000).scrollToElement(help).perform();
		
	}

}
