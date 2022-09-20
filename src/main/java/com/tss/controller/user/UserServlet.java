/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.tss.controller.user;

import com.alibaba.fastjson.JSONObject;
import com.tss.constants.HttpStatusCodeConstants;
import com.tss.helper.RequestHelper;
import com.tss.helper.ResponseHelper;
import com.tss.model.User;
import com.tss.model.payload.ListResponseMessage;
import com.tss.model.payload.ResponseMessage;
import com.tss.service.impl.UserServiceImpl;
import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author nguye
 */
public class UserServlet extends HttpServlet {

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
                case "list":
                    list(request, response);
                    break;
                case "create":
                    create(request, response);
                    break;
                case "update":
                    update(request, response);
                    break;
                case "delete":
                    delete(request, response);
                    break;
                case "get":
                    get(request, response);
                    break;
                default:
                    list(request, response);
                    break;
            }
        } catch (NullPointerException e) {
            list(request, response);
        }
    }

    private void get(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UserServiceImpl userService = new UserServiceImpl();
        JSONObject jsonObject = RequestHelper.getJsonData(request);
        User user = userService.findById(jsonObject.getInteger("user_id"));
        // response
        if (user != null) {
            ResponseHelper.sendResponse(response, new ResponseMessage(HttpStatusCodeConstants.OK, "Get user successfully", user));
        } else {
            ResponseHelper.sendResponse(response, new ResponseMessage(HttpStatusCodeConstants.NOT_FOUND, "User not found"));
        } 
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
    }

    private void list(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UserServiceImpl userService = new UserServiceImpl();
        JSONObject jsonObject = RequestHelper.getJsonData(request);
        String fullname = jsonObject.getString("fullname");
        String email = jsonObject.getString("email");
        int currentPageNo = jsonObject.getInteger("currentPageNo");
        int pageSize = jsonObject.getInteger("pageSize");
        int count = userService.count(fullname, email);
        int totalPages = (int) Math.ceil((double) count / pageSize);
        int offset = (currentPageNo - 1) * pageSize;
        List<User> listUser = userService.List(fullname, email, offset, pageSize);
        // response
        ResponseHelper.sendResponse(response, new ListResponseMessage(HttpStatusCodeConstants.OK, "Get list user successfully", listUser, count, currentPageNo, totalPages));
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
        processRequest(request, response);
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
