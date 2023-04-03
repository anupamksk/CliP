package actionsmethods;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UsageofModifierKeys {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		Actions actions = new Actions(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://www.facebook.com/");
		driver.switchTo().activeElement();
		//KeyDown() press and hold the modifiers button only
		//entered the modified functional satate Of keys
		//performed the modified functionality Of left arrow
		//release the shift  modifier by keyUp()
		//performed the normal functionality of left arrow.
		//perform() - void
		actions.keyDown(Keys.SHIFT).sendKeys("abcd").sendKeys(Keys.ARROW_LEFT).sendKeys(Keys.ARROW_LEFT).keyUp(Keys.SHIFT).sendKeys(Keys.ARROW_LEFT).perform();
	}

}
