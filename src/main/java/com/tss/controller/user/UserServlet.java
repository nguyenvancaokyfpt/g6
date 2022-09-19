/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.tss.controller.user;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tss.constants.HttpStatusCodeConstants;
import com.tss.helper.RequestHelper;
import com.tss.model.User;
import com.tss.model.payload.ResponseMessage;
import com.tss.service.impl.UserServiceImpl;
import java.io.IOException;
import java.io.PrintWriter;
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

    private void get(HttpServletRequest request, HttpServletResponse response) {
        UserServiceImpl userService = new UserServiceImpl();
        JSONObject jsonObject = RequestHelper.getJsonData(request);
        User user = userService.findById(jsonObject.getInteger("user_id"));
        // response
        try {
            response.setContentType("application/json");
            if(user != null) {
                try (PrintWriter writer = response.getWriter()) {
                    response.setStatus(HttpStatusCodeConstants.SUCCESS); // Success
                    ResponseMessage responseMessage = new ResponseMessage();
                    responseMessage.setStatus("success");
                    responseMessage.setCode(HttpStatusCodeConstants.SUCCESS);
                    responseMessage.setMessage("Get user info success");
                    responseMessage.setData(user);
                    writer.write(JSONArray.toJSONString(responseMessage));
                    writer.flush();
                }
            } else {
                try (PrintWriter writer = response.getWriter()) {
                    response.setStatus(HttpStatusCodeConstants.NOT_FOUND); // Not found
                    ResponseMessage responseMessage = new ResponseMessage();
                    responseMessage.setStatus("error");
                    responseMessage.setCode(HttpStatusCodeConstants.NOT_FOUND);
                    responseMessage.setMessage("User not found");
                    writer.write(JSONArray.toJSONString(responseMessage));
                    writer.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
    }

    private void list(HttpServletRequest request, HttpServletResponse response) {

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
