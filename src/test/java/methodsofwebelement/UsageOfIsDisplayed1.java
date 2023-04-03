package methodsofwebelement;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UsageOfIsDisplayed1 {
	public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://services.ecourts.gov.in/ecourtindia_v6/");
		WebElement caseStatus = driver.findElement(By.id("leftPaneMenuCS"));
		caseStatus.click();
		//Thread.sleep(5000);
		WebElement popupCloseButton = driver.findElement(By.xpath("//div[contains(@class,'modal-header text')]/button[@class='btn-close']"));
		popupCloseButton.click();
		WebElement courtEstdDropdown = driver.findElement(By.id("court_est_code"));
		if (courtEstdDropdown.isDisplayed()) {
			System.out.println("Boolean True");
			System.out.println("-ve Testing");
			System.out.println("Fail: The Court Estd Dropdown is visible in the UI."+ "");
		}else {
			System.out.println("Boolean False");
			System.out.println("-ve Testing");
			System.out.println("Pass: The Court Estd Dropdown is invisible in the UI.");
		}
		driver.manage().window().minimize();
		driver.quit();
		
	}
	
}
