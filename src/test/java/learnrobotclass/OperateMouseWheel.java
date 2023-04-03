package learnrobotclass;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OperateMouseWheel {
	public static void main(String[] args) throws AWTException, Throwable{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");
		Robot robot = new Robot();
		//int value is the No of notches in the mouse wheel
		robot.mouseWheel(2);
		Thread.sleep(3000);
		//-ve int value will scroll back/ up in a reverse order upon the notches
		robot.mouseWheel(-2);
	}

}
