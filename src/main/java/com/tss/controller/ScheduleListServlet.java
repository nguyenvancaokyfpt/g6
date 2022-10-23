package com.tss.controller;

import com.tss.constants.ActionConstants;
import com.tss.helper.ScheduleHelper;
import com.tss.model.Schedule;
import com.tss.service.ClassService;
import com.tss.service.ScheduleService;
import com.tss.service.impl.ClassServiceImpl;
import com.tss.service.impl.ScheduleServiceImpl;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class ScheduleListServlet extends HttpServlet {

    private ScheduleService scheduleService;
    private ClassService classService;

    @Override
    public void init() throws ServletException {
        scheduleService = new ScheduleServiceImpl();
        classService = new ClassServiceImpl();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String action = request.getParameter("action");
            switch (action) {
                case ActionConstants.LIST:
                    list(request, response);
                    break;
                case ActionConstants.CREATE:
                    create(request, response);
                    break;
                case ActionConstants.UPDATE:
                    update(request, response);
                    break;
                case ActionConstants.GET:
                    get(request, response);
                    break;
                default:
                    System.out.println(action);
                    list(request, response);
                    break;
            }
        } catch (NullPointerException e) {
            list(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("jspPath", "shared/scheduleList.jsp");
        String begin = ScheduleHelper.getCurrent("", "begin");
        String end = ScheduleHelper.getCurrent("", "end");
        List<Schedule> scheduleList = scheduleService.getScheduleList(
                begin, end, "", "");
        request.setAttribute("scheduleList", scheduleList);

        List<String> weeks = ScheduleHelper.getWeeksOfYear(2022);
        request.setAttribute("listWeek", weeks);
        request.setAttribute("classes", classService.findAllClassroom());
        request.setAttribute("current", ScheduleHelper.currentWeek(begin, end));
        request.setAttribute("year", 2022);
        request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("jspPath", "shared/scheduleList.jsp");
        String year = request.getParameter("year");
        String week = request.getParameter("week");
        String searchRg = request.getParameter("searchRg");
        request.setAttribute("searchRg", searchRg);
        if (ScheduleHelper.isDate(searchRg)) {
            year = searchRg.split("-")[0];
            String week1 = ScheduleHelper.getCurrent(searchRg, "begin");
            week1 = week1.split("-")[2] + "/" + week1.split("-")[1];
            String week2 = ScheduleHelper.getCurrent(searchRg, "end");
            week2 = week2.split("-")[2] + "/" + week2.split("-")[1];
            week = week1 + " - " + week2;
        }
        request.setAttribute("year", year);

        String classFilter = request.getParameter("classFilter");
        request.setAttribute("classFilter", classFilter);

        String begin = year + "-" + ScheduleHelper.getBeginEnd(week, "begin");
        String end = year + "-" + ScheduleHelper.getBeginEnd(week, "end");
        List<Schedule> scheduleList = scheduleService.getScheduleList(
                begin, end, searchRg, classFilter);
        request.setAttribute("scheduleList", scheduleList);

        List<String> weeks = ScheduleHelper.getWeeksOfYear(2022);
        request.setAttribute("listWeek", weeks);
        request.setAttribute("classes", classService.findAllClassroom());
        request.setAttribute("current", ScheduleHelper.currentWeek(begin, end));
        request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int slot = Integer.parseInt(request.getParameter("slot"));
        Time from = ScheduleHelper.getTimeOfSlot(slot, "from");
        Time to = ScheduleHelper.getTimeOfSlot(slot, "to");
        String date = request.getParameter("invoice_date");
        Date trainingDate = Date.valueOf(ScheduleHelper.convertStringToDate(date));
        int classId = Integer.parseInt(request.getParameter("classId"));
        String title = request.getParameter("title");
        String room = request.getParameter("room");
        Schedule schedule = new Schedule(0, classId, slot,
                title, trainingDate, from, to, room, "");
        if (scheduleService.checkDupSchedule(schedule)) {
            request.setAttribute("jspPath", "shared/scheduleAdd.jsp");
            request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);
        } else {
            scheduleService.add(schedule);
            response.sendRedirect("/schedule/list");
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int scheduleId = Integer.parseInt(request.getParameter("scheduleId"));
        int slot = Integer.parseInt(request.getParameter("slot"));
        Time from = ScheduleHelper.getTimeOfSlot(slot, "from");
        Time to = ScheduleHelper.getTimeOfSlot(slot, "to");
        String date = request.getParameter("invoice_date");
        Date trainingDate = Date.valueOf(ScheduleHelper.convertStringToDate(date));
        int classId = Integer.parseInt(request.getParameter("classId"));
        String title = request.getParameter("title");
        String room = request.getParameter("room");
        Schedule schedule = new Schedule(scheduleId, classId, slot,
                title, trainingDate, from, to, room, "");
        if (scheduleService.checkDupSchedule(schedule)) {
            request.setAttribute("jspPath", "shared/scheduleDetails.jsp");
            Schedule s = scheduleService.getScheduleById(scheduleId);
            request.setAttribute("schedule", s);
            request.setAttribute("classes", classService.findAllClassroom());
            request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);
        } else {
            scheduleService.update(schedule);
            response.sendRedirect("/schedule/list");
        }
    }

    private void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int scheduleId = Integer.parseInt(request.getParameter("scheduleId"));
        if (scheduleId == -1) {
            request.setAttribute("jspPath", "shared/scheduleAdd.jsp");
        } else {
            request.setAttribute("jspPath", "shared/scheduleDetails.jsp");
            Schedule s = scheduleService.getScheduleById(scheduleId);
            request.setAttribute("schedule", s);
        }
        request.setAttribute("classes", classService.findAllClassroom());
        request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);
    }

}
