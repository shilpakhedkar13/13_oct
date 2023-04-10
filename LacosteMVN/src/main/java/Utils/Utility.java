package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	
	public static void TakeScreenShot(WebDriver driver,String testID) throws IOException {
		File scrnshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		String timeStamp = date.toString().replace(":", "_").replace("", "_");
		File dest = new File ("C:\\Users\\Shilpa Khedkar\\Desktop\\"+testID + "_" + timeStamp + ".jpg");
		FileHandler.copy(scrnshot, dest);
	}
	
	public static String GetExcelData (String sheet,int row, int cell) throws FileNotFoundException {
		
		String path = "C:\\Users\\Shilpa Khedkar\\Desktop\\Lacoste.xlsx";
		FileInputStream file = new FileInputStream(path);
		Workbook workbook = new WorkbookFactory(path);	
		Sheet s = workbook.getSheet("Sheet1");
		Row r = s.getRow(2);
		Cell c = r.getCell(0);
		String data = c.getStringCellValue();
		System.out.println(data);
		double d = WorkbookFactory.create(file).getSheet("Sheet1").getRow(15).getCell(0).getNumericCellValue();
		System.out.println(d);
		
		
	}
	
	
	
	
}