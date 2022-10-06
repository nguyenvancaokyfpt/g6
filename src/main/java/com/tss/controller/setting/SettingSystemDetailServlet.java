/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.tss.controller.setting;

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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author msi
 */
public class SettingSystemDetailServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        Connection connection = BaseDao.getConnection();
        SettingDaoIml dao = new SettingDaoIml();

        String action = "";
        action = request.getParameter("action");
        if (action == null) {
            action += "";
        }
        Setting setting = new Setting();
        int id = 1;
        String idString = request.getParameter("id");
        if (idString == null) {
            idString += "1";
        }
        id = Integer.parseInt(idString);
        setting = dao.findById(connection, id);
        request.setAttribute("settingdetail", setting);
        switch (action) {
            case "view":
                request.getRequestDispatcher("/jsp/post/admin/settingdetail.jsp").forward(request, response);
                break;
            case "edit":
                request.getRequestDispatcher("/jsp/post/admin/editsetting.jsp").forward(request, response);
                break;
            case "update":
                id = Integer.parseInt(request.getParameter("id"));
                int type_id = Integer.parseInt(request.getParameter("type_id"));
                String title = request.getParameter("title");
                String value = request.getParameter("value");
                String display_order = request.getParameter("display_order");
                int status_id = Integer.parseInt(request.getParameter("status"));
                String description = request.getParameter("description");
                dao.updateSetting(connection, id, type_id, title, value, display_order, status_id, description);
                setting = dao.findById(connection, id);
                request.setAttribute("settingdetail", setting);
                request.getRequestDispatcher("/jsp/post/admin/settingdetail.jsp").forward(request, response);
                break;
            default:
                request.getRequestDispatcher("/jsp/post/admin/settingdetail.jsp").forward(request, response);
                break;
        }
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
            Logger.getLogger(SettingSystemDetailServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SettingSystemDetailServlet.class.getName()).log(Level.SEVERE, null, ex);
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
