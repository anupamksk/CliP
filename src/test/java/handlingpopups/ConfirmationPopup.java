package handlingpopups;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConfirmationPopup {
	public static void main(String[] args) {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://www.pib.gov.in/indexd.aspx");
		System.out.println("alert message = " + driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		//UnhandledAlertException - selenium - run - unchecked - popup
		WebElement farmersWelfare = driver.findElement(By.linkText("Ministry of Agriculture & Farmers Welfare"));
		new Actions(driver).pause(5000).scrollToElement(farmersWelfare).perform();
		farmersWelfare.click();
		//driver.switchTo().alert().accept();
		String confirmationText = driver.switchTo().alert().getText();
		System.out.println("confirmationText = " + confirmationText);
		driver.switchTo().alert().dismiss();
		
	}

}
