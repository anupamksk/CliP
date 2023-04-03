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

public class TvNameAndPrice {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.get("https://www.amazon.in/");
		WebElement searchTextbox = driver.findElement(By.id("twotabsearchtextbox"));
		searchTextbox.sendKeys("tv");
		driver.findElement(By.id("nav-search-submit-button")).click();
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		String wid1 = driver.getWindowHandle();
		System.out.println("wid1= "+wid1);
		String url;
		for(;;) {
		try {
			WebElement parentElement = driver.findElement(By.xpath("//div[@data-index='26']"));
			parentElement.findElement(By.xpath("//span[text()='Sansui 140 cm (55 inches) 4K Ultra HD Certified Android LED TV JSW55ASUHD (Mystique Black)']")).click();
			
			break;
		    } catch (NoSuchElementException e) {
			jse.executeScript("window.scrollBy(0,500)");
		     }
		}
		Set<String> wid = driver.getWindowHandles();
		for(String window : wid ) {
			System.out.println(window);	
			Thread.sleep(5000);
			if(driver.switchTo().window(window).getTitle().equals("Amazon.in : tv")) {				
				
			}
			else {
				driver.switchTo().window(window);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='centerCol']//span[@id='productTitle']")));
				WebElement tvTitle = driver.findElement(By.xpath("//div[@id='centerCol']//span[@id='productTitle']"));
				System.out.println("tvTitle= "+tvTitle.getText());
				WebElement tvPrice = driver.findElement(By.xpath("//div[@id='corePriceDisplay_desktop_feature_div']//span[@class='a-price-whole']"));
				System.out.println("tvPrice= "+tvPrice.getText());				
			}
		}
		driver.manage().window().minimize();
		driver.quit();		
	}
}
