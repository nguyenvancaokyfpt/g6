/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.tss.controller.attendance;

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
public class AttendanceDetailServlet extends HttpServlet {

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
        List<AnhPTClassUser> UserList = new ArrayList<>();
        List<AnhPTSchedule> ScheduleList = new ArrayList<>();
        List<Attendance> AttendanceList = new ArrayList<>();

        int class_id = 0;
        String class_idString;
        String schedule_idString;
        String message = "";

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
            case "create":
                int totalSchedule = 0;
                class_id = Integer.parseInt(request.getParameter("class_id"));
                UserList = dao.findAllClassUser(connection, class_id);
                int schedule_id = Integer.parseInt(request.getParameter("schedule_id"));
                for (AnhPTClassUser classUser : UserList) {
                    int trainer_id = classUser.getUser_id();
                    int status_id = Integer.parseInt(request.getParameter("user_status[" + trainer_id + "]"));
                    String comment = request.getParameter("user_comment[" + trainer_id + "]");
                    dao.takeAttendance(connection, class_id, trainer_id, schedule_id, status_id, comment);
                    totalSchedule = dao.countTotalSchedule(connection, class_id, classUser.getUser_id());
                    int absent = dao.countAbsent(connection, class_id, classUser.getUser_id());
                    double absentPercent = (double) absent / totalSchedule * 100;
                    classUser.setAbsent((int) absentPercent);
                }
                message = "Successfully take attendance";
                request.setAttribute("message", message);
                change(request, response);
                break;
            case "edit":
                class_id = Integer.parseInt(request.getParameter("class_id"));
                UserList = dao.findAllClassUser(connection, class_id);
                schedule_id = Integer.parseInt(request.getParameter("schedule_id"));
                for (AnhPTClassUser classUser : UserList) {
                    int trainer_id = classUser.getUser_id();
                    int status_id = Integer.parseInt(request.getParameter("user_status[" + trainer_id + "]"));
                    String comment = request.getParameter("user_comment[" + trainer_id + "]");
                    dao.changeAttendance(connection, class_id, trainer_id, schedule_id, status_id, comment);
                    totalSchedule = dao.countTotalSchedule(connection, class_id, classUser.getUser_id());
                    int absent = dao.countAbsent(connection, class_id, classUser.getUser_id());
                    double absentPercent = (double) absent / totalSchedule * 100;
                    classUser.setAbsent((int) absentPercent);
                }
                message = "Successfully take attendance";
                request.setAttribute("message", message);
                change(request, response);
                break;
            case "take":
                class_idString = request.getParameter("class_id");
                UserList = dao.findAllClassUser(connection, Integer.parseInt(class_idString));
                schedule_idString = request.getParameter("schedule_id");
                request.setAttribute("class_id", class_idString);
                request.setAttribute("schedule_id", schedule_idString);
                request.setAttribute("userList", UserList);
                request.setAttribute("jspPath", "shared/attendanceDetail.jsp");
                request.setAttribute("brecrumbs", ResponseHelper.brecrumbs(
                        ScreenConstants.USER_DASHBOARD,
                        ScreenConstants.ATTENDANCE_DETAIL));
                request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);
                break;

            case "change":
                change(request, response);
                break;

            case "get":
                class_id = Integer.parseInt(request.getParameter("class_id"));
                UserList = dao.findAllClassUser(connection, class_id);
                ScheduleList = dao.findAllSchedule(connection, class_id);
                AttendanceList = dao.findAllAttendance(connection, class_id);
                request.setAttribute("class_id", class_id);
                request.setAttribute("userList", UserList);
                request.setAttribute("scheduleList", ScheduleList);
                request.setAttribute("attendanceList", AttendanceList);
                request.setAttribute("jspPath", "shared/attendanceDetailList.jsp");
                request.setAttribute("brecrumbs", ResponseHelper.brecrumbs(
                        ScreenConstants.USER_DASHBOARD,
                        ScreenConstants.ATTENDANCE_DETAIL));
                request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);
                break;
            default:
                int train_id = user.getUserId();
                ScheduleList = dao.findTodaySchedule(connection, train_id);
                AttendanceList = dao.findTodayAttendance(connection);
                request.setAttribute("class_id", class_id);
                request.setAttribute("userList", UserList);
                request.setAttribute("scheduleList", ScheduleList);
                request.setAttribute("attendanceList", AttendanceList);
                request.setAttribute("jspPath", "shared/attendanceDetailList.jsp");
                request.setAttribute("brecrumbs", ResponseHelper.brecrumbs(
                        ScreenConstants.USER_DASHBOARD,
                        ScreenConstants.ATTENDANCE_DETAIL));
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
            Logger.getLogger(AttendanceDetailServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AttendanceDetailServlet.class.getName()).log(Level.SEVERE, null, ex);
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

    private void change(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException {
        Connection connection = BaseDao.getConnection();
        AttendanceDaoImpl dao = new AttendanceDaoImpl();
        List<AnhPTClassUser> UserList = new ArrayList<>();
        //List<AnhPTSchedule> ScheduleList = new ArrayList<>();
        List<Attendance> AttendanceList = new ArrayList<>();

        //int class_id = 0;
        String class_idString;
        String schedule_idString;

        class_idString = request.getParameter("class_id");
        UserList = dao.findAllClassUser(connection, Integer.parseInt(class_idString));
        schedule_idString = request.getParameter("schedule_id");
        int schedule_id = Integer.parseInt(schedule_idString);
        AttendanceList = dao.findAttendanceBySchedule(connection, schedule_id);
        request.setAttribute("class_id", class_idString);
        request.setAttribute("schedule_id", schedule_id);
        request.setAttribute("userList", UserList);
        request.setAttribute("attendanceList", AttendanceList);
        request.setAttribute("jspPath", "shared/attendanceDetailEdit.jsp");
        request.setAttribute("brecrumbs", ResponseHelper.brecrumbs(
                ScreenConstants.USER_DASHBOARD,
                ScreenConstants.ATTENDANCE_DETAIL));
        request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);
    }
}
