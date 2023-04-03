package learnrobotclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MouseMiddleScrollButtonClickAndScroll {
	public static void main(String[] args) throws Throwable,AWTException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		Robot robot=new Robot();
		robot.mousePress(InputEvent.BUTTON2_DOWN_MASK);
		Thread.sleep(1000);
		robot.mouseMove(0, 500);
		Thread.sleep(1000);
		robot.mouseRelease(InputEvent.BUTTON2_DOWN_MASK);	
	}

}
