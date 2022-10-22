/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.tss.controller;

import com.tss.constants.ActionConstants;
import com.tss.constants.ScreenConstants;
import com.tss.helper.ResponseHelper;
import com.tss.model.Milestone;
import com.tss.model.Team;
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
        try {
            String action = request.getParameter("action");
            switch (action) {
                case ActionConstants.UPDATE:
                    update(request, response);
                    break;
                case ActionConstants.GET:
                    view(request, response);
                    break;
                case ActionConstants.DELETE:
                    remove(request, response);
                    break;
                default:
                    break;
            }
        } catch (NullPointerException e) {
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("jspPath", "shared/teamdetails.jsp");
        request.setAttribute("customJs", ResponseHelper.customJs(
                "Team/details.js"));
        request.setAttribute("brecrumbs", ResponseHelper.brecrumbs(
                ScreenConstants.USER_DASHBOARD,
                ScreenConstants.TEAM_LIST,
                ScreenConstants.TEAM_DETAIL));
        //BEGIN
        int teamid = Integer.parseInt(request.getParameter("teamId"));
        int classID = Integer.parseInt(request.getParameter("classId"));
        Team team = teamService.FindTeamById(teamid, classID);
        
        
        System.out.println(team.getClassName());
        request.setAttribute("team", team);
        //END
        request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void view(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int teamid = Integer.parseInt(request.getParameter("teamId"));
        int classID = Integer.parseInt(request.getParameter("classId"));

        Team team = teamService.FindTeamById(teamid, classID);
        ResponseHelper.sendResponse(response, team);
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
