/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.tss.controller.setting;

import com.tss.constants.ActionConstants;
import com.tss.model.system.SubjectSetting;
import com.tss.service.SubjectService;
import com.tss.service.SubjectSettingService;
import com.tss.service.impl.SubjectServiceImpl;
import com.tss.service.impl.SubjectSettingServiceImpl;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class SubjectSettingServlet extends HttpServlet {

    private SubjectSettingService subjectSettingService;
    private SubjectService subjectService;

    @Override
    public void init() throws ServletException {
        subjectSettingService = new SubjectSettingServiceImpl();
        subjectService = new SubjectServiceImpl();
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
                case ActionConstants.CHANGE_STATUS:
                    changeStatus(request, response);
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
        request.setAttribute("jspPath", "shared/subjectSetting.jsp");
        List<SubjectSetting> list = subjectSettingService.getSubjectSettingList(0, 5, "", "", "", "", "", "");
        request.setAttribute("ssList", list);
        List<Integer> totalPages = new ArrayList<>();
        int totalRecord = subjectSettingService.countAll();
        int pages = (totalRecord % 5 == 0) ? (totalRecord / 5) : ((totalRecord / 5) + 1);
        for (int i = 1; i <= pages; i++) {
            totalPages.add(i);
        }
        request.setAttribute("pages", totalPages);
        request.setAttribute("currentPage", 1);
        request.setAttribute("subjectList", subjectService.List(0, Integer.MAX_VALUE));
        request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("jspPath", "shared/subjectSetting.jsp");
        String searchRg = request.getParameter("searchRg");
        request.setAttribute("searchRg", searchRg);
        String subjectFilter = request.getParameter("subjectFilter");
        request.setAttribute("subjectFilter", subjectFilter);
        String titleFilter = request.getParameter("titleFilter");
        request.setAttribute("titleFilter", titleFilter);
        String displayOrderFilter = request.getParameter("displayOrderFilter");
        request.setAttribute("displayOrderFilter", displayOrderFilter);
        String statusFilter = request.getParameter("statusFilter");
        request.setAttribute("statusFilter", statusFilter);
        String sort = request.getParameter("sort");
        request.setAttribute("sort", sort);
        int pageNo = 1;
        if (!request.getParameter("pageNo").equals("")) {
            pageNo = Integer.parseInt(request.getParameter("pageNo"));
        }
        request.setAttribute("currentPage", pageNo);
        int page = 0;
        if (pageNo == 1) {
            page = 0;
        } else {
            page = (pageNo - 1) * 5;
        }
        List<SubjectSetting> list = subjectSettingService.getSubjectSettingList(page, 5, searchRg,
                subjectFilter, titleFilter, displayOrderFilter, statusFilter, "");
        request.setAttribute("ssList", list);
        List<Integer> totalPages = new ArrayList<>();
        int totalRecord = subjectSettingService.countAll(searchRg,
                subjectFilter, titleFilter, displayOrderFilter, statusFilter);
        int pages = (totalRecord % 5 == 0) ? (totalRecord / 5) : ((totalRecord / 5) + 1);
        for (int i = 1; i <= pages; i++) {
            totalPages.add(i);
        }
        request.setAttribute("pages", totalPages);
        request.setAttribute("subjectList", subjectService.List(0, Integer.MAX_VALUE));
        if (list.isEmpty()) {
            request.setAttribute("notice", "There no result as you expected!!!");
        }

        request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int typeId = Integer.parseInt(request.getParameter("typeId"));
        String title = "", displayOrder = "";
        switch (typeId) {
            case 1:
                title = "Marks";
                break;
            case 2:
                title = "Learning progress";
                break;
            case 3:
                title = "Lecture";
                break;
            case 4:
                title = "Complexity";
                break;
        }
        String value = request.getParameter("value");
        switch (value) {
            case "1":
                displayOrder = "Simple";
                break;
            case "2":
                displayOrder = "Normal";
                break;
            case "3":
                displayOrder = "Complex";
                break;
        }
        String description = request.getParameter("description");
        int statusId = Integer.parseInt(request.getParameter("statusId"));
        int subjectId = Integer.parseInt(request.getParameter("subjectId"));
        SubjectSetting subjectSetting = new SubjectSetting(0, typeId, title, value, displayOrder, statusId,
                description, subjectId, "");
        subjectSettingService.add(subjectSetting);
        response.sendRedirect("/subjectSetting");
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int settingId = Integer.parseInt(request.getParameter("settingId"));
        int typeId = Integer.parseInt(request.getParameter("typeId"));
        String title = "", displayOrder = "";
        switch (typeId) {
            case 1:
                title = "Marks";
                break;
            case 2:
                title = "Learning progress";
                break;
            case 3:
                title = "Lecture";
                break;
            case 4:
                title = "Complexity";
                break;
        }
        String value = request.getParameter("value");
        switch (value) {
            case "1":
                displayOrder = "Simple";
                break;
            case "2":
                displayOrder = "Normal";
                break;
            case "3":
                displayOrder = "Complex";
                break;
        }
        String description = request.getParameter("description");
        int statusId = Integer.parseInt(request.getParameter("statusId"));
        int subjectId = Integer.parseInt(request.getParameter("subjectId"));
        SubjectSetting subjectSetting = new SubjectSetting(settingId, typeId, title, value, displayOrder, statusId,
                description, subjectId, "");
        subjectSettingService.update(subjectSetting);
        response.sendRedirect("/subjectSetting");
    }

    private void changeStatus(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int settingId = Integer.parseInt(request.getParameter("settingId"));
        subjectSettingService.changeStatus(settingId);
        response.sendRedirect("/subjectSetting");
    }

    private void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("jspPath", "shared/subjectSettingDetails.jsp");
        int settingId = Integer.parseInt(request.getParameter("settingId"));
        SubjectSetting ss = subjectSettingService.findById(settingId);
        request.setAttribute("subjectSetting", ss);
        request.setAttribute("subjectList", subjectService.List(0, Integer.MAX_VALUE));

        request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);
    }
}
