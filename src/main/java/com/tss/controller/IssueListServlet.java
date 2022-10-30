/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.tss.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson2.JSON;
import com.tss.constants.ActionConstants;
import com.tss.constants.ScreenConstants;
import com.tss.helper.DTOHelper;
import com.tss.helper.RequestHelper;
import com.tss.helper.ResponseHelper;
import com.tss.model.Issue;
import com.tss.model.Milestone;
import com.tss.model.Status;
import com.tss.model.Team;
import com.tss.model.Trainee;
import com.tss.model.User;
import com.tss.model.payload.DataTablesMessage;
import com.tss.model.util.DataTablesColumns;
import com.tss.service.IssueService;
import com.tss.service.MilestoneService;
import com.tss.service.TeamService;
import com.tss.service.impl.InsueServiceImpl;
import com.tss.service.impl.MilestoneServiceImpl;
import com.tss.service.impl.TeamServiceImpl;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nguye
 */
public class IssueListServlet extends HttpServlet {

    private MilestoneService mileService;
    private TeamService teamService;
    private IssueService issueService;

    public IssueListServlet() {
        mileService = new MilestoneServiceImpl();
        teamService = new TeamServiceImpl();
        issueService = new InsueServiceImpl();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String action = request.getParameter("action");
        switch (action) {
            case ActionConstants.LIST:
                list(request, response);
                break;
            case "getTeam":
                getTeam(request, response);
            case ActionConstants.CREATE:
                create(request, response);
            default:
                throw new AssertionError();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("jspPath", "trainee/issuelist.jsp");
        request.setAttribute("customJs", ResponseHelper.customJs(
                "issue/customTable.js"));
        request.setAttribute("brecrumbs", ResponseHelper.brecrumbs(
                ScreenConstants.USER_DASHBOARD,
                ScreenConstants.ISSUE_LIST));
        User u = (User) request.getAttribute("user");
        List<Milestone> miles = mileService.findAllBySupporter(u.getUserId());
        request.setAttribute("miles", miles);
        request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void list(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JSONObject jsonObject = RequestHelper.getJsonDataForm(request);
        int start = 0;
        int length = 10;
        String search = "";
        int draw = 1;
        int orderColumn = 1;
        String orderDir = "asc";
        String orderBy = "issue_id";
        int classFilter = -1;
        int teamFilter = -1;
        int assignFilter = -1;
        int statusFilter = -1;
        List<DataTablesColumns> columns = new ArrayList<DataTablesColumns>();
        try {
            if (jsonObject != null) {
                start = jsonObject.getJSONArray("start").getInteger(0);
                length = jsonObject.getJSONArray("length").getInteger(0);
                search = jsonObject.getJSONArray("search[value]").getString(0);
                draw = jsonObject.getJSONArray("draw").getInteger(0);
                classFilter = jsonObject.getJSONArray("classId").getInteger(0);
                teamFilter = jsonObject.getJSONArray("teamId").getInteger(0);
                assignFilter = jsonObject.getJSONArray("assigneeId").getInteger(0);
                statusFilter = jsonObject.getJSONArray("status").getInteger(0);
                orderColumn = jsonObject.getJSONArray("order[0][column]").getInteger(0);
                orderDir = jsonObject.getJSONArray("order[0][dir]").getString(0);
                orderBy = convertCol(orderColumn);
            }
        } catch (NullPointerException e) {
            System.out.println(e);
        }
        List<Issue> list = issueService.findAll(start, length, search, orderBy, orderDir, classFilter, teamFilter,
                assignFilter, statusFilter);
        int recordsTotal = issueService.countAll(classFilter, teamFilter);
        int recordsFiltered = issueService.countFilter(search, classFilter, teamFilter, assignFilter, statusFilter);
        ResponseHelper.sendResponse(response, new DataTablesMessage(draw, recordsTotal, recordsFiltered, list));
    }

    private String convertCol(int col) {
        switch (col) {
            case 0:
                return "issue_id";
            case 1:
                return "title";
            case 2:
                return "mile_title";
            case 3:
                return "full_name";
            case 4:
                return "status_id";
            case 5:
                return "is_closed";
            default:
                return "issue_id";
        }
    }

    private void getTeam(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int classId = Integer.parseInt(request.getParameter("classId"));
        List<Team> teams = teamService.FindByClassID(classId);
        ResponseHelper.sendResponse(response, teams);
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            Issue i = new Issue();
            Team t = new Team();
            t.setId(Integer.parseInt(request.getParameter("issue_team")));
            i.setTeam(t);
            Trainee tt = new Trainee();
            tt.setUserId(Integer.parseInt(request.getParameter("issue_assignee")));
            i.setAssignee(tt);
            i.setTitle(request.getParameter("issue_title"));
            i.setGitlab_url(request.getParameter("issue_url"));
            Status s = new Status();
            s.setStatusId(Integer.parseInt(request.getParameter("issue_status")));
            i.setStatus(s);
            i.setDecription(request.getParameter("issue_description"));
            i.setExtra_labels("#none");
            i.setIsClose(0);
            i.setLink_id(1);
            i.setType(1);
            issueService.addIssue(i);
            ResponseHelper.sendResponse(response, true);
        } catch (Exception e) {
            ResponseHelper.sendResponse(response, false);
        }
    }

//    private void create(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        JSONObject jsonObject = RequestHelper.getJsonDataForm(request);
//        try {
//            if (jsonObject != null) {
//                Issue i = new Issue();
//                Team t = new Team();
//                t.setId(jsonObject.getJSONArray("issue_team").getInteger(0));
//                i.setTeam(t);
//                Trainee tt = new Trainee();
//                tt.setUserId(jsonObject.getJSONArray("issue_assignee").getInteger(0));
//                i.setAssignee(tt);
//                i.setTitle(jsonObject.getJSONArray("issue_title").getString(0));
//                i.setGitlab_url(jsonObject.getJSONArray("issue_url").getString(0));
//                Status s = new Status();
//                s.setStatusId(jsonObject.getJSONArray("issue_status").getInteger(0));
//                i.setStatus(s);
//                i.setDecription(jsonObject.getJSONArray("issue_description").getString(0));
//                i.setExtra_labels("#none");
//                i.setIsClose(1);
//                i.setLink_id(1);
//                i.setType(1);
//                issueService.addIssue(i);
//            }
//        } catch (NullPointerException e) {
//            ResponseHelper.sendResponse(response, false);
//        }
//    }
}
