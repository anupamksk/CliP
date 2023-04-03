package actionsmethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MouseHoveringOnEle {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		Actions actions = new Actions(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://www.myntra.com/");
		WebElement menOption = driver.findElement(By.xpath("//div[@class='desktop-navContent']/..//a[text()='Men']"));
		WebElement womenOption = driver.findElement(By.xpath("//div[@class='desktop-navContent']/..//a[text()='Women']"));
		WebElement kidsOption = driver.findElement(By.xpath("//div[@class='desktop-navContent']/..//a[text()='Kids']"));
		WebElement homeAndLivingOption = driver.findElement(By.xpath("//div[@class='desktop-navContent']/..//a[text()='Home & Living']"));
		WebElement	beautyOption = driver.findElement(By.xpath("//div[@class='desktop-navContent']/..//a[text()='Beauty']"));
		WebElement studioOption = driver.findElement(By.xpath("//div[@class='desktop-navContent']/..//a[text()='Studio']"));
		//actions.moveToElement(menOption).pause(Duration.ofSeconds(1)).moveToElement(womenOption).pause(Duration.ofSeconds(1)).moveToElement(kidsOption).pause(Duration.ofSeconds(1)).moveToElement(homeAndLivingOption).pause(Duration.ofSeconds(1)).moveToElement(beautyOption).pause(Duration.ofSeconds(1)).moveToElement(studioOption).build().perform();
		actions.moveToElement(menOption).pause(Duration.ofSeconds(1)).moveToElement(womenOption).pause(Duration.ofSeconds(1)).moveToElement(kidsOption).pause(Duration.ofSeconds(1)).moveToElement(homeAndLivingOption).pause(Duration.ofSeconds(1)).moveToElement(beautyOption).pause(Duration.ofSeconds(1)).moveToElement(studioOption).perform();

	}

}
