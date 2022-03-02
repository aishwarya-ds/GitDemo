package com.qa.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import com.qa.resources.Baseclass;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class DataDriven {
    public static Logger log= LogManager.getLogManager().getLogger(Baseclass.class.getName());

    public ArrayList<String> getData(String testcaseName) throws IOException {

        ArrayList<String> a = new ArrayList<String>();

        FileInputStream fis = new FileInputStream("C://Users//D G Bhat//Data driven//Liveconnect.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        int sheets = workbook.getNumberOfSheets();
        for (int i = 0; i < sheets; i++) {
            if (workbook.getSheetName(i).equalsIgnoreCase("Source_Data")) {
                XSSFSheet sheet = workbook.getSheetAt(i);
                // Identify Testcases coloum by scanning the entire 1st row
                Iterator<Row> rows = sheet.iterator();// sheet is collection of rows
                Row firstRow = rows.next();
                Iterator<Cell> ce = firstRow.cellIterator();//row is collection of cells
                int k = 0;
                int coloumn = 0;
                while (ce.hasNext()) {
                    Cell value = ce.next();
                    if (value.getStringCellValue().equalsIgnoreCase("Module")) {
                        coloumn = k;
                    }
                    k++;
                }
                System.out.println(coloumn);
                // once coloumn is identified then scan entire testcase coloum to identify purcjhase testcase row
                while (rows.hasNext()) {
                    Row r = rows.next();
//                    log.info(r.getCell(coloumn).getStringCellValue());
//                    System.out.println(" column index : " +r.getCell(coloumn).getStringCellValue());
                    if (r.getCell(coloumn).getStringCellValue().equalsIgnoreCase(testcaseName)) {
                        // after you grab purchase testcase row = pull all the data of that row and feed into test
                        Iterator<Cell> cv = r.cellIterator();
                        while (cv.hasNext()) {
                            Cell c = cv.next();
                            if (c.getCellType() == CellType.STRING) {
                                a.add(c.getStringCellValue());
                            } else {
                                a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
                            }
                        }
                        break;
                    }
                }
            }
        }
        System.out.println("complete");
        return a;

    }
}
