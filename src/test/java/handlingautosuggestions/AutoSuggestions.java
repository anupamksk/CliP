package handlingautosuggestions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutoSuggestions {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://www.google.com/");
		driver.switchTo().activeElement().sendKeys("Selenium");
		List<WebElement> allAutoSuggestions = driver.findElements(By.xpath("//li[@class='sbct' and not(@id)]//div[@class='wM6W7d']/span"));
		System.out.println(allAutoSuggestions.size());
		for (WebElement suggestion : allAutoSuggestions) {
			String autoSuggestion = suggestion.getText();
			System.out.println(autoSuggestion);
			if (autoSuggestion.equals("selenium version")) {
				suggestion.click();
				break;
			}
		}
		driver.quit();
	}

}
