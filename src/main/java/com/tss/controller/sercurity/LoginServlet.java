package com.tss.controller.sercurity;

import com.alibaba.fastjson.JSONObject;
import com.tss.helper.CaptchaHelper;
import com.tss.helper.GoogleLoginHelper;
import com.tss.helper.RequestHelper;
import com.tss.helper.ResponseHelper;
import com.tss.model.User;
import com.tss.model.payload.ResponseMessage;
import com.tss.model.sercurity.GoogleClientSecret;
import com.tss.model.sercurity.Permission;
import com.tss.model.sercurity.UserRole;
import com.tss.service.LoginService;
import com.tss.service.PermissionService;
import com.tss.service.RoleService;
import com.tss.service.UserService;
import com.tss.service.impl.LoginServiceImpl;
import com.tss.service.impl.RoleServiceImpl;
import com.tss.service.impl.UserServiceImpl;
import com.tss.service.impl.PermissionServiceImpl;
import com.tss.constants.HttpStatusCodeConstants;
import com.tss.constants.RoleConstants;
import com.tss.constants.SessionConstants;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.TreeSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

    private LoginService loginService;
    private UserService userService;
    private RoleService roleService;
    private PermissionService permissionService;

    @Override
    public void init() throws ServletException {
        loginService = new LoginServiceImpl();
        userService = new UserServiceImpl();
        roleService = new RoleServiceImpl();
        permissionService = new PermissionServiceImpl();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        JSONObject jsonObject = RequestHelper.getJsonData(request);

        String email = jsonObject.getString("email");
        String password = jsonObject.getString("password");
        String captcha = jsonObject.getString("captcha");
        // get captcha from session
        String captchaSession = (String) request.getSession().getAttribute(SessionConstants.CAPTCHA_STRING);
        // check captcha
        if (!captcha.equals(captchaSession) || captchaSession == null) {
            ResponseHelper.sendResponse(response, new ResponseMessage(HttpStatusCodeConstants.BAD_REQUEST,
                    "Captcha is not correct"));
            return;
        }
        // destroy captcha
        request.getSession().removeAttribute(SessionConstants.CAPTCHA_STRING);

        if (loginService.login(email, password)) {
            // get user info
            User user = userService.findByEmail(email);
            // set user info to session
            request.getSession().setAttribute(SessionConstants.USER_SESSION, user);
            // get all roles of user
            List<UserRole> roles = roleService.findByUserId(user.getUserId());
            // Convert to String list
            TreeSet<RoleConstants> roleNames = roleService.convertRoleListToRoleConstantsList(roles);
            // set role list to session
            request.getSession().setAttribute(SessionConstants.USER_ROLES, roleNames);
            // get all permissions of user
            List<Permission> permissions = null;
            for (RoleConstants roleConstants : roleNames) {
                List<Permission> temp = permissionService.ListBySettingId(roleConstants.getId());
                if (permissions == null) {
                    permissions = temp;
                } else {
                    permissions.addAll(temp);
                }
            }
            // set permission list to session
            request.getSession().setAttribute(SessionConstants.USER_PERMISSIONS, permissions);
            // response
            ResponseHelper.sendResponse(response,
                    new ResponseMessage(HttpStatusCodeConstants.OK, "Login success", user));
        } else {
            ResponseHelper.sendResponse(response,
                    new ResponseMessage(HttpStatusCodeConstants.UNAUTHORIZED,
                            "Your information is incorrect. Please try again"));
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
            request.getRequestDispatcher("/jsp/authentication/login.jsp").forward(request, response);
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
