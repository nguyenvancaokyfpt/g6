package com.tss.controller.user;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;

import com.alibaba.fastjson.JSONArray;
import com.tss.constants.HttpStatusCodeConstants;
import com.tss.constants.SessionConstants;
import com.tss.model.User;
import com.tss.model.payload.ResponseMessage;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author nguye
 */
public class ProfileServlet extends HttpServlet {

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
                case "update":
                    update(request, response);
                    break;
                case "changePassword":
                    changePassword(request, response);
                    break;
                case "get":
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
        try {
            User user = (User) request.getSession().getAttribute(SessionConstants.USER_SESSION);
            response.setContentType("application/json");
            response.setStatus(HttpStatusCodeConstants.SUCCESS); // Success
            try (PrintWriter writer = response.getWriter()) {
                ResponseMessage responseMessage = new ResponseMessage();
                responseMessage.setStatus("success");
                responseMessage.setCode(HttpStatusCodeConstants.SUCCESS);
                responseMessage.setMessage("Get user info success");
                responseMessage.setData(user);
                writer.write(JSONArray.toJSONString(responseMessage));
                writer.flush();
            }
        } catch (Exception e) {
            response.setContentType("application/json");
            response.setStatus(HttpStatusCodeConstants.INTERNAL_SERVER_ERROR);
            try (PrintWriter writer = response.getWriter()) {
                ResponseMessage responseMessage = new ResponseMessage();
                responseMessage.setStatus("error");
                responseMessage.setCode(HttpStatusCodeConstants.INTERNAL_SERVER_ERROR);
                responseMessage.setMessage("Get user info failed");
                writer.write(JSONArray.toJSONString(responseMessage));
                writer.flush();
            }
        }
    }

    private void changePassword(HttpServletRequest request, HttpServletResponse response) {
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
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
