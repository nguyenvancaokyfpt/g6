package com.tss.controller.management;

import java.io.IOException;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.tss.constants.ActionConstants;
import com.tss.constants.RoleConstants;
import com.tss.constants.ScreenConstants;
import com.tss.helper.RequestHelper;
import com.tss.helper.ResponseHelper;
import com.tss.model.Subject;
import com.tss.model.payload.DataTablesMessage;
import com.tss.service.UserService;
import com.tss.service.SubjectService;
import com.tss.service.impl.SubjectServiceImpl;
import com.tss.service.impl.UserServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
public class SubjectManagementServlet extends HttpServlet {

    private SubjectService subjectService;
    private UserService userService;

    @Override
    public void init() throws ServletException {
        subjectService = new SubjectServiceImpl();
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
                case ActionConstants.CHANGE_STATUS:
                    changeStatus(request, response);
                    break;
                case ActionConstants.GET:
                    get(request, response);
                    break;
                case ActionConstants.FIND_PAGING_SUBJECT:
                    findPaging(request, response);
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
        String role = request.getAttribute((RoleConstants.ROLE).getTitle()).toString();
        request.setAttribute("jspPath", role + "/subjectDetails.jsp");
        int subjectId = Integer.parseInt(request.getParameter("subjectId"));
        request.setAttribute("subject", subjectService.findById(subjectId));
        request.setAttribute("userList", userService.List("", "", 0, Integer.MAX_VALUE));
        request.getRequestDispatcher("../jsp/template.jsp").forward(request, response);
    }

    private void changeStatus(HttpServletRequest request, HttpServletResponse response) throws IOException {
        subjectService.changeStatus(Integer.parseInt(request.getParameter("subjectId")));
        response.sendRedirect("/subject/list");
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Subject subject = new Subject();
        subject.setSubjectId(Integer.parseInt(request.getParameter("subjectId")));
        subject.setSubjectCode(request.getParameter("subjectCode"));
        subject.setSubjectName(request.getParameter("subjectName"));
        subject.setExpertId(Integer.parseInt(request.getParameter("expertId")));
        subject.setManagerId(Integer.parseInt(request.getParameter("managerId")));
        subject.setStatusId(Integer.parseInt(request.getParameter("statusId")));
        subject.setBody(request.getParameter("body"));
        subjectService.modify(subject);
        response.sendRedirect("/subject/list");
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Subject subject = new Subject();
        subject.setSubjectCode(request.getParameter("subjectCode"));
        subject.setSubjectName(request.getParameter("subjectName"));
        subject.setExpertId(Integer.parseInt(request.getParameter("expertId")));
        subject.setManagerId(Integer.parseInt(request.getParameter("managerId")));
        subject.setStatusId(Integer.parseInt(request.getParameter("statusId")));
        subject.setBody(request.getParameter("body"));
        subjectService.add(subject);
        response.sendRedirect("/subject/list");
    }

    private void list(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JSONObject jsonObject = RequestHelper.getJsonData(request);
        int start = 0;
        int length = 10;
        String search = "";
        int draw = 1;
        // if (jsonObject != null) {
        // start = jsonObject.getInteger("start");
        // length = jsonObject.getInteger("length");
        // search = jsonObject.getString("search[value]");
        // draw = jsonObject.getInteger("draw");
        // } else {
        // start = Integer.parseInt(request.getParameter("start"));
        // length = Integer.parseInt(request.getParameter("length"));
        // search = request.getParameter("search[value]");
        // draw = Integer.parseInt(request.getParameter("draw"));
        // }
        // List<Subject> subject = subjectService.List("","",1,10);
        List<Subject> subject = subjectService.findAll(start, length, search);
        int recordsTotal = subjectService.countAll();
        int recordsFiltered = subjectService.countAll(search);
        // response
        ResponseHelper.sendResponse(response, new DataTablesMessage(draw, recordsTotal, recordsFiltered, subject));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String role = request.getAttribute((RoleConstants.ROLE).getTitle()).toString();
        request.setAttribute("jspPath", role + "/subject.jsp");
        // request.setAttribute("customJs", ResponseHelper.customJs(
        // "apps/sjtable-edited.js"));
        request.setAttribute("brecrumbs", ResponseHelper.brecrumbs(
                ScreenConstants.SUBJECT_LIST,
                ScreenConstants.SUBJECT_DETAILS));
        int pageNo = 1;
        if (request.getParameter("pageNo") != null) {
            pageNo = Integer.parseInt(request.getParameter("pageNo"));
        }
        request.setAttribute("pageNo", pageNo);
        request.setAttribute("pages", subjectService.pages(subjectService.List(0, Integer.MAX_VALUE), 3));
        if (pageNo == 1) {
            request.setAttribute("subjectList", subjectService.List(pageNo - 1, 3));
        } else {
            request.setAttribute("subjectList", subjectService.List((pageNo - 1) * 3, 3));
        }
        request.setAttribute("userList", userService.List("", "", 0, Integer.MAX_VALUE));
        request.getRequestDispatcher("../jsp/template.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void findPaging(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String role = request.getAttribute((RoleConstants.ROLE).getTitle()).toString();
        request.setAttribute("jspPath", role + "/subject.jsp");
        String searchRg = request.getParameter("searchRg");
        request.setAttribute("searchRg", searchRg);
        int pageNo = Integer.parseInt(request.getParameter("pageNo"));
        request.setAttribute("pages",
                subjectService.pages(subjectService.findAll(0, Integer.MAX_VALUE, searchRg), 3));
        if (pageNo == 1) {
            request.setAttribute("subjectList", subjectService.findAll(pageNo - 1, 3, searchRg));
        } else {
            request.setAttribute("subjectList", subjectService.findAll((pageNo - 1) * 3, 3, searchRg));
        }
        request.setAttribute("userList", userService.List("", "", 0, Integer.MAX_VALUE));
        request.getRequestDispatcher("../jsp/template.jsp").forward(request, response);
    }

}
