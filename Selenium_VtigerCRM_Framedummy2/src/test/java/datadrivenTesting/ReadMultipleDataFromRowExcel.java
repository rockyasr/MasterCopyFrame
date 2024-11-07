package datadrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDataFromRowExcel {
      public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream("C:\\Users\\Ranjith\\eclipse-workspace\\Selenium_VtigerCRM_FrameWork\\src\\test\\resources\\mobiledata.xlsx");
		Workbook workbook = WorkbookFactory.create(file);
		Sheet sheet = workbook.getSheet("sheet1");
		int lastRowNum = sheet.getLastRowNum();
		for(int i=1;i<=lastRowNum;i++) {
			String column1data = sheet.getRow(i).getCell(0).toString();
			String column2data = sheet.getRow(i).getCell(1).toString();
			System.out.println(column1data+"\t"+column2data);
		}
		workbook.close();
	}
}
