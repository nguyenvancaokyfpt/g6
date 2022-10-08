/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.tss.controller;

import java.io.IOException;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.tss.constants.ActionConstants;
import com.tss.constants.ScreenConstants;
import com.tss.helper.RequestHelper;
import com.tss.helper.ResponseHelper;
import com.tss.model.WebContact;
import com.tss.model.payload.DataTablesMessage;
import com.tss.service.WebContactService;
import com.tss.service.impl.WebContactServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class WebContactServlet extends HttpServlet {

    private WebContactService webContactService;

    @Override
    public void init() throws ServletException {
        webContactService = new WebContactServiceImpl();
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
                case ActionConstants.REPLY:
                    reply(request, response);
                    break;
                default:
                    list(request, response);
                    break;
            }
        } catch (NullPointerException e) {
            list(request, response);
        }
    }

    private void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("jspPath", "shared/webcontactdetails.jsp");
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        WebContact webContact = webContactService.findById(categoryId);
        request.setAttribute("webContactDetails", webContact);
        request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);
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
        List<WebContact> users = webContactService.findAll(start, length, search);
        int recordsTotal = webContactService.countAll();
        int recordsFiltered = webContactService.countAll(search);
        // response
        ResponseHelper.sendResponse(response, new DataTablesMessage(draw, recordsTotal, recordsFiltered, users));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("jspPath", "shared/webcontact.jsp");
        request.setAttribute("customJs", ResponseHelper.customJs(
                "apps/web-contact/table-edited.js",
                "apps/web-contact/export-web-contact.js",
                "apps/web-contact/add.js"
        ));
        request.setAttribute("brecrumbs", ResponseHelper.brecrumbs(
                ScreenConstants.USER_DASHBOARD,
                ScreenConstants.WEB_CONTACT_LIST
        ));
        request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void reply(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("jspPath", "shared/webcontact.jsp");
        int categoryId = Integer.parseInt(request.getParameter("webcontactid"));
        String reply = request.getParameter("reply");
        webContactService.reply(categoryId, reply);
        response.sendRedirect("/webcontact/list");
    }

}
