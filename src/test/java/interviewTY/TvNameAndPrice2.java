package interviewTY;

import java.time.Duration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TvNameAndPrice2 {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.get("https://www.amazon.in/");
		WebElement searchTextbox = driver.findElement(By.id("twotabsearchtextbox"));
		searchTextbox.sendKeys("tv");
		driver.findElement(By.id("nav-search-submit-button")).click();
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		String url;
		for(;;) {
		try {
			url = driver.findElement(By.xpath("//div[@data-index='26']//a")).getAttribute("href");
			break;
		} catch (NoSuchElementException e) {
			jse.executeScript("window.scrollBy(0,500)");
		}
		}
		driver.navigate().to(url);
		WebElement tvTitle = driver.findElement(By.xpath("//div[@id='centerCol']//span[@id='productTitle']"));
		System.out.println("tvTitle= "+tvTitle.getText());
		WebElement tvPrice = driver.findElement(By.xpath("//div[@id='corePriceDisplay_desktop_feature_div']//span[@class='a-price-whole']"));
		System.out.println("tvPrice= "+tvPrice.getText());
		driver.manage().window().minimize();
		driver.quit();		
	}
}
