/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.tss.controller;

import com.tss.constants.RoleConstants;
import com.tss.constants.ScreenConstants;
import com.tss.helper.ResponseHelper;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.tss.service.impl.UserServiceImpl;
import com.tss.model.User;

/**
 *
 * @author Dat Lai
 */
public class UserDetails extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String role = request.getAttribute(RoleConstants.ROLE.getTitle()).toString();
        request.setAttribute("jspPath", role + "/userdetails.jsp");
        
        UserServiceImpl usi = new UserServiceImpl();
        User u = usi.findById(Integer.parseInt(request.getParameter("id")));
        
        request.setAttribute("user", u);
        System.out.println(u.getFullname());
        request.setAttribute("customJs", ResponseHelper.customJs(
                "apps/user-management/users/list/table-edited.js",
                "apps/user-management/users/list/export-users.js",
                "apps/user-management/users/list/add.js"
        ));
        request.setAttribute("brecrumbs", ResponseHelper.brecrumbs(
                ScreenConstants.USER_DASHBOARD,
                ScreenConstants.USER_MANAGEMENT,
                ScreenConstants.USER_DETAILS
        ));
        request.getRequestDispatcher("../jsp/template.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
