package genericLibrary;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
public class ExcelRead {
	public static Object[][] multipleRead(String sheetName) throws EncryptedDocumentException, IOException {
		File file = new File("C:\\Users\\praneeth\\Desktop\\selenium\\Workspace\\com.DWS.1.0\\src\\test\\resources\\TestData\\TestData.xlsx");      
		FileInputStream fis=new FileInputStream(file);
		Workbook workbook=WorkbookFactory.create(fis);
		Sheet sheet=workbook.getSheet(sheetName);
		
		int row_count= sheet.getPhysicalNumberOfRows();
	
		int col_count = sheet.getRow(0).getPhysicalNumberOfCells();
	
		Object[][] data=new Object[row_count-1][col_count];
		for(int i=1;i<row_count;i++) {
			for(int j=0;j<col_count;j++) {
				data[i-1][j]=sheet.getRow(i).getCell(j).toString();
			}
		}
		return data;
	}
	public static String singleRead(String sheetName,int rowNum,int colNum) throws EncryptedDocumentException, IOException {
		File file = new File("C:\\Users\\praneeth\\Desktop\\selenium\\Workspace\\SeleniumTraining\\Testdata\\TestData.xlsx");         //Define the file path
		FileInputStream fis=new FileInputStream(file);
		Workbook workbook=WorkbookFactory.create(fis);
		Sheet sheet=workbook.getSheet(sheetName);
		return sheet.getRow(rowNum).getCell(colNum).toString();
	}
}
