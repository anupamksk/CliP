package actionsmethods;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MouseHoveringFindElementsa {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		Actions actions = new Actions(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://www.myntra.com/");
		//One Address multiple ele and perform the action
		List<WebElement> allElements = driver.findElements(By.cssSelector("a[class='desktop-main']"));
		for (WebElement ele : allElements) {
			actions.moveToElement(ele).pause(Duration.ofSeconds(1)).perform();
		}
		//System.out.println(allElements.size());
		driver.manage().window().minimize();
		driver.quit();
	}

}
