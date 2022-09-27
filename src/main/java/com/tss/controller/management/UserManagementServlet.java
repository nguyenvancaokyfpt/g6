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
import com.tss.helper.DTOHelper;
import com.tss.helper.DebugHelper;
import com.tss.helper.RequestHelper;
import com.tss.helper.ResponseHelper;
import com.tss.model.User;
import com.tss.model.payload.DataTablesMessage;
import com.tss.model.payload.ResponseMessage;
import com.tss.model.util.DataTablesColumns;
import com.tss.service.UserService;
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
                    list(request, response);
                    break;
                case ActionConstants.CREATE:
                    create(request, response);
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
            list(request, response);
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
        userService.modify(u);
        response.sendRedirect("/management/user");
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
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
                for (int i = 0; i <= numberofcolumn; i++) {
                    columns.add(new DataTablesColumns(DTOHelper.convertToSnakeCase(jsonObject.getJSONArray("columns[" + i + "][data]").getString(0)),
                            jsonObject.getJSONArray("columns[" + i + "][name]").getString(0),
                            jsonObject.getJSONArray("columns[" + i + "][searchable]").getBoolean(0),
                            jsonObject.getJSONArray("columns[" + i + "][orderable]").getBoolean(0),
                            jsonObject.getJSONArray("columns[" + i + "][search][value]").getString(0),
                            jsonObject.getJSONArray("columns[" + i + "][search][regex]").getBoolean(0)));
                }
                for (DataTablesColumns dataTablesColumns : columns) {
                    if (dataTablesColumns.getData().equals("role")) {
                        roleFilter = dataTablesColumns.getSearchValue();
                    }
                    if (dataTablesColumns.getData().equals("status_id")) {
                        statusFilter = dataTablesColumns.getSearchValue();
                    }
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        List<User> users = userService.findAll(start, length, search, columns, orderColumn, orderDir, roleFilter, statusFilter);
        int recordsTotal = userService.countAll();
        int recordsFiltered = userService.countAll(search, roleFilter, statusFilter);
        // response
        ResponseHelper.sendResponse(response, new DataTablesMessage(draw, recordsTotal, recordsFiltered, users));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String role = request.getAttribute(RoleConstants.ROLE.getTitle()).toString();
        request.setAttribute("jspPath", role + "/user.jsp");
        request.setAttribute("customJs", ResponseHelper.customJs(
                "apps/user-management/users/list/table-edited.js",
                "apps/user-management/users/list/export-users.js"));
        request.setAttribute("brecrumbs", ResponseHelper.brecrumbs(
                ScreenConstants.USER_DASHBOARD,
                ScreenConstants.USER_MANAGEMENT));
        request.getRequestDispatcher("../jsp/template.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
