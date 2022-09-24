/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.tss.controller;

import com.tss.dao.BaseDao;
import com.tss.dao.impl.SettingDaoIml;
import com.tss.model.system.Setting;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author msi
 */
public class SettingListServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        Connection connection = BaseDao.getConnection();
        SettingDaoIml dao = new SettingDaoIml();
        int page = 1;
        String pageString = request.getParameter("page");
        String searchword = request.getParameter("searchword");
        String order = request.getParameter("order");
        String dir = request.getParameter("dir");

        if (pageString == null||pageString == "") {
            page = 1;
        } else {
            page = Integer.parseInt(pageString);
        }
        if (searchword == null) {
            searchword = "";
        }
        if (order == null) {
            order = "setting_id";
        }
        if (dir == null) {
            dir = "desc";
        }

        int totalSetting = dao.countComplete(connection, searchword, order);
        int endPage = totalSetting / 5;
        if (totalSetting % 5 != 0) {
            endPage++;
        }
        List<Setting> list = new ArrayList<>();
        try {
            list = dao.CompleteList(connection, (page - 1) * 5, searchword, order, dir);
        } catch (SQLException ex) {
            Logger.getLogger(SettingDaoIml.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("page", page);
        request.setAttribute("endPage", endPage);
        request.setAttribute("settinglist", list);
        request.setAttribute("order", order);
        request.setAttribute("dir", dir);
        request.setAttribute("searchword", searchword);
        request.getRequestDispatcher("jsp/post/admin/settinglist.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(SettingListServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(SettingListServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
