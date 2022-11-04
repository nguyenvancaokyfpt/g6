/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.tss.controller.webContact;

import java.io.IOException;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.tss.constants.ActionConstants;
import com.tss.constants.ScreenConstants;
import com.tss.helper.RequestHelper;
import com.tss.helper.ResponseHelper;
import com.tss.model.WebContact;
import com.tss.model.payload.DataTablesMessage;
import com.tss.service.UserService;
import com.tss.service.WebContactService;
import com.tss.service.impl.UserServiceImpl;
import com.tss.service.impl.WebContactServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class WebContactServlet extends HttpServlet {

    private WebContactService webContactService;
    private UserService userService;

    @Override
    public void init() throws ServletException {
        webContactService = new WebContactServiceImpl();
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
        request.setAttribute("userList", userService.findAll(0, Integer.MAX_VALUE, ""));
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
        JSONObject jsonObject = RequestHelper.getJsonDataForm(request);
        int start = 0;
        int length = 10;
        String orderDir = "asc";
        String orderBy = "web_contact_id";
        int orderColumn = 1;
        int supFilter = -1;
        String search = "";
        int draw = 1;
        try {
            if (jsonObject != null) {
                start = jsonObject.getJSONArray("start").getInteger(0);
                length = jsonObject.getJSONArray("length").getInteger(0);
                search = jsonObject.getJSONArray("search[value]").getString(0);
                draw = jsonObject.getJSONArray("draw").getInteger(0);
                orderColumn = jsonObject.getJSONArray("order[0][column]").getInteger(0);
                orderDir = jsonObject.getJSONArray("order[0][dir]").getString(0);
                orderBy = getOrderCol(orderColumn);
                supFilter = jsonObject.getJSONArray("supId").getInteger(0);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        List<WebContact> users = webContactService.findAll(start, length, search, orderBy, orderDir, supFilter);
        int recordsTotal = webContactService.countAll();
        int recordsFiltered = webContactService.countAll(search,supFilter);
        // response
        ResponseHelper.sendResponse(response, new DataTablesMessage(draw, recordsTotal, recordsFiltered, users));
    }

    private String getOrderCol(int index) {
        switch (index) {
            case 0:
                return "web_contact_id";
            case 1:
                return "full_name";
            case 2:
                return "email";
            case 3:
                return "mobile";
            case 4:
                return "Date";
            case 5:
                return "supporter_name";
            default:
                return "web_contact_id";
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("jspPath", "shared/webcontact.jsp");
        request.setAttribute("customJs", ResponseHelper.customJs(
                "apps/web-contact/table-edited.js"));
        request.setAttribute("brecrumbs", ResponseHelper.brecrumbs(
                ScreenConstants.USER_DASHBOARD,
                ScreenConstants.WEB_CONTACT_LIST));
        request.setAttribute("sups", userService.getSupporter());
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
