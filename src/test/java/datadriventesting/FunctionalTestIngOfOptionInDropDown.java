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

public class FunctionalTestIngOfOptionInDropDown {
	public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.facebook.com/signup/");
		Select monthSelect = new Select(driver.findElement(By.id("month")));
		FileInputStream fis = new FileInputStream("./src/test/resources/dropdata.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("Sheet1");
		Row row = sheet.getRow(0);
		 short minColIx = row.getFirstCellNum();
		 short maxColIx = row.getLastCellNum();
		 for(short colIx=++minColIx; colIx<maxColIx; colIx++) {
			// System.out.println(row.getCell(colIx).getStringCellValue());
			 monthSelect.selectByVisibleText(row.getCell(colIx).getStringCellValue());
			 if (monthSelect.getFirstSelectedOption().isSelected()) {
				System.out.println("Pass: "+monthSelect.getFirstSelectedOption().getText()+" is Selected.");
			}else {
				System.out.println("Fail: " +monthSelect.getFirstSelectedOption().getText()+" is not Selected.");
			}
		 }	
		 driver.manage().window().minimize();
		 driver.quit();
		}	

}
