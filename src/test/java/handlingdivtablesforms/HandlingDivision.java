package handlingdivtablesforms;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingDivision {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://www.facebook.com/");
		WebElement createNewAccButton = driver.findElement(By.linkText("Create New Account"));
		createNewAccButton.click();
		//Parent Element - 
		//The search criteria should Be within the scope of the parent element
		WebElement regFormDivTag = driver.findElement(By.id("reg_form_box"));
		//enter the username
		regFormDivTag.findElement(By.name("firstname")).sendKeys("abcd");
		//Select the male radio button
		regFormDivTag.findElement(By.xpath("//label[text()='Male']/../input[@type='radio']")).click();
		//search the count Of input tags and check how many are visible in the UI 
		List<WebElement> allInputTags = regFormDivTag.findElements(By.tagName("input"));
		System.out.println("allInputTags count = " + allInputTags.size());
		int count = 0;
		for (WebElement inputTag : allInputTags) {
			if (inputTag.isDisplayed()) {
				count++;
			}
		}
		System.out.println("Visble input tag count = " + count);
	}

}
