package genericutility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	public WebDriver driver;
	public FileUtility fileUtil = new FileUtility();
	public ExcelUtility excelutil = new ExcelUtility();
	public WebDriverUtility webdriverUtil = new WebDriverUtility();
	public WebElementUtility webElementUtil = new WebElementUtility();
	public JavaUtility javaUtil = new JavaUtility();
	
		@BeforeMethod
	public void configBeforeMethod() throws IOException {
		// launch the browser
		String browse = fileUtil.readCommondata("browser");
		if (browse.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browse.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (browse.equals("edge")) {
			driver = new EdgeDriver();
		}
		//maximize the browser
		driver.manage().window().maximize();
		//trigger the main url of the application
		String url = fileUtil.readCommondata("url");
		driver.get(url);
	}
	//@AfterMethod
	public void configAfterMethod() {
		//minimize the browser and terminate the session
		driver.manage().window().minimize();
		driver.quit();
	}

}
