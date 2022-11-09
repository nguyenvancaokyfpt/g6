package com.tss.controller.management;

import java.io.IOException;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.tss.constants.ActionConstants;
import com.tss.constants.ScreenConstants;
import com.tss.helper.RequestHelper;
import com.tss.helper.ResponseHelper;
import com.tss.model.Subject;
import com.tss.model.payload.DataTablesMessage;
import com.tss.service.SubjectService;
import com.tss.service.UserService;
import com.tss.service.impl.SubjectServiceImpl;
import com.tss.service.impl.UserServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class SubjectManagementServlet extends HttpServlet {

    private SubjectService subjectService;
    private UserService userService;

    @Override
    public void init() throws ServletException {
        subjectService = new SubjectServiceImpl();
        userService = new UserServiceImpl();
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

    private void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("jspPath", "shared/subjectDetails.jsp");
        int subjectId = Integer.parseInt(request.getParameter("subjectId"));
        if (subjectId == -1) {
            request.setAttribute("jspPath", "shared/subjectAdd.jsp");
        }
        request.setAttribute("brecrumbs", ResponseHelper.brecrumbs(
                ScreenConstants.SUBJECT_LIST, ScreenConstants.SUBJECT_DETAILS));
        request.setAttribute("subject", subjectService.findById(subjectId));
        request.setAttribute("userList", userService.findAll(0, Integer.MAX_VALUE, ""));
        request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);
    }

    private void changeStatus(HttpServletRequest request, HttpServletResponse response) throws IOException {
        boolean x = subjectService.changeStatus(Integer.parseInt(request.getParameter("subjectId")));
        request.getSession().setAttribute("toast", x);
        response.sendRedirect("/subject/list");
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int subjectId = Integer.parseInt(request.getParameter("subjectId"));
        Subject subject = subjectService.findById(subjectId);
        String subjectName = request.getParameter("subjectName");
        subject.setSubjectName(subjectName);
        String subjectCode = request.getParameter("subjectCode");
        subject.setSubjectCode(subjectCode);
        subject.setExpertId(Integer.parseInt(request.getParameter("expertId")));
        subject.setManagerId(Integer.parseInt(request.getParameter("managerId")));
        subject.setStatusId(Integer.parseInt(request.getParameter("status")));
        String body = request.getParameter("body");
        subject.setBody(body);
        boolean x = subjectService.update(subject);
        request.getSession().setAttribute("toast", x);
        response.sendRedirect("/subject/list");
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Subject subject = new Subject();
        subject.setSubjectCode(request.getParameter("subjectCode"));
        subject.setSubjectName(request.getParameter("subjectName"));
        subject.setExpertId(Integer.parseInt(request.getParameter("expertId")));
        subject.setManagerId(Integer.parseInt(request.getParameter("managerId")));
        subject.setStatusId(Integer.parseInt(request.getParameter("status")));
        subject.setBody(request.getParameter("body"));
        boolean x = subjectService.add(subject);
        request.getSession().setAttribute("toast", x);
        response.sendRedirect("/subject/list");
    }

    private void list(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("jspPath", "shared/subject.jsp");
        request.setAttribute("brecrumbs", ResponseHelper.brecrumbs(
                ScreenConstants.SUBJECT_LIST));
        String managerId = request.getParameter("managerId");
        request.setAttribute("managerId", managerId);
        String expertId = request.getParameter("expertId");
        request.setAttribute("expertId", expertId);
        String status = request.getParameter("status");
        request.setAttribute("status", status);
        String search = request.getParameter("search");
        request.setAttribute("searchRg", search);
        int curPage = Integer.parseInt(request.getParameter("curPage"));
        List<Subject> subjects = subjectService.list((curPage - 1) * 5, 5, search,
                managerId, expertId, status);
        List<Integer> pages = new ArrayList<>();
        int count = subjectService.countAll(search, managerId, expertId, status);
        int totalPages = count % 5 == 0 ? (count / 5) : ((count / 5) + 1);
        for (int i = 1; i <= totalPages; i++) {
            pages.add(i);
        }
        request.setAttribute("pages", pages);
        request.setAttribute("curPage", curPage);
        request.setAttribute("endPage", totalPages);
        request.setAttribute("subjectList", subjects);
        request.setAttribute("userList", userService.findAll(0, Integer.MAX_VALUE, ""));
        request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("jspPath", "shared/subject.jsp");
        request.setAttribute("brecrumbs", ResponseHelper.brecrumbs(
                ScreenConstants.SUBJECT_LIST));
        List<Subject> subjects = subjectService.list(0, 5, "", "", "", "");
        List<Integer> pages = new ArrayList<>();
        int count = subjectService.countAll("", "", "", "");
        int totalPages = count % 5 == 0 ? (count / 5) : (count / 5 + 1);
        for (int i = 1; i <= totalPages; i++) {
            pages.add(i);
        }
        request.setAttribute("pages", pages);
        request.setAttribute("curPage", 1);
        request.setAttribute("endPage", totalPages);
        request.setAttribute("subjectList", subjects);
        request.setAttribute("userList", userService.findAll(0, Integer.MAX_VALUE, ""));
        request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
