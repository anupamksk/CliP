package datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class RunTimePolymorphisim {
	 WebDriver driver;
	 @Test
public void polymorphism () throws IOException {
		 //run time polymorphism
		 //script is data independent
		 // run same script in different browser - cross browser testing is easy
		 // resuability of the script enhanced
		 //not to hard code the data - automation standard
		 //maintainenece of the script has become easy.
		 
	FileInputStream fis = new FileInputStream("./src/test/resources/commondata.properties");
	Properties pobj=new Properties();
	pobj.load(fis);
	String browsername = pobj.getProperty("browser");
	if (browsername.equals("chrome")) {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(pobj.getProperty("url"));
		WebElement usernameTextField = driver.findElement(By.id("username"));
		usernameTextField.sendKeys(pobj.getProperty("username"));
		WebElement passwordTextField = driver.findElement(By.name("pwd"));
		passwordTextField.sendKeys(pobj.getProperty("password"));
		driver.findElement(By.id("loginButton")).click();
	}else if (browsername.equals("firefox")) {
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(pobj.getProperty("url"));
		WebElement usernameTextField = driver.findElement(By.id("username"));
		usernameTextField.sendKeys(pobj.getProperty("username"));
		WebElement passwordTextField = driver.findElement(By.name("pwd"));
		passwordTextField.sendKeys(pobj.getProperty("password"));
		driver.findElement(By.id("loginButton")).click();
	}
}

}
