package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {

	public static void captureScreenShot(WebDriver driver, int id) throws IOException {

		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
		Date value = new Date();
		String date = df.format(value);

		TakesScreenshot take = (TakesScreenshot) driver;

		File src = take.getScreenshotAs(OutputType.FILE);

		File dest = new File("test-output\\FailTestScreenshots\\Test-" + id + " " + date + ".jpg");

		FileHandler.copy(src, dest);
	}

	public static String fetchDataFromExcel(String sheetName, int rowName, int cellName)
			throws EncryptedDocumentException, IOException {

		FileInputStream file = new FileInputStream("src\\test\\resources\\Testdata\\Practice.xlsx");
		Workbook wb = WorkbookFactory.create(file);
		Sheet sheet1 = wb.getSheet(sheetName);
		Row row = sheet1.getRow(rowName);
		Cell cell = row.getCell(cellName);
		String value;
		try {
			value = cell.getStringCellValue();
		}
		catch (IllegalStateException e) 
		{
				double numvalue = cell.getNumericCellValue();
				long num = (long) numvalue;
				value = Long.toString(num);
		}
		return value;
	}
	
	public static String fetchFractionDataFromExcel(String sheetName, int rowName, int cellName)
			throws EncryptedDocumentException, IOException {

		FileInputStream file = new FileInputStream("src\\test\\resources\\Testdata\\Practice.xlsx");
		Workbook wb = WorkbookFactory.create(file);
		Sheet sheet1 = wb.getSheet(sheetName);
		Row row = sheet1.getRow(rowName);
		Cell cell = row.getCell(cellName);
		String value;
		try {
			value = cell.getStringCellValue();
		}
		catch (IllegalStateException e) 
		{
				double numvalue = cell.getNumericCellValue();
				value = Double.toString(numvalue);
		}
		return value;
	}
}
