package com.tss.controller.sercurity;

import java.awt.image.BufferedImage;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;

import com.alibaba.fastjson.JSONObject;
import com.tss.constants.HttpStatusCodeConstants;
import com.tss.constants.ScreenConstants;
import com.tss.constants.SessionConstants;
import com.tss.helper.CaptchaHelper;
import com.tss.helper.EmailHelper;
import com.tss.helper.PasswordHelper;
import com.tss.helper.RequestHelper;
import com.tss.helper.ResponseHelper;
import com.tss.model.User;
import com.tss.model.payload.ResponseMessage;
import com.tss.service.UserService;
import com.tss.service.impl.UserServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author nguye
 */
public class ResetPasswordServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserServiceImpl();
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
        String action = request.getParameter("action");
        action = action == null ? "" : action.trim();

        if (action.equals("newPassword")) {
            String token = jsonObject.getString("token");
            String email = jsonObject.getString("email");
            String password = jsonObject.getString("password");

            password = PasswordHelper.generateSecurePassword(password);

            if (token != null && email != null && password != null) {

                Boolean checkToken = userService.checkResetPasswordToken(token, email);
                if (checkToken) {
                    userService.updatePwdByEmail(email, password);
                    userService.detachResetPasswordToken(email);
                    ResponseHelper.sendResponse(response,
                            new ResponseMessage(HttpServletResponse.SC_OK, "Reset password successfully"));
                } else {
                    ResponseHelper.sendResponse(response,
                            new ResponseMessage(HttpServletResponse.SC_BAD_REQUEST, "Token is epired or invalid"));
                }
            } else {
                ResponseHelper.sendResponse(response, new ResponseMessage(HttpStatusCodeConstants.BAD_REQUEST,
                        "Please input all required fields"));
            }
        } else {
            String email = jsonObject.getString("email");
            String captcha = jsonObject.getString("captcha");
            String resetLink = RequestHelper.getHost(request) + ScreenConstants.RESET_PASSWORD.getPath() + "?email="
                    + email
                    + "&token=";

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

            // check email is exist
            User user = userService.findByEmail(email);
            if (user == null) {
                ResponseHelper.sendResponse(response, new ResponseMessage(HttpStatusCodeConstants.BAD_REQUEST,
                        "Email is not exist"));
                return;
            } else {
                String token = userService.generateResetPasswordToken(user);
                resetLink += token;
                // send mail reset password
                EmailHelper emailHelper = new EmailHelper();
                emailHelper.sendResetPasswordEmail(email, resetLink);
                // response
                ResponseHelper.sendResponse(response, new ResponseMessage(HttpStatusCodeConstants.OK,
                        "Reset password link has been sent to your email"));
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

        // get email address
        String email = request.getParameter("email");
        String token = request.getParameter("token");
        if (email == null || token == null) {
            // Captcha generate
            CaptchaHelper captchaHelper = new CaptchaHelper();
            BufferedImage bufferedImage = captchaHelper.getCaptchaImage();
            String base64Image = captchaHelper.convertImageToBase64(bufferedImage);
            // set captcha text to session
            request.getSession().setAttribute(SessionConstants.CAPTCHA_STRING, captchaHelper.getCaptchaString());
            // set captcha image to request
            request.setAttribute("captchaImage", base64Image);
            request.getRequestDispatcher("/jsp/authentication/password-reset.jsp").forward(request, response);
        } else {
            request.setAttribute("email", email);
            request.setAttribute("token", token);
            request.getRequestDispatcher("/jsp/authentication/new-password.jsp").forward(request, response);
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
