package com.tss.controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import java.io.IOException;

import com.tss.constants.HttpStatusCodeConstants;
import com.tss.constants.SessionConstants;
import com.tss.constants.ActionConstants;
import com.tss.helper.ResponseHelper;
import com.tss.model.Client;
import com.tss.model.User;
import com.tss.model.payload.ResponseMessage;
import com.tss.service.impl.ClientServiceImpl;
import com.tss.service.impl.UserServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nguye
 */
public class ProfileServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
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
        ResponseHelper.sendResponse(response, new ResponseMessage(HttpStatusCodeConstants.OK, "Get user successfully", user));
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
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        int userId = 0;
        String action = "";
        if(request.getParameter("userId")!=null){
         userId = Integer.parseInt(request.getParameter("userId"));
        }
       if(request.getParameter("action")!=null){
           action = request.getParameter("action");
       }
        UserServiceImpl userService = new UserServiceImpl();
       
 //       ClientServiceImpl clientService = new ClientServiceImpl(); 
//        if (clientService.findClientById(userId) != null) {
//            Client client = clientService.findClientById(userId);  
//            request.setAttribute("client", client);
//        }
        User user = userService.findById(userId);
       // out.print(user.getUserId() +"-"+ user.getFullname()+"-" + user.getAvatarUrl()+"-" + user.getEmail()+"-"+user.getMobile());
      
       
        request.setAttribute("user", user);
        if(action.equalsIgnoreCase("update")){
         request.getRequestDispatcher("jsp/userSetting.jsp").forward(request, response);
        }else{
         request.getRequestDispatcher("jsp/userProfile.jsp").forward(request, response); //servlet load ra user profile
        }
       
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String userId = request.getParameter("id"); // tên bên jsp
        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        UserServiceImpl userService = new UserServiceImpl();
//        ClientServiceImpl clientService = new ClientServiceImpl();
//        if (clientService.findClientById(Integer.parseInt(userId)) != null) {
//            String address = request.getParameter("address");
//            String company = request.getParameter("company");
//            clientService.update(Integer.parseInt(userId), address, company);
//        }
        userService.update(Integer.parseInt(userId), fullName, email, mobile);
      
        response.sendRedirect("profile?userId=2");
       
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
