package datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadStringDataFromExcel {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//passing the file relative path
		FileInputStream fis = new FileInputStream("./src/test/resources/exceldata.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("testcasespecificdata");
		Row row = sheet.getRow(3);
		Cell cell = row.getCell(2);
		//String cellData = cell.getStringCellValue();
		long cellNumericData = (long)cell.getNumericCellValue();
		workbook.close();
		//System.out.println(cellData);
		System.out.println(cellNumericData);
	}

}
