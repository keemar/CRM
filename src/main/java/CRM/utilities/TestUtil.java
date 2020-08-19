package CRM.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Timestamp;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import CRM.base.base;

public class TestUtil extends base{

	public static long Page_time_out = 30;
	public static long implicit_time_out = 30;
	public static String TestDatapath = "./\\src\\main\\java\\CRM\\testdata\\TestData.xlsx";
	public static Workbook wb;
	public static Sheet sht;


    public static void capturescreenshot(WebDriver driver) throws Exception{

    	
        //Convert web driver object to TakeScreenshot

        TakesScreenshot scrShot =((TakesScreenshot)driver);

        //Call getScreenshotAs method to create image file

                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

            //Move image file to new destination
                //Timestamp timestamp = new Timestamp(System.currentTimeMillis());

                File DestFile=new File("./\\Screenshots\\"+System.currentTimeMillis()+".png");

                //Copy file at destination

                FileUtils.copyFile(SrcFile, DestFile);

    }

	

	public static Object[][] gettestdata(String sheetname)   {

			FileInputStream inputStream=null;
			try {
				inputStream = new FileInputStream(TestDatapath);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				//wb = new XSSFWorkbook(inputStream);
				wb=WorkbookFactory.create(inputStream);
			} catch (EncryptedDocumentException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			sht = wb.getSheet(sheetname);
			Object[][] data = new Object[sht.getLastRowNum()][sht.getRow(0).getLastCellNum()];
System.out.println(" row : "+ sht.getLastRowNum());
System.out.println(" col : "+ sht.getRow(0).getLastCellNum());

			
			for(int i=0;i<sht.getLastRowNum();i++) {
				for(int k=0;k<sht.getRow(0).getLastCellNum();k++) {

					data[i][k] = sht.getRow(i+1).getCell(k).toString();
					System.out.println(" data : "+ data[i][k] );


				}
			}

		return data;

	}


}
