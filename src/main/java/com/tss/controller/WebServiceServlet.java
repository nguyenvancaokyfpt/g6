/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.tss.controller;

import com.tss.controller.management.*;
import com.alibaba.fastjson.JSONObject;
import com.tss.constants.ActionConstants;
import com.tss.constants.HttpStatusCodeConstants;
import com.tss.constants.RoleConstants;
import com.tss.constants.ScreenConstants;
import com.tss.helper.RequestHelper;
import com.tss.helper.ResponseHelper;
import com.tss.model.User;
import com.tss.model.WebContact;
import com.tss.model.payload.DataTablesMessage;
import com.tss.model.payload.ListResponseMessage;
import com.tss.model.payload.ResponseMessage;
import com.tss.service.WebContactService;
import com.tss.service.impl.WebContactServiceImpl;
import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class WebServiceServlet extends HttpServlet {

    private WebContactService webService;

    @Override
    public void init() throws ServletException {
        webService = new WebContactServiceImpl();
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
                    list(request, response);
                    break;
            }
        } catch (NullPointerException e) {
            list(request, response);
        }
    }

    private void get(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        JSONObject jsonObject = RequestHelper.getJsonData(request);
//        User user = userService.findById(jsonObject.getInteger("user_id"));
//        // response
//        if (user != null) {
//            ResponseHelper.sendResponse(response,
//                    new ResponseMessage(HttpStatusCodeConstants.OK, "Get user successfully", user));
//        } else {
//            ResponseHelper.sendResponse(response,
//                    new ResponseMessage(HttpStatusCodeConstants.NOT_FOUND, "User not found"));
//        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
    }

    private void list(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JSONObject jsonObject = RequestHelper.getJsonData(request);
        int start = 0;
        int length = 10;
        String search = "";
        int draw = 1;
        if (jsonObject != null) {
            start = jsonObject.getInteger("start");
            length = jsonObject.getInteger("length");
            search = jsonObject.getString("search[value]");
            draw = jsonObject.getInteger("draw");
        } else {
            start = Integer.parseInt(request.getParameter("start"));
            length = Integer.parseInt(request.getParameter("length"));
            search = request.getParameter("search[value]");
            draw = Integer.parseInt(request.getParameter("draw"));
        }
        List<WebContact> users = webService.findAll(start, length, search);
        int recordsTotal = webService.countAll();
        int recordsFiltered = webService.countAll(search);
        // response
        ResponseHelper.sendResponse(response, new DataTablesMessage(draw, recordsTotal, recordsFiltered, users));        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
        String role = request.getAttribute(RoleConstants.ROLE.getTitle()).toString();
        request.setAttribute("jspPath", role + "/webcontact.jsp");
        request.setAttribute("customJs", ResponseHelper.customJs(
            "apps/Web-Contact/table-edited.js"
        ));
        request.setAttribute("brecrumbs", ResponseHelper.brecrumbs(
            ScreenConstants.USER_DASHBOARD,
            ScreenConstants.WEB_CONTACT
        ));
        request.getRequestDispatcher("../jsp/template.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


}
