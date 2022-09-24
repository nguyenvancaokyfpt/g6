/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.tss.controller.sercurity;

import java.awt.image.BufferedImage;
import java.io.IOException;

import com.alibaba.fastjson.JSONObject;
import com.tss.constants.HttpStatusCodeConstants;
import com.tss.constants.SessionConstants;
import com.tss.helper.CaptchaHelper;
import com.tss.helper.GoogleLoginHelper;
import com.tss.helper.RequestHelper;
import com.tss.helper.ResponseHelper;
import com.tss.model.User;
import com.tss.model.payload.ResponseMessage;
import com.tss.model.sercurity.GoogleClientSecret;
import com.tss.service.RegisterService;
import com.tss.service.UserService;
import com.tss.service.impl.RegisterServiceImpl;
import com.tss.service.impl.UserServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author nguye
 */
public class RegisterServlet extends HttpServlet {

    private UserService userService;
    private RegisterService registerService;

    @Override
    public void init() throws ServletException {
        userService = new UserServiceImpl();
        registerService = new RegisterServiceImpl();
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
        JSONObject jsonObject = RequestHelper.getJsonData(request);
        String email = jsonObject.getString("email");
        String password = jsonObject.getString("password");
        String name = jsonObject.getString("name");
        String captcha = jsonObject.getString("captcha");
        // get captcha from session
        String captchaSession = (String) request.getSession().getAttribute(SessionConstants.CAPTCHA_STRING);
        // check captcha
        if (!captcha.equals(captchaSession)) {
            ResponseHelper.sendResponse(response, new ResponseMessage(HttpStatusCodeConstants.BAD_REQUEST,
                    "Captcha is not correct"));
            return;
        }
        // destroy captcha session
        request.getSession().removeAttribute(SessionConstants.CAPTCHA_STRING);

        // check if email is existed
        if (userService.findByEmail(email) != null) {
            ResponseHelper.sendResponse(response, new ResponseMessage(HttpStatusCodeConstants.CONFLICT,
                    "Email is existed"));
            return;
        }

        // register
        if (registerService.register(new User(email, password, name))) {
            ResponseHelper.sendResponse(response, new ResponseMessage(HttpStatusCodeConstants.OK,
                    "Register successfully"));
        } else {
            ResponseHelper.sendResponse(response, new ResponseMessage(HttpStatusCodeConstants.INTERNAL_SERVER_ERROR,
                    "Register failed"));
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
        // if logged in, redirect to dashboard
        if (request.getSession().getAttribute(SessionConstants.USER_SESSION) != null) {
            response.sendRedirect("dashboard");
        } else {

            GoogleClientSecret googleClientSecret = GoogleLoginHelper.loadClientSecrets();
            request.setAttribute("googleClientSecret", googleClientSecret);

            // Captcha generate
            CaptchaHelper captchaHelper = new CaptchaHelper();
            BufferedImage bufferedImage = captchaHelper.getCaptchaImage();
            String base64Image = captchaHelper.convertImageToBase64(bufferedImage);
            // set captcha text to session
            request.getSession().setAttribute(SessionConstants.CAPTCHA_STRING, captchaHelper.getCaptchaString());
            // set captcha image to request
            request.setAttribute("captchaImage", base64Image);

            request.getRequestDispatcher("/jsp/authentication/sign-up.jsp").forward(request, response);
        }
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
