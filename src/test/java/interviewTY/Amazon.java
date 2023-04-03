package interviewTY;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Amazon {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("tv");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.titleIs("Amazon.in : tv"));
		List<WebElement> allTvOptions = driver
				.findElements(By.xpath("//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']"));
		System.out.println(allTvOptions.size());
		for (WebElement tv : allTvOptions) {
			System.out.println(tv.getText());
		}
		Actions action = new Actions(driver);
		action.scrollToElement(allTvOptions.get(allTvOptions.size() - 2));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		// jse.executeScript("window.scrollBy(0,6500)");
		allTvOptions.get(allTvOptions.size() - 2).click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.titleContains(allTvOptions.get(allTvOptions.size() - 2).getText()));
		System.err.println(driver.getTitle());
	}

}
