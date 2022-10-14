package com.tss.controller.setting;

import com.tss.service.SubjectService;
import com.tss.service.impl.SubjectServiceImpl;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddSubjectSettingServlet extends HttpServlet {

    private SubjectService subjectService;

    @Override
    public void init() throws ServletException {
        subjectService = new SubjectServiceImpl();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddSubjectSettingServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddSubjectSettingServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("jspPath", "shared/subjectSettingAdd.jsp");
        request.setAttribute("subjectList", subjectService.List(0, Integer.MAX_VALUE));

        request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
