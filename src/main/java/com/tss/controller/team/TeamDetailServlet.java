/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.tss.controller.team;

import com.google.api.client.googleapis.auth.clientlogin.ClientLogin;
import com.tss.constants.ActionConstants;
import com.tss.constants.ScreenConstants;
import com.tss.helper.ResponseHelper;
import com.tss.model.ClassEntity;
import com.tss.model.Milestone;
import com.tss.model.Team;
import com.tss.model.Trainee;
import com.tss.service.ClassService;
import com.tss.service.MilestoneService;
import com.tss.service.SubjectService;
import com.tss.service.TeamService;
import com.tss.service.UserService;
import com.tss.service.impl.ClassServiceImpl;
import com.tss.service.impl.MilestoneServiceImpl;
import com.tss.service.impl.SubjectServiceImpl;
import com.tss.service.impl.TeamServiceImpl;
import com.tss.service.impl.UserServiceImpl;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author nguye
 */
public class TeamDetailServlet extends HttpServlet {

    private MilestoneService mileService;
    private ClassService classService;
    private TeamService teamService;
    private UserService userService;
    private SubjectService subjectService;

    public TeamDetailServlet() {
        mileService = new MilestoneServiceImpl();
        classService = new ClassServiceImpl();
        teamService = new TeamServiceImpl();
        userService = new UserServiceImpl();
        subjectService = new SubjectServiceImpl();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String action = request.getParameter("action");
            if (action == null) {
                response.sendRedirect("list");
                return;
            }
            switch (action) {
                case ActionConstants.CREATE:
                    create(request, response);
                    break;
                case ActionConstants.UPDATE:
                    update(request, response);
                    break;
                case ActionConstants.GET:
                    view(request, response);
                    break;
                case ActionConstants.DELETE:
                    remove(request, response);
                    break;
                case "getMember":
                    GetTeamMember(request, response);
                    break;
                case "getWaiting":
                    GetWaitingList(request, response);
                    break;
                case "doAdd":
                    doAdd(request, response);
                    break;
                default:
                    response.sendRedirect("list");
                    break;
            }
        } catch (NullPointerException e) {
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int teamId = Integer.parseInt(request.getParameter("team_id"));
        System.out.println(request.getParameter("team_class"));
        int classId = Integer.parseInt(request.getParameter("team_class"));
        String projectCode = request.getParameter("team_project");
        String topicName = request.getParameter("team_topicName");
        String topicCode = request.getParameter("team_topicCode");
        String description = request.getParameter("team_description");
        int statusId = Integer.parseInt(request.getParameter("team_status"));
        Team t = new Team(teamId, null, projectCode, topicCode, topicName, statusId, description, null);
        teamService.UpdateTeam(t);
        response.sendRedirect("detail?action=get&teamId=" + teamId + "&classId=" + classId + "&toast=1");
    }

    private void view(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("jspPath", "shared/teamdetails.jsp");
        request.setAttribute("customJs", ResponseHelper.customJs(
                "Team/details.js"));
        request.setAttribute("brecrumbs", ResponseHelper.brecrumbs(
                ScreenConstants.USER_DASHBOARD,
                ScreenConstants.TEAM_LIST,
                ScreenConstants.TEAM_DETAIL));
        //BEGIN'
        int teamid = 0;
        int classID = 0;
        try {
            teamid = Integer.parseInt(request.getParameter("teamId"));
            classID = Integer.parseInt(request.getParameter("classId"));
        } catch (Exception e) {
            response.sendRedirect("list");
            return;
        }

        Team team = teamService.FindTeamById(teamid, classID);
        request.setAttribute("team", team);
        request.setAttribute("toast", request.getParameter("toast"));
        //END
        request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);
    }

    private void GetTeamMember(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int teamid = Integer.parseInt(request.getParameter("teamId"));
        int classID = Integer.parseInt(request.getParameter("classId"));
        Team team = teamService.FindTeamById(teamid, classID);
        ResponseHelper.sendResponse(response, team.getListTrainee());
    }

    private void GetWaitingList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int classID = Integer.parseInt(request.getParameter("classId"));
        List<Trainee> waiting = userService.GetWaitingList(classID);
        ResponseHelper.sendResponse(response, waiting);
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) {
        int traineeId = Integer.parseInt(request.getParameter("traineeId"));
        int classId = Integer.parseInt(request.getParameter("classId"));
        int teamId = Integer.parseInt(request.getParameter("teamId"));
        teamService.RemoveFromTeam(traineeId, classId, teamId);
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int classId = 0;
        String doing = request.getParameter("doing");
        if (doing != null) {
            classId = Integer.parseInt(request.getParameter("team_class"));
            String projectCode = request.getParameter("team_project");
            String topicName = request.getParameter("team_topicName");
            String topicCode = request.getParameter("team_topicCode");
            String description = request.getParameter("team_description");
            int statusId = Integer.parseInt(request.getParameter("team_status"));
            Team t = new Team(0, null, projectCode, topicCode, topicName, statusId, description, null);
            t.setClassId(classId);
            teamService.AddTeam(t);
            request.setAttribute("toast", "2");
        }

        request.setAttribute("jspPath", "shared/teamdetailsadd.jsp");
        request.setAttribute("customJs", ResponseHelper.customJs(
                "Team/add.js"));
        request.setAttribute("brecrumbs", ResponseHelper.brecrumbs(
                ScreenConstants.USER_DASHBOARD,
                ScreenConstants.TEAM_LIST,
                ScreenConstants.TEAM_DETAIL));

        if (classId == 0) {
            classId = Integer.parseInt(request.getParameter("classId"));
        }
        ClassEntity myClass = classService.findByID(classId);
        request.setAttribute("myClass", myClass);
        System.out.println(myClass);
        request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);
    }

    private void doAdd(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int classId = Integer.parseInt(request.getParameter("team_class"));
        String projectCode = request.getParameter("team_project");
        String topicName = request.getParameter("team_topicName");
        String topicCode = request.getParameter("team_topicCode");
        String description = request.getParameter("team_description");
        int statusId = Integer.parseInt(request.getParameter("team_status"));
        Team t = new Team(0, null, projectCode, topicCode, topicName, statusId, description, null);
        t.setClassId(classId);
        teamService.AddTeam(t);
        ResponseHelper.sendResponse(response, teamService.GetNewTeamId() - 1);
    }
}
