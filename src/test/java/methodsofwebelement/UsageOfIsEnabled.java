package methodsofwebelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UsageOfIsEnabled {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://sandbox.abdm.gov.in/applications/cowin/Home/cowin_signup_form");
		WebElement acceptTermsButton = driver.findElement(By.xpath("//button[text()='Accept Terms of Service']"));
		acceptTermsButton.click();
		WebElement checkBox = driver.findElement(By.xpath("//label[text()='Please accept Terms of Service']/..//input[@id='confbtn']"));
		
		checkBox.click();
		WebElement submitButton = driver.findElement(By.name("submit"));
		if (submitButton.getTagName().equals("input")|| submitButton.getTagName().equals("button") ) {
			System.out.println("<"+submitButton.getTagName()+">");
			if (submitButton.isEnabled()) {
				System.out.println("Boolean True");
				System.out.println("-ve testing");
				System.out.println("Fail: The Submit button Is functionally enabled before Selecting the accept terms Of Service checkbox");
			}else {
				System.out.println("Boolean False");
				System.out.println("-ve testing");
				System.out.println("Pass: The Submit button Is functionally disabled before selecting the Accept terms Of Service Checkbox");
			}
		}else {
			System.out.println("<"+submitButton.getTagName()+">");
			System.out.println("It Always return boolan true");
			System.out.println("Element enability cannot be checked since the tagName is other than <input> and <button>");
		}
		
	}

}
