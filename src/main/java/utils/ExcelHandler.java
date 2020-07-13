package utils;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;

import java.io.FileInputStream;
import java.io.IOException;

import static utils.RandomGenerator.randNumb;

public class ExcelHandler {
    public static HSSFWorkbook workbook;
    public static HSSFSheet worksheet;
    public static DataFormatter formatter = new DataFormatter();
    public static String file_location = "D:\\\\Projects\\\\tmn-rest-test\\\\src\\\\main\\\\java\\\\data\\\\TestData.xls";

    public static Object[][] excelReader() {

        try {
            FileInputStream fileInputStream = new FileInputStream(file_location); //Excel sheet file location get mentioned here
            workbook = new HSSFWorkbook(fileInputStream); //get my workbook
            worksheet = workbook.getSheet("getSession");// get my sheet from workbook
            HSSFRow Row = worksheet.getRow(0);     //get my Row which start from 0

            int RowNum = worksheet.getPhysicalNumberOfRows();// count my number of Rows
            int ColNum = Row.getLastCellNum(); // get last ColNum

            Object[][] Data = new Object[RowNum - 1][ColNum]; // pass my  count data in array

            for (int i = 0; i < RowNum - 1; i++) //Loop work for Rows
            {
                HSSFRow row = worksheet.getRow(i + 1);

                for (int j = 0; j < ColNum; j++) //Loop work for colNum
                {
                    if (row == null)
                        Data[i][j] = "";
                    else {
                        HSSFCell cell = row.getCell(j);
                        if (((HSSFCell) cell).toString().equalsIgnoreCase("null"))
                            Data[i][j] = ""; //if it get null value it pass no data
                        else if (cell.toString().equalsIgnoreCase("genAppVer")) {
                            Data[i][j] = randNumb(4);   //if it get defined value it pass randomly generated data
                        } else {
                            String value = formatter.formatCellValue(cell);
                            Data[i][j] = value; //This formatter get my all values as string i.e integer, float all type data value
                        }
                    }
                }
            }
            return Data;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
