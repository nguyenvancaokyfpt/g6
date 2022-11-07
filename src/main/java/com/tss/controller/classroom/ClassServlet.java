/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.tss.controller.classroom;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.tss.constants.ScreenConstants;
import com.tss.dao.BaseDao;
import com.tss.dao.impl.AnhPTSubjectDaoImpl;
import com.tss.dao.impl.ClassDaoImpl;
import com.tss.dao.impl.SettingDaoImpl;
import com.tss.helper.ResponseHelper;
import com.tss.model.ClassAnhPT;
import com.tss.model.Subject;
import com.tss.model.system.Setting;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author msi
 */
public class ClassServlet extends HttpServlet {

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
        ClassDaoImpl dao = new ClassDaoImpl();
        SettingDaoImpl settingDao = new SettingDaoImpl();
        AnhPTSubjectDaoImpl sdao = new AnhPTSubjectDaoImpl();
        List<ClassAnhPT> list = new ArrayList<>();
        List<Setting> termList = new ArrayList<>();
        List<ClassAnhPT> trainerList = new ArrayList<>();
        List<ClassAnhPT> supporterList = new ArrayList<>();
        List<Subject> subjectList = new ArrayList<>();
        String action = request.getParameter("action");
        int id = 1;
        int status_id = 1;
        String idString = "";
        String statusIdString = "";
        String class_code = "";
        int combo_id = 1;
        int trainer_id = 1;
        int term_id = 1;
        int addstatus_id = 1;
        int subject_id = 1;
        String description = "";
        termList = settingDao.ListTerm(connection);
        trainerList = dao.listTrainer(connection, 24);
        supporterList = dao.listTrainer(connection, 25);
        subjectList = sdao.List(connection);
        request.setAttribute("trainerList", trainerList);
        request.setAttribute("supporterList", supporterList);
        if (action == null) {
            action += "";
        }
        switch (action) {
            case "update":
                idString = request.getParameter("id");
                ClassAnhPT classdetail = new ClassAnhPT();
                try {
                    id = Integer.parseInt(idString);
                    classdetail = dao.findById2(connection, id);
                } catch (Exception e) {
                }
                request.setAttribute("classdetail", classdetail);
                request.setAttribute("term_id", classdetail.getTerm_id());
                request.setAttribute("trainer_id", classdetail.getTrainer_id());
                request.setAttribute("supporter_id", classdetail.getCombo_id());
                request.setAttribute("subject_id", classdetail.getSubject_id());
                request.setAttribute("termList", termList);
                request.setAttribute("trainerList", trainerList);
                request.setAttribute("supporterList", supporterList);
                request.setAttribute("subjectList", subjectList);
                request.setAttribute("jspPath", "shared/editclass.jsp");
                request.setAttribute("brecrumbs", ResponseHelper.brecrumbs(
                        ScreenConstants.USER_DASHBOARD,
                        ScreenConstants.CLASS_DETAIL));
                request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);
                break;
            case "edit":
                idString = request.getParameter("id");
                description = request.getParameter("description");
                try {
                    id = Integer.parseInt(idString);
                    class_code = request.getParameter("class_code");
                    combo_id = Integer.parseInt(request.getParameter("supporter_id"));
                    trainer_id = Integer.parseInt(request.getParameter("trainer_id"));
                    term_id = Integer.parseInt(request.getParameter("term_id"));
                    addstatus_id = Integer.parseInt(request.getParameter("status_id"));
                    description = request.getParameter("description");
                    subject_id = Integer.parseInt(request.getParameter("subject_id"));
                } catch (Exception e) {
                }
                dao.edit2(connection, id, class_code, combo_id, trainer_id, term_id, addstatus_id, description, subject_id);
            case "create":
                if (!action.equals("create")) {

                } else {
                    request.setAttribute("termList", termList);
                    request.setAttribute("trainerList", trainerList);
                    request.setAttribute("supporterList", supporterList);
                    request.setAttribute("subjectList", subjectList);
                    request.setAttribute("jspPath", "shared/addclass.jsp");
                    request.setAttribute("brecrumbs", ResponseHelper.brecrumbs(
                            ScreenConstants.USER_DASHBOARD,
                            ScreenConstants.CLASS_LIST));
                    request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);
                    break;
                }
            case "add":
                if (!action.equals("add")) {

                } else {
                    class_code = request.getParameter("class_code");
                    combo_id = Integer.parseInt(request.getParameter("supporter_id"));
                    trainer_id = Integer.parseInt(request.getParameter("trainer_id"));
                    term_id = Integer.parseInt(request.getParameter("term_id"));
                    addstatus_id = Integer.parseInt(request.getParameter("status_id"));
                    description = request.getParameter("description");
                    subject_id = Integer.parseInt(request.getParameter("subject_id"));
                    dao.add2(connection, class_code, combo_id, trainer_id, term_id, addstatus_id, description, subject_id);
                }
            case "delete":
                if (!action.equals("delete")) {

                } else {
                    id = 1;
                    status_id = 1;
                    idString = request.getParameter("id");
                    statusIdString = request.getParameter("status_id");
                    if (idString != null) {
                        id = Integer.parseInt(idString);
                    }
                    if (statusIdString != null) {
                        status_id = Integer.parseInt(statusIdString);
                    }
                    if (status_id == 1) {
                        status_id = 0;
                    } else {
                        status_id = 1;
                    }
                    dao.changeStatus(connection, id, status_id);
                }
            default:
                int page = 1;
                String pageString = request.getParameter("page");
                String searchword = request.getParameter("searchword");
                String order = request.getParameter("order");
                String dir = request.getParameter("dir");
                String term = request.getParameter("term");
                String status = request.getParameter("status");
                String trainer = request.getParameter("trainer");
                String subject = request.getParameter("subject");
                if (pageString == null || pageString.equals("")) {
                    page = 1;
                } else {
                    page = Integer.parseInt(pageString);
                }
                if (searchword == null) {
                    searchword = "";
                } else {
                    searchword = searchword.trim();
                }
                if (order == null) {
                    order = "class_id";
                }
                if (dir == null) {
                    dir = "asc";
                }
                if (term == null) {
                    term = "";
                }
                if (trainer == null) {
                    trainer = "";
                }
                if (status == null) {
                    status = "";
                }
                if (subject == null) {
                    subject = "";
                }
                // Paging
                int totalSetting = 0;
                if (trainer.equals("")) {
                    totalSetting = dao.countSearchFilter(connection, searchword, term, status, subject);
                } else {
                    int trainer_int = Integer.parseInt(trainer);
                    totalSetting = dao.countSearchFilter2(connection, searchword, term, status, trainer_int, subject);
                }

                int endPage = totalSetting / 5;
                if (totalSetting % 5 != 0) {
                    endPage++;
                }
                // List
                try {
                    if (trainer.equals("")) {
                        list = dao.listSearchFilter(connection, (page - 1) * 5, searchword, term, status, order, dir, subject);
                    } else {
                        int trainer_int = Integer.parseInt(trainer);
                        list = dao.listSearchFilter2(connection, (page - 1) * 5, searchword, term, status, order, dir, trainer_int, subject);
                    }
                    termList = settingDao.ListTerm(connection);
                } catch (SQLException ex) {
                    Logger.getLogger(SettingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }

                request.setAttribute("page", page);
                request.setAttribute("classList", list);
                request.setAttribute("termList", termList);
                request.setAttribute("subjectList", subjectList);
                request.setAttribute("endPage", endPage);
                request.setAttribute("searchword", searchword);
                request.setAttribute("order", order);
                request.setAttribute("dir", dir);
                request.setAttribute("term", term);
                request.setAttribute("status", status);
                request.setAttribute("trainer", trainer);
                request.setAttribute("subject", subject);
                request.setAttribute("jspPath", "shared/classlist.jsp");
                request.setAttribute("brecrumbs", ResponseHelper.brecrumbs(
                        ScreenConstants.USER_DASHBOARD,
                        ScreenConstants.CLASS_LIST));
                request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the
    // + sign on the left to edit the code.">
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
            Logger.getLogger(ClassServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ClassServlet.class.getName()).log(Level.SEVERE, null, ex);
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
