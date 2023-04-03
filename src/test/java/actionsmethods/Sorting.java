package actionsmethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Sorting {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		Actions actions = new Actions(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://jqueryui.com/sortable/");
		driver.switchTo().frame(0);
		WebElement sortableEle = driver.findElement(By.xpath("//li[text()='Item 1']"));
		actions.dragAndDropBy(sortableEle, 0, 45).pause(Duration.ofSeconds(1)).perform();
	}

}
