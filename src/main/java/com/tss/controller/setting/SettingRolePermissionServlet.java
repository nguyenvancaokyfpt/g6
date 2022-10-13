/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.tss.controller.setting;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.tss.constants.ActionConstants;
import com.tss.constants.HttpStatusCodeConstants;
import com.tss.constants.RoleConstants;
import com.tss.constants.ScreenConstants;
import com.tss.helper.RequestHelper;
import com.tss.helper.ResponseHelper;
import com.tss.model.payload.ResponseMessage;
import com.tss.model.payload.RolePermissionData;
import com.tss.model.payload.RolePermissionMessage;
import com.tss.model.sercurity.Permission;
import com.tss.model.system.Screen;
import com.tss.service.RoleService;
import com.tss.service.impl.RoleServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author nguye
 */
public class SettingRolePermissionServlet extends HttpServlet {

    private RoleService roleService;

    @Override
    public void init() throws ServletException {
        roleService = new RoleServiceImpl();
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
        String action = request.getParameter("action") == null ? "" : request.getParameter("action");

        switch (action) {
            case ActionConstants.UPDATE:
                doPostUpdate(request, response);
                break;
            case ActionConstants.GET:
                doGetRolePermission(request, response);
                break;

            default:
                doPostGet(request, response);
                break;
        }
    }

    private void doGetRolePermission(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JSONObject jsonObject = RequestHelper.getJsonData(request);
        boolean showAll = true;
        try {
            showAll = jsonObject.getBoolean("showAll");
        } catch (Exception e) {
            showAll = true;
        }
        try {
            int roleId = jsonObject.getIntValue("roleId");
            RolePermissionMessage rolePermissionMessage = roleService.getRolePermission(roleId);

            if (!showAll) {
                List<Permission> permissions = rolePermissionMessage.getPermissions();
                List<Permission> nPermissions = new ArrayList<>();
                for (Permission permission : permissions) {
                    if (permission.isCanGet() || permission.isCanCreate() || permission.isCanUpdate()
                            || permission.isCanDelete()) {
                        nPermissions.add(permission);
                    }
                }
                rolePermissionMessage.setPermissions(nPermissions);
            }
            ResponseHelper.sendResponse(response,
                    new ResponseMessage(HttpStatusCodeConstants.OK, "Succsess", rolePermissionMessage));
        } catch (Exception e) {
            ResponseHelper.sendResponse(response,
                    new ResponseMessage(HttpStatusCodeConstants.INTERNAL_SERVER_ERROR, "INTERNAL_SERVER_ERROR"));
        }
    }

    private void doPostUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        RolePermissionMessage data = RequestHelper.getJsonData(request, RolePermissionMessage.class);

        if (data == null) {
            ResponseHelper.sendResponse(response,
                    new ResponseMessage(HttpStatusCodeConstants.BAD_REQUEST, "Invalid data"));
            return;
        }

        Boolean status = roleService.updateRolePermission(data.getRoleId(), data.getPermissions());

        if (status) {
            ResponseHelper.sendResponse(response,
                    new ResponseMessage(HttpStatusCodeConstants.OK, "Update role permission successfully", data));
        } else {
            ResponseHelper.sendResponse(response, new ResponseMessage(HttpStatusCodeConstants.INTERNAL_SERVER_ERROR,
                    "Update role permission failed"));
        }
    }

    private void doPostGet(HttpServletRequest request, HttpServletResponse response) {
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

        String action = request.getParameter("action") == null ? "" : request.getParameter("action");

        switch (action) {
            case "view":
                doGetView(request, response);
                break;
            default:
                doGetDefault(request, response);
                break;
        }

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

    protected void doGetDefault(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // List all role
        List<RoleConstants> listRole = RoleConstants.getAllRole();

        List<RolePermissionData> listRoleData = new ArrayList<>();

        ScreenConstants[] listScreen = ScreenConstants.privateScreen();

        for (RoleConstants role : listRole) {
            // count user of role
            int countUser = roleService.countUserByRole(role);
            // List permission available of role
            List<Screen> listPermission = roleService.getPermissionByRole(role);

            listRoleData.add(new RolePermissionData(role, countUser, listPermission));
        }

        // delete role admin
        // for (RolePermissionData roleData : listRoleData) {
        //     if (roleData.getRole().equals(RoleConstants.ADMIN)) {
        //         listRoleData.remove(roleData);
        //         break;
        //     }
        // }

        

        request.setAttribute("data", listRoleData);
        request.setAttribute("listScreen", listScreen);

        request.setAttribute("jspPath", "shared/settingrole.jsp");
        request.setAttribute("customJs", ResponseHelper.customJs(
                "apps/user-management/roles/list/add.js",
                "apps/user-management/roles/list/update-role.js"));
        request.setAttribute("brecrumbs", ResponseHelper.brecrumbs(
                ScreenConstants.USER_DASHBOARD,
                ScreenConstants.SETTING_ROLE_PERMISSIONS));
        request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);
    }

    protected void doGetView(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("jspPath", "shared/viewrole.jsp");
        request.setAttribute("customJs", ResponseHelper.customJs(
                "apps/user-management/roles/view/view.js",
                "apps/user-management/roles/view/update-role.js"));
        request.setAttribute("brecrumbs", ResponseHelper.brecrumbs(
                ScreenConstants.USER_DASHBOARD,
                ScreenConstants.SETTING_ROLE_PERMISSIONS));
        request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);
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
