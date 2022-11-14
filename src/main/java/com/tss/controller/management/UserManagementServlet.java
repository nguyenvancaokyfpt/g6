/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.tss.controller.management;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.tss.constants.ActionConstants;
import com.tss.constants.HttpStatusCodeConstants;
import com.tss.constants.RoleConstants;
import com.tss.constants.ScreenConstants;
import com.tss.helper.DebugHelper;
import com.tss.helper.RequestHelper;
import com.tss.helper.ResponseHelper;
import com.tss.model.User;
import com.tss.model.payload.DataTablesMessage;
import com.tss.model.payload.ResponseMessage;
import com.tss.model.system.Role;
import com.tss.model.util.DataTablesColumns;
import com.tss.service.RegisterService;
import com.tss.service.UserService;
import com.tss.service.impl.RegisterServiceImpl;
import com.tss.service.impl.UserServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author nguye
 */
public class UserManagementServlet extends HttpServlet {

    private UserService userService;
    private RegisterService registerService;

    @Override
    public void init() throws ServletException {
        userService = new UserServiceImpl();
        registerService = new RegisterServiceImpl();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String action = request.getParameter("action");
            DebugHelper.print(action);
            switch (action) {
                case ActionConstants.LIST:
                    list(request, response);
                    break;
                case ActionConstants.CREATE:
                    postCreate(request, response);
                    break;
                case ActionConstants.UPDATE:
                    update(request, response);
                    break;
                case ActionConstants.DELETE:
                    delete(request, response);
                    break;
                case ActionConstants.GET:
                    get(request, response);
                    break;
                default:
                    System.out.println(action);
                    list(request, response);
                    break;
            }
        } catch (NullPointerException e) {
            postCreate(request, response);
        }
    }

    private void get(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JSONObject jsonObject = RequestHelper.getJsonData(request);
        User user = userService.findById(jsonObject.getInteger("user_id"));
        // response
        if (user != null) {
            ResponseHelper.sendResponse(response,
                    new ResponseMessage(HttpStatusCodeConstants.OK, "Get user successfully", user));
        } else {
            ResponseHelper.sendResponse(response,
                    new ResponseMessage(HttpStatusCodeConstants.NOT_FOUND, "User not found"));
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("userID"));
        User u = userService.findById(id);
        if (u.getStatusId() == 1) {
            u.setStatusId(0);
        } else {
            u.setStatusId(1);
        }
        boolean flag = userService.modify(u);
        if (flag) {
            ResponseHelper.sendResponse(response, true);
        } else {
            ResponseHelper.sendResponse(response, false);
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("jspPath", "shared/userAdd.jsp");
        UserServiceImpl usi = new UserServiceImpl();
        List<Role> roles = usi.getRoles();
        request.setAttribute("roles", roles);
        request.setAttribute("customJs", ResponseHelper.customJs("apps/user-management/users/create.js"));
        request.setAttribute("brecrumbs", ResponseHelper.brecrumbs(
                ScreenConstants.USER_DASHBOARD,
                ScreenConstants.USER_MANAGEMENT,
                ScreenConstants.USER_DETAILS_MANAGEMENT));
        request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);
    }

    private void list(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JSONObject jsonObject = RequestHelper.getJsonDataForm(request);
        int start = 0;
        int length = 10;
        String search = "";
        int draw = 1;
        int numberofcolumn = -1;
        int orderColumn = 1;
        String orderDir = "asc";
        String roleFilter = "";
        String statusFilter = "";
        List<DataTablesColumns> columns = new ArrayList<DataTablesColumns>();
        try {
            if (jsonObject != null) {
                start = jsonObject.getJSONArray("start").getInteger(0);
                length = jsonObject.getJSONArray("length").getInteger(0);
                search = jsonObject.getJSONArray("search[value]").getString(0);
                draw = jsonObject.getJSONArray("draw").getInteger(0);
                numberofcolumn = jsonObject.getJSONArray("numberOfColumns").getInteger(0);
                orderColumn = jsonObject.getJSONArray("order[0][column]").getInteger(0);
                orderDir = jsonObject.getJSONArray("order[0][dir]").getString(0);
                roleFilter = jsonObject.getJSONArray("role").getString(0);
                statusFilter = jsonObject.getJSONArray("status").getString(0);
                if (roleFilter.equalsIgnoreCase("-1")) {
                    roleFilter = "";
                }
                if (statusFilter.equalsIgnoreCase("-1")) {
                    statusFilter = "";
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        List<User> users = userService.findAll(start, length, search, columns, orderColumn, orderDir, roleFilter,
                statusFilter);
        int recordsTotal = userService.countAll();
        int recordsFiltered = userService.countAll(search, roleFilter, statusFilter);
        // response
        ResponseHelper.sendResponse(response, new DataTablesMessage(draw, recordsTotal, recordsFiltered, users));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String action = request.getParameter("action");
            switch (action) {
                case ActionConstants.CREATE:
                    create(request, response);
                    break;
                case ActionConstants.GET:
                    request.setAttribute("jspPath", "shared/user.jsp");
                    request.setAttribute("customJs", ResponseHelper.customJs(
                            "apps/user-management/users/list/table-edited.js"));
                    request.setAttribute("brecrumbs", ResponseHelper.brecrumbs(
                            ScreenConstants.USER_DASHBOARD,
                            ScreenConstants.USER_MANAGEMENT));
                    request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);
                    break;
                default:
                    request.setAttribute("jspPath", "shared/user.jsp");
                    request.setAttribute("customJs", ResponseHelper.customJs(
                            "apps/user-management/users/list/table-edited.js"));
                    request.setAttribute("brecrumbs", ResponseHelper.brecrumbs(
                            ScreenConstants.USER_DASHBOARD,
                            ScreenConstants.USER_MANAGEMENT));
                    request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);
                    break;
            }
        } catch (NullPointerException e) {
            request.setAttribute("jspPath", "shared/user.jsp");
            request.setAttribute("customJs", ResponseHelper.customJs(
                    "apps/user-management/users/list/table-edited.js"));
            request.setAttribute("brecrumbs", ResponseHelper.brecrumbs(
                    ScreenConstants.USER_DASHBOARD,
                    ScreenConstants.USER_MANAGEMENT));
            request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);
        }
    }

    private void postCreate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JSONObject jsonObject = RequestHelper.getJsonData(request);
        User user = new User();
        String fullname = "";
        int roleId = 0;
        String email = "";
        String mobile = "";
        String note = "";
        int statusId = 0;
        DebugHelper.print(jsonObject);
        try {
            fullname = jsonObject.getString("fullname");
            roleId = jsonObject.getIntValue("roleId");
            email = jsonObject.getString("email");
            mobile = jsonObject.getString("mobile");
            note = jsonObject.getString("note");
            statusId = jsonObject.getIntValue("statusId");
        } catch (Exception e) {
            e.printStackTrace();
            ResponseHelper.sendResponse(response, new ResponseMessage(
                    HttpStatusCodeConstants.BAD_REQUEST, "Bad Request"));
            return;
        }
        user.setFullname(fullname);
        user.setRole(RoleConstants.getRole(roleId));
        user.setEmail(email);
        user.setMobile(mobile);
        user.setNote(note);
        user.setStatusId(statusId);

        if (registerService.registerUser(user)) {
            ResponseHelper.sendResponse(response, new ResponseMessage(
                    HttpStatusCodeConstants.OK, "OK"));
        } else {
            ResponseHelper.sendResponse(response, new ResponseMessage(
                    HttpStatusCodeConstants.BAD_REQUEST, "Bad Request"));
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
