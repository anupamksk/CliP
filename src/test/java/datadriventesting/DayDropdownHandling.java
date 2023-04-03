package datadriventesting;

import java.io.FileInputStream;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class DayDropdownHandling {
	
	@Test
	
	public void datedropdownhandling() throws Throwable {
		//PreConditions
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		//Triggering main url of the test application 
		driver.get("https://www.facebook.com/signup/");
		//creating select type of object for DateDropDown
		Select dayDropdown = new Select(driver.findElement(By.id("day")));
		System.out.println("Is date Dropdown is multiselect type dropdown? :"+dayDropdown.isMultiple());
		//selecting path for TestCaseSpecificData for Date dropdow
		FileInputStream fis = new FileInputStream("./src/test/resources/dropdowndata.xlsx");
		//passing the path to fetch the data from the excel sheet using apache POI library
		Workbook dateDrop = WorkbookFactory.create(fis);
		Sheet sheet = dateDrop.getSheet("datetestspecificdata");
		Row row = sheet.getRow(0);
		short firstCellIndex = row.getFirstCellNum();
		short lastCellIndex = row.getLastCellNum();
		System.out.println(firstCellIndex);
		System.out.println(lastCellIndex);
		for(short cell=++firstCellIndex ; cell < lastCellIndex ; cell++)
		{
			//since the below method returns the double datatype so we need to convert it to long datatype
			long day= (long)row.getCell(cell).getNumericCellValue();
			//selectByVisibletext() will accept the argument in string format so we need to convert 
			//it to the string format by over riding the toString() in Long class
			//here the long datatype is converted to "Long" datatype implicitly with the help of autoBoxing  
			String dayInString = Long.toString(day);
			//selecting the option in DateDropdown by visible text
			dayDropdown.selectByVisibleText(dayInString);
			if (dayDropdown.getFirstSelectedOption().isSelected()) {
				System.out.println("Pass: " + (long)row.getCell(cell).getNumericCellValue() + " is selected in the dropdown");
			}else {
				System.out.println("Fail: " + (long)row.getCell(cell).getNumericCellValue() + " is not selected in the dropdown");
			}
		}
		//Before Post Condition it is java Standard to close the workbook file
		dateDrop.close();
		//PostCondition
		driver.manage().window().minimize();
		driver.quit();
	}

}
