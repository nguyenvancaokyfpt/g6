package com.tss.controller.user;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;

import com.alibaba.fastjson.JSONObject;
import com.tss.constants.ActionConstants;
import com.tss.constants.HttpStatusCodeConstants;
import com.tss.constants.ScreenConstants;
import com.tss.constants.SessionConstants;
import com.tss.helper.RequestHelper;
import com.tss.helper.ResponseHelper;
import com.tss.model.User;
import com.tss.model.payload.ResponseMessage;
import com.tss.service.UserService;
import com.tss.service.impl.UserServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author nguye
 */
public class ProfileServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
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
        try {
            String action = request.getParameter("action");
            switch (action) {
                case ActionConstants.UPDATE:
                    update(request, response);
                    break;
                case ActionConstants.CHANGE_PASSWORD:
                    changePassword(request, response);
                    break;
                case ActionConstants.GET:
                    get(request, response);
                    break;
                default:
                    get(request, response);
                    break;
            }
        } catch (NullPointerException e) {
            get(request, response);
        }
    }

    private void get(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute(SessionConstants.USER_SESSION);
        ResponseHelper.sendResponse(response,
                new ResponseMessage(HttpStatusCodeConstants.OK, "Get user successfully", user));
    }

    private void changePassword(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute(SessionConstants.USER_SESSION);
        JSONObject jsonObject = RequestHelper.getJsonData(request);
        String currentpassword = jsonObject.getString("currentpassword");
        String newpassword = jsonObject.getString("newpassword");

        if (userService.changePassword(user, currentpassword, newpassword)) {
            ResponseHelper.sendResponse(response,
                    new ResponseMessage(HttpStatusCodeConstants.OK, "Change password successfully"));
        } else {
            ResponseHelper.sendResponse(response,
                    new ResponseMessage(HttpStatusCodeConstants.BAD_REQUEST, "Current password is incorrect"));
        }

        ResponseHelper.sendResponse(response,
                new ResponseMessage(HttpStatusCodeConstants.OK, "Change password successfully"));
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute(SessionConstants.USER_SESSION);
        JSONObject jsonObject = RequestHelper.getJsonData(request);
        String name = jsonObject.getString("fullName");
        String email = jsonObject.getString("email");
        String phone = jsonObject.getString("mobile");

        if (userService.update(user, name, email, phone)) {
            ResponseHelper.sendResponse(response,
                    new ResponseMessage(HttpStatusCodeConstants.OK, "Update user successfully"));
            // update session
            user.setFullname(name);
            user.setEmail(email);
            user.setMobile(phone);
            request.getSession().setAttribute(SessionConstants.USER_SESSION, user);
        } else {
            ResponseHelper.sendResponse(response,
                    new ResponseMessage(HttpStatusCodeConstants.BAD_REQUEST, "Update user failed"));
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

        String tab = request.getParameter("tab") == null ? "profile" : request.getParameter("tab");

        switch (tab) {
            case "settings":
                request.setAttribute("jspPath", "shared/account/settings.jsp");
                break;
            default:
                request.setAttribute("jspPath", "shared/account/overview.jsp");
                break;
        }
        request.setAttribute("customJs", ResponseHelper.customJs(
                "account/settings/signin-methods.js",
                "account/settings/profile-details.js",
                "account/settings/deactivate-account.js"));
        request.setAttribute("brecrumbs", ResponseHelper.brecrumbs(
                ScreenConstants.USER_DASHBOARD));
        request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);
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
