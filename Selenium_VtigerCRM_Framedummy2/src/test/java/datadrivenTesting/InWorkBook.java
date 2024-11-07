package datadrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class InWorkBook {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream("C:\\\\Users\\\\Ranjith\\\\eclipse-workspace\\\\Selenium_VtigerCRM_FrameWork\\\\src\\\\test\\\\resources\\\\DataDrivenExcel.xlsx");
		Workbook workbook = WorkbookFactory.create(file);
		Sheet sheet = workbook.getSheet("demovtiger");
		Row row = sheet.getRow(1);
		Cell cell = row.getCell(0);
		System.out.println(cell.getStringCellValue());
		workbook.close();
	}
}
