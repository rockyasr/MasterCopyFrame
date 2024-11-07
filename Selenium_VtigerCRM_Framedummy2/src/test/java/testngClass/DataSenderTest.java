package testngClass;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class DataSenderTest {
	@DataProvider
	public Object[][] getData() {

		Object[][] objArray = new Object[3][3];
		objArray[0][0] = "Ranjith";
		objArray[0][1] = "AS";
		objArray[0][2] = 9791633487l;
		objArray[1][0] = "sekar";
		objArray[1][1] = "A";
		objArray[1][2] = 9486968387l;
		objArray[2][0] = "TamilSelvi";
		objArray[2][1] = "S";
		objArray[2][2] = 9786873782l;

		return objArray;
	}

	@DataProvider
	public Object[][] getPhoneData() {
		Object[][] obj = { { "iphone", "Apple iPhone 13 (128GB) - Blue" },
				{ "samsung", "Samsung Galaxy S24 5G AI Smartphone (Marble Gray, 8GB, 128GB Storage)" },
				{ "nothing", "Nothing Phone 2a 5G (White, 8GB RAM, 256GB Storage)" } };
		return obj;
	}

	@DataProvider
	public Object[][] getPhoneDataFromExcel() throws EncryptedDocumentException, IOException {
		ExcelUtility exutils = new ExcelUtility();
		int rowCount = exutils.getRowCount("phone");
		Object[][] obj = new Object[rowCount][2];
		for (int i = 0; i < rowCount; i++) {
			obj[i][0] = exutils.readDataFromExcel("phone", i + 1, 0);
			obj[i][1] = exutils.readDataFromExcel("phone", i + 1, 1);
		}
		return obj;
	}
}
