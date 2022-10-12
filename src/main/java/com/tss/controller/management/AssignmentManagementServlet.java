package com.tss.controller.management;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.tss.constants.ActionConstants;
import com.tss.constants.ScreenConstants;
import com.tss.helper.ResponseHelper;
import com.tss.model.Assignment;
import com.tss.model.Subject;
import com.tss.service.AssignmentService;
import com.tss.service.SubjectService;
import com.tss.service.impl.AssignmentServiceImpl;
import com.tss.service.impl.SubjectServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
        if (list.isEmpty()) {
            request.setAttribute("notice", "There no result as you expected!!!");
        }

        request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("assign_id"));
        System.out.println(request.getParameter("assign_subject"));
        int sub_id = Integer.parseInt(request.getParameter("assign_subject"));
        String name = request.getParameter("assign_name");
        String body = request.getParameter("assign_description");
        int is_team = Integer.parseInt(request.getParameter("assign_team"));
        int weight = Integer.parseInt(request.getParameter("assign_weight"));
        int is_going = Integer.parseInt(request.getParameter("assign_going"));
        int status = Integer.parseInt(request.getParameter("assign_status"));
        Assignment assign = new Assignment(id, sub_id, name, body, weight, is_team, is_going, status, "");

        assignmentService.update(assign);
        System.out.println("here");
        response.sendRedirect("list");
    }

    private void changeStatus(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int assId = Integer.parseInt(request.getParameter("assId"));
        assignmentService.changeStatus(assId);
        response.sendRedirect("/assignment/list");
    }

    private void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("jspPath", "shared/assignmentdetails.jsp");
        request.setAttribute("customJs", ResponseHelper.customJs(
                "Assignment/custom.js"));
        request.setAttribute("brecrumbs", ResponseHelper.brecrumbs(
                ScreenConstants.USER_DASHBOARD,
                ScreenConstants.ASSIGNNMENT_LIST));
        Assignment assign = assignmentService.findById(Integer.parseInt(request.getParameter("assignId")));
        SubjectServiceImpl sv = new SubjectServiceImpl();
        List<Subject> subjects = sv.findAll(0, sv.countAll(), "");
        request.setAttribute("assign", assign);
        request.setAttribute("subjects", subjects);
        request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);
    }

}
