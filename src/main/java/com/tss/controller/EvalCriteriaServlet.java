/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.tss.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.tss.constants.ActionConstants;
import com.tss.constants.ScreenConstants;
import com.tss.helper.DTOHelper;
import com.tss.helper.RequestHelper;
import com.tss.helper.ResponseHelper;
import com.tss.model.Assignment;
import com.tss.model.EvalCriteria;
import com.tss.model.Subject;
import com.tss.model.payload.DataTablesMessage;
import com.tss.model.util.DataTablesColumns;
import com.tss.service.AssignmentService;
import com.tss.service.EvalCriteriaService;
import com.tss.service.SubjectService;
import com.tss.service.impl.AssignmentServiceImpl;
import com.tss.service.impl.EvalCriteriaServiceImpl;
import com.tss.service.impl.SubjectServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Dat Lai
 */
public class EvalCriteriaServlet extends HttpServlet {

    private EvalCriteriaService evalService;
    private AssignmentService assignService;
    private SubjectService subService;

    public EvalCriteriaServlet() {
        evalService = new EvalCriteriaServiceImpl();
        assignService = new AssignmentServiceImpl();
        subService = new SubjectServiceImpl();
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
                case "add":
                    add(request, response);
                    break;
                case ActionConstants.GET:
                    view(request, response);
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
        request.setAttribute("jspPath", "manager/evalcriteria.jsp");
        request.setAttribute("customJs", ResponseHelper.customJs(
                "manager/customTable.js"));
        request.setAttribute("brecrumbs", ResponseHelper.brecrumbs(
                ScreenConstants.USER_DASHBOARD,
                ScreenConstants.EVALCRITERIA_LIST));
        request.setAttribute("assigns", assignService.findAll(0, assignService.countAll(), "", "", "", "", ""));
        SubjectServiceImpl sv = new SubjectServiceImpl();
        request.setAttribute("subjects", sv.findAll(0, sv.countAll(), ""));
        request.setAttribute("toastStatus", request.getParameter("toastStatus"));
        request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);
    }

    private void list(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JSONObject jsonObject = RequestHelper.getJsonDataForm(request);
        int start = 0;
        int length = 10;
        String search = "";
        int draw = 1;
        int numberofcolumn = -1;
        int orderColumn = 1;
        String orderDir = "asc";
        String subjectFilter = "";
        String assignFilter = "";
        String statusFilter = "";
        List<DataTablesColumns> columns = new ArrayList<DataTablesColumns>();

        try {
            if (jsonObject != null) {
                start = jsonObject.getJSONArray("start").getInteger(0);
                length = jsonObject.getJSONArray("length").getInteger(0);
                search = jsonObject.getJSONArray("search[value]").getString(0);
                draw = jsonObject.getJSONArray("draw").getInteger(0);
                numberofcolumn = jsonObject.getJSONArray("numberOfColumns").getInteger(0);
                orderColumn = jsonObject.getJSONArray("order[0][column]").getInteger(0);
                orderDir = jsonObject.getJSONArray("order[0][dir]").getString(0);
                for (int i = 0; i < numberofcolumn; i++) {
                    columns.add(new DataTablesColumns(
                            DTOHelper.convertToSnakeCase(
                                    jsonObject.getJSONArray("columns[" + i + "][data]").getString(0)),
                            jsonObject.getJSONArray("columns[" + i + "][name]").getString(0),
                            jsonObject.getJSONArray("columns[" + i + "][searchable]").getBoolean(0),
                            jsonObject.getJSONArray("columns[" + i + "][orderable]").getBoolean(0),
                            jsonObject.getJSONArray("columns[" + i + "][search][value]").getString(0),
                            jsonObject.getJSONArray("columns[" + i + "][search][regex]").getBoolean(0)));
                }

                for (DataTablesColumns dataTablesColumns : columns) {
                    if (dataTablesColumns.getData().equals("subject_name")) {
                        subjectFilter = dataTablesColumns.getSearchValue();
                    }
                    if (dataTablesColumns.getData().equals("assign_name")) {
                        assignFilter = dataTablesColumns.getSearchValue();
                    }
                    if (dataTablesColumns.getData().equals("status")) {
                        statusFilter = dataTablesColumns.getSearchValue();
                    }
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        List<EvalCriteria> evalList = evalService.findAll(start, length, search, columns, orderColumn,
                orderDir, subjectFilter, assignFilter, statusFilter);
        int recordsTotal = evalService.countAll();
        int recordsFiltered = evalService.countAll(search, subjectFilter, assignFilter, statusFilter);

        // response
        ResponseHelper.sendResponse(response, new DataTablesMessage(draw, recordsTotal, recordsFiltered, evalList));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("jspPath", "manager/addEvalCriteria.jsp");
        request.setAttribute("customJs", ResponseHelper.customJs(
                "manager/customTable.js"));
        request.setAttribute("brecrumbs", ResponseHelper.brecrumbs(
                ScreenConstants.USER_DASHBOARD,
                ScreenConstants.EVALCRITERIA_LIST));
        request.setAttribute("assigns", assignService.findAll(0, assignService.countAll(), "", "", "", "", ""));
        request.setAttribute("subjects", subService.findAll(0, subService.countAll(), ""));
        request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);

    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int id = evalService.getNewId();
        int ass_id = Integer.parseInt(request.getParameter("criteria_assign"));
        int mile_id = 1;

        String name = request.getParameter("criteria_name");
        String des = request.getParameter("criteria_description");
        int is_team = Integer.parseInt(request.getParameter("criteria_team"));
        int weight = Integer.parseInt(request.getParameter("criteria_weight"));
        int loc = Integer.parseInt(request.getParameter("criteria_loc"));
        int status = 1;
        Object prams[] = { id, ass_id, mile_id, name, is_team, weight, loc, status, des };
        evalService.add(prams);
        response.sendRedirect("evalCriteriaList?toastStatus=2");
    }

    private void view(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("jspPath", "manager/evalcriteriadetails.jsp");
        request.setAttribute("customJs", ResponseHelper.customJs(
                "manager/customEvalDetails.js"));
        request.setAttribute("brecrumbs", ResponseHelper.brecrumbs(
                ScreenConstants.USER_DASHBOARD,
                ScreenConstants.EVALCRITERIA_LIST));
        EvalCriteria eval = evalService.findById(Integer.parseInt(request.getParameter("evalId")));
        Assignment ass = assignService.findById(eval.getAssign());
        Subject sub = (new SubjectServiceImpl()).findById(ass.getSubjectId());
        request.setAttribute("eval", eval);
        request.setAttribute("assign", ass);
        request.setAttribute("sub", sub);
        request.setAttribute("assigns", assignService.findAll(0, assignService.countAll(), "", "", "", "", ""));
        request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {

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
        response.sendRedirect("evalCriteriaList?toastStatus=1");
    }

}
