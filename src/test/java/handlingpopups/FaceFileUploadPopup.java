package handlingpopups;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FaceFileUploadPopup {
	public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.foundit.in/seeker/registration");
		//WebElement fileUploadButton = driver.findElement(By.id("file-upload"));
		//fileUploadButton.click();
		//WebElement updatedChooseCvButton = driver.findElement(By.xpath("//span[text()='Choose CV']"));
		WebElement fileUploadEle = driver.findElement(By.xpath("//span[text()='Choose CV']"));
		String fileName="C:\\Users\\HP\\Desktop\\actionsnotes.txt";
		StringSelection content = new StringSelection(fileName);
		Toolkit toolKit=Toolkit.getDefaultToolkit();
		Clipboard clipboard=toolKit.getSystemClipboard();
		clipboard.setContents(content, null);
		fileUploadEle.click();
		Thread.sleep(3000);
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);	
	}

}
