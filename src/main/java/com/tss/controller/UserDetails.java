/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.tss.controller;

import java.io.IOException;

import com.tss.constants.ActionConstants;
import com.tss.constants.ScreenConstants;
import com.tss.helper.ResponseHelper;
import com.tss.model.User;
import com.tss.service.UserService;
import com.tss.service.impl.UserServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Dat Lai
 */
public class UserDetails extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserServiceImpl();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String action = request.getParameter("action");
            switch (action) {
                case ActionConstants.LIST:
                    break;
                case ActionConstants.CREATE:
                    break;
                case ActionConstants.UPDATE:
                    update(request, response);
                    break;
                case ActionConstants.DELETE:
                    break;
                case ActionConstants.GET:
                    break;
                default:
                    System.out.println(action);
                    break;
            }
        } catch (NullPointerException e) {
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // System.out.println(request.getParameter("userID"));
        int userID = Integer.parseInt(request.getParameter("userID"));
        User u = userService.findById(userID);
        u.setFullname(request.getParameter("userName"));
        u.setEmail(request.getParameter("userEmail"));
        u.setMobile(request.getParameter("userMobile"));
        u.setStatusId(Integer.parseInt(request.getParameter("userStatus")));
        u.setNote(request.getParameter("userNote"));
        userService.modify(u);
        response.sendRedirect("/management/user/detail?id=" + userID);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("jspPath", "shared/userdetails.jsp");

        UserServiceImpl usi = new UserServiceImpl();
        User u = usi.findById(Integer.parseInt(request.getParameter("id")));

        request.setAttribute("user", u);
        request.setAttribute("customJs", ResponseHelper.customJs(
                "apps/user-management/users/view/custom.js"));
        request.setAttribute("brecrumbs", ResponseHelper.brecrumbs(
                ScreenConstants.USER_DASHBOARD,
                ScreenConstants.USER_MANAGEMENT,
                ScreenConstants.USER_DETAILS_MANAGEMENT));
        request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
