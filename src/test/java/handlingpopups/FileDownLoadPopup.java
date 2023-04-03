package handlingpopups;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FileDownLoadPopup {
	public static void main(String[] args) throws AWTException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://www.selenium.dev/downloads/");
		//click and we will get file down load Popup
		driver.findElement(By.linkText("4.7.2")).click();
		//go to the browsers downloads page
		//press keyboard Button ctrl+j
		//new Actions(driver).pause(3000).sendKeys(Keys.CONTROL+"J").perform();
		/*
		 * Robot robot = new Robot(); robot.keyPress(KeyEvent.VK_CONTROL);
		 * robot.keyPress(KeyEvent.VK_J); Thread.sleep(2000);
		 * robot.keyRelease(KeyEvent.VK_CONTROL); robot.keyRelease(KeyEvent.VK_J);
		 */
		//trigger the downloads page url
		driver.get("chrome://downloads/");
		//identify the shadow host element
		WebElement shodowHost = driver.findElement(By.tagName("downloads-manager"));
		//get the shadow root upon the host element
		SearchContext shadowRoot = shodowHost.getShadowRoot();
		//isentify the shadow dom element upon the shadow root
		WebElement randomEle = shadowRoot.findElement(By.cssSelector("downloads-toolbar[id='toolbar']"));
		String attValue = randomEle.getAttribute("role");
		System.out.println(attValue);
		driver.navigate().back();
		}

}
