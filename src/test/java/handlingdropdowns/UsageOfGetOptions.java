package handlingdropdowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UsageOfGetOptions {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://www.facebook.com/signup");
		Select monthSelect = new Select(driver.findElement(By.id("month")));
		List<WebElement> allMonthOptions = monthSelect.getOptions();
		System.out.println("allMonthOPtion Count = " + allMonthOptions.size());
		for (WebElement monthOption : allMonthOptions) {
			//all month <Option> tagText
			String monthVisibleText = monthOption.getText();
			System.out.println(monthVisibleText);
		}
		driver.manage().window().minimize();
		driver.quit();
	}

}
