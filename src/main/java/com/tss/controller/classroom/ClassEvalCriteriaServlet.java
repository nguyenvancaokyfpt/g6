/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.tss.controller.classroom;

import java.io.IOException;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.tss.constants.ActionConstants;
import com.tss.constants.ScreenConstants;
import com.tss.helper.RequestHelper;
import com.tss.helper.ResponseHelper;
import com.tss.model.ClassEntity;
import com.tss.model.ClassEvalCriteria;
import com.tss.model.EvalCriteria;
import com.tss.model.payload.DataTablesMessage;
import com.tss.service.AssignmentService;
import com.tss.service.ClassEvalCriteriaService;
import com.tss.service.ClassService;
import com.tss.service.EvalCriteriaService;
import com.tss.service.impl.AssignmentServiceImpl;
import com.tss.service.impl.ClassEvalCriteriaServiceImpl;
import com.tss.service.impl.ClassServiceImpl;
import com.tss.service.impl.EvalCriteriaServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author a
 */
public class ClassEvalCriteriaServlet extends HttpServlet {
    private ClassEvalCriteriaService classEvalCriteriaService;
    private ClassService classService;
    private EvalCriteriaService evalService;
    private AssignmentService assignService;

    @Override
    public void init() throws ServletException {
        classEvalCriteriaService = new ClassEvalCriteriaServiceImpl();
        classService = new ClassServiceImpl();
        evalService = new EvalCriteriaServiceImpl();
        assignService = new AssignmentServiceImpl();
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
                    // delete(request, response);
                    break;
                case ActionConstants.GET:
                    get(request, response);
                    break;
                case ActionConstants.REPLY:
                    // reply(request, response);
                    break;
                default:
                    list(request, response);
                    break;
            }
        } catch (NullPointerException e) {
            list(request, response);
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // EvalCriteria eval = new EvalCriteria();
        JSONObject jsonObject = RequestHelper.getJsonData(request);
        int id = evalService.getNewId();
        int ass_id = Integer.parseInt(jsonObject.getString("criteria_assign"));
        int mile_id = 1;

        String name = jsonObject.getString("criteria_name");
        String des = jsonObject.getString("criteria_description");
        int is_team = Integer.parseInt(jsonObject.getString("criteria_team"));
        int weight = Integer.parseInt(jsonObject.getString("criteria_weight"));
        int loc = Integer.parseInt(jsonObject.getString("criteria_loc"));
        int status = 1;
        Object prams[] = { id, ass_id, mile_id, name, is_team, weight, loc, status, des };
        evalService.add(prams);
        response.sendRedirect("evalCriteriaList");
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JSONObject jsonObject = RequestHelper.getJsonData(request);
        int id = Integer.parseInt(jsonObject.getString("criteria_id"));
        int ass_id = Integer.parseInt(jsonObject.getString("criteria_assign"));
        String name = jsonObject.getString("criteria_name");
        String des = jsonObject.getString("criteria_description");
        int is_team = Integer.parseInt(jsonObject.getString("criteria_team"));
        int weight = Integer.parseInt(jsonObject.getString("criteria_weight"));
        int loc = Integer.parseInt(jsonObject.getString("criteria_loc"));
        int status = Integer.parseInt(jsonObject.getString("criteria_status"));

        EvalCriteria eval = new EvalCriteria(id, ass_id, 0, name, is_team, weight, loc, status, des);

        evalService.modify(eval);
        response.sendRedirect("evalCriteriaList");
    }

    private void get(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("jspPath", "shared/classEvalCriteriaDetail.jsp");
        request.setAttribute("customJs", ResponseHelper.customJs(
                "Assignment/custom.js", "apps/class-eval-criteria/update.js"));
        request.setAttribute("brecrumbs", ResponseHelper.brecrumbs(
                ScreenConstants.CLASS_EVAL_CRITERIA_LIST,
                ScreenConstants.CLASS_EVAL_CRITERIA_DETAIL));
        EvalCriteria eval = evalService.findById(Integer.parseInt(request.getParameter("id")));

        request.setAttribute("eval", eval);

        request.setAttribute("assigns", assignService.findAll(0, assignService.countAll(), "", "", "", "", ""));
        request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);
    }

    private void list(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        JSONObject jsonObject = RequestHelper.getJsonData(request);
        int start = 0;
        int length = 10;
        String search = "";
        int draw = 1;
        if (jsonObject != null) {
            start = jsonObject.getInteger("start");
            length = jsonObject.getInteger("length");
            search = jsonObject.getString("search[value]");
            draw = jsonObject.getInteger("draw");
        } else {
            start = Integer.parseInt(request.getParameter("start"));
            length = Integer.parseInt(request.getParameter("length"));
            search = request.getParameter("search[value]");
            draw = Integer.parseInt(request.getParameter("draw"));
        }
        List<ClassEvalCriteria> classEvalCriterias = classEvalCriteriaService.List(search, start, length);

        int recordsTotal = classEvalCriteriaService.countAll();
        int recordsFiltered = classEvalCriteriaService.countAll(search);

        // java.util.logging.Logger.getLogger("foo").info(classEntity.size()+"");
        // response
        ResponseHelper.sendResponse(response,
                new DataTablesMessage(draw, recordsTotal, recordsFiltered, classEvalCriterias));
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
        // java.util.logging.Logger.getLogger("foo").info(classService.ListCbxa() + "");
        List<ClassEntity> classEntity = classService.ListCbxa();

        request.setAttribute("classList", classEntity);
        request.setAttribute("assigns", assignService.findAll(0, assignService.countAll(), "", "", "", "", ""));
        request.setAttribute("jspPath", "shared/classEvalCriteria.jsp");
        request.setAttribute("customJs", ResponseHelper.customJs(
                "apps/class-eval-criteria/table-edited.js",
                "apps/class-eval-criteria/add.js"));
        request.setAttribute("brecrumbs", ResponseHelper.brecrumbs(
                ScreenConstants.USER_DASHBOARD,
                ScreenConstants.CLASS_EVAL_CRITERIA_LIST));

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
