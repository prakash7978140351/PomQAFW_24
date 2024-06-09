package com.mystore.utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtils {
    private Workbook workbook;
    private Sheet sheet;
    private String filePath;

    public ExcelUtils(String filePath, String sheetName) {
        this.filePath = filePath;
        try {
            FileInputStream fis = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet(sheetName);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getCellData(int rowNum, int colNum) {
        Row row = sheet.getRow(rowNum);
        Cell cell = row.getCell(colNum);
        DataFormatter formatter = new DataFormatter();
        return formatter.formatCellValue(cell);
    }

    public void setCellData(int rowNum, int colNum, String data) {
        Row row = sheet.getRow(rowNum);
        if (row == null) {
            row = sheet.createRow(rowNum);
        }
        Cell cell = row.getCell(colNum);
        if (cell == null) {
            cell = row.createCell(colNum);
        }
        cell.setCellValue(data);
        try {
            FileOutputStream fos = new FileOutputStream(filePath);
            workbook.write(fos);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getRowCount() {
        return sheet.getLastRowNum() + 1;
    }
    
    public int getColumnCount() {
        return sheet.getRow(0).getLastCellNum();
    }

    public Object[][] getData() {
        int rowCount = getRowCount();
        int colCount = sheet.getRow(0).getLastCellNum();
        Object[][] data = new Object[rowCount - 1][colCount];

        for (int i = 1; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                data[i - 1][j] = getCellData(i, j);
            }
        }
        return data;
    }

    public void closeWorkbook() {
        try {
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
