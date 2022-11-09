package com.tss.controller.schedule;

import com.tss.constants.ActionConstants;
import com.tss.constants.ScreenConstants;
import com.tss.helper.ResponseHelper;
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
import java.util.ArrayList;
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
        request.setAttribute("brecrumbs", ResponseHelper.brecrumbs(
                ScreenConstants.SCHEDULE_LIST));
        String classFilter = request.getAttribute("globalClass").toString();
        switch (classFilter) {
            case "-1":
                classFilter = "1";
                break;
            case "0":
                classFilter = "";
                break;
        }
        String searchRg = request.getParameter("search") == null ? "" : request.getParameter("search");
        request.setAttribute("searchRg", searchRg);
        if (searchRg.contains("/")) {
            searchRg = ScheduleHelper.formatDateSql(searchRg);
        }
        int curPage = Integer.parseInt(request.getParameter("curPage") == null ? "1"
                : (request.getParameter("curPage").equals("") ? "" : request.getParameter("curPage")));
        List<Schedule> scheduleList = scheduleService.getScheduleList((curPage - 1) * 5, 5, searchRg, classFilter);
        int count = scheduleService.getScheduleCount(searchRg, classFilter);
        int pages = (count % 5 == 0) ? (count / 5) : ((count / 5) + 1);
        List<Integer> totalPages = new ArrayList<>();
        for (int i = 1; i <= pages; i++) {
            totalPages.add(i);
        }
        request.setAttribute("pages", totalPages);
        request.setAttribute("curPage", curPage);
        request.setAttribute("endPage", pages);
        request.setAttribute("scheduleList", scheduleList);
        request.setAttribute("classes", classService.findAllClassroom());
        request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("jspPath", "shared/scheduleList.jsp");
        request.setAttribute("brecrumbs", ResponseHelper.brecrumbs(
                ScreenConstants.SCHEDULE_LIST));
        String classFilter = request.getAttribute("globalClass").toString();
        switch (classFilter) {
            case "-1":
                classFilter = "1";
                break;
            case "0":
                classFilter = "";
                break;
        }
        List<Schedule> scheduleList = scheduleService.getScheduleList(0, 5, "", classFilter);
        request.setAttribute("scheduleList", scheduleList);
        request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int slot = Integer.parseInt(request.getParameter("slot"));
        String f = request.getParameter("from");
        Time from = Time.valueOf(f.length() == 5 ? f.concat(":00") : f);
        String t = request.getParameter("to");
        Time to = Time.valueOf(t.length() == 5 ? t.concat(":00") : t);
        String date = request.getParameter("date");
        Date trainingDate = Date.valueOf(date);
        int classId = Integer.parseInt(request.getParameter("classId"));
        String room = request.getParameter("room");
        // response.getWriter().print(from+"\n"+to);
        Schedule schedule = new Schedule(0, classId, slot,
                trainingDate, from, to, room, "");
        if (scheduleService.checkDupSchedule(schedule)) {
            request.setAttribute("jspPath", "shared/scheduleDetails.jsp");
            request.setAttribute("classes", classService.findAllClassroom());
            request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);
        } else {
            boolean x = scheduleService.add(schedule);
            request.getSession().setAttribute("toast", x);
            response.sendRedirect("/schedule/list");
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int scheduleId = Integer.parseInt(request.getParameter("scheduleId"));
        int slot = Integer.parseInt(request.getParameter("slot"));
        String f = request.getParameter("from");
        Time from = Time.valueOf(f.length() == 5 ? f.concat(":00") : f);
        String t = request.getParameter("to");
        Time to = Time.valueOf(t.length() == 5 ? t.concat(":00") : t);
        String date = request.getParameter("date");
        Date trainingDate = Date.valueOf(date);
        int classId = Integer.parseInt(request.getParameter("classId"));
        String room = request.getParameter("room");
        // response.getWriter().print(from+"\n"+to);
        Schedule schedule = new Schedule(scheduleId, classId, slot,
                trainingDate, from, to, room, "");
        if (scheduleService.checkDupSchedule(schedule)) {
            request.setAttribute("jspPath", "shared/scheduleDetails.jsp");
            Schedule s = scheduleService.getScheduleById(scheduleId);
            request.setAttribute("schedule", s);
            request.setAttribute("classes", classService.findAllClassroom());
            request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);
        } else {
            boolean x = scheduleService.update(schedule);
            request.getSession().setAttribute("toast", x);
            response.sendRedirect("/schedule/list");
        }
    }

    private void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int scheduleId = Integer.parseInt(request.getParameter("scheduleId"));
        if (scheduleId == -1) {
            request.setAttribute("jspPath", "shared/scheduleAdd.jsp");
            request.setAttribute("brecrumbs", ResponseHelper.brecrumbs(
                    ScreenConstants.SCHEDULE_LIST));
        } else {
            request.setAttribute("jspPath", "shared/scheduleDetails.jsp");
            request.setAttribute("brecrumbs", ResponseHelper.brecrumbs(
                    ScreenConstants.SCHEDULE_LIST, ScreenConstants.SCHEDULE_DETAIL));
            Schedule s = scheduleService.getScheduleById(scheduleId);
            request.setAttribute("schedule", s);
        }
        request.setAttribute("classes", classService.findAllClassroom());
        request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);
    }

}
