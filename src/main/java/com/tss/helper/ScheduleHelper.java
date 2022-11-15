package com.tss.helper;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ScheduleHelper {

    public static List<String> getWeeksOfYear(int year) {
        List<String> weeks = new ArrayList<>();
        LocalDate beginYear = LocalDate.of(year, 01, 01);
        int i = 0;
        LocalDate beginWeek = beginYear.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
        while (i < 52) {
            String x = beginWeek.format(DateTimeFormatter.ofPattern("dd/MM"))
                    + " - "
                    + beginWeek.plusDays(6).format(DateTimeFormatter.ofPattern("dd/MM"));
            beginWeek = beginWeek.plusDays(7);
            weeks.add(x);
            i++;
        }
        return weeks;
    }

    public static String getCurrent(String date, String status) {
        LocalDate day = LocalDate.now();
        if (!date.equals("")) {
            day = LocalDate.parse(date);
        }
        if (status.equals("begin")) {
            while (day.getDayOfWeek() != DayOfWeek.MONDAY) {
                day = day.minusDays(1);
            }
            return day.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } else {
            while (day.getDayOfWeek() != DayOfWeek.SUNDAY) {
                day = day.plusDays(1);
            }
            return day.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }
    }

    public static String currentWeek(String begin, String end) {
        begin = begin.split("-")[2] + "/" + begin.split("-")[1];
        end = end.split("-")[2] + "/" + end.split("-")[1];
        String rs = begin + " - " + end;
        return rs;
    }

    public static String getBeginEnd(String week, String status) {
        String begin = "", end = "";
        if (status.equals("begin")) {
            begin = week.split("-")[0].trim();
            begin = begin.replaceAll("/", "-");
            begin = begin.split("-")[1] + "-" + begin.split("-")[0];
            return begin;
        }
        if (status.equals("end")) {
            end = week.split("-")[1].trim();
            end = end.replaceAll("/", "-");
            end = end.split("-")[1] + "-" + end.split("-")[0];
            return end;
        }
        return "";
    }

    // check string is date
    public static boolean isDate(String date) {
        try {
            LocalDate.parse(date);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static Time getTimeOfSlot(int slot, String status) {
        if (status.equals("from")) {
            switch (slot) {
                case 1:
                    return Time.valueOf("07:30:00");
                case 2:
                    return Time.valueOf("09:10:00");
                case 3:
                    return Time.valueOf("10:50:00");
                case 4:
                    return Time.valueOf("12:50:00");
                case 5:
                    return Time.valueOf("14:30:00");
                case 6:
                    return Time.valueOf("16:10:00");
            }
        } else {
            switch (slot) {
                case 1:
                    return Time.valueOf("09:00:00");
                case 2:
                    return Time.valueOf("10:40:00");
                case 3:
                    return Time.valueOf("12:20:00");
                case 4:
                    return Time.valueOf("14:20:00");
                case 5:
                    return Time.valueOf("16:00:00");
                case 6:
                    return Time.valueOf("17:40:00");
            }
        }
        return null;
    }

    // function return string from date with format 11, Sep 2022
    public static String getStringFromDate(String date1) {
        LocalDate date = LocalDate.parse(date1);
        String rs = date.getDayOfMonth() + ", "
                + date.getMonth().toString().substring(0, 1).toUpperCase()
                + date.getMonth().toString().substring(1, 3).toLowerCase() + " " + date.getYear();
        return rs;
    }

    // function convert 11, Sep 2022 to 2022-09-11
    public static String convertStringToDate(String date) {
        String[] arr = date.split(" ");
        String day = arr[0].substring(0, arr[0].length() - 1);
        String month = arr[1].substring(0, 3);
        switch (month) {
            case "Jan":
                month = "01";
                break;
            case "Feb":
                month = "02";
                break;
            case "Mar":
                month = "03";
                break;
            case "Apr":
                month = "04";
                break;
            case "May":
                month = "05";
                break;
            case "Jun":
                month = "06";
                break;
            case "Jul":
                month = "07";
                break;
            case "Aug":
                month = "08";
                break;
            case "Sep":
                month = "09";
                break;
            case "Oct":
                month = "10";
                break;
            case "Nov":
                month = "11";
                break;
            case "Dec":
                month = "12";
                break;
        }
        String year = arr[2];
        String rs = year + "-" + month + "-" + day;
        return rs;
    }

    public static String formatDateSql(String x) {
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        sdf1.setLenient(false);
        sdf1.setLenient(false);
        Date d = new Date();
        try {
            d = sdf1.parse(x);
        } catch (Exception e) {
        }
        return sdf2.format(d);
    }

    public static void main(String[] args) {
        System.out.println(formatDateSql("11-09-2022"));
    }
}
