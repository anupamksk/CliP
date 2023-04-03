package actionsmethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Slider {
	public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	Actions actions = new Actions(driver);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://jqueryui.com/slider/");
	driver.switchTo().frame(0);
	WebElement slider = driver.findElement(By.id("slider"));
	actions.moveToElement(slider).clickAndHold(slider).moveByOffset(100, 0).release(slider).perform();
	}

}
