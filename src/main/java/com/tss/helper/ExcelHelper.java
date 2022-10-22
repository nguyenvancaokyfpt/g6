package com.tss.helper;

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
                    String phone = "";
                    Float grade = 0.0f;
                    Row row = rowIterator.next();
                    Iterator<Cell> cellIterator = row.cellIterator();
                    int columnIndex = 0;
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        switch (cell.getCellType()) {
                            case Cell.CELL_TYPE_STRING:
                                switch (columnIndex) {
                                    case 0:
                                        fullname = cell.getStringCellValue();
                                        columnIndex++;
                                        break;
                                    case 1:
                                        email = cell.getStringCellValue();
                                        columnIndex++;
                                        break;
                                    case 2:
                                        phone = cell.getStringCellValue();
                                        columnIndex++;
                                        break;
                                    default:
                                        break;
                                }
                                break;
                            case Cell.CELL_TYPE_NUMERIC:
                                if (columnIndex == 3) {
                                    grade = (float) cell.getNumericCellValue();
                                    columnIndex++;
                                }
                        }
                    }
                    Trainee c = new Trainee();
                    c.setFullname(fullname);
                    c.setEmail(email);
                    c.setMobile(phone);
                    c.setGrade(grade);
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
