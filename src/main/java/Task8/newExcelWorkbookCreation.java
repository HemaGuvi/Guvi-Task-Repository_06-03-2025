package Task8;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import com.google.common.collect.Table.Cell;
import org.apache.poi.ss.usermodel.Cell;

public class newExcelWorkbookCreation {
	
	
	public static void main(String[] args) throws IOException 
 {
		// TODO Auto-generated method stub
		myFileCreation();
		myFileReading();
	}
	public static void myFileCreation()
		{
		XSSFWorkbook myWorkbook=new XSSFWorkbook();
		XSSFSheet mysheet=myWorkbook.createSheet("Sheet1");		
		XSSFRow myfirstrow=mysheet.createRow(0);
		myfirstrow.createCell(0).setCellValue("NAME");
		myfirstrow.createCell(1).setCellValue("Age");
		myfirstrow.createCell(2).setCellValue("Email ID");
		XSSFRow row1 = mysheet.createRow(1);
        row1.createCell(0).setCellValue("John Doe");
        row1.createCell(1).setCellValue(30);
        row1.createCell(2).setCellValue("john@test.com");

        XSSFRow	row2 = mysheet.createRow(2);
        row2.createCell(0).setCellValue("Jane Doe");
        row2.createCell(1).setCellValue(28);
        row2.createCell(2).setCellValue("jane@test.com");
        
        XSSFRow row3=mysheet.createRow(3);
        row3.createCell(0).setCellValue("Bob smith");
        row3.createCell(1).setCellValue(35);
        row3.createCell(2).setCellValue("jacky@example.com");
       
        XSSFRow row4=mysheet.createRow(4);
        row4.createCell(0).setCellValue("Swapnil");
        row4.createCell(1).setCellValue(37);
        row4.createCell(2).setCellValue("swapnil@example.com");
        
		try(FileOutputStream fileOutput=new FileOutputStream("myfirstExcelfile.xlsx"))
		{
		myWorkbook.write(fileOutput);
		System.out.println("File got created Successfully");
		}
		catch(IOException e)
		{
		System.out.println("File has been created successfully"+e.getMessage());
		}
		finally 
			{
			try {
				myWorkbook.close();
			
				}
			catch(IOException e)
			{
				e.printStackTrace();
			}}
		}
		
	

	public static void myFileReading() throws IOException
	{
		try {
		FileInputStream myFiletoRead = new FileInputStream(new File("C:\\Hema\\Excel for PGM\\ExcelforTask8-1.xlsx"));
		XSSFWorkbook myWorkBooktoRead=new XSSFWorkbook(myFiletoRead);
		XSSFSheet mySheettoRead=myWorkBooktoRead.getSheetAt(0);
		
		for(Row row:mySheettoRead)
		{
			for(Cell cell:row)
			{
				switch(cell.getCellType())
				{
				case STRING:
					System.out.println("Cell Value::"+cell.getStringCellValue());
					break;
				case NUMERIC:
					System.out.println("Cell Value::"+cell.getNumericCellValue());
					break;
					
				default:
					System.out.println("Cell Type:unknown");
					break;
				}
				}
		}
		}
		
		catch(IOException e)
		{
			System.out.println("IO Exception");
			//e.printStackTrace();
	
		}
		
	}}
		
			
		
					
		
	

		
	