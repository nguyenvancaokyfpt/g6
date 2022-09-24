/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Filter.java to edit this template
 */
package com.tss.filter;

import com.tss.constants.HttpStatusCodeConstants;
import com.tss.constants.RoleConstants;
import com.tss.constants.ScreenConstants;
import com.tss.constants.SessionConstants;
import com.tss.helper.DebugHelper;
import com.tss.helper.RequestHelper;
import com.tss.helper.ResponseHelper;
import com.tss.model.User;
import com.tss.model.payload.ResponseMessage;
import com.tss.model.sercurity.Permission;

import java.io.IOException;
import java.util.List;
import java.util.TreeSet;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author nguye
 */
public class SercurityFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String uri = request.getRequestURI();
        String method = request.getMethod();
        String action = request.getParameter("action") == null ? "" : request.getParameter("action");

        // Detect screen for request
        ScreenConstants screen = ScreenConstants.findScreenByPath(uri);
        if (screen != null) {
            request.setAttribute("screen", screen);
        }

        // Allow public access
        if (RequestHelper.isPublicAccess(uri)) {
            filterChain.doFilter(request, response);
            return;
        }
        // 404 not found
        if (method.equals("GET") && !RequestHelper.isExist(uri)) {
            request.getRequestDispatcher("/jsp/authentication/general/error-404.jsp").forward(request, response);
            return;
        }

        // Disallow public access to other pages
        User user = (User) request.getSession().getAttribute(SessionConstants.USER_SESSION);
        if (user == null) {
            if (method.equals("GET")) {
                response.sendRedirect(ScreenConstants.LOGIN.getPath());
            } else {
                ResponseHelper.sendResponse(response, new ResponseMessage(HttpStatusCodeConstants.UNAUTHORIZED, "Unauthorized access to " + uri));
            }
        } else {
            // get user permissions from sessions
            List<Permission> permissions = (List<Permission>) request.getSession().getAttribute(SessionConstants.USER_PERMISSIONS);

            // set user information to request attribute
            request.setAttribute("user", user);

            // Check permission
            if (RequestHelper.isAllowedAccess(permissions, uri, action)) {
                DebugHelper.log("ALLOWED ACCESS TO " + uri);
                // get role from sessions
                TreeSet<RoleConstants> roleNames = (TreeSet<RoleConstants>) request.getSession().getAttribute(SessionConstants.USER_ROLES);
                // set the main role to request attribute
                request.setAttribute(RoleConstants.ROLE.getTitle(), roleNames.first().getTitle().toLowerCase());
                filterChain.doFilter(request, response);
            } else {
                DebugHelper.log("DENIED ACCESS TO " + uri);
                if (method.equals("GET")) {
                    request.getRequestDispatcher("/jsp/authentication/general/error-500.jsp").forward(request, response);
                } else {
                    ResponseHelper.sendResponse(response, new ResponseMessage(HttpStatusCodeConstants.FORBIDDEN, "Forbidden access to " + uri));
                }
            }
        }
    }

    @Override
    public void destroy() {

    }

}
