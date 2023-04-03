package screenshots;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementScreenShot {
	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
//		TakesScreenshot tss=(TakesScreenshot)driver;
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		WebElement loginButton = driver.findElement(By.name("login"));
		File tempFile= loginButton.getScreenshotAs(OutputType.FILE);
		String timeStamp=LocalDateTime.now().toString().replace(':', '-');
		File destFile=new File("./errorshots/facebook"+timeStamp+".png");
		try {
			FileUtils.copyFile(tempFile, destFile);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		driver.manage().window().minimize();
		driver.quit();
	}

}
