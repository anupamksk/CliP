package synchronization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VigorousInteraction {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.actitime.com/login.do");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.id("keepLoggedInCheckBox")).click();
		driver.findElement(By.id("loginButton")).click();
		//Thread.sleep(5000);
		driver.findElement(By.xpath("//a[contains(.,'Tasks')]")).click();
		driver.findElement(By.xpath("//a[contains(.,'Reports')]")).click();
		driver.findElement(By.xpath("//a[contains(.,'Users')]")).click();
		driver.findElement(By.id("logoutLink")).click();	
	
	}
}
