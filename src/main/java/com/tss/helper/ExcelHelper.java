package com.tss.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.tss.model.Trainee;

public class ExcelHelper {

    public static List<Trainee> readEcxelFile(String path) {
        List<Trainee> traineeList = new ArrayList<Trainee>();
        try {
            FileInputStream fis = new FileInputStream(path);
            Workbook workbook = null;
            if (path.toLowerCase().endsWith("xlsx")) {
                workbook = new XSSFWorkbook(fis);
            } else if (path.toLowerCase().endsWith("xls")) {
                workbook = new HSSFWorkbook(fis);
            }
            int numberOfSheets = workbook.getNumberOfSheets();
            for (int i = 0; i < numberOfSheets; i++) {
                Sheet sheet = workbook.getSheetAt(i);
                Iterator<Row> rowIterator = sheet.iterator();
                while (rowIterator.hasNext()) {
                    String fullname = "";
                    String email = "";
                    Row row = rowIterator.next();
                    Iterator<Cell> cellIterator = row.cellIterator();
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        switch (cell.getCellType()) {
                            case Cell.CELL_TYPE_STRING:
                                if (fullname.equalsIgnoreCase("")) {
                                    fullname = cell.getStringCellValue().trim();
                                } else if (email.equalsIgnoreCase("")) {
                                    email = cell.getStringCellValue().trim();
                                } else {
                                    System.out.println("Random data::" + cell.getStringCellValue());
                                }
                                break;
                            case Cell.CELL_TYPE_NUMERIC:
                                System.out.println("Random data::" + cell.getNumericCellValue());
                        }
                    }
                    Trainee c = new Trainee(fullname, email);
                    traineeList.add(c);
                }

            }
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // remove header
        traineeList.remove(0);
        return traineeList;
    }

}
