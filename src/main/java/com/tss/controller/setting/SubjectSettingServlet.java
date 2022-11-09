package com.tss.controller.setting;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.tss.constants.ActionConstants;
import com.tss.constants.ScreenConstants;
import com.tss.helper.ResponseHelper;
import com.tss.model.system.SubjectSetting;
import com.tss.service.SubjectService;
import com.tss.service.SubjectSettingService;
import com.tss.service.impl.SubjectServiceImpl;
import com.tss.service.impl.SubjectSettingServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
        request.setAttribute("brecrumbs", ResponseHelper.brecrumbs(
                ScreenConstants.SUBJECT_SETTING));
        List<SubjectSetting> list = subjectSettingService.getSubjectSettingList(0, 5,
                "", "", "", "");
        request.setAttribute("ssList", list);
        List<Integer> totalPages = new ArrayList<>();
        int totalRecord = subjectSettingService.countAll("", "", "", "");
        int pages = (totalRecord % 5 == 0) ? (totalRecord / 5) : ((totalRecord / 5) + 1);
        for (int i = 1; i <= pages; i++) {
            totalPages.add(i);
        }
        request.setAttribute("pages", totalPages);
        request.setAttribute("curPage", 1);
        request.setAttribute("endPage", pages);
        request.setAttribute("subjectList", subjectService.List(0, Integer.MAX_VALUE));
        request.setAttribute("subjectTypes", subjectSettingService.getSettings());
        request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("jspPath", "shared/subjectSetting.jsp");
        request.setAttribute("brecrumbs", ResponseHelper.brecrumbs(
                ScreenConstants.SUBJECT_SETTING));
        String searchRg = request.getParameter("searchRg");
        request.setAttribute("searchRg", searchRg);
        String subjectFilter = request.getParameter("subjectFilter");
        request.setAttribute("subjectFilter", subjectFilter);
        String typeFilter = request.getParameter("typeFilter");
        request.setAttribute("typeFilter", typeFilter);
        String statusFilter = request.getParameter("statusFilter");
        request.setAttribute("statusFilter", statusFilter);
        int curPage = Integer.parseInt(request.getParameter("curPage"));
        request.setAttribute("curPage", curPage);
        List<SubjectSetting> list = subjectSettingService.getSubjectSettingList(
                (curPage - 1) * 5, 5, searchRg,
                subjectFilter, typeFilter, statusFilter);
        request.setAttribute("ssList", list);
        List<Integer> totalPages = new ArrayList<>();
        int totalRecord = subjectSettingService.countAll(searchRg,
                subjectFilter, typeFilter, statusFilter);
        int pages = (totalRecord % 5 == 0) ? (totalRecord / 5) : ((totalRecord / 5) + 1);
        for (int i = 1; i <= pages; i++) {
            totalPages.add(i);
        }
        request.setAttribute("pages", totalPages);
        request.setAttribute("endPage", pages);
        request.setAttribute("subjectTypes", subjectSettingService.getSettings());
        request.setAttribute("subjectList", subjectService.List(0, Integer.MAX_VALUE));
        if (list.isEmpty()) {
            request.setAttribute("notice", "There no result as you expected!!!");
        }

        request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String title = request.getParameter("title");
        int value = Integer.parseInt(request.getParameter("value"));
        int typeId = Integer.parseInt(request.getParameter("typeId"));
        String displayOrder = request.getParameter("displayOrder");
        int status = Integer.parseInt(request.getParameter("statusId"));
        String description = request.getParameter("description");
        int subjectId = Integer.parseInt(request.getParameter("subjectId"));
        SubjectSetting subjectSetting = new SubjectSetting(0, typeId, title, value,
                displayOrder, status, description, subjectId, "", "");
        boolean x = subjectSettingService.add(subjectSetting);
        request.getSession().setAttribute("toast", x);
        response.sendRedirect("/subject/setting");
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int settingId = Integer.parseInt(request.getParameter("settingId"));
        String title = request.getParameter("title");
        int typeId = Integer.parseInt(request.getParameter("typeId"));
        int value = Integer.parseInt(request.getParameter("value"));
        String displayOrder = request.getParameter("displayOrder");
        int status = Integer.parseInt(request.getParameter("statusId"));
        String description = request.getParameter("description");
        int subjectId = Integer.parseInt(request.getParameter("subjectId"));
        SubjectSetting subjectSetting = new SubjectSetting(settingId, typeId, title, value,
                displayOrder, status, description, subjectId, "", "");
        boolean x = subjectSettingService.update(subjectSetting);
        request.getSession().setAttribute("toast", x);
        response.sendRedirect("/subject/setting");
    }

    private void changeStatus(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int settingId = Integer.parseInt(request.getParameter("settingId"));
        boolean x = subjectSettingService.changeStatus(settingId);
        request.getSession().setAttribute("toast", x);
        response.sendRedirect("/subject/setting");
    }

    private void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("jspPath", "shared/subjectSettingDetails.jsp");
        request.setAttribute("brecrumbs", ResponseHelper.brecrumbs(
                ScreenConstants.SUBJECT_SETTING));
        int settingId = Integer.parseInt(request.getParameter("settingId"));
        SubjectSetting ss = subjectSettingService.findById(settingId);
        request.setAttribute("subjectSetting", ss);
        request.setAttribute("subjectTypes", subjectSettingService.getSettings());
        request.setAttribute("subjectList", subjectService.List(0, Integer.MAX_VALUE));

        request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);
    }
}
