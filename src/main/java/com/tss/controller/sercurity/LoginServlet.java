package com.tss.controller.sercurity;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tss.helper.RequestHelper;
import com.tss.model.User;
import com.tss.model.payload.ResponseMessage;
import com.tss.service.impl.LoginServiceImpl;
import com.tss.service.impl.UserServiceImpl;
import com.tss.constants.HttpStatusCodeConstants;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet {

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
            LoginServiceImpl loginService = new LoginServiceImpl();
            UserServiceImpl userService = new UserServiceImpl();
            JSONObject jsonObject = RequestHelper.getJsonData(request);

            String username = jsonObject.getString("username");
            String password = jsonObject.getString("password");
            
            // output payload
            System.out.println(request.getParameterMap());
            if (loginService.login(username, password)) {
                // get user info
                User user = userService.findByUsername(username);
                // set user info to session
                request.getSession().setAttribute("user", user);
                // response
                try {
                    response.setContentType("application/json");
                    response.setStatus(HttpStatusCodeConstants.SUCCESS); // Success
                    try (PrintWriter writer = response.getWriter()) {
                        ResponseMessage responseMessage = new ResponseMessage();
                        responseMessage.setStatus("success");
                        responseMessage.setCode(HttpStatusCodeConstants.SUCCESS);
                        responseMessage.setMessage("Login success");
                        responseMessage.setData(user);
                        writer.write(JSONArray.toJSONString(responseMessage));
                        writer.flush();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    response.setContentType("application/json");
                    response.setStatus(HttpStatusCodeConstants.UNAUTHORIZED); // Unauthorized
                    try (PrintWriter writer = response.getWriter()) {
                        ResponseMessage responseMessage = new ResponseMessage();
                        responseMessage.setStatus("error");
                        responseMessage.setCode(HttpStatusCodeConstants.UNAUTHORIZED);
                        responseMessage.setMessage("Username or password is incorrect");
                        writer.write(JSONArray.toJSONString(responseMessage));
                        writer.flush();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
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
        request.getRequestDispatcher("/jsp/authentication/login.jsp").forward(request, response);
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
