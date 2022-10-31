/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.tss.controller.management;

import java.io.IOException;
import java.util.Date;

import com.alibaba.fastjson.JSONObject;
import com.tss.constants.ActionConstants;
import com.tss.constants.HttpStatusCodeConstants;
import com.tss.constants.ScreenConstants;
import com.tss.helper.DebugHelper;
import com.tss.helper.RequestHelper;
import com.tss.helper.ResponseHelper;
import com.tss.model.Trainee;
import com.tss.model.payload.ResponseMessage;
import com.tss.service.TraineeService;
import com.tss.service.impl.TraineeServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author nguye
 */
@WebServlet(name = "TraineeDetailServlet", urlPatterns = { "/management/trainee/detail" })
public class TraineeDetailServlet extends HttpServlet {

    private TraineeService traineeService;

    @Override
    public void init() throws ServletException {
        traineeService = new TraineeServiceImpl();
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
        response.setContentType("text/html;charset=UTF-8");
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

    private void get(HttpServletRequest request, HttpServletResponse response) {
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JSONObject jsonObject = RequestHelper.getJsonData(request);
        DebugHelper.print(jsonObject);
        int userId = jsonObject.getIntValue("id");
        String fullName = jsonObject.getString("fullname");
        String email = jsonObject.getString("email");
        String mobile = jsonObject.getString("mobile");
        Date dropoutDate = null;
        if (jsonObject.getString("due_date") != null) {
            dropoutDate = jsonObject.getDate("due_date");
        }
        int status = jsonObject.getIntValue("status");
        String note = jsonObject.getString("note");

        Trainee trainee = new Trainee();
        trainee.setUserId(userId);
        trainee.setFullname(fullName);
        trainee.setEmail(email);
        trainee.setMobile(mobile);
        trainee.setDropoutDate(dropoutDate);
        trainee.setStatusId(status);
        trainee.setNote(note);

        traineeService.update(trainee);

        if (status == 1) {
            traineeService.dropout(userId, null);
            traineeService.active(userId);
        } else if (status == 0) {
            traineeService.dropout(userId, null);
            traineeService.deactive(userId);
        } else {
            traineeService.dropout(userId, dropoutDate);
        }

        ResponseHelper.sendResponse(response,
                new ResponseMessage(HttpStatusCodeConstants.OK, "Update trainee successfully"));

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
        String action = request.getParameter("action") == null ? "" : request.getParameter("action");
        int id = request.getParameter("id") == null ? 52 : Integer.parseInt(request.getParameter("id"));
        int classId = request.getParameter("classId") == null ? 1 : Integer.parseInt(request.getParameter("classId"));

        Trainee trainee = traineeService.getTraineeByTraineeIdAndClassId(id, classId);

        DebugHelper.print(trainee);

        request.setAttribute("trainee", trainee);
        request.setAttribute("action", action);

        switch (action) {
            case "update":
                request.setAttribute("jspPath", "shared/traineeDetail.jsp");
                request.setAttribute("customJs", ResponseHelper.customJs(
                        "apps/user-management/trainee/detail.js"));
                request.setAttribute("brecrumbs", ResponseHelper.brecrumbs(
                        ScreenConstants.USER_DASHBOARD,
                        ScreenConstants.TRAINEE_LIST,
                        ScreenConstants.TRAINEE_DETAIL));
                request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);
                break;
            default:
                request.setAttribute("jspPath", "shared/traineeDetail.jsp");
                request.setAttribute("customJs", ResponseHelper.customJs(
                        "apps/user-management/trainee/detail.js"));
                request.setAttribute("brecrumbs", ResponseHelper.brecrumbs(
                        ScreenConstants.USER_DASHBOARD,
                        ScreenConstants.TRAINEE_LIST,
                        ScreenConstants.TRAINEE_DETAIL));
                request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);
                break;
        }

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
