package learnrobotclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class KeyBoardUSeByRobotClass {
	public static void main(String[] args) throws AWTException, Throwable{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");
		Robot robot = new Robot();
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_A);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_A);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_A);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_A);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_SHIFT);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_SHIFT);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_BACK_SPACE);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_BACK_SPACE);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_BACK_SPACE);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_BACK_SPACE);
		Thread.sleep(4000);
		driver.quit();
	}

}
