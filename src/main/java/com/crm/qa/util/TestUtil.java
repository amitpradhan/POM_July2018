package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	public static long PAGE_LOAD_TIMEOUT=60;
	public static long IMPLICIT_WAIT=20;
	public static String TESTDATA_SHEET_PATH=System.getProperty("user.dir")
			+"//src//main//java//com//crm//qa//testdata"
			+ "//FreeCRMTestData.xlsx";
	static Workbook book;
	static Sheet sheet;
	
	//"mainpanel" is the frame name for main frame 
		public void switchToFrame(String frameName){
			driver.switchTo().frame(frameName);
		}
		
		public static void takeScreenshotAtEndOfTest() throws IOException{
			 File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			 String currentDir=System.getProperty("user.dir");
			 FileUtils.copyFile(scrFile, new File(currentDir+"//screenshots//"+System.currentTimeMillis()+".png"));
			 
			}
		public void switchToFrameUsingFrameNo(int frameNo){
			
		}
		public void switchToFrameUsingWebElement(WebElement frame){
			
		}
		
		
		public static Object[][] getTestData(String sheetName){
			FileInputStream file=null;
			
				try {
					file=new FileInputStream(TESTDATA_SHEET_PATH);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				try {
					/*
					 * It will give the handle to call method of Workbook interface
					 * As good as creating object of XSSFWorkbook class
					 */
					book=WorkbookFactory.create(file);
				} catch (EncryptedDocumentException e) {
						e.printStackTrace();
				} catch (InvalidFormatException e) {
						e.printStackTrace();
				} catch (IOException e) {
						e.printStackTrace();
				}
				sheet=book.getSheet(sheetName);
				
				int rows=sheet.getLastRowNum();
				int cols=sheet.getRow(0).getLastCellNum();
				//create 2D-object array based according to rows and cols
				Object[][] data=new Object[rows][cols];
				
				for (int i = 0; i < rows; i++) {
					for (int j = 0; j < cols; j++) {
						data[i][j]=sheet.getRow(i+1).getCell(j).toString().trim();
						System.out.print(data[i][j]+"--");
					}
					System.out.println();
				}
				
			return data;
		}
		
		


}
