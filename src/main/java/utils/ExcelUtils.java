package utils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {

    public static Object[][] getCustomerData(String filePath, String sheetName) throws IOException {

            FileInputStream fileInputStream = new FileInputStream(filePath);
            Workbook workbook = new XSSFWorkbook(fileInputStream);

//        workbook = WorkbookFactory.create(fileInputStream);
            Sheet sheet = workbook.getSheet(sheetName);
            DataFormatter dataFormatter = new DataFormatter();

//        sheet = workbook.getSheet(sheetName);

            int rowCount = sheet.getPhysicalNumberOfRows();
            int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
            Object[][] data = new Object[rowCount - 1][colCount+1];
            int count = 0;
            for (int i = 1; i < rowCount; i++) {
                Row row = sheet.getRow(i);
                data[i-1][0]= count;
                count++;
                for (int j = 0; j < colCount; j++) {
                    Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    if (cell.getCellType() == CellType.NUMERIC) {
                        // For numeric cells, directly cast to Integer
                        data[i - 1][j+1] = (int) cell.getNumericCellValue();
                    } else {
                        // For non-numeric cells, format using DataFormatter
                        data[i - 1][j+1] = dataFormatter.formatCellValue(cell).toString();
                    }

                }
            }
        workbook.close();
        fileInputStream.close();
        return data;

    }
}
