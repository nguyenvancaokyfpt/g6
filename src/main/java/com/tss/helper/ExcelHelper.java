package com.tss.helper;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.tss.model.Team;
import com.tss.model.Trainee;
import com.tss.model.Excel.TeamImportModel;

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

    public static boolean exportUserForTeamImport(List<Trainee> userList, String path) {
        Workbook workbook = new XSSFWorkbook();

        Sheet groupSheet = workbook.createSheet("Group");
        // create header
        Row groupHeader = groupSheet.createRow(0);
        groupHeader.createCell(0).setCellValue("Group no");
        groupHeader.createCell(1).setCellValue("Group name");
        groupHeader.createCell(2).setCellValue("Project Code");
        groupHeader.createCell(3).setCellValue("Topic Code");
        groupHeader.createCell(4).setCellValue("Topic Name");
        groupHeader.createCell(5).setCellValue("Group Description");
        // set column width
        groupSheet.setColumnWidth(0, 5000);
        groupSheet.setColumnWidth(1, 5000);
        groupSheet.setColumnWidth(2, 5000);
        groupSheet.setColumnWidth(3, 5000);
        groupSheet.setColumnWidth(4, 5000);
        groupSheet.setColumnWidth(5, 7000);
        // set header style
        CellStyle groupHeaderStyle = workbook.createCellStyle();
        groupHeaderStyle.setAlignment(CellStyle.ALIGN_CENTER);
        groupHeaderStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        groupHeaderStyle.setWrapText(true);
        // Color
        groupHeaderStyle.setFillForegroundColor((short) 22);
        groupHeaderStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        // boder for header
        groupHeaderStyle.setBorderBottom(CellStyle.BORDER_THIN);
        groupHeaderStyle.setBorderTop(CellStyle.BORDER_THIN);
        groupHeaderStyle.setBorderRight(CellStyle.BORDER_THIN);
        groupHeaderStyle.setBorderLeft(CellStyle.BORDER_THIN);
        for (int i = 0; i < 6; i++) {
            groupHeader.getCell(i).setCellStyle(groupHeaderStyle);
        }
        // fill example data
        for (int i = 1; i < 5; i++) {
            Row row = groupSheet.createRow(i);
            row.createCell(0).setCellValue(i);
            row.createCell(1).setCellValue("Group " + i);
            row.createCell(2).setCellValue("Project Code");
            row.createCell(3).setCellValue("Topic Code");
            row.createCell(4).setCellValue("Topic Name");
            row.createCell(5).setCellValue("Group Description");
        }

        Sheet sheet = workbook.createSheet("Student");
        // set header
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Group no");
        header.createCell(1).setCellValue("Email");
        header.createCell(2).setCellValue("Fullname");
        header.createCell(3).setCellValue("Group Leader");
        // set column width
        sheet.setColumnWidth(0, 3000);
        sheet.setColumnWidth(1, 6000);
        sheet.setColumnWidth(2, 6000);
        sheet.setColumnWidth(3, 3000);
        // ser color gray for header
        CellStyle style = workbook.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        style.setWrapText(true);
        style.setFillForegroundColor((short) 22);
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        // boder for header
        style.setBorderBottom(CellStyle.BORDER_THIN);
        style.setBorderTop(CellStyle.BORDER_THIN);
        style.setBorderRight(CellStyle.BORDER_THIN);
        style.setBorderLeft(CellStyle.BORDER_THIN);
        for (int i = 0; i < 4; i++) {
            header.getCell(i).setCellStyle(style);
        }
        int rownum = 1;
        for (Trainee user : userList) {
            Row row = sheet.createRow(rownum++);
            int cellnum = 0;
            Cell cell = row.createCell(cellnum++);
            cell.setCellValue("");
            cell = row.createCell(cellnum++);
            cell.setCellValue(user.getEmail());
            cell = row.createCell(cellnum++);
            cell.setCellValue(user.getFullname());
            cell = row.createCell(cellnum++);
            cell.setCellValue("");
        }

        // Write the output to a file
        try {
            FileOutputStream fileOut = new FileOutputStream(path);
            workbook.write(fileOut);
            fileOut.close();
        } catch (Exception e) {
            DebugHelper.print("Error when export user for team import");
            return false;
        }
        return true;
    }

    public static TeamImportModel readTeamImportFile(String path) {
        List<Team> teamList = new ArrayList<>();
        List<Trainee> traineeList = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet groupSheet = workbook.getSheet("Group");
            Sheet traineeSheet = workbook.getSheet("Student");
            // read group sheet
            Iterator<Row> groupRowIterator = groupSheet.iterator();
            while (groupRowIterator.hasNext()) {
                Row row = groupRowIterator.next();
                if (row.getRowNum() == 0) {
                    continue;
                }
                Iterator<Cell> cellIterator = row.cellIterator();
                Team team = new Team();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getColumnIndex()) {
                        case 0:
                            team.setId((int) cell.getNumericCellValue());
                            break;
                        case 1:
                            team.setName(cell.getStringCellValue());
                            break;
                        case 2:
                            team.setProject_code(cell.getStringCellValue());
                            break;
                        case 3:
                            team.setTopic_code(cell.getStringCellValue());
                            break;
                        case 4:
                            team.setTopic_name(cell.getStringCellValue());
                            break;
                        case 5:
                            team.setDescription(cell.getStringCellValue());
                            break;
                    }
                }
                teamList.add(team);
            }
            // read trainee sheet
            Iterator<Row> traineeRowIterator = traineeSheet.iterator();
            while (traineeRowIterator.hasNext()) {
                Row row = traineeRowIterator.next();
                if (row.getRowNum() == 0) {
                    continue;
                }
                Iterator<Cell> cellIterator = row.cellIterator();
                Trainee trainee = new Trainee();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getColumnIndex()) {
                        case 0:
                            trainee.setTeamId((int) cell.getNumericCellValue());
                            break;
                        case 1:
                            trainee.setEmail(cell.getStringCellValue());
                            break;
                        case 2:
                            trainee.setFullname(cell.getStringCellValue());
                            break;
                        case 3:
                            try {
                                trainee.setIsLeader(cell.getNumericCellValue() == 1);
                            } catch (Exception e) {
                                trainee.setIsLeader(false);
                            }
                            break;
                    }
                }
                traineeList.add(trainee);
            }
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        HashMap<Integer, List<Trainee>> traineeMap = new HashMap<>();
        for (Team team : teamList) {
            List<Trainee> traineeListInTeam = new ArrayList<>();
            for (Trainee trainee : traineeList) {
                if (trainee.getTeamId() == team.getId()) {
                    traineeListInTeam.add(trainee);
                }
            }
            traineeMap.put(team.getId(), traineeListInTeam);
        }
        return new TeamImportModel(teamList, traineeMap);
    }
}
