package handlingpopups;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DownLoadPopup {
	public static void main(String[] args) throws InterruptedException, Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://www.selenium.dev/downloads/");
		driver.findElement(By.linkText("4.7.2")).click();
		//we will get the file down load Popup
		//trigger the browsers downloads page URL
		driver.get("chrome://downloads/");
		WebElement shadowHost1 = driver.findElement(By.tagName("downloads-manager"));
		SearchContext shadowRoot1 = shadowHost1.getShadowRoot();
		WebElement shadowHost2 = shadowRoot1.findElement(By.id("frb0"));
		SearchContext shadowRoot2 = shadowHost2.getShadowRoot();
		//InvalidArgumentException - if we use xpath for shadow dom element
		WebElement ele = shadowRoot2.findElement(By.cssSelector("cr-button[focus-type='save']"));
		
		ele.click();
		Thread.sleep(3000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		//driver.switchTo().alert().accept();
		Thread.sleep(10000);
		driver.navigate().back();
		System.out.println(ele.getTagName());
		driver.quit();
	}

}
