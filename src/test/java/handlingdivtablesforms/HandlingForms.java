package handlingdivtablesforms;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingForms {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://www.facebook.com/");
		WebElement parentElement = driver.findElement(By.tagName("form"));
		//click on forgotten password and come back to the Login page
		
		WebElement emailTextField = parentElement.findElement(By.id("email"));
		WebElement passwordTextField = parentElement.findElement(By.id("pass"));
		
		WebElement forgottenPasswordLink = parentElement.findElement(By.linkText("Forgotten password?"));
		forgottenPasswordLink.click();
		driver.navigate().back();
		WebElement parentElement2= driver.findElement(By.tagName("form"));
		WebElement emailTextField2 = parentElement2.findElement(By.id("email"));
		wait.until(ExpectedConditions.visibilityOf(emailTextField2));
		emailTextField2.sendKeys("chandan.r@testynatra.com");
		WebElement loginButton = parentElement2.findElement(By.tagName("button"));
		loginButton.submit();
		driver.navigate().back();
	}

}
