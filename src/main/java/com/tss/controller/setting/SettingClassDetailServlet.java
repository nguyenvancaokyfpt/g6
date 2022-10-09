package com.tss.controller.setting;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;

import com.alibaba.fastjson.JSONObject;
import com.tss.constants.ActionConstants;
import com.tss.constants.HttpStatusCodeConstants;
import com.tss.constants.ScreenConstants;
import com.tss.helper.DebugHelper;
import com.tss.helper.RequestHelper;
import com.tss.helper.ResponseHelper;
import com.tss.model.payload.ResponseMessage;
import com.tss.model.system.ClassSetting;
import com.tss.service.ClassSettingService;
import com.tss.service.impl.ClassSettingServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author nguye
 */
public class SettingClassDetailServlet extends HttpServlet {

    private ClassSettingService classSettingService;

    @Override
    public void init() throws ServletException {
        classSettingService = new ClassSettingServiceImpl();
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
            case ActionConstants.DELETE:
                doPostDelete(request, response);
                break;
            default:
                doPostDefault(request, response);
                break;
        }

    }

    private void doPostDefault(HttpServletRequest request, HttpServletResponse response) {
    }

    private void doPostDelete(HttpServletRequest request, HttpServletResponse response) {
    }

    private void doPostUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JSONObject jsonObject = RequestHelper.getJsonData(request);
        try {
            int settingId = Integer.parseInt(jsonObject.getString("id"));
            String description = jsonObject.getString("description");
            String displayOrder = jsonObject.getString("displayOrther");
            String value = jsonObject.getString("value");
            int active = Integer.parseInt(jsonObject.getString("active"));

            DebugHelper.print("active: " + active);

            classSettingService.updateClassSetting(settingId, value, description, displayOrder, active);

            ResponseHelper.sendResponse(response, new ResponseMessage(HttpStatusCodeConstants.OK, "Update success"));

        } catch (Exception e) {
            ResponseHelper.sendResponse(response,
                    new ResponseMessage(HttpStatusCodeConstants.BAD_REQUEST, "Invalid data"));
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
        String action = request.getParameter("action") == null ? "" : request.getParameter("action");
        switch (action) {
            case ActionConstants.UPDATE:
                doGetUpdate(request, response);
                break;
            default:
                doGetDefault(request, response);
                break;
        }
    }

    private void doGetDefault(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int settingId = request.getParameter("id") == null ? 0
                : Integer.parseInt(request.getParameter("id"));

        ClassSetting setting = classSettingService.getSettingById(settingId);
        request.setAttribute("setting", setting);

        request.setAttribute("jspPath", "shared/classSettingDetail.jsp");
        request.setAttribute("customJs", ResponseHelper.customJs());
        request.setAttribute("brecrumbs", ResponseHelper.brecrumbs(
                ScreenConstants.USER_DASHBOARD,
                ScreenConstants.SETTING_CLASS_DETAIL));
        request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);
    }

    private void doGetUpdate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int settingId = request.getParameter("id") == null ? 0
                : Integer.parseInt(request.getParameter("id"));
        ClassSetting setting = classSettingService.getSettingById(settingId);
        request.setAttribute("setting", setting);
        request.setAttribute("jspPath", "shared/classSettingDetailUpdate.jsp");
        request.setAttribute("customJs", ResponseHelper.customJs(
                "apps/seting/class/classSettingDetailUpdate.js"));
        request.setAttribute("brecrumbs", ResponseHelper.brecrumbs(
                ScreenConstants.USER_DASHBOARD,
                ScreenConstants.SETTING_CLASS_DETAIL));
        request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);
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
