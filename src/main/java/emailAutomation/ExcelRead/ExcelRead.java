package emailAutomation.ExcelRead;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	
	public static String ExcelFile = "./TestData/MailTestData.xlsx" ;
	public static String  MailContent = "MailContent" ;
	
	
	public static String ReadExcelFile(int rownum , int cellnum , String SheetName) throws Throwable {
		File FileLocation = new File(ExcelFile);
		FileInputStream FI = new FileInputStream(FileLocation);
		XSSFWorkbook Workbook = new XSSFWorkbook(FI);
		XSSFSheet Sheet = Workbook.getSheet(SheetName);
		Row row = Sheet.getRow(rownum);
		Cell cell =  row.getCell(cellnum);
		String Data = cell.toString();
		return Data;
	}

}
