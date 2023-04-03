package handlingdivtablesforms;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingTables {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://irctc.com/contact.html");
		WebElement irctcOption = driver.findElement(By.xpath("//a[text()=' IRCTC ']"));
		irctcOption.click();
		//parent Element
		WebElement tableTag = driver.findElement(By.tagName("table"));
		List<WebElement> buddhistTrainDetails = tableTag.findElements(By.xpath("//td[text()='Buddhist train']/../td"));
		for (WebElement details : buddhistTrainDetails) {
			if (details.getText().equals("Visit Website")) {
				String buddhistUrl = details.findElement(By.tagName("a")).getAttribute("href");
				System.out.println("buddhistUrl = " + buddhistUrl);
			}else {
				String buddhistDetails = details.getText();
				System.out.println("buddhistDetails = " + buddhistDetails);
			}
		}
		driver.manage().window().minimize();
		driver.quit();
	}

}
