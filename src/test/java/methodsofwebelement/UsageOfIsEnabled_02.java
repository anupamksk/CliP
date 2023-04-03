package methodsofwebelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UsageOfIsEnabled_02 {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.actitime.com/");
		WebElement keepLoggedInCheckBox = driver.findElement(By.id("keepLoggedInCheckBox"));
		if (keepLoggedInCheckBox.isEnabled()) {
			System.out.println("Boolean True");
		}else {
			System.out.println("Boolean False");
		}
		driver.manage().window().minimize();
		driver.quit();
	}
}
