/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package com.tss.controller.issue;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.tss.constants.ScreenConstants;
import com.tss.helper.ResponseHelper;
import com.tss.model.Milestone;
import com.tss.model.User;
import com.tss.service.MilestoneService;
import com.tss.service.impl.MilestoneServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author nguye
 */
public class IssueDetailServlet extends HttpServlet {
    private MilestoneService mileService;
    
    public IssueDetailServlet() {
        mileService = new MilestoneServiceImpl();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet IssueDetailServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet IssueDetailServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("jspPath", "trainee/issueadd.jsp");
        request.setAttribute("customJs", ResponseHelper.customJs(
                "issue/add.js"));
        request.setAttribute("brecrumbs", ResponseHelper.brecrumbs(
                ScreenConstants.USER_DASHBOARD,
                ScreenConstants.ISSUE_LIST));
        User u = (User) request.getAttribute("user");
        List<Milestone> miles = mileService.findAllBySupporter(u.getUserId());
        request.setAttribute("miles", miles);
        request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);
    }


    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
