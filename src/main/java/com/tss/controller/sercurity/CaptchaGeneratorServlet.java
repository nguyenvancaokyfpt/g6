/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.tss.controller.sercurity;

import java.awt.image.BufferedImage;
import java.io.IOException;

import com.tss.constants.HttpStatusCodeConstants;
import com.tss.constants.SessionConstants;
import com.tss.helper.CaptchaHelper;
import com.tss.helper.ResponseHelper;
import com.tss.model.payload.ResponseMessage;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author nguye
 */
public class CaptchaGeneratorServlet extends HttpServlet {

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
        // Captcha generate
        CaptchaHelper captchaHelper = new CaptchaHelper();
        BufferedImage bufferedImage = captchaHelper.getCaptchaImage();
        String base64Image = "data:image/png;base64," + captchaHelper.convertImageToBase64(bufferedImage);
        // set captcha text to session
        request.getSession().setAttribute(SessionConstants.CAPTCHA_STRING, captchaHelper.getCaptchaString());
        // response
        ResponseHelper.sendResponse(response, new ResponseMessage(HttpStatusCodeConstants.OK, "Captcha generated",
                base64Image));
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
        processRequest(request, response);
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
