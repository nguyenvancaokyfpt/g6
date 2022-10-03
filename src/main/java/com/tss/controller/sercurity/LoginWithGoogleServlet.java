/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.tss.controller.sercurity;

import java.io.IOException;
import java.util.List;
import java.util.TreeSet;

import com.alibaba.fastjson.JSONObject;
import com.tss.constants.HttpStatusCodeConstants;
import com.tss.constants.RoleConstants;
import com.tss.constants.SessionConstants;
import com.tss.helper.GoogleLoginHelper;
import com.tss.helper.RequestHelper;
import com.tss.helper.ResponseHelper;
import com.tss.model.User;
import com.tss.model.payload.ResponseMessage;
import com.tss.model.sercurity.Permission;
import com.tss.model.sercurity.UserRole;
import com.tss.service.PermissionService;
import com.tss.service.RegisterService;
import com.tss.service.RoleService;
import com.tss.service.UserService;
import com.tss.service.impl.PermissionServiceImpl;
import com.tss.service.impl.RegisterServiceImpl;
import com.tss.service.impl.RoleServiceImpl;
import com.tss.service.impl.UserServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author nguye
 */
public class LoginWithGoogleServlet extends HttpServlet {

    private UserService userService;
    private RegisterService registerService;
    private RoleService roleService;
    private PermissionService permissionService;

    @Override
    public void init() throws ServletException {
        userService = new UserServiceImpl();
        registerService = new RegisterServiceImpl();
        roleService = new RoleServiceImpl();
        permissionService = new PermissionServiceImpl();
    }

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
        JSONObject jsonObject = RequestHelper.getJsonData(request);
        String accessToken = jsonObject.getString("credential");
        User userGoogle = GoogleLoginHelper.getUserInfo(accessToken);
        // check if user is existed
        // if not, create new user
        // else, login
        // get user info
        User user = userService.findByEmail(userGoogle.getEmail());
        if (user == null) {
            if (registerService.registerUserWithGoogle(userGoogle)) {
                User newUser = userService.findByEmail(userGoogle.getEmail());
                // set user info to session
                request.getSession().setAttribute(SessionConstants.USER_SESSION, newUser);
                // get all roles of user
                List<UserRole> roles = roleService.findByUserId(newUser.getUserId());
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
                // set permission list to session
                request.getSession().setAttribute(SessionConstants.USER_PERMISSIONS, permissions);
                // response
                ResponseHelper.sendResponse(response,
                        new ResponseMessage(HttpStatusCodeConstants.OK, "Login success", newUser));
            }
        } else {
            // check user is active
            if (!user.isActive()) {
                ResponseHelper.sendResponse(response, new ResponseMessage(HttpStatusCodeConstants.BAD_REQUEST,
                        "Your account is inactive, please contact admin to active"));
                return;
            }
            // set user info to session
            request.getSession().setAttribute(SessionConstants.USER_SESSION, user);
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
            // set permission list to session
            request.getSession().setAttribute(SessionConstants.USER_PERMISSIONS, permissions);
            // response
            ResponseHelper.sendResponse(response,
                    new ResponseMessage(HttpStatusCodeConstants.OK, "Login success", user));
        }
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
