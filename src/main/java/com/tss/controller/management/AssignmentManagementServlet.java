package com.tss.controller.management;

import com.tss.constants.ActionConstants;
import com.tss.model.Assignment;
import java.io.IOException;
import java.io.PrintWriter;

import com.tss.service.AssignmentService;
import com.tss.service.SubjectService;
import com.tss.service.impl.AssignmentServiceImpl;
import com.tss.service.impl.SubjectServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class AssignmentManagementServlet extends HttpServlet {

    private AssignmentService assignmentService;
    private SubjectService subjectService;

    @Override
    public void init() throws ServletException {
        assignmentService = new AssignmentServiceImpl();
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
        request.setAttribute("jspPath", "shared/assignment.jsp");
        List<Assignment> list = assignmentService.findAll(0, 5, "",
                "", "", "", "");
        request.setAttribute("assList", list);
        List<Integer> totalPages = new ArrayList<>();
        int totalRecord = assignmentService.countAll();
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
        request.setAttribute("jspPath", "shared/assignment.jsp");
        String searchRg = request.getParameter("searchRg");
        request.setAttribute("searchRg", searchRg);
        String subjectFilter = request.getParameter("subjectFilter");
        request.setAttribute("subjectFilter", subjectFilter);
        String isTeamworkFilter = request.getParameter("isteamworkFilter");
        request.setAttribute("isteamworkFilter", isTeamworkFilter);
        String isOngoingFilter = request.getParameter("isgoingFilter");
        request.setAttribute("isongoingFilter", isOngoingFilter);
        String statusFilter = request.getParameter("statusFilter");
        request.setAttribute("statusFilter", statusFilter);
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
        List<Assignment> list = assignmentService.findAll(page, 5, searchRg,
                subjectFilter, isTeamworkFilter, isOngoingFilter, statusFilter);
        request.setAttribute("assList", list);
        List<Integer> totalPages = new ArrayList<>();
        int totalRecord = assignmentService.countAll(searchRg,
                subjectFilter, isTeamworkFilter, isOngoingFilter, statusFilter);
        int pages = (totalRecord % 5 == 0) ? (totalRecord / 5) : ((totalRecord / 5) + 1);
        for (int i = 1; i <= pages; i++) {
            totalPages.add(i);
        }
        request.setAttribute("pages", totalPages);
        request.setAttribute("subjectList", subjectService.List(0, Integer.MAX_VALUE));
        if(list.isEmpty()){
            request.setAttribute("notice", "There no result as you expected!!!");
        }
        
        request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
    }

    private void changeStatus(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int assId = Integer.parseInt(request.getParameter("assId"));
        assignmentService.changeStatus(assId);
        response.sendRedirect("/assignment/list");
    }

    private void get(HttpServletRequest request, HttpServletResponse response) {
    }

}
