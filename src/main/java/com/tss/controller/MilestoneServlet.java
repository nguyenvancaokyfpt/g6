/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.tss.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.tss.constants.ActionConstants;
import com.tss.constants.ScreenConstants;
import com.tss.helper.RequestHelper;
import com.tss.helper.ResponseHelper;
import com.tss.model.Assignment;
import com.tss.model.ClassEntity;
import com.tss.model.Milestone;
import com.tss.model.Subject;
import com.tss.model.payload.DataTablesMessage;
import com.tss.service.AssignmentService;
import com.tss.service.ClassService;
import com.tss.service.MilestoneService;
import com.tss.service.SubjectService;
import com.tss.service.impl.ClassServiceImpl;
import com.tss.service.impl.MilestoneServiceImpl;
import com.tss.service.impl.SubjectServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MilestoneServlet extends HttpServlet {

    private MilestoneService mileStoneService;
    private ClassService classService;
    private SubjectService subjectService;
    private AssignmentService assignmentService;

    @Override
    public void init() throws ServletException {
        mileStoneService = new MilestoneServiceImpl();
        classService = new ClassServiceImpl();
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
                case ActionConstants.DELETE:
                    delete(request, response);
                    break;
                case ActionConstants.GET:
                    get(request, response);
                    break;
                case ActionConstants.REPLY:
                    reply(request, response);
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
        request.setAttribute("jspPath", "shared/milestonedetails.jsp");
        request.setAttribute("customJs", ResponseHelper.customJs(
                "Assignment/custom.js", "apps/milestone/update.js"));
        request.setAttribute("brecrumbs", ResponseHelper.brecrumbs(
                ScreenConstants.MILESTONE_LIST,
                ScreenConstants.MILESTONE_DETAILS));
        int id = Integer.parseInt(request.getParameter("milestoneId"));
        Milestone milestone = mileStoneService.findById(id);
        List<ClassEntity> classEntity = classService.ListCbxa();
        List<Subject> subject = subjectService.findAll(0, 1000, "");
        // List<Assignment> assignments = assignmentService.findAll(1, 1000, "", "", "",
        // "", "");
        // request.setAttribute("assignmentDetails", assignments);
        request.setAttribute("milestoneDetails", milestone);
        request.setAttribute("subjectList", subject);
        request.setAttribute("classList", classEntity);
        request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JSONObject jsonObject = RequestHelper.getJsonData(request);
        int mileStoneId = Integer.parseInt(jsonObject.getString("milestoneId"));
        Milestone milestone = mileStoneService.findById(mileStoneId);
        int assId = milestone.getAssId();
        int classId = Integer.parseInt(jsonObject.getString("classId"));
        int subjectId = Integer.parseInt(jsonObject.getString("subjectId"));
        Date fromDate = Date.valueOf(jsonObject.getString("fromDate"));
        Date toDate = Date.valueOf(jsonObject.getString("toDate"));
        milestone.setStatusId(Integer.parseInt(jsonObject.getString("statusId")));
        String assBody = jsonObject.getString("assBody");
        if (assBody.equals("")) {
            milestone.setAssBody(milestone.getAssBody());
        } else {
            milestone.setAssBody(assBody);
        }
        String description = jsonObject.getString("description");
        if (description.equals("")) {
            milestone.setDescription(milestone.getDescription());
        } else {
            milestone.setDescription(description);
        }
        String title = jsonObject.getString("title");
        if (title.equals("")) {
            milestone.setTitle(milestone.getTitle());
        } else {
            milestone.setTitle(title);
        }
        mileStoneService.updateAss(assId, subjectId);
        mileStoneService.update(milestone, classId, fromDate, toDate, title, assBody, description,
                milestone.getStatusId());
        response.sendRedirect("/milestone/list");
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JSONObject jsonObject = RequestHelper.getJsonData(request);
        Milestone milestone = new Milestone();
        milestone.setAssId(Integer.parseInt(jsonObject.getString("assId")));
        milestone.setClassId(Integer.parseInt(jsonObject.getString("classId")));
        milestone.setFromDate(Date.valueOf(jsonObject.getString("fromDate")));
        milestone.setToDate(Date.valueOf(jsonObject.getString("toDate")));
        milestone.setTitle(jsonObject.getString("title"));
        milestone.setAssBody(jsonObject.getString("description"));
        milestone.setDescription(jsonObject.getString("description"));
        milestone.setStatusId(0);
        mileStoneService.add(milestone);
        response.sendRedirect("/milestone/list");
    }

    private void list(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        JSONObject jsonObject = RequestHelper.getJsonData(request);
        int start = 0;
        int length = 10;
        String search = "";
        int draw = 1;
        if (jsonObject != null) {
            start = jsonObject.getInteger("start");
            length = jsonObject.getInteger("length");
            search = jsonObject.getString("search[value]");
            draw = jsonObject.getInteger("draw");
        } else {
            start = Integer.parseInt(request.getParameter("start"));
            length = Integer.parseInt(request.getParameter("length"));
            search = request.getParameter("search[value]");
            draw = Integer.parseInt(request.getParameter("draw"));
        }
        List<Milestone> milestones = mileStoneService.List(0, 10, search);

        int recordsTotal = mileStoneService.countAll();
        int recordsFiltered = mileStoneService.countAll(search);

        // java.util.logging.Logger.getLogger("foo").info(classEntity.size()+"");
        // response
        ResponseHelper.sendResponse(response, new DataTablesMessage(draw, recordsTotal, recordsFiltered, milestones));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<ClassEntity> classEntity = classService.ListCbxa();
        List<Assignment> assignments = mileStoneService.findAll(0, 1000);
        java.util.logging.Logger.getLogger("foo").info(assignments.size() + "");
        request.setAttribute("assignmentDetails", assignments);
        request.setAttribute("classList", classEntity);
        request.setAttribute("jspPath", "shared/milestone.jsp");
        request.setAttribute("customJs", ResponseHelper.customJs(
                "apps/milestone/table-edited.js",
                "apps/milestone/add.js"));
        request.setAttribute("brecrumbs", ResponseHelper.brecrumbs(
                ScreenConstants.USER_DASHBOARD,
                ScreenConstants.MILESTONE_LIST));

        request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void reply(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // request.setAttribute("jspPath", "shared/webcontact.jsp");
        // int categoryId = Integer.parseInt(request.getParameter("webcontactid"));
        // String reply = request.getParameter("reply");
        // webContactService.reply(categoryId, reply);
        // response.sendRedirect("/webcontact/list");
    }

}
