/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package com.tss.controller;

import java.io.IOException;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.tss.constants.ActionConstants;
import com.tss.constants.HttpStatusCodeConstants;
import com.tss.constants.ScreenConstants;
import com.tss.helper.DebugHelper;
import com.tss.helper.ExcelHelper;
import com.tss.helper.RequestHelper;
import com.tss.helper.ResponseHelper;
import com.tss.model.Classroom;
import com.tss.model.Team;
import com.tss.model.Trainee;
import com.tss.model.Excel.TeamImportModel;
import com.tss.model.payload.ResponseMessage;
import com.tss.service.ClassService;
import com.tss.service.TeamService;
import com.tss.service.UserService;
import com.tss.service.impl.ClassServiceImpl;
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
public class TeamNewServlet extends HttpServlet {

    private ClassService classService;
    private TeamService teamService;
    private UserService userService;

    @Override
    public void init() throws ServletException {
        classService = new ClassServiceImpl();
        teamService = new TeamServiceImpl();
        userService = new UserServiceImpl();
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     * 
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action") != null ? request.getParameter("action") : "";
        switch (action) {
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
            default:
                list(request, response);
                break;
        }
    }

    private void list(HttpServletRequest request, HttpServletResponse response) {
    }

    private void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JSONObject jsonObject = RequestHelper.getJsonData(request);
        try {
            String action = jsonObject.getString("action");
            switch (action) {
                case "import":
                    importTeam(jsonObject, request, response);
                    break;
                default:
                    ResponseHelper.sendResponse(response,
                            new ResponseMessage(HttpStatusCodeConstants.BAD_REQUEST, "Action is not valid"));
                    break;
            }
        } catch (Exception e) {
            ResponseHelper.sendResponse(response,
                    new ResponseMessage(HttpStatusCodeConstants.BAD_REQUEST, "Please check your input data"));
        }
    }

    private void importTeam(JSONObject jsonObject, HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        try {
            int classId = jsonObject.getIntValue("classId");
            String fileUrl = jsonObject.getString("fileUrl");
            String appPath = request.getServletContext().getRealPath("");
            appPath = appPath.replace('\\', '/');
            String filePath = appPath + fileUrl;

            Classroom classroom = classService.findClassById(classId);
            if (classroom == null) {
                ResponseHelper.sendResponse(response,
                        new ResponseMessage(HttpStatusCodeConstants.BAD_REQUEST, "Class is not exist"));
                return;
            }

            TeamImportModel teamImportModel = ExcelHelper.readTeamImportFile(filePath);
            if (teamImportModel == null) {
                ResponseHelper.sendResponse(response,
                        new ResponseMessage(HttpStatusCodeConstants.BAD_REQUEST, "File is not valid"));
                return;
            }

            // Remove all student link to team of this class
            teamService.removeStudentLinkToTeam(classId);

            // remove all team in class
            teamService.resetTeam(classId);

            // set class id for all team
            for (Team team : teamImportModel.getListTeam()) {
                team.setClassId(classId);
            }
            // set class id for all student
            for (Integer key : teamImportModel.getTraineeTeamMap().keySet()) {
                List<Trainee> traineeList = teamImportModel.getTraineeTeamMap().get(key);
                for (Trainee trainee : traineeList) {
                    trainee.setClassId(classId);
                }
            }
            // import team
            List<Integer> listTeamId = teamService.importTeam(teamImportModel.getListTeam());
            if (listTeamId == null) {
                ResponseHelper.sendResponse(response,
                        new ResponseMessage(HttpStatusCodeConstants.BAD_REQUEST, "Import team failed"));
                return;
            }

            // import student
            List<Integer> listStudentId = teamService.importStudent(teamImportModel.getTraineeTeamMap(), listTeamId);
            if (listStudentId.size() == 0) {
                ResponseHelper.sendResponse(response,
                        new ResponseMessage(HttpStatusCodeConstants.BAD_REQUEST, "Import student failed"));
                return;
            }

            ResponseHelper.sendResponse(response,
                    new ResponseMessage(HttpStatusCodeConstants.OK, "Import team successfully"));
        } catch (Exception e) {
            DebugHelper.print(e);
            ResponseHelper.sendResponse(response,
                    new ResponseMessage(HttpStatusCodeConstants.BAD_REQUEST, "Please check your input data"));
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the
    // + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     * 
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action") != null ? request.getParameter("action") : "";
        switch (action) {
            case ActionConstants.GET:
                getFile(request, response);
                break;
            default:
                view(request, response);
                break;
        }
    }

    private void view(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("jspPath", "shared/teamnew.jsp");
        request.setAttribute("customJs", ResponseHelper.customJs(
                "Team/custom.js"));
        request.setAttribute("brecrumbs", ResponseHelper.brecrumbs(
                ScreenConstants.USER_DASHBOARD,
                ScreenConstants.TEAM_LIST,
                ScreenConstants.TEAM_NEW));
        request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);
    }

    private void getFile(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String param = request.getParameter("classId") == null ? "" : request.getParameter("classId");
        int classId = 0;
        try {
            classId = Integer.parseInt(param);
        } catch (Exception e) {
            ResponseHelper.sendResponse(response, new ResponseMessage(HttpStatusCodeConstants.BAD_REQUEST,
                    "Invalid class id"));
            return;
        }
        UserService userService = new UserServiceImpl();
        List<Trainee> traineeList = userService.findAllByClassId(0, 999, "", null, 0, "ASC", "", classId);
        String appPath = request.getServletContext().getRealPath("");
        appPath = appPath.replace('\\', '/');
        ExcelHelper.exportUserForTeamImport(traineeList,
                appPath + "assets/media/file/TeamImportTemplateClass" + classId + ".xlsx");
        response.sendRedirect(request.getContextPath() + "/assets/media/file/TeamImportTemplateClass" + classId
                + ".xlsx");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * 
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     * 
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
