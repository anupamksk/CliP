package actionsmethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MoveByOneElementReference {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		Actions actions=new Actions(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://www.myntra.com/");
		WebElement menOption = driver.findElement(By.xpath("//div[@class='desktop-navContent']/..//a[text()='Men']"));
		actions.moveToElement(menOption).pause(Duration.ofSeconds(1)).moveToElement(menOption).moveByOffset(78, 0).pause(Duration.ofSeconds(1)).moveToElement(menOption).moveByOffset(150, 0).pause(Duration.ofSeconds(1)).moveToElement(menOption).moveByOffset(256, 0).pause(Duration.ofSeconds(1)).moveToElement(menOption).moveByOffset(369, 0).build().perform();
		//actions.moveToElement(menOption).pause(Duration.ofSeconds(1)).moveToElement(menOption, 78, 0).pause(Duration.ofSeconds(1)).moveToElement(menOption, 156, 0).perform();
	}

}
