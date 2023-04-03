package handlingdropdowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MultiSelectDropdown {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://testpages.herokuapp.com/basic_html_form.html");
		WebElement multiSelectDropdown = driver.findElement(By.name("multipleselect[]"));
		Select select = new Select(multiSelectDropdown);
		if (select.isMultiple()) {
			System.out.println("Boolean True - MultiSelect");
			//select 2nd option
			select.selectByIndex(1);
			//Select 3rd option
			select.selectByIndex(2);
			//deselect 3rd option 
			//select.deselectByIndex(2);
			//deselect 4th Option
			//select.deselectByIndex(3);
			//deselect all selected option from the multi-select dropdown
			//select.deselectAll();
			//get all Selected option 
			List<WebElement> allSelectedOption = select.getAllSelectedOptions();
			System.out.println("All Selected Option Count = " + allSelectedOption.size());
			for (WebElement selectedOption : allSelectedOption) {
				System.out.println(selectedOption.getText());
			}
			
		}else {
			System.out.println("Boolean False - SingleSelect");
		}
		//driver.manage().window().minimize();
		//driver.quit();
	}

}
