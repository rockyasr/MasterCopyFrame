package datadrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataInToExcel {
     public static void main(String[] args) throws EncryptedDocumentException, IOException {
    	 FileInputStream file = new FileInputStream("./src/test/resources/orgdataforCondition.xlsx");
 		Workbook workbook = WorkbookFactory.create(file);
 		Sheet sheet = workbook.getSheet("org");
 		Cell cell = sheet.getRow(1).createCell(4);
 		cell.setCellValue("PASS");
 		FileOutputStream file1=new FileOutputStream("./src/test/resources/orgdataforCondition.xlsx");
 		workbook.write(file1);
 		workbook.close();
 		System.out.println("====executed=====");
	}
}
