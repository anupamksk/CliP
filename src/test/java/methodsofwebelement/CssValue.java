package methodsofwebelement;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;

public class CssValue {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		WebElement loginButton = driver.findElement(By.name("login"));
		String fontType = loginButton.getCssValue("font-family");
		System.out.println("fontType = " + fontType);
		String fontBoldness = loginButton.getCssValue("font-weight");
		System.out.println("fontBoldness = " + fontBoldness);
		String fontSize = loginButton.getCssValue("font-size");
		System.out.println("fontSize = " + fontSize);
		String backgroundColor = Color.fromString(loginButton.getCssValue("background-color")).asHex();
		System.out.println("backgroundColor = " + backgroundColor);
		driver.manage().window().minimize();
		driver.quit();
	}
}
