package synchronization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EndToEnd {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://demo.actitime.com/");
		String expectedLoginPageTitle = "actiTIME - Login";
		System.out.println("expectedLoginPageTitle = " + expectedLoginPageTitle);
		String actualLoginPageTitle = driver.getTitle();
		System.out.println("actualLoginPageTitle = " + actualLoginPageTitle);
		String expectedLoginPageUrl = "https://demo.actitime.com/login.do";
		System.out.println("expectedLoginPageUrl = " + expectedLoginPageUrl);
		String actualLoginPageUrl = driver.getCurrentUrl();
		System.out.println("actualLoginPageUrl =  " + actualLoginPageUrl);
		if (actualLoginPageUrl.equals(expectedLoginPageUrl) || actualLoginPageTitle.equals(expectedLoginPageTitle)) {
			System.out.println("Pass: The Login page is Displayed Upon the verification of its Url and its title");
			WebElement usernameTextField=driver.findElement(By.id("username"));
			usernameTextField.clear();
			usernameTextField.sendKeys("admin");
			WebElement passwordTextField = driver.findElement(By.name("pwd"));
			passwordTextField.clear();
			passwordTextField.sendKeys("manager");
			WebElement loginButton = driver.findElement(By.id("loginButton"));
			loginButton.click();
			
			String expectedHomePageTitle = "actiTIME - Enter Time-Track";
			System.out.println("expectedHomePageTitle = " + expectedHomePageTitle);
			String expectedHomePageUrl = "https://demo.actitime.com/user/submit_tt.do";
			System.out.println("expectedHomePageUrl = " + expectedHomePageUrl);
			if (wait.until(ExpectedConditions.urlToBe(expectedHomePageUrl))) {
				String actualHomePageUrl = driver.getCurrentUrl();
				System.out.println("actualHomePageUrl = " + actualHomePageUrl);
				System.out.println("HomePage URL is Correct");
				if (wait.until(ExpectedConditions.titleIs(expectedHomePageTitle))) {
					String actualHomePageTitle = driver.getTitle();
					System.out.println("actualHomePageTitle = " + actualHomePageTitle);
					System.out.println("HomePage title is correct");
					WebElement logoutOption=driver.findElement(By.id("logoutLink"));
					if (logoutOption.isDisplayed()) {
						System.out.println("Pass: The LogOut Option is Displayed and verified.");
						System.out.println("Pass: The Home Page is Displayed");
						logoutOption.click();
					}else {
						System.out.println("Fail: The Logout Option Is not displayes and it is verified.");
					}
				}else {
					System.out.println("HomePage title is incorrect");
				}
			}else {
			
				System.out.println("HomePage URL is incorrect");
				System.out.println("Fail : The HomePage is not displayed.");
			}
		}else {
			System.out.println("Fail: The Login page is not displayed upon verifiction of the URL and its title");
		}
		
		driver.manage().window().minimize();
		driver.quit();
	}
	
}
