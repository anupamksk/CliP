package interviewTY;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Najeer {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.switchTo().newWindow(WindowType.TAB);
		String widTab2 = driver.getWindowHandle();
		driver.switchTo().newWindow(WindowType.TAB);	
		driver.switchTo().window(widTab2);
		driver.close();
	}
}
