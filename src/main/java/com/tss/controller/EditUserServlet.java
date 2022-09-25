/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.tss.controller;

import com.tss.constants.HttpStatusCodeConstants;
import com.tss.constants.SessionConstants;
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
import java.io.IOException;
import java.io.PrintWriter;


/**
 *
 * @author ADMIN
 */
public class EditUserServlet extends HttpServlet {

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
        User user = (User) request.getSession().getAttribute(SessionConstants.USER_SESSION);
      //  Client client = (Client) request.getSession().getAttribute(SessionConstants.CLIENT_SESSION);
       //  ResponseHelper.sendResponse(response, new ResponseMessage(HttpStatusCodeConstants.OK, "Get client successfully", client));
        ResponseHelper.sendResponse(response, new ResponseMessage(HttpStatusCodeConstants.OK, "Get user successfully", user));
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        int userId = Integer.parseInt(request.getParameter("userId"));
        UserServiceImpl userService = new UserServiceImpl();
       
        ClientServiceImpl clientService = new ClientServiceImpl();
        User user = userService.findById(userId);
       // out.print(user.getUserId() +"-"+ user.getFullname()+"-" + user.getAvatarUrl()+"-" + user.getEmail()+"-"+user.getMobile());
      
        if (clientService.findClientById(userId) != null) {
            Client client = clientService.findClientById(userId);  
            request.setAttribute("client", client);
        }
        request.setAttribute("user", user);
       // request.getRequestDispatcher("jsp/userProfile.jsp").forward(request, response); //servlet load ra user profile
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
       //        String userId = request.getParameter("id"); // tên bên jsp
//        String fullName = request.getParameter("fullName");
//        String email = request.getParameter("email");
//        String mobile = request.getParameter("mobile");
//        UserServiceImpl userService = new UserServiceImpl();
//        ClientServiceImpl clientService = new ClientServiceImpl();
//        if (clientService.findClientById(Integer.parseInt(userId)) != null) {
//            String address = request.getParameter("address");
//            String company = request.getParameter("company");
//            clientService.update(Integer.parseInt(userId), address, company);
//        }
//        userService.update(Integer.parseInt(userId), fullName, email, mobile);
//        request.setAttribute("jspPath", "/userProfile.jsp");
//        try {
//            request.getRequestDispatcher("jsp/template.jsp").forward(request, response); //servlet load ra user profile
//        } catch (ServletException ex) {
//            Logger.getLogger(ProfileServlet.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(ProfileServlet.class.getName()).log(Level.SEVERE, null, ex);
//        }
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
