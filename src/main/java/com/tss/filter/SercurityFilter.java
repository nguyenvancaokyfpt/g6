/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Filter.java to edit this template
 */
package com.tss.filter;

import com.alibaba.fastjson.JSONArray;
import com.tss.constants.HttpStatusCodeConstants;
import com.tss.constants.RequestURIConstants;
import com.tss.constants.SessionConstants;
import com.tss.helper.RequestHelper;
import com.tss.model.User;
import com.tss.model.payload.ResponseMessage;


import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author nguye
 */
public class SercurityFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String uri = request.getRequestURI();
        String method = request.getMethod();

        // Allow public access
        if (RequestHelper.isPublicAccess(uri)) {
            filterChain.doFilter(request, response);
            return;
        }
        // 404 not found
        if (method.equals("GET") && !RequestHelper.isExist(uri)) {
            request.getRequestDispatcher("/jsp/authentication/general/error-404.jsp").forward(request, response);
            return;
        }

        // Disallow public access to other pages
        User user = (User) request.getSession().getAttribute(SessionConstants.USER_SESSION);
        if (user == null) {
            if (method.equals("GET")) {
                response.sendRedirect(RequestURIConstants.LOGIN);
            } else {
                try {
                    response.setContentType("application/json");
                    response.setStatus(HttpStatusCodeConstants.UNAUTHORIZED); // Unauthorized
                    try (PrintWriter writer = response.getWriter()) {
                        ResponseMessage responseMessage = new ResponseMessage();
                        responseMessage.setStatus("error");
                        responseMessage.setCode(HttpStatusCodeConstants.UNAUTHORIZED);
                        responseMessage.setMessage("Unauthorized " + uri);
                        writer.write(JSONArray.toJSONString(responseMessage));
                        writer.flush();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }

}
