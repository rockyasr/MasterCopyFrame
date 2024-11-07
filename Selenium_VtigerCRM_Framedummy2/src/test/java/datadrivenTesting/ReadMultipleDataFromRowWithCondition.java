package datadrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDataFromRowWithCondition {
    public static void main(String[] args) throws EncryptedDocumentException, IOException {
    	
    	String expectedTestId="tc_01";
    	String data1="";
		String data2="";
		String data3="";
		boolean flag=false;
		FileInputStream file = new FileInputStream("./src/test/resources/orgdataforCondition.xlsx");
		Workbook workbook = WorkbookFactory.create(file);
		Sheet sheet = workbook.getSheet("org");
		int lastRowNum = sheet.getLastRowNum();
		for(int i=0;i<=lastRowNum;i++) {
			String data="";
			try {
				data = sheet.getRow(i).getCell(0).toString();
				if(data.equals(expectedTestId)) {
					flag=true;
					data1 = sheet.getRow(i).getCell(1).toString();
					data2 = sheet.getRow(i).getCell(2).toString();
					data3 = sheet.getRow(i).getCell(3).toString();
					
				}
			} catch (Exception e) {
			}
		}
		if(flag==true) {
			System.out.println(data1);
			System.out.println(data2);
			System.out.println(data3);
		}else {
			System.out.println(expectedTestId);
		}
		
	}
}
