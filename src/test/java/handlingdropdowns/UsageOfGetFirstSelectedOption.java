package handlingdropdowns;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UsageOfGetFirstSelectedOption {
	public static void main(String[] args) {
		 WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		 driver.get("https://www.facebook.com/signup");
		 Select monthSelect = new Select(driver.findElement(By.id("month")));
		 //default selected value before selection
		 String defaultSelectedMonth = monthSelect.getFirstSelectedOption().getText();
		 System.out.println("defaultSelectedMonth = " + defaultSelectedMonth);	
		 monthSelect.selectByIndex(7);
		 //selected value check after selection
		 String selectedMonthOption = monthSelect.getFirstSelectedOption().getText();
		 System.out.println("selectedMonthOption = " + selectedMonthOption);
		 driver.manage().window().minimize();
		 driver.quit();
	}

}
