package actionsmethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RightClick {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		Actions actions = new Actions(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://www.facebook.com/");
		WebElement loginButton = driver.findElement(By.name("login"));
		//right click is performed at the (0,0) co-ordinates
		//right click without element reference - contextClick() 
		//actions.contextClick().perform();
		//actions.contextClick(loginButton).perform();
//		actions.moveToElement(loginButton).contextClick();
		//right click with element ref - contextClick(WebElement targetEle)
		actions.moveToElement(loginButton).contextClick(loginButton).perform();
	}

}
