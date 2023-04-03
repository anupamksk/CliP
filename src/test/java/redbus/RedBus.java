package redbus;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RedBus {
	WebDriver driver;
	@BeforeMethod
	public void beforeMethod() {
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(4));
		driver.get("https://www.redbus.in/");		
	}
	@AfterMethod
	public void afterMethod() {
		driver.manage().window().minimize();
		driver.quit();
	}
	@Test
	public void doubleToggleArrow() {
		
		WebElement parentDiv = driver.findElement(By.cssSelector("div[class='clearfix search-wrap']"));
		WebElement fromTextfield = parentDiv.findElement(By.id("src"));
		WebElement doubleToggleArrow = parentDiv.findElement(By.id("togglebtn"));
		WebElement toTextfield = parentDiv.findElement(By.id("dest"));
		fromTextfield.sendKeys("Bengaluru");
		toTextfield.sendKeys("Hyderabad");
		String beforeToggleFromTextFieldValue = fromTextfield.getAttribute("value");
		System.out.println("beforeToggleFromTextFieldValue = "+beforeToggleFromTextFieldValue);
		String beforeToggleToTextFieldValue = toTextfield.getAttribute("value");
		System.out.println("beforeToggleToTextFieldValue = "+beforeToggleToTextFieldValue);
		doubleToggleArrow.click();
		String afterToggleFromTextFieldValue = fromTextfield.getAttribute("value");
		System.out.println("afterToggleFromTextFieldValue = "+afterToggleFromTextFieldValue);
		String afterToggleToTextFieldValue = toTextfield.getAttribute("value");
		System.out.println("afterToggleToTextFieldValue = "+afterToggleToTextFieldValue);
		if(afterToggleFromTextFieldValue.equals(beforeToggleToTextFieldValue)&&afterToggleToTextFieldValue.equals(beforeToggleFromTextFieldValue)) {
			System.out.println("Pass: doubleToggleArrow is working and it has been verified");
		}else {
			System.out.println("Fail: doubleToggleArrow is not working and it has been verified");
		}		
	}
	@Test
	public void satSunColour() {
		WebElement weekendDays = driver.findElement(By.xpath("//td[text()='Jan 2023']/../..//td[text()=8]"));
//		String backgroundColor = Color.fromString(weekendDays.getCssValue("background-color")).asHex();
//		System.out.println("backgroundColor = "+backgroundColor);
		String color=weekendDays.getCssValue("color");
		System.out.println(color);		
	}
	@Test
	public void suggestionSameAddress() {
		WebElement parentDiv = driver.findElement(By.cssSelector("div[class='clearfix search-wrap']"));
		WebElement fromTextfield = parentDiv.findElement(By.id("src"));
		fromTextfield.clear();
		fromTextfield.sendKeys("Bengaluru");
		WebElement toTextfield = parentDiv.findElement(By.id("dest"));
		
		WebElement firstSuggestion = driver.findElement(By.className("selected"));
		if(firstSuggestion.getText().equals(fromTextfield.getAttribute("value"))) {
			System.out.println("Pass: Address filled in fromTextField is showing under the suggestion and it is verified.");
		} else {
			System.out.println("Fail: Address filled in fromTextField is not showing under the suggestion and it is verified.");
		}
	}
	@Test
	public void priviousDatesDisable() {
		driver.findElement(By.id("onward_cal")).click();
		driver.findElement(By.cssSelector("td[class='prev']")).click();
		List<WebElement> allPrevoiusDates = driver.findElements(By.xpath("//td[@class='past day']"));
		for (WebElement previousDate : allPrevoiusDates) {
			previousDate.click();
			if (previousDate.isSelected()) {
				Reporter.log("Fail: Previous date " + previousDate.getText() + " is enable and verified.");
			}else {
				Reporter.log("Pass: Previous date " + previousDate.getText() + " is disable and verified.");
			}
		}
	}
	@Test
	public void checkCalenderDate() {
		driver.findElement(By.id("onward_cal")).click();
		WebElement currentDate = driver.findElement(By.cssSelector("td[class='current day']"));
		String currentDateBackgroundColor = currentDate.getCssValue("background-color");
		if (currentDateBackgroundColor.equals("rgba(216, 78, 85, 1)")) {
			Reporter.log("Pass: Calender is highliting today's date and verified.");
		}else {
			Reporter.log("Fail: Calender is not highliting today's date and verified.");
		}
	}
	@Test
	public void fromTextfieldIsActiveElement() {
		WebElement fromTextfield = driver.findElement(By.id("src"));
		if (driver.switchTo().activeElement().equals(fromTextfield)) {
			Reporter.log("Pass: From textfield is by default active element and verified");
		}else {
			Reporter.log("Pass: From textfield is not a active element by default and verified");
		}
	}
}
