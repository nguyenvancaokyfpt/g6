/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Filter.java to edit this template
 */
package com.tss.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import com.tss.constants.HttpStatusCodeConstants;
import com.tss.constants.RoleConstants;
import com.tss.constants.ScreenConstants;
import com.tss.constants.SessionConstants;
import com.tss.helper.DebugHelper;
import com.tss.helper.PermissionHelper;
import com.tss.helper.RequestHelper;
import com.tss.helper.ResponseHelper;
import com.tss.model.Classroom;
import com.tss.model.User;
import com.tss.model.payload.ResponseMessage;
import com.tss.model.sercurity.Permission;
import com.tss.model.sercurity.UserRole;
import com.tss.service.ClassService;
import com.tss.service.PermissionService;
import com.tss.service.RoleService;
import com.tss.service.impl.ClassServiceImpl;
import com.tss.service.impl.PermissionServiceImpl;
import com.tss.service.impl.RoleServiceImpl;

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

    private RoleService roleService;
    private PermissionService permissionService;
    private ClassService classService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        roleService = new RoleServiceImpl();
        permissionService = new PermissionServiceImpl();
        classService = new ClassServiceImpl();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
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
                response.sendRedirect(ScreenConstants.LOGIN.getPath() + "?redirect=" + uri);
            } else {
                ResponseHelper.sendResponse(response,
                        new ResponseMessage(HttpStatusCodeConstants.UNAUTHORIZED, "Unauthorized access to " + uri));
            }
        } else {
            // get all roles of user
            List<UserRole> roles = roleService.findByUserId(user.getUserId());
            // Convert to String list
            TreeSet<RoleConstants> roleNames = roleService.convertRoleListToRoleConstantsList(roles);
            // set role list to session
            request.getSession().setAttribute(SessionConstants.USER_ROLES, roleNames);
            // get all permissions of user
            List<Permission> permissions = null;
            for (RoleConstants roleConstants : roleNames) {
                List<Permission> temp = permissionService.ListBySettingId(roleConstants.getId());
                if (permissions == null) {
                    permissions = temp;
                } else {
                    permissions.addAll(temp);
                }
            }

            PermissionHelper permissionHelper = new PermissionHelper(permissions);
            // set permission helper to request
            request.setAttribute("permissionHelper", permissionHelper);

            // set user information to request attribute
            request.setAttribute("user", user);

            // Check permission
            if (RequestHelper.isAllowedAccess(permissions, uri, action)) {
                DebugHelper.log("ALLOWED ACCESS TO " + uri);
                // set the main role to request attribute
                request.setAttribute(RoleConstants.ROLE.getTitle(), roleNames.first().getTitle().toLowerCase());
                request.setAttribute("ROLE_CONSTANTS", roleNames.first());
                RoleConstants role = roleNames.first();
                List<Classroom> userClass = new ArrayList<>();
                if (role == RoleConstants.ADMIN) {
                    userClass = classService.findAllClassroom();
                } else if (role == RoleConstants.STUDENT) {
                    userClass = classService.findClassroomByStudent(user.getUserId());
                } else {
                    userClass = classService.findClassroomByTeacher(user.getUserId());
                }
                request.setAttribute("USER_CLASS", userClass);
                filterChain.doFilter(request, response);
            } else {
                DebugHelper.log("DENIED ACCESS TO " + uri);
                if (method.equals("GET")) {
                    request.getRequestDispatcher("/jsp/authentication/general/error-500.jsp").forward(request,
                            response);
                } else {
                    ResponseHelper.sendResponse(response,
                            new ResponseMessage(HttpStatusCodeConstants.FORBIDDEN, "Forbidden access to "
                                    + uri));
                }
            }
        }
    }

    @Override
    public void destroy() {

    }

}
