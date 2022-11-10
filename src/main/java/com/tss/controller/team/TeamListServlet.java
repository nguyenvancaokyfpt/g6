/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.tss.controller.team;

import java.io.IOException;
import java.util.List;

import com.tss.constants.ActionConstants;
import com.tss.constants.ScreenConstants;
import com.tss.helper.ResponseHelper;
import com.tss.model.ClassEntity;
import com.tss.model.Milestone;
import com.tss.model.Team;
import com.tss.model.Trainee;
import com.tss.model.User;
import com.tss.service.ClassService;
import com.tss.service.MilestoneService;
import com.tss.service.TeamService;
import com.tss.service.UserService;
import com.tss.service.impl.ClassServiceImpl;
import com.tss.service.impl.MilestoneServiceImpl;
import com.tss.service.impl.TeamServiceImpl;
import com.tss.service.impl.UserServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author nguye
 */
public class TeamListServlet extends HttpServlet {

    private MilestoneService mileService;
    private ClassService classService;
    private TeamService teamService;
    private UserService userService;

    public TeamListServlet() {
        mileService = new MilestoneServiceImpl();
        classService = new ClassServiceImpl();
        teamService = new TeamServiceImpl();
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
                case ActionConstants.UPDATE:
                    update(request, response);
                    break;
                case ActionConstants.GET:
                    view(request, response);
                    break;
                case ActionConstants.CHANGE_STATUS:
                    changestatus(request, response);
                    break;
                case ActionConstants.DELETE:
                    remove(request, response);
                    break;
                case "leader":
                    SetLeader(request, response);
                    break;
                case "update2":
                    update2(request, response);
                    break;
                case "getWaiting":
                    getWaiting(request, response);
                    break;
                case "addToTeam": {
                    addToTeam(request, response);
                }
                default:
                    break;
            }
        } catch (NullPointerException e) {
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("jspPath", "shared/teamlist.jsp");
        request.setAttribute("customJs", ResponseHelper.customJs(
                "Team/custom.js"));
        request.setAttribute("brecrumbs", ResponseHelper.brecrumbs(
                ScreenConstants.USER_DASHBOARD,
                ScreenConstants.TEAM_LIST));
        // BEGIN
        User u = (User) request.getAttribute("user");
        int classId = (int) request.getAttribute("globalClass");
        List<Milestone> miles = mileService.findAllBySupporter(u.getUserId(), classId);
        request.setAttribute("miles", miles);
        // END
        request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void list(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("charset=UTF-8");
        int mileID = Integer.parseInt(request.getParameter("mileId"));
        Milestone mile = mileService.findById(mileID);
        ClassEntity myClass = classService.findByID(mile.getClassId());
        myClass.setMile(mile);
        List<Trainee> trainees = userService.findAllByClassId(0, userService.countAllByClassId(myClass.getId()), "",
                null, -1, "asc", "", myClass.getId());
        myClass.setListTrainee(trainees);
        List<Team> teams = teamService.FindByClassID(myClass.getId(), mileID);
        myClass.setListTeam(teams);

        ResponseHelper.sendResponse(response, myClass);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
        int traineeId = Integer.parseInt(request.getParameter("traineeId"));
        int classId = Integer.parseInt(request.getParameter("classId"));
        int teamId = Integer.parseInt(request.getParameter("teamId"));
        teamService.ChangeTeam(traineeId, classId, teamId);
    }

    private void update2(HttpServletRequest request, HttpServletResponse response) {
        int traineeId = Integer.parseInt(request.getParameter("traineeId"));
        int classId = Integer.parseInt(request.getParameter("classId"));
        int teamId = Integer.parseInt(request.getParameter("teamId"));
        teamService.ChangeTeam2(traineeId, classId, teamId);
    }

    private void SetLeader(HttpServletRequest request, HttpServletResponse response) {
        int traineeId = Integer.parseInt(request.getParameter("traineeId"));
        int classId = Integer.parseInt(request.getParameter("classId"));
        int teamId = Integer.parseInt(request.getParameter("teamId"));
        teamService.SetLeader(traineeId, classId, teamId);
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
        // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void view(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
        // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void changestatus(HttpServletRequest request, HttpServletResponse response) {
        int teamId = Integer.parseInt(request.getParameter("teamId"));
        int statusId = Integer.parseInt(request.getParameter("statusId")) == 1 ? 0 : 1;
        teamService.changeStatus(teamId, statusId);
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) {
        int teamId = Integer.parseInt(request.getParameter("teamId"));
        teamService.RemoveTeam(teamId);
    }

    private void getWaiting(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int classId = Integer.parseInt(request.getParameter("classId"));
        int milestoneId = Integer.parseInt(request.getParameter("mileId"));
        List<Trainee> trains = teamService.GetWaitingList(classId, milestoneId);
        ResponseHelper.sendResponse(response, trains);
    }

    private void addToTeam(HttpServletRequest request, HttpServletResponse response) {
        int userId = Integer.parseInt(request.getParameter("traineeId"));
        int teamId = Integer.parseInt(request.getParameter("teamId"));
        teamService.AddToTeam(userId, teamId);
    }
}
