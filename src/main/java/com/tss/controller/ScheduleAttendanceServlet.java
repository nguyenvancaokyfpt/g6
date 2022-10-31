/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.tss.controller;

import com.tss.constants.RoleConstants;
import com.tss.constants.ScreenConstants;
import com.tss.dao.BaseDao;
import com.tss.dao.impl.AttendanceDaoImpl;
import com.tss.helper.ResponseHelper;
import com.tss.model.AnhPTClassUser;
import com.tss.model.AnhPTSchedule;
import com.tss.model.Attendance;
import com.tss.model.Classroom;
import com.tss.model.User;
import com.tss.service.impl.ClassServiceImpl;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nguye
 */
public class ScheduleAttendanceServlet extends HttpServlet {

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
        Connection connection = BaseDao.getConnection();
        AttendanceDaoImpl dao = new AttendanceDaoImpl();
        List<Attendance> AttendanceList = new ArrayList<>();
        List<AnhPTSchedule> ScheduleList = new ArrayList<>();
        request.setAttribute("scheduleList", ScheduleList);
        List<AnhPTClassUser> UserList = new ArrayList<>();
        List<Classroom> myClass = new ArrayList<>();
        RoleConstants role = (RoleConstants) request.getAttribute("ROLE_CONSTANTS");
        User user = (User) request.getAttribute("user");
        ClassServiceImpl classService = new ClassServiceImpl();
        if (null == role) {
            myClass = classService.findClassroomByTeacher(user.getUserId());
        } else {
            switch (role) {
                case ADMIN:
                    myClass = classService.findAllClassroom();
                    break;
                case STUDENT:
                    myClass = classService.findClassroomByStudent(user.getUserId());
                    break;
                default:
                    myClass = classService.findClassroomByTeacher(user.getUserId());
                    break;
            }
        }
        request.setAttribute("myClass", myClass);

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "get":
                int class_id = Integer.parseInt(request.getParameter("class_id"));
                ScheduleList = dao.findAllSchedule(connection, class_id);
                int user_id = user.getUserId();
                int totalSchedule = dao.countTotalSchedule(connection, class_id, user_id);
                int absent = dao.countAbsent(connection, class_id, user_id);
                int absentSofar = 0;
                double absentPercent = (double) absent / totalSchedule * 100;
                absentSofar = (int) absentPercent;
                AttendanceList = dao.findAttendanceByUser(connection, class_id, user_id);
                request.setAttribute("scheduleList", ScheduleList);
                request.setAttribute("attendanceList", AttendanceList);
                request.setAttribute("class_id", class_id);
                request.setAttribute("absentSofar", absentSofar);
                request.setAttribute("absent", absent);
                request.setAttribute("totalSchedule", totalSchedule);
                request.setAttribute("jspPath", "shared/attendanceSchedule.jsp");
                request.setAttribute("brecrumbs", ResponseHelper.brecrumbs(
                        ScreenConstants.USER_DASHBOARD,
                        ScreenConstants.SCHEDULE_ATTENDACE));
                request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);
                break;
            default:
                request.setAttribute("jspPath", "shared/attendanceSchedule.jsp");
                request.setAttribute("brecrumbs", ResponseHelper.brecrumbs(
                        ScreenConstants.USER_DASHBOARD,
                        ScreenConstants.SCHEDULE_ATTENDACE));
                request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);
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
            Logger.getLogger(ScheduleAttendanceServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ScheduleAttendanceServlet.class.getName()).log(Level.SEVERE, null, ex);
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
