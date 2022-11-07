/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.tss.controller.attendance;

import com.tss.constants.RoleConstants;
import com.tss.constants.ScreenConstants;
import com.tss.constants.SessionConstants;
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
public class AttendanceTrackingServlet extends HttpServlet {

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
        AttendanceDaoImpl dao = new AttendanceDaoImpl();
        List<Attendance> AttendanceList = new ArrayList<>();
        List<AnhPTSchedule> ScheduleList = new ArrayList<>();
        request.setAttribute("scheduleList", ScheduleList);
        List<AnhPTClassUser> UserList = new ArrayList<>();
        List<Classroom> myClass = new ArrayList<>();
        int class_id = 0;
        int totalSchedule = 0;
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
                Integer.parseInt(request.getParameter("class_id"));
                totalSchedule = 0;
                ScheduleList = dao.findAllSchedule(connection, class_id);
                UserList = dao.findAllClassUser(connection, class_id);
                for (AnhPTClassUser cUser : UserList) {
                    totalSchedule = dao.countTotalSchedule(connection, class_id, cUser.getUser_id());
                    int absent = dao.countAbsent(connection, class_id, cUser.getUser_id());
                    double absentPercent = (double) absent / totalSchedule * 100;
                    cUser.setAbsent((int) absentPercent);
                }
                AttendanceList = dao.findAllAttendance(connection, class_id);
                request.setAttribute("attendanceList", AttendanceList);
                request.setAttribute("scheduleList", ScheduleList);
                request.setAttribute("userList", UserList);
                request.setAttribute("class_id", class_id);
                request.setAttribute("totalSchedule", totalSchedule);
                break;
            default:
                int globalClassId = -1;
                try {
                globalClassId = (int) request.getSession().getAttribute(SessionConstants.GLOBAL_CLASS_ID);
            } catch (Exception e) {
                globalClassId = -1;
            }
            class_id = globalClassId;
            totalSchedule = 0;
            ScheduleList = dao.findAllSchedule(connection, class_id);
            UserList = dao.findAllClassUser(connection, class_id);
            for (AnhPTClassUser cUser : UserList) {
                totalSchedule = dao.countTotalSchedule(connection, class_id, cUser.getUser_id());
                int absent = dao.countAbsent(connection, class_id, cUser.getUser_id());
                double absentPercent = (double) absent / totalSchedule * 100;
                cUser.setAbsent((int) absentPercent);
            }
            AttendanceList = dao.findAllAttendance(connection, class_id);
            request.setAttribute("attendanceList", AttendanceList);
            request.setAttribute("scheduleList", ScheduleList);
            request.setAttribute("userList", UserList);
            request.setAttribute("class_id", class_id);
            request.setAttribute("totalSchedule", totalSchedule);
            break;
        }
        request.setAttribute("jspPath", "shared/attendanceTracking.jsp");

        request.setAttribute("brecrumbs", ResponseHelper.brecrumbs(
                ScreenConstants.USER_DASHBOARD,
                ScreenConstants.ATTENDANCE_TRACKING));
        request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);
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
            Logger.getLogger(AttendanceTrackingServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AttendanceTrackingServlet.class.getName()).log(Level.SEVERE, null, ex);
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
