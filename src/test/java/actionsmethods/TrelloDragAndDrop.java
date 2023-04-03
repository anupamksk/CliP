package actionsmethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TrelloDragAndDrop {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		Actions actions = new Actions(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://trello.com/");
		WebElement loginOption = driver.findElement(By.xpath("//a[text()='Get Trello for free']/preceding-sibling::a[text()='Log in']"));
		loginOption.click();
		driver.switchTo().activeElement().sendKeys("peoplefortiptur@gmail.com");
		WebElement continueButton = driver.findElement(By.id("login"));
		continueButton.submit();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
//		wait.until(ExpectedConditions.elementToBeSelected(By.name("password")));
		driver.switchTo().activeElement().sendKeys("9886947924");
		WebElement loginButton = driver.findElement(By.id("login-submit"));
		loginButton.submit();
		if (wait.until(ExpectedConditions.titleIs("Boards | Trello"))) {
			System.out.println("We Are in Boards | Trello page ");
		}else {
			System.out.println("We Are not in Boards | Trello page ");
		}
		WebElement dragAndDropBoard = driver.findElement(By.xpath("//h3[text()='Starred boards']/../..//div[@title='DragAndDrop']"));
		dragAndDropBoard.click();
		WebElement mavenProjectCard = driver.findElement(By.xpath("//span[@class='card-short-id hide']/ancestor::a[contains(@href,'maven-project')]"));
		WebElement listToDrop = driver.findElement(By.xpath("//textarea[text()='Completed']/../../div[contains(@class,'list-cards u-fancy-scroll')]"));
		actions.clickAndHold(mavenProjectCard).dragAndDrop(mavenProjectCard, listToDrop).release().perform();
	
		
		
	}

}
