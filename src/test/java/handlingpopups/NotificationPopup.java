package handlingpopups;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NotificationPopup {

public static void main(String[] args) {
	//ChromeOptions options = new ChromeOptions();
	//options.addArguments("--disable-notifications");
	//WebDriver driver=new ChromeDriver(options);
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://www.mi.com/in");
}

}
