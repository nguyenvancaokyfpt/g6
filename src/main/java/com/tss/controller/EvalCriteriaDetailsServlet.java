/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.tss.controller;

import com.tss.constants.ActionConstants;
import com.tss.constants.ScreenConstants;
import com.tss.helper.DebugHelper;
import com.tss.helper.ResponseHelper;
import com.tss.model.Assignment;
import com.tss.model.EvalCriteria;
import com.tss.model.Subject;
import com.tss.service.AssignmentService;
import com.tss.service.EvalCriteriaService;
import com.tss.service.impl.AssignmentServiceImpl;
import com.tss.service.impl.EvalCriteriaServiceImpl;
import com.tss.service.impl.SubjectServiceImpl;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Dat Lai
 */
public class EvalCriteriaDetailsServlet extends HttpServlet {

    private EvalCriteriaService evalService;
    private AssignmentService assignService;

    public EvalCriteriaDetailsServlet() {
        evalService = new EvalCriteriaServiceImpl();
        assignService = new AssignmentServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case ActionConstants.GET:
                getDetails(request, response);
                break;
            case ActionConstants.UPDATE:
                updateDetails(request, response);
                break;
            case ActionConstants.CHANGE_STATUS:
                changeStatus(request, response);
                break;
            case "doUpdate":
                doUpdate(request, response);
                break;
            default:
                response.sendRedirect("/evalCriteria/evalCriteriaList");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    private void getDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("jspPath", "manager/evalcriteriadetails.jsp");
        request.setAttribute("customJs", ResponseHelper.customJs(
                "manager/customEvalDetails.js"));
        request.setAttribute("brecrumbs", ResponseHelper.brecrumbs(
                ScreenConstants.USER_DASHBOARD,
                ScreenConstants.EVALCRITERIA_LIST,
                ScreenConstants.EVALCRITERIA_DETAIL
        ));
        EvalCriteria eval = evalService.findById(Integer.parseInt(request.getParameter("evalId")));
        Assignment ass = assignService.findById(eval.getAssign());
        Subject sub = (new SubjectServiceImpl()).findById(ass.getSubjectId());
        request.setAttribute("eval", eval);
        request.setAttribute("assign", ass);
        request.setAttribute("sub", sub);
        request.setAttribute("assigns", assignService.findAll(0, assignService.countAll(), "", "", "", "", ""));
        request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);
    }

    private void changeStatus(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("evalId"));
        int status = Integer.parseInt(request.getParameter("status")) == 1 ? 0 : 1;
        evalService.changeStatus(id, status);
        response.sendRedirect("/evalCriteria/evalCriteriaList");
    }

    private void updateDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("jspPath", "manager/evalcriteriaEdit.jsp");
        request.setAttribute("customJs", ResponseHelper.customJs(
                "manager/customEvalDetails.js"));
        request.setAttribute("brecrumbs", ResponseHelper.brecrumbs(
                ScreenConstants.USER_DASHBOARD,
                ScreenConstants.EVALCRITERIA_LIST,
                ScreenConstants.EVALCRITERIA_DETAIL));
        EvalCriteria eval = evalService.findById(Integer.parseInt(request.getParameter("evalId")));
        request.setAttribute("eval", eval);
        request.setAttribute("assigns", assignService.findAll(0, assignService.countAll(), "", "", "", "", ""));
        request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);
    }

    private void doUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("criteria_id"));
        int ass_id = Integer.parseInt(request.getParameter("criteria_assign"));
        String name = request.getParameter("criteria_name");
        String des = request.getParameter("criteria_description");
        int is_team = Integer.parseInt(request.getParameter("criteria_team"));
        int weight = Integer.parseInt(request.getParameter("criteria_weight"));
        int loc = Integer.parseInt(request.getParameter("criteria_loc"));
        int status = Integer.parseInt(request.getParameter("criteria_status"));

        EvalCriteria eval = new EvalCriteria(id, ass_id, 0, name, is_team, weight, loc, status, des);

        evalService.modify(eval);
        response.sendRedirect("evalCriteriaList");
    }

}
